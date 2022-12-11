package sumo.desktop_server.Controllers.Utils.Report;

import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.Fight.Fight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketHelper {
    private long[] roundRobinGenerationList;
    private Map<Long,Integer> idToResult = new HashMap<>();
    private final Map<Integer,Map<Long,Integer>> roundToResult = new HashMap<>();
    private final int numberOfPlayersOrRounds;
    private final List<Fight> fights;

    public List<Fight> getFights() {
        return fights;
    }

    public List<CompetitorInDraw> getCompetitorInDrawList() {
        return competitorInDrawList;
    }

    private final Map<Integer,List<Long>> idToSumOfPoints = new HashMap<>();
    List<CompetitorInDraw> competitorInDrawList;

    public BucketHelper(int numberOfPlayersOrRounds, List<CompetitorInDraw> competitorInDrawList,List<Fight> fights) {
        this.numberOfPlayersOrRounds = numberOfPlayersOrRounds;
        this.fights = fights;
        this.competitorInDrawList = competitorInDrawList;
        initRoundRobinGenerationList(competitorInDrawList);
        initMaps();


    }
    public void updateSumOfPoints(int sumOfPoints,long competitorId){
        idToSumOfPoints.computeIfAbsent(sumOfPoints,integer -> new ArrayList<>()).add(competitorId);
    }

    private void initRoundRobinGenerationList(List<CompetitorInDraw> competitorInDrawList){
        if (numberOfPlayersOrRounds % 2 != 0){
            roundRobinGenerationList = new long[numberOfPlayersOrRounds];
        }else {
            roundRobinGenerationList = new long[numberOfPlayersOrRounds + 1];
        }
        int i = 0;
        for (CompetitorInDraw competitorInDraw: competitorInDrawList){
            roundRobinGenerationList[i] = competitorInDraw.getCompetitor().getId();
            i++;
        }
    }

    private void initMaps(){
        int round = 1;
        int bound = 10;

        if (fights.size() < 10){
            bound = fights.size();
        }

        for (int i =0; i<bound; i++){
            Fight fight = fights.get(i);
            //new round

            long firstCompetitorId = fight.getFirstCompetitor().getId();
            long secondCompetitorId = fight.getSecondCompetitor().getId();

            int whoIsWinner = fight.getWhoIsWinner();
            if (whoIsWinner == 1){
                idToResult.put(firstCompetitorId,1);
                idToResult.put(secondCompetitorId,0);
            }else {
                idToResult.put(firstCompetitorId,0);
                idToResult.put(secondCompetitorId,1);
            }
            //TODO check for even and diffrenct number of competitors
            if ((fight.getNumberOfPlaceInDraw() +1)%(numberOfPlayersOrRounds/2) == 0){
                roundToResult.put(round,idToResult);
                idToResult = new HashMap<>();
                round++;
            }


        }
    }
    public void shiftElements(){
        int length = this.roundRobinGenerationList.length;
        long[] reordered = new long[length];

        for(int i=1; i<=length;i++)
            reordered[i % length] = this.roundRobinGenerationList[i-1];
        this.roundRobinGenerationList = reordered;

    }

    public boolean competitorHasBreak(long competitorId){
        return roundRobinGenerationList[roundRobinGenerationList.length/2] != competitorId;
    }
    public int getFightResultForCompetitor(int numberOfRound,Long competitorId){
        return roundToResult.get(numberOfRound).get(competitorId);
    }
    public List<BucketHelper> generateBuckets(){
        List<BucketHelper> bucketHelperList = new ArrayList<>();

        idToSumOfPoints.forEach((integer, list) -> {
            if (list.size() > 2){
                List<Fight> restFights = fights.subList(10,fights.size() );
                List<Competitor> restCompetitors = new ArrayList<>();
                restFights.forEach(fight -> {
                    restCompetitors.add(fight.getFirstCompetitor());
                    restCompetitors.add(fight.getSecondCompetitor());
                });
                List<CompetitorInDraw> restCompetitorsInDraw = competitorInDrawList.stream().filter(competitorInDraw -> restCompetitors.contains(competitorInDraw.getCompetitor())).toList();

                bucketHelperList.add(new BucketHelper(restFights.size(),restCompetitorsInDraw,restFights));
            }
        });
        return bucketHelperList;
    }


}
