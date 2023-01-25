package sumo.desktop_server.Controllers.Utils.Report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sumo.desktop_server.Controllers.Utils.Report.Compare.BronzeMedalSorter;
import sumo.desktop_server.Controllers.Utils.Report.Compare.GoldMedalSorter;
import sumo.desktop_server.Controllers.Utils.Report.Compare.SilverMedalSorter;
import sumo.desktop_server.Controllers.Utils.Report.Utils.PdfUtils;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.PointsClassification.PointsClassification;
import sumo.desktop_server.Database.Results.Result;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MedalClassificationReport {
    PdfUtils pdfUtils = new PdfUtils();
    private static final Logger logger = LoggerFactory.getLogger(PointClassificationReport.class);
    public void generateReport(Document document,List<CategoryAtCompetition> categoryAtCompetitionList, List<PointsClassification> pointsClassifications, Map<Long,List<Result>> results, Long competitionId) throws DocumentException {


        int numberOfWeightsCategory = categoryAtCompetitionList.size();
        //header // max 9?
        PdfPTable tableHeader = new PdfPTable(4 + numberOfWeightsCategory);
        tableHeader.setWidthPercentage(100);

        int[] baseWidths = new int[]{1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] widths = Arrays.copyOfRange(baseWidths, 0, 4 + numberOfWeightsCategory);

        tableHeader.setWidths(widths);
        float cellSize = 20f;
        pdfUtils.updateTableContextWithSize(tableHeader,"M-ce",pdfUtils.getFontSize_10_bold(), Element.ALIGN_CENTER,cellSize);
        pdfUtils.updateTableContextWithSize(tableHeader,"Kraj",pdfUtils.getFontSize_10_bold(), Element.ALIGN_CENTER, cellSize);
        pdfUtils.updateTableContextWithSize(tableHeader,"L. zaw.",pdfUtils.getFontSize_10_bold(), Element.ALIGN_CENTER, cellSize);


        for (CategoryAtCompetition categoryAtCompetition : categoryAtCompetitionList) {
            String weightCategory = categoryAtCompetition.getCategory().getWeightCategory();

            pdfUtils.updateTableContext1(tableHeader,weightCategory,pdfUtils.getFontSize_10_bold(),Element.ALIGN_CENTER);
        }
        pdfUtils.updateTableContext1(tableHeader, "SUMA MEDALI", pdfUtils.getFontSize_10_bold(), Element.ALIGN_CENTER);

        List<NationalClassificationRecord> nationalClassificationRecords = prepareData(categoryAtCompetitionList,results);
        LinkedHashMap<String, List<NationalClassificationRecord>> sortedData = sortDataByMedals(nationalClassificationRecords);

        int placement = 1;
        for (var entry : sortedData.entrySet()){
            List<NationalClassificationRecord> nationalClassificationRecordList = entry.getValue();

            pdfUtils.updateTableContextAccorToPlacementWithSize(tableHeader,String.valueOf(placement),placement,pdfUtils.getFontSize_10(), Element.ALIGN_CENTER,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(tableHeader,nationalClassificationRecordList.get(0).country(),placement,pdfUtils.getFontSize_10(), Element.ALIGN_CENTER,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(tableHeader,String.valueOf(nationalClassificationRecordList.size()),placement,pdfUtils.getFontSize_10(), Element.ALIGN_CENTER,cellSize);

            int totalSumOfMedals = 0;
            for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitionList){
                String weightCategory = categoryAtCompetition.getCategory().getWeightCategory();

                List<NationalClassificationRecord> forConcreteWeightCategory = nationalClassificationRecordList.stream()
                        .filter(nationalClassificationRecord -> nationalClassificationRecord.weightCategory().equals(weightCategory)).toList();

                if (forConcreteWeightCategory.size() == 0){
                    pdfUtils.updateTableContextAccorToPlacementWithSize(tableHeader,"-",placement,pdfUtils.getFontSize_8(), Element.ALIGN_CENTER,cellSize);
                }else {
                    AtomicInteger sumOfGoldMedals = new AtomicInteger(0);
                    AtomicInteger sumOfSilverMedals= new AtomicInteger(0);
                    AtomicInteger sumOfBronzeMedals = new AtomicInteger(0);
                    forConcreteWeightCategory.forEach(nationalClassificationRecord -> {
                        if (nationalClassificationRecord.placement() == 1)
                            sumOfGoldMedals.addAndGet(1);
                        if (nationalClassificationRecord.placement() == 2)
                            sumOfSilverMedals.addAndGet(1);
                        if (nationalClassificationRecord.placement() == 3)
                            sumOfBronzeMedals.addAndGet(1);
                    });
                    totalSumOfMedals += sumOfGoldMedals.get() + sumOfSilverMedals.get() + sumOfBronzeMedals.get();
                    pdfUtils.updateTableContextAccorToPlacementWithSize(tableHeader,sumOfGoldMedals.get() + " gold, " + sumOfSilverMedals.get() +" silver, " + sumOfBronzeMedals.get() +" bronze",placement,pdfUtils.getFontSize_8(),Element.ALIGN_CENTER,cellSize);

                }
            }
            pdfUtils.updateTableContextAccorToPlacementWithSize(tableHeader,String.valueOf(totalSumOfMedals),placement,pdfUtils.getFontSize_10_bold(),Element.ALIGN_CENTER,cellSize);

            placement ++;


        }
        document.add(tableHeader);
    }

    private List<NationalClassificationRecord> prepareData(List<CategoryAtCompetition> filteredCategoriesByAgeCategoryAndSex,  Map<Long,List<Result>> results) {


        List<NationalClassificationRecord> nationalClassificationRecords = new ArrayList<>();
        //mapa
        //uniq weigths??
        for (CategoryAtCompetition categoryAtCompetition: filteredCategoriesByAgeCategoryAndSex){
            String weightCategory = categoryAtCompetition.getCategory().getWeightCategory();

            //List<Result> resultsByWeightCategory = results.stream().filter(result -> result.getCategoryAtCompetition().getId() == categoryAtCompetition.getId()).toList();
            List<Result> resultsByWeightCategory = results.get(categoryAtCompetition.getId());
            for (Result result: resultsByWeightCategory){
                nationalClassificationRecords.add(new NationalClassificationRecord(result.getCompetitor().getCountry(),weightCategory,0, result.getPlacement()));
            }

        }
        return nationalClassificationRecords;


    }

    private LinkedHashMap<String, List<NationalClassificationRecord>> sortDataByMedals (List<NationalClassificationRecord> nationalClassificationRecords){
        Map<String,List<NationalClassificationRecord>> countryToCompetitors = new HashMap<>();

        for (NationalClassificationRecord classificationRecord: nationalClassificationRecords){
            String key = classificationRecord.country();
            if (!countryToCompetitors.containsKey(key)){
                countryToCompetitors.put(key,new ArrayList<>());
            }
            countryToCompetitors.get(key).add(classificationRecord);
        }

        LinkedHashMap<String, List<NationalClassificationRecord>> sortedBySumOfMedals= new LinkedHashMap<>();
        ArrayList<List<NationalClassificationRecord>> list = new ArrayList<>();

        for (Map.Entry<String, List<NationalClassificationRecord>> entry : countryToCompetitors.entrySet()){
            list.add(entry.getValue());
        }

        list.sort(new GoldMedalSorter()
                .thenComparing(new SilverMedalSorter())
                .thenComparing(new BronzeMedalSorter()));



        for (List<NationalClassificationRecord> records : list){
            for (Map.Entry<String, List<NationalClassificationRecord>> entry : countryToCompetitors.entrySet()){
                if (entry.getValue() == records){
                    sortedBySumOfMedals.put(entry.getKey(), records);
                }
            }
        }
        return sortedBySumOfMedals;
    }
}
