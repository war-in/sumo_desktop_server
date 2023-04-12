package sumo.desktop_server.Controllers.Utils.Report.Compare;

import sumo.desktop_server.Controllers.Utils.Report.NationalClassificationRecord;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;

import java.util.Comparator;
import java.util.List;

public class WeightCategorySorter implements Comparator<CategoryAtCompetition> {
    @Override
    public int compare(CategoryAtCompetition o1, CategoryAtCompetition o2) {
        String weightCategory = o1.getCategory().getWeightCategory();
        String weightCategory2 = o2.getCategory().getWeightCategory();
        weightCategory=weightCategory.replace("kg","");
        weightCategory2=weightCategory2.replace("kg","");
        weightCategory=weightCategory.strip();
        weightCategory2=weightCategory2.strip();
        if (weightCategory.equals("OPEN") || weightCategory.equals("open")){
            return 1;
        }
        if (weightCategory2.equals("OPEN") || weightCategory2.equals("open")){
            return -1;
        }
        return Integer.compare(Integer.parseInt(weightCategory),Integer.parseInt(weightCategory2));
    }
}
