package sumo.desktop_server.Controllers.Utils.Report;

import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.Fight.Fight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderHelper {
    public Fight getActualFight() {
        return actualFight;
    }

    public Fight getOppositeFight() {
        return oppositeFight;
    }

    private List<Fight> fights;
    private List<CompetitorInDraw> competitorInDrawList;

    Map<Integer,Integer> actualFightIndexToArrayIndex = new HashMap<>();
    int actualFightIndex = 0;
    int fightIndex = 0;
    int actualCompetitor = 0;

    int numberOfPlaceInDrawLeft;
    int numberOfPlaceInDrawRight;

    Fight actualFight;
    Fight oppositeFight;

    public int getNumberOfPlaceInDrawLeft() {
        return numberOfPlaceInDrawLeft;
    }

    public int getNumberOfPlaceInDrawRight() {
        return numberOfPlaceInDrawRight;
    }

    Competitor actualLeftCompetitor;
    Competitor actualRightCompetitor;
    int counter = 0;
    public LadderHelper(List<Fight> fights, List<CompetitorInDraw> competitorInDrawList) {
        this.competitorInDrawList = competitorInDrawList;
        this.fights = fights;
        generateLinearTableFromFights();
    }

    public Map<Integer, Integer> getActualFightIndexToArrayIndex() {
        return actualFightIndexToArrayIndex;
    }

    public void generateLinearTableFromFights(){

        //eliminacje
        for (int i =4; i<=7; i++){
            this.actualFightIndexToArrayIndex.put(fightIndex,i);
            fightIndex++;
        }
        //polfinaly
        for (int i = 2; i<4; i++){
            this.actualFightIndexToArrayIndex.put(fightIndex,i);
            fightIndex++;
        }

        //repasarze
        for (int i = 11; i>= 10; i--){
            this.actualFightIndexToArrayIndex.put(fightIndex,i);
            fightIndex++;
        }

        for (int i = 9; i>= 8; i--){
            this.actualFightIndexToArrayIndex.put(fightIndex,i);
            fightIndex++;
        }

        //final
        this.actualFightIndexToArrayIndex.put(fightIndex,1);



    }
    public void goToMatch(int matchNumber){
        this.actualFightIndex = matchNumber;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void loadActualRepachageMatch(){

        if (counter == 3){
            counter = 0;
        }

        actualFight = this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex));
        oppositeFight =  this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex + 1) );

        loadCompetitors();

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

    public void loadActualMatch(){
        //next match
        if (counter == 3){
            counter = 0;
        }

        actualFight = this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex));
        oppositeFight =  this.fights.get(this.actualFightIndexToArrayIndex.get(this.actualFightIndex + 2) );

        loadCompetitors();
    }
    //@TODO
    public void loadFinal(){
        actualFight = this.fights.get(1);
        actualLeftCompetitor = this.actualFight.getFirstCompetitor();
        actualRightCompetitor = this.actualFight.getSecondCompetitor();

    }

    public Fight getNextMatch(){
        return this.fights.get(this.actualFightIndexToArrayIndex.get(actualFightIndex +1));
    }
    //@TODO
    public void goToNextMatch(){
        if (this.actualFightIndex + 1 == fights.size()){
            return;
        }
        this.actualFightIndex = (this.actualFightIndex+1) % (fights.size()- 1);
    }
    public void goToPrevMatch(){
        if (this.actualFightIndex == 0) return;
        //@TODO hardcoded value
        this.actualFightIndex = (this.actualFightIndex - 1) % (30 - 1);
    }

    public Competitor getActualLeftCompetitor() {
        return actualLeftCompetitor;
    }

    public Competitor getActualRightCompetitor() {
        return actualRightCompetitor;
    }
    public List<Competitor> getTop4Competitors(){
        Fight finalFight = this.fights.get(1);
        Fight thirdPlaceFight1 = this.fights.get(8);
        Fight thirdPlaceFight2 = this.fights.get(9);

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
    //brak nuli w bazie
    private int getCompetitorPlaceInDraw(Competitor competitor){
        return competitorInDrawList.stream().filter(competitorInDraw -> competitorInDraw.getCompetitor().getId().equals(competitor.getId())).findFirst().get().getNumberOfPlaceInDraw();
    }


}
