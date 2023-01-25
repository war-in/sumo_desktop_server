package sumo.desktop_server.Controllers.Utils.Report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import sumo.desktop_server.Controllers.Utils.Report.Utils.PdfUtils;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HeaderPdf {
    PdfUtils pdfUtils = new PdfUtils();
    BaseColor baseColorDarkGrey = new BaseColor(105,105,105);
    BaseColor baseColorGrey = new BaseColor(128,128,128);
    Font grey = FontFactory.getFont(FontFactory.HELVETICA,15f, baseColorDarkGrey);
    Font lightGrey = FontFactory.getFont(FontFactory.HELVETICA,10f, baseColorGrey);

    public void addHeader(PdfWriter writer, Document document, String competitionType, String sex, AgeCategory ageCategory, String city, LocalDate startDate, LocalDate endDate, String classification) throws DocumentException {
        //age sex
        float pdfPageWidth = document.getPageSize().getWidth();

        Chunk competitionTypeString = new Chunk(competitionType,grey);
        Paragraph competitionTypeP = new Paragraph(competitionTypeString);
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        int startDay = startDate.getDayOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        String polishSex;
        if (sex.equals("famele")){
            polishSex = "Kobiety";
        }else {
            polishSex = "Mezczyzni";
        }
        pdfUtils.skipLines(document,1);

        String date = city + " " + startDay + "-"+formatter.format(endDate);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell(polishSex +", grupa wiekowa: "+ ageCategory.getName(), Element.ALIGN_LEFT));
        table.addCell(getCell(date, Element.ALIGN_RIGHT));
        document.add(table);

        float tableWidth = table.getTotalWidth();

        float xLeft = (pdfPageWidth - tableWidth)/2;

        float xRight = pdfPageWidth - xLeft;

        PdfContentByte cb = writer.getDirectContent();

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true) - 5f;

        cb.setColorStroke(baseColorGrey);
        cb.moveTo(xLeft,positionY);
        cb.lineTo(xRight,positionY);
        cb.closePathStroke();
        pdfUtils.skipLines(document,1);
        Paragraph p = new Paragraph(classification, FontFactory.getFont(FontFactory.HELVETICA_BOLD,15f));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        pdfUtils.skipLines(document,1);

    }
    private PdfPCell getCell(String text, int alignment){
        PdfPCell cell = new PdfPCell(new Paragraph(text,lightGrey));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
    public void addHeader(PdfWriter writer, Document document, String competitionType, AgeCategory ageCategory, String city, LocalDate startDate, LocalDate endDate, String classification) throws DocumentException {
        //age
        float pdfPageWidth = document.getPageSize().getWidth();

        Chunk competitionTypeString = new Chunk(competitionType,grey);
        Paragraph competitionTypeP = new Paragraph(competitionTypeString);
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        int startDay = startDate.getDayOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        pdfUtils.skipLines(document,1);

        String date = city + " " + startDay + "-"+formatter.format(endDate);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("grupa wiekowa: "+ ageCategory.getName(), Element.ALIGN_LEFT));
        table.addCell(getCell(date, Element.ALIGN_RIGHT));
        document.add(table);

        float tableWidth = table.getTotalWidth();

        float xLeft = (pdfPageWidth - tableWidth)/2;

        float xRight = pdfPageWidth - xLeft;

        PdfContentByte cb = writer.getDirectContent();

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true) - 5f;

        cb.setColorStroke(baseColorGrey);
        cb.moveTo(xLeft,positionY);
        cb.lineTo(xRight,positionY);
        cb.closePathStroke();
        pdfUtils.skipLines(document,1);
        Paragraph p = new Paragraph(classification, FontFactory.getFont(FontFactory.HELVETICA_BOLD,15f));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        pdfUtils.skipLines(document,1);

    }

    public void addHeader(PdfWriter writer, Document document, String competitionType, String sex, String city, LocalDate startDate, LocalDate endDate, String classification) throws DocumentException {
        // sex
        float pdfPageWidth = document.getPageSize().getWidth();

        Chunk competitionTypeString = new Chunk(competitionType,grey);
        Paragraph competitionTypeP = new Paragraph(competitionTypeString);
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        int startDay = startDate.getDayOfMonth();

        String polishSex;
        if (sex.equals("famele")){
            polishSex = "Kobiety";
        }else {
            polishSex = "Mezczyzni";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        pdfUtils.skipLines(document,1);

        String date = city + " " + startDay + "-"+formatter.format(endDate);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell(polishSex, Element.ALIGN_LEFT));
        table.addCell(getCell(date, Element.ALIGN_RIGHT));
        document.add(table);

        float tableWidth = table.getTotalWidth();

        float xLeft = (pdfPageWidth - tableWidth)/2;

        float xRight = pdfPageWidth - xLeft;

        PdfContentByte cb = writer.getDirectContent();

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true) - 5f;

        cb.setColorStroke(baseColorGrey);
        cb.moveTo(xLeft,positionY);
        cb.lineTo(xRight,positionY);
        cb.closePathStroke();
        pdfUtils.skipLines(document,1);
        Paragraph p = new Paragraph(classification, FontFactory.getFont(FontFactory.HELVETICA_BOLD,15f));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        pdfUtils.skipLines(document,1);

    }

    public void addHeader(PdfWriter writer, Document document, String competitionType, String city, LocalDate startDate, LocalDate endDate, String classification) throws DocumentException {
        // sex
        float pdfPageWidth = document.getPageSize().getWidth();

        Chunk competitionTypeString = new Chunk(competitionType,grey);
        Paragraph competitionTypeP = new Paragraph(competitionTypeString);
        competitionTypeP.setAlignment(Element.ALIGN_CENTER);
        document.add(competitionTypeP);

        int startDay = startDate.getDayOfMonth();



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        pdfUtils.skipLines(document,1);

        String date = city + " " + startDay + "-"+formatter.format(endDate);
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.addCell(getCell(date, Element.ALIGN_RIGHT));
        document.add(table);

        float tableWidth = table.getTotalWidth();

        float xLeft = (pdfPageWidth - tableWidth)/2;

        float xRight = pdfPageWidth - xLeft;

        PdfContentByte cb = writer.getDirectContent();

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true) - 5f;

        cb.setColorStroke(baseColorGrey);
        cb.moveTo(xLeft,positionY);
        cb.lineTo(xRight,positionY);
        cb.closePathStroke();
        pdfUtils.skipLines(document,1);
        Paragraph p = new Paragraph(classification, FontFactory.getFont(FontFactory.HELVETICA_BOLD,15f));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        pdfUtils.skipLines(document,1);

    }

}
