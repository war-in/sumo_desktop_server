package sumo.desktop_server.Controllers.Utils.Report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import sumo.desktop_server.Controllers.Utils.Report.Utils.PdfUtils;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TitlePagePdf {
    private final PdfUtils pdfUtils = new PdfUtils();


    public void generatePage(Document document,String competitionType, String sex, AgeCategory ageCategory, String city, LocalDate startDate, LocalDate endDate) throws FileNotFoundException, DocumentException {


        pdfUtils.skipLines(document,7);

        Paragraph competitionTypeP = new Paragraph(competitionType,pdfUtils.getFontSize_10());
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        String polishSex;
        if (sex.equals("famele")){
            polishSex = "Kobiety";
        }else {
            polishSex = "Mezczyzni";
        }
        Paragraph p = new Paragraph(polishSex+","+" grupa wiekowa: " + ageCategory.getName());
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);

        int startDay = startDate.getDayOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");


        Paragraph date = new Paragraph(city + " " + startDay + "-"+formatter.format(endDate));
        date.setAlignment(Element.ALIGN_CENTER);
        document.add(date);

    }
    public void generatePage(Document document,String competitionType,AgeCategory ageCategory, String city, LocalDate startDate, LocalDate endDate) throws FileNotFoundException, DocumentException {

        pdfUtils.skipLines(document,7);

        Paragraph competitionTypeP = new Paragraph(competitionType);
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        Paragraph p = new Paragraph("Grupa wiekowa: " + ageCategory.getName());
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);

        int startDay = startDate.getDayOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");


        Paragraph date = new Paragraph(city + " " + startDay + "-"+formatter.format(endDate));
        date.setAlignment(Element.ALIGN_CENTER);
        document.add(date);

    }
    public void generatePage(Document document,String competitionType, String sex, String city, LocalDate startDate, LocalDate endDate) throws FileNotFoundException, DocumentException {

        pdfUtils.skipLines(document,7);

        Paragraph competitionTypeP = new Paragraph(competitionType,pdfUtils.getFontSize_10());
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        String polishSex;
        if (sex.equals("famele")){
            polishSex = "Kobiety";
        }else {
            polishSex = "Mezczyzni";
        }
        Paragraph p = new Paragraph(polishSex);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);

        int startDay = startDate.getDayOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");


        Paragraph date = new Paragraph(city + " " + startDay + "-"+formatter.format(endDate));
        date.setAlignment(Element.ALIGN_CENTER);
        document.add(date);

    }
    public void generatePage(Document document,String competitionType, String city, LocalDate startDate, LocalDate endDate) throws FileNotFoundException, DocumentException {

        pdfUtils.skipLines(document,7);

        Paragraph competitionTypeP = new Paragraph(competitionType,pdfUtils.getFontSize_10());
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        int startDay = startDate.getDayOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");


        Paragraph date = new Paragraph(city + " " + startDay + "-"+formatter.format(endDate));
        date.setAlignment(Element.ALIGN_CENTER);
        document.add(date);

    }
}
