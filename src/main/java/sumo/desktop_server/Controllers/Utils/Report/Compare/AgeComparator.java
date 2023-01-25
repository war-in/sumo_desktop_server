package sumo.desktop_server.Controllers.Utils.Report.Compare;

import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;

import java.util.Comparator;

public class AgeComparator implements Comparator<CategoryAtCompetition> {

    @Override
    public int compare(CategoryAtCompetition o1, CategoryAtCompetition o2) {
        return Integer.compare(getAgeCategory(o1),getAgeCategory(o2));
    }
    private int getAgeCategory(CategoryAtCompetition categoryAtCompetition) {
        return AgeCategoryEnum.fromText(categoryAtCompetition.getCategory().getAgeCategory().getName()).ordinal();
    }
}
