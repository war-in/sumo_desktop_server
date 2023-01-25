package sumo.desktop_server.Controllers.Utils.Report.Compare;

import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;

import java.util.Comparator;

public class GenderComparator implements Comparator<CategoryAtCompetition> {

    @Override
    public int compare(CategoryAtCompetition o1, CategoryAtCompetition o2) {
        return o1.getCategory().getSex().getSex().compareTo(o2.getCategory().getSex().getSex());
    }
}
