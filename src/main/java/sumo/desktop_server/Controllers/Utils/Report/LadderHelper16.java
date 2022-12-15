package sumo.desktop_server.Controllers.Utils.Report;

import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.Fight.Fight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderHelper16 {
    private List<Fight> fights;

    Map<Integer, Integer> actualFightIndexToArrayIndex = new HashMap<>();
    private List<CompetitorInDraw> competitorInDrawList;
    int actualFightIndex = 0;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    int fightIndex = 0;

    public Competitor getActualLeftCompetitor() {
        return actualLeftCompetitor;
    }

    public Competitor getActualRightCompetitor() {
        return actualRightCompetitor;
    }

    int actualCompetitor = 0;

    Fight actualFight;
    Fight oppositeFight;

    public String getNumberOfPlaceInDrawLeft() {
        return numberOfPlaceInDrawLeft;
    }

    public String getNumberOfPlaceInDrawRight() {
        return numberOfPlaceInDrawRight;
    }

    String numberOfPlaceInDrawLeft;
    String numberOfPlaceInDrawRight;

    Competitor actualLeftCompetitor;
    Competitor actualRightCompetitor;
    int counter = 0;

    public Map<Integer, Integer> getActualFightIndexToArrayIndex() {
        return actualFightIndexToArrayIndex;
    }

    public LadderHelper16(List<Fight> fights, List<CompetitorInDraw> competitorInDrawList) {
        this.fights = fights;
        this.competitorInDrawList = competitorInDrawList;
    }

    public void initializeActualFightIndexMap() {


        for (int i = 8; i <= 15; i++) {
            this.actualFightIndexToArrayIndex.put(fightIndex, i);
            fightIndex++;
        }

        for (int i = 4; i <= 7; i++) {
            this.actualFightIndexToArrayIndex.put(fightIndex, i);
            fightIndex++;
        }

        for (int i = 2; i <= 3; i++) {
            this.actualFightIndexToArrayIndex.put(fightIndex, i);
            fightIndex++;
        }

        for (int i = 20; i <= 23; i++) {
            this.actualFightIndexToArrayIndex.put(fightIndex, i);
            fightIndex++;
        }
        for (int i = 19; i >= 18; i--) {
            this.actualFightIndexToArrayIndex.put(fightIndex, i);
            fightIndex++;
        }
        for (int i = 17; i >= 16; i--) {
            this.actualFightIndexToArrayIndex.put(fightIndex, i);
            fightIndex++;
        }

        //final
        this.actualFightIndexToArrayIndex.put(fightIndex, 1);

    }
    public void goToMatch(int matchNumber){
        this.actualFightIndex = matchNumber;
    }

    private void loadCompetitors() {
        if (counter == 0) {
            actualLeftCompetitor = this.actualFight.getFirstCompetitor();
            actualRightCompetitor = this.oppositeFight.getFirstCompetitor();
        } else if (counter == 1) {
            if (this.actualFight.getWhoIsWinner() == 2){
                this.actualLeftCompetitor  = this.actualFight.getSecondCompetitor();
            }
            if (this.oppositeFight.getWhoIsWinner() == 2){
                this.actualRightCompetitor = this.oppositeFight.getSecondCompetitor();
            }

        }else if (counter == 2){
            this.actualLeftCompetitor = this.actualFight.getSecondCompetitor();
            this.actualRightCompetitor  = this.oppositeFight.getSecondCompetitor();
        }
        this.numberOfPlaceInDrawLeft = getCompetitorPlaceInDraw(this.actualLeftCompetitor);
        this.numberOfPlaceInDrawRight = getCompetitorPlaceInDraw(this.actualRightCompetitor);
        counter++;
    }
    public void loadFinal(){
        actualFight = this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex));
        this.actualLeftCompetitor = this.actualFight.getFirstCompetitor();
        this.actualRightCompetitor = this.actualFight.getSecondCompetitor();
        this.numberOfPlaceInDrawLeft = getCompetitorPlaceInDraw(this.actualLeftCompetitor);
        this.numberOfPlaceInDrawRight = getCompetitorPlaceInDraw(this.actualRightCompetitor);
    }

    public void loadActualMatch(int shift){
        //next match
        if (counter == 3){
            counter = 0;
        }

        actualFight = this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex));
        oppositeFight =  this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex + shift) );

        loadCompetitors();

    }
    public List<Competitor> getTop4Competitors(){
        Fight finalFight = this.fights.get(1);
        Fight thirdPlaceFight1 = this.fights.get(17);
        Fight thirdPlaceFight2 = this.fights.get(16);

        if (finalFight.getWhoIsWinner() == 1){
            return Arrays.asList(finalFight.getFirstCompetitor(),finalFight.getSecondCompetitor(),getWinnerFromFight(thirdPlaceFight1),getWinnerFromFight(thirdPlaceFight2));
        }else {
            return Arrays.asList(finalFight.getSecondCompetitor(),finalFight.getFirstCompetitor(),getWinnerFromFight(thirdPlaceFight1),getWinnerFromFight(thirdPlaceFight2));
        }

    }
    private Competitor getWinnerFromFight(Fight fight){
        if (fight.getWhoIsWinner() == 1){
            return fight.getFirstCompetitor();
        }else
        {
            return fight.getSecondCompetitor();
        }
        }

    private String getCompetitorPlaceInDraw(Competitor competitor){
        //free fight
        if (competitor.getId() == 0){
            return "-";
        }
        return String.valueOf(competitorInDrawList.stream().filter(competitorInDraw -> competitorInDraw.getCompetitor().getId().equals(competitor.getId())).findFirst().get().getNumberOfPlaceInDraw());
    }
}
