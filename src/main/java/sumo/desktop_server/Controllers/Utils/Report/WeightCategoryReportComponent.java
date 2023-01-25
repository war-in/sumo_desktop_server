package sumo.desktop_server.Controllers.Utils.Report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sumo.desktop_server.Controllers.Utils.Report.Utils.PdfUtils;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.Competitor.PersonalDetails;
import sumo.desktop_server.Database.Results.Result;

import java.util.List;
import java.util.Map;

public class WeightCategoryReportComponent {
    PdfUtils pdfUtils = new PdfUtils();
    private static final Logger logger = LoggerFactory.getLogger(WeightCategoryReportComponent.class);

    public void generateReport(Document document, List<Result> resultsData, CategoryAtCompetition categoryAtCompetition) throws DocumentException {

        //header
        PdfPTable tableHeader = new PdfPTable(1);
        tableHeader.setWidthPercentage(100);
        String weightCategory = categoryAtCompetition.getCategory().getWeightCategory();
        pdfUtils.updateTableContextWithSize(tableHeader,"Kategoria wagowa: " + weightCategory + " kg",pdfUtils.getFontSize_10_bold(),Element.ALIGN_CENTER,20f);
        document.add(tableHeader);


        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1,4,3,1,3,4});
        float cellSize = 20f;

        pdfUtils.updateTableContextWithSize(table,"M-ce",pdfUtils.getFontSize_10_bold(),Element.ALIGN_CENTER,cellSize);
        pdfUtils.updateTableContextWithSize(table,"Nazwisko",pdfUtils.getFontSize_10_bold(),Element.ALIGN_LEFT,cellSize);
        pdfUtils.updateTableContextWithSize(table,"Imie",pdfUtils.getFontSize_10_bold(),Element.ALIGN_LEFT,cellSize);
        pdfUtils.updateTableContextWithSize(table,"Rok",pdfUtils.getFontSize_10_bold(),Element.ALIGN_CENTER,cellSize);
        pdfUtils.updateTableContextWithSize(table,"Nr licencji",pdfUtils.getFontSize_10_bold(),Element.ALIGN_CENTER,cellSize);
        pdfUtils.updateTableContextWithSize(table,"Kraj",pdfUtils.getFontSize_10_bold(),Element.ALIGN_LEFT,cellSize);
        logger.info("category: " + categoryAtCompetition.getId());
        for (Result data: resultsData){
            PersonalDetails personalDetails = data.getCompetitor().getPersonalDetails();
            int placement  = data.getPlacement();

            pdfUtils.updateTableContextAccorToPlacementWithSize(table,String.valueOf(placement), placement, pdfUtils.getFontSize_10(),Element.ALIGN_CENTER,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(table, personalDetails.getSurname(),placement,pdfUtils.getFontSize_10(),Element.ALIGN_LEFT,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(table, personalDetails.getName(),placement,pdfUtils.getFontSize_10(),Element.ALIGN_LEFT,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(table, String.valueOf(personalDetails.getBirthDate().getYear()),placement,pdfUtils.getFontSize_10(),Element.ALIGN_CENTER,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(table, "-",placement,pdfUtils.getFontSize_10(),Element.ALIGN_CENTER,cellSize);
            pdfUtils.updateTableContextAccorToPlacementWithSize(table, data.getCompetitor().getCountry(),placement,pdfUtils.getFontSize_10(),Element.ALIGN_CENTER,cellSize);
        }
        document.add(table);

    }
}
