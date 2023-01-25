package sumo.desktop_server.Controllers.Utils.Report.Utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfUtils {
    Font fontSize_5 =  FontFactory.getFont(FontFactory.HELVETICA, 5f);
    Font fontSize_8 =  FontFactory.getFont(FontFactory.HELVETICA, 8f);
    Font fontSize_8_bold =  FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8f);

    public Font getFontSize_8_bold() {
        return fontSize_8_bold;
    }

    Font fontSize_10 =  FontFactory.getFont(FontFactory.HELVETICA, 10f);
    Font fontSize_10_bold =  FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10f);
    public void skipLines(Document document,int lineSkipp) throws DocumentException {
        String ch = "\n";
        Paragraph p = new Paragraph(ch.repeat(lineSkipp));
        document.add(p);

    }

    public Font getFontSize_8() {
        return fontSize_8;
    }

    public Font getFontSize_10_bold() {
        return fontSize_10_bold;
    }

    public Font getFontSize_10() {
        return fontSize_10;
    }
    public void updateTableContext1(PdfPTable table, String context, Font fontSize,int aligement){

        PdfPCell cell = new PdfPCell(new Phrase(context,fontSize));
        cell.setHorizontalAlignment(aligement);
        table.addCell(cell);
    }
    public void updateTableContextAccorToPlacementWithSize(PdfPTable table,String context,int placement,  Font fontSize,int aligement, float cellSize){
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(context,fontSize));
        cell.setHorizontalAlignment(aligement);
        cell.setFixedHeight(cellSize);
        if (placement == 1){
            cell.setBackgroundColor(new BaseColor(255,215,0));
        }
        if (placement == 2) {
            cell.setBackgroundColor(new BaseColor(192,192,192));
        }
        if (placement == 3){
            cell.setBackgroundColor(new BaseColor(153,101,21));
        }
        table.addCell(cell);

    }
    public void updateTableContextWithSize(PdfPTable table,String context ,Font fontSize ,int alignment, float cellSize){

        PdfPCell cell = new PdfPCell(new Phrase(context,fontSize));
        cell.setHorizontalAlignment(alignment);
        cell.setFixedHeight(cellSize);
        table.addCell(cell);

    }
    public void updateTableContextWithColor(PdfPTable table,String contextLeft,float cellSize,Font fontSize,BaseColor color){

        PdfPCell cell = new PdfPCell(new Phrase(contextLeft,fontSize));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        cell.setBackgroundColor(color);
        table.addCell(cell);

    }
}
