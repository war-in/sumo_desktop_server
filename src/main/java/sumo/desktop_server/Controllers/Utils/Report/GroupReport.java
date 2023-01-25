package sumo.desktop_server.Controllers.Utils.Report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.util.PropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sumo.desktop_server.Controllers.Utils.Report.Compare.AgeCategoryEnum;
import sumo.desktop_server.Controllers.Utils.Report.Compare.AgeComparator;
import sumo.desktop_server.Controllers.Utils.Report.Compare.GenderComparator;
import sumo.desktop_server.Controllers.Utils.Report.Compare.WeightCategorySorter;
import sumo.desktop_server.Controllers.Utils.Report.Utils.IndividualReportData;
import sumo.desktop_server.Controllers.Utils.Report.Utils.Maps;
import sumo.desktop_server.Controllers.Utils.Report.Utils.PdfUtils;
import sumo.desktop_server.Controllers.Utils.Report.Utils.ReportService;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionPdfReport;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.PointsClassification.PointsClassification;
import sumo.desktop_server.Database.Results.Result;
import sumo.desktop_server.Database.Results.ResultService;
import sumo.desktop_server.Database.Results.ResultServiceImpl;
import sumo.desktop_server.Database.Sex.Sex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GroupReport {
    PdfUtils pdfUtils = new PdfUtils();
    CategoryAtCompetitionPdfReport categoryAtCompetitionPdfReport = new CategoryAtCompetitionPdfReport();
    HeaderPdf headerPdf = new HeaderPdf();
    private static final Logger logger = LoggerFactory.getLogger(GroupReport.class);
    public ByteArrayInputStream generateReport(ReportService reportService, Competition competition, String sex, AgeCategory ageCategory, List<CategoryAtCompetition> categoryAtCompetitions, Map<Long, List<Result>> results, List<PointsClassification> pointsClassifications) throws DocumentException, FileNotFoundException {
        //age sex division
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        String competitionType = competition.getType().getType();
        String city = competition.getCity();
        LocalDate startDate = competition.getStartDate();
        LocalDate endDate = competition.getEndDate();


        TitlePagePdf titlePagePdf = new TitlePagePdf();
        titlePagePdf.generatePage(document,competition.getType().getType(),sex,ageCategory, competition.getCity(), competition.getStartDate(),competition.getEndDate());

        document.newPage();

        WeightCategoryReportComponent weightCategoryReportComponent = new WeightCategoryReportComponent();
        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions) {
            headerPdf.addHeader(writer,document,competitionType,sex, ageCategory, city,startDate, endDate, "KLASYFIKACJA INDYWIDUALNA");
            List<Result> resultList = results.get(categoryAtCompetition.getId());

            weightCategoryReportComponent.generateReport(document, resultList, categoryAtCompetition);
            document.newPage();
        }

        document.newPage();
        headerPdf.addHeader(writer,document,competitionType,sex, ageCategory, city,startDate,endDate, "KLASYFIKACJA DRUZYNOWA");
        PointClassificationReport pointClassificationReport = new PointClassificationReport();
        pointClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results);
        document.newPage();

        headerPdf.addHeader(writer,document,competitionType,sex, ageCategory, city,startDate,endDate, "KLASYFIKACJA DRUZYNOWA");
        MedalClassificationReport medalClassificationReport = new MedalClassificationReport();
        medalClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results,competition.getId());
        document.newPage();

        //sort individual report first famele then man from lower age category
        //gender

        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions){

            IndividualReportData reportData = reportService.getDataForIndividualReport(categoryAtCompetition.getId());
            categoryAtCompetitionPdfReport.categoryAtCompetitionReport(writer,document,out,
                   reportData.results(),reportData.competitors(),reportData.categoryAtCompetition(),
                   reportData.draw(),reportData.competitorInDrawList(),reportData.competitorsAndFightsInDraw());
            document.newPage();
        }

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
    public ByteArrayInputStream generateReport(ReportService reportService,Competition competition, AgeCategory ageCategory, List<CategoryAtCompetition> categoryAtCompetitions, Map<Long, List<Result>> results, List<PointsClassification> pointsClassifications) throws DocumentException, FileNotFoundException {
        //age divison
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        String competitionType = competition.getType().getType();
        String city = competition.getCity();
        LocalDate startDate = competition.getStartDate();
        LocalDate endDate = competition.getEndDate();

        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        TitlePagePdf titlePagePdf = new TitlePagePdf();
        titlePagePdf.generatePage(document,competition.getType().getType(),ageCategory, competition.getCity(), competition.getStartDate(),competition.getEndDate());
        document.newPage();


        WeightCategoryReportComponent weightCategoryReportComponent = new WeightCategoryReportComponent();
        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions) {

            if (results.containsKey(categoryAtCompetition.getId())) {
                headerPdf.addHeader(writer,document,competitionType, ageCategory.getName(), city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
                List<Result> resultList = results.get(categoryAtCompetition.getId());
                weightCategoryReportComponent.generateReport(document, resultList, categoryAtCompetition);
                document.newPage();
            }
        }

        document.newPage();
        headerPdf.addHeader(writer,document,competitionType, ageCategory.getName(), city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
        PointClassificationReport pointClassificationReport = new PointClassificationReport();
        pointClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results);

        document.newPage();
        headerPdf.addHeader(writer,document,competitionType, ageCategory.getName(), city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
        MedalClassificationReport medalClassificationReport = new MedalClassificationReport();
        medalClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results,competition.getId());
        document.newPage();




        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions){
            IndividualReportData reportData = reportService.getDataForIndividualReport(categoryAtCompetition.getId());
            categoryAtCompetitionPdfReport.categoryAtCompetitionReport(writer,document,out,
                    reportData.results(),reportData.competitors(),reportData.categoryAtCompetition(),
                    reportData.draw(),reportData.competitorInDrawList(),reportData.competitorsAndFightsInDraw());
            document.newPage();
        }
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
    public ByteArrayInputStream generateReport(ReportService reportService,Competition competition, String sex, List<CategoryAtCompetition> categoryAtCompetitions, Map<Long,List<Result>> results, List<PointsClassification> pointsClassifications) throws DocumentException, FileNotFoundException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        //sex division

        String competitionType = competition.getType().getType();
        String city = competition.getCity();
        LocalDate startDate = competition.getStartDate();
        LocalDate endDate = competition.getEndDate();

        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        TitlePagePdf titlePagePdf = new TitlePagePdf();
        titlePagePdf.generatePage(document,competition.getType().getType(),sex, competition.getCity(), competition.getStartDate(),competition.getEndDate());




        WeightCategoryReportComponent weightCategoryReportComponent = new WeightCategoryReportComponent();
        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions) {
            headerPdf.addHeader(writer,document,competitionType, sex, city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
            List<Result> resultList = results.get(categoryAtCompetition.getId());
            weightCategoryReportComponent.generateReport(document, resultList, categoryAtCompetition);
            document.newPage();
        }
        headerPdf.addHeader(writer,document,competitionType, sex, city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
        PointClassificationReport pointClassificationReport = new PointClassificationReport();
        pointClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results);
        document.newPage();

        headerPdf.addHeader(writer,document,competitionType, sex, city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
        MedalClassificationReport medalClassificationReport = new MedalClassificationReport();
        medalClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results,competition.getId());

        document.newPage();



        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions){

            IndividualReportData reportData = reportService.getDataForIndividualReport(categoryAtCompetition.getId());
            categoryAtCompetitionPdfReport.categoryAtCompetitionReport(writer,document,out,
                    reportData.results(),reportData.competitors(),reportData.categoryAtCompetition(),
                    reportData.draw(),reportData.competitorInDrawList(),reportData.competitorsAndFightsInDraw());
            document.newPage();
        }

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
    public ByteArrayInputStream generateReport(ReportService reportService, Competition competition, List<CategoryAtCompetition> categoryAtCompetitions, Map<Long,List<Result>> results, List<PointsClassification> pointsClassifications) throws DocumentException, FileNotFoundException {
        //full
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        String competitionType = competition.getType().getType();
        String city = competition.getCity();
        LocalDate startDate = competition.getStartDate();
        LocalDate endDate = competition.getEndDate();

        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        TitlePagePdf titlePagePdf = new TitlePagePdf();
        titlePagePdf.generatePage(document,competition.getType().getType(), competition.getCity(), competition.getStartDate(),competition.getEndDate());
        document.newPage();



        WeightCategoryReportComponent weightCategoryReportComponent = new WeightCategoryReportComponent();
        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions) {
            headerPdf.addHeader(writer,document,competitionType,city,startDate,endDate, "KLASYFIKACJA INDYWIDUALNA");
            List<Result> resultList = results.get(categoryAtCompetition.getId());
            weightCategoryReportComponent.generateReport(document, resultList, categoryAtCompetition);
            document.newPage();
        }

        PointClassificationReport pointClassificationReport = new PointClassificationReport();
        pointClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results);
        document.newPage();

        MedalClassificationReport medalClassificationReport = new MedalClassificationReport();
        medalClassificationReport.generateReport(document,categoryAtCompetitions,pointsClassifications,results,competition.getId());
        document.newPage();


        for (CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions){

            IndividualReportData reportData = reportService.getDataForIndividualReport(categoryAtCompetition.getId());
            categoryAtCompetitionPdfReport.categoryAtCompetitionReport(writer,document,out,
                    reportData.results(),reportData.competitors(),reportData.categoryAtCompetition(),
                    reportData.draw(),reportData.competitorInDrawList(),reportData.competitorsAndFightsInDraw());
            document.newPage();
        }

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
