package sumo.desktop_server.Database.CategoryAtCompetition;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sumo.desktop_server.Controllers.Utils.Report.BucketHelper;
import sumo.desktop_server.Controllers.Utils.Report.LadderHelper;
import sumo.desktop_server.Controllers.Utils.Report.LadderHelper16;
import sumo.desktop_server.Database.AgeCategory.AgeCategory;
import sumo.desktop_server.Database.Category.Category;
import sumo.desktop_server.Database.Competition.Competition;
import sumo.desktop_server.Database.CompetitionType.CompetitionType;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.Competitor.PersonalDetails;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Results.Result;
import sumo.desktop_server.Database.Sex.Sex;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.List;


public class CategoryAtCompetitionPdfReport {
    private static final Logger logger = LoggerFactory.getLogger(CategoryAtCompetitionPdfReport.class);
    private  boolean upEven = false;
    private  boolean upOdd = false;
    private float previousHeight;

    Font fontSize_5 =  FontFactory.getFont(FontFactory.TIMES, 5f);
    Font fontSize_8 =  FontFactory.getFont(FontFactory.TIMES, 8f);
    Font fontSize_10 =  FontFactory.getFont(FontFactory.TIMES, 10f);

    Font fontSize_5_Helvetica =  FontFactory.getFont(FontFactory.HELVETICA, 5f);
    Font fontSize_8_Helvetica =  FontFactory.getFont(FontFactory.HELVETICA, 8f);
    Font fontSize_8_Helvetica_Bold =  FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8f);
    Font fontSize_10_Helvetica =  FontFactory.getFont(FontFactory.HELVETICA, 10f);
    Font fontSize_10_Helvetica_Bold =  FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10f);



    public ByteArrayInputStream categoryAtCompetitionReport(List<Result> results,List<Competitor> competitorLit, CategoryAtCompetition categoryAtCompetition, Draw draw, List<CompetitorInDraw> competitorInDrawList, List<Fight> fights){
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Competition competition = categoryAtCompetition.getCompetition();
        String city = competition.getCity();
        CompetitionType type = competition.getType();

        LocalDate date = categoryAtCompetition.getDate();

        Category category = categoryAtCompetition.getCategory();
        String weightCategory = category.getWeightCategory();
        Sex sex = category.getSex();

        AgeCategory ageCategory = category.getAgeCategory();
        String ageCategoryName = ageCategory.getName();

        int drawType = draw.getDrawType().getNumberOfCompetitors();
        logger.info(Integer.toString(drawType));

        List<Fight> fightList = fights.stream().sorted(Comparator.comparing(Fight::getNumberOfPlaceInDraw)).toList();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            //PdfWriter.getInstance(document,out);
            document.open();


            this.addDocHead(document, type.getType(), city, date);
            this.addToPodHead(document, sex.getSex(), ageCategoryName, weightCategory);
            if (drawType == 5){
                int numberOfPlayersInDraw = competitorInDrawList.size();
                this.addMainTable(document,numberOfPlayersInDraw,weightCategory);
                BucketHelper bucketHelper = new BucketHelper(numberOfPlayersInDraw,competitorInDrawList,fightList);
                this.addDetails(document, competitorLit,bucketHelper,results);

                List<BucketHelper> bucketHelperList = bucketHelper.generateBuckets();
                if (bucketHelperList.size() > 0) {
                    BucketHelper bucketHelper1 = bucketHelperList.get(0);
                    document.add(new Paragraph("\n\n\n"));
                    Paragraph paragraph = new Paragraph("PLAY-OFF");
                    paragraph.setAlignment(Element.ALIGN_CENTER);
                    document.add(paragraph);
                    document.add(new Paragraph("\n\n\n"));
                    logger.info("competitors in dogrywki: " + bucketHelper1.getCompetitorInDrawList().size());
                    this.addMainTable(document,bucketHelper1.getCompetitorInDrawList().size(),weightCategory);
                    this.addDetails(document,competitorLit,bucketHelper1,results);

                }

            }
            if (drawType == 8){
                this.addLadder8(document, writer, competitorInDrawList, competitorLit, drawType,fightList);

            }
            if (drawType == 16){
                this.addLadder16(document,writer, competitorInDrawList, competitorLit, drawType,fightList);

            }

            document.close();


        }catch (DocumentException ex) {
            logger.error("Error occurred: {0}", ex);
        }


        return new ByteArrayInputStream(out.toByteArray());
    }
    public void categoryAtCompetitionReport(PdfWriter writer, Document document,ByteArrayOutputStream out ,List<Result> results,List<Competitor> competitorLit, CategoryAtCompetition categoryAtCompetition, Draw draw, List<CompetitorInDraw> competitorInDrawList, List<Fight> fights){

        Competition competition = categoryAtCompetition.getCompetition();
        String city = competition.getCity();
        CompetitionType type = competition.getType();

        LocalDate date = categoryAtCompetition.getDate();

        Category category = categoryAtCompetition.getCategory();
        String weightCategory = category.getWeightCategory();
        Sex sex = category.getSex();

        AgeCategory ageCategory = category.getAgeCategory();
        String ageCategoryName = ageCategory.getName();

        int drawType = draw.getDrawType().getNumberOfCompetitors();
        logger.info(Integer.toString(drawType));

        List<Fight> fightList = fights.stream().sorted(Comparator.comparing(Fight::getNumberOfPlaceInDraw)).toList();

        try {

            //PdfWriter.getInstance(document,out)
            this.addDocHead(document, type.getType(), city, date);
            logger.info("tu jestem 2");

            this.addToPodHead(document, sex.getSex(), ageCategoryName, weightCategory);
            logger.info("tu jestem 3");
            if (drawType == 5){
                int numberOfPlayersInDraw = competitorInDrawList.size();
                this.addMainTable(document,numberOfPlayersInDraw,weightCategory);
                BucketHelper bucketHelper = new BucketHelper(numberOfPlayersInDraw,competitorInDrawList,fightList);
                this.addDetails(document, competitorLit,bucketHelper,results);

                List<BucketHelper> bucketHelperList = bucketHelper.generateBuckets();
                if (bucketHelperList.size() > 0) {
                    BucketHelper bucketHelper1 = bucketHelperList.get(0);
                    document.add(new Paragraph("\n\n\n"));
                    Paragraph paragraph = new Paragraph("PLAY-OFF");
                    paragraph.setAlignment(Element.ALIGN_CENTER);
                    document.add(paragraph);
                    document.add(new Paragraph("\n\n\n"));
                    logger.info("competitors in dogrywki: " + bucketHelper1.getCompetitorInDrawList().size());
                    this.addMainTable(document,bucketHelper1.getCompetitorInDrawList().size(),weightCategory);
                    this.addDetails(document,competitorLit,bucketHelper1,results);

                }

            }
            logger.info("tu jestem 4");

            if (drawType == 8){
                this.addLadder8(document, writer, competitorInDrawList, competitorLit, drawType,fightList);

            }
            if (drawType == 16){
                this.addLadder16(document,writer, competitorInDrawList, competitorLit, drawType,fightList);

            }

        }catch (DocumentException ex) {
            logger.error("Error occurred: {0}", ex);
        }

    }
    private void addDocHead(Document document,String type, String city,LocalDate date) throws DocumentException {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(50);

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        logger.info(type);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase(type, headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase(city + " " + date, headFont));
        logger.info(city + date);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        document.add(table);

    }
    private void addToPodHead(Document document,String sex,String ageCategory, String weightCategory) throws DocumentException {
        Font fontSize_10 =  FontFactory.getFont(FontFactory.TIMES, 10f);
        Paragraph paragraph1 = new Paragraph(sex + "    " + ageCategory + "     " + "Weight category: " + weightCategory,fontSize_10);
        paragraph1.setAlignment(Element.ALIGN_CENTER);

        //document.setMargins(200, 36, 36, 36);

        document.add(paragraph1);

        document.add(new Paragraph("\n\n"));
    }

    private void addMainTable(Document document,int numberOfPlayersInDraw,String weightCategory) throws DocumentException {
        PdfPTable table = new PdfPTable(17 + numberOfPlayersInDraw);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell(new Phrase("No.",fontSize_8_Helvetica));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);//1
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Draw place",fontSize_8_Helvetica));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);//1
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Weight: " + weightCategory));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(12);
        table.addCell(cell);

        Font fontSize_10 = FontFactory.getFont(FontFactory.HELVETICA,10f);
        cell = new PdfPCell(new Phrase("Year of birth",fontSize_8_Helvetica));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("RESULTS"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(numberOfPlayersInDraw);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Sum of points",fontSize_8_Helvetica));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Placement",fontSize_8_Helvetica));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Surname Name"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(8);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Country"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(4);
        table.addCell(cell);

        String[] rounds = {"I","II","III","IV","V"};
        logger.info("players in draw: " + numberOfPlayersInDraw);
        for (int i = 0; i<numberOfPlayersInDraw; i++){
            cell = new PdfPCell(new Phrase(rounds[i]));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        //document.add(table);
    }
    private void addDetails(Document document,List<Competitor> competitorList,BucketHelper bucketHelper,List<Result> results) throws DocumentException {
        int numberOfCompetitors = bucketHelper.getCompetitorInDrawList().size();
        PdfPTable table = new PdfPTable(7 + numberOfCompetitors);
        table.setWidthPercentage(100);

        int[] baseWidths = new int[]{1,1,8,4,1,1,1,1,1,1,1,1};
        int[] widths = Arrays.copyOfRange(baseWidths,0,7 + numberOfCompetitors);

        table.setWidths(widths);

        List<CompetitorInDraw> sortedByCompetitorList = new ArrayList<>();
        List<CompetitorInDraw> competitorInDrawList = bucketHelper.getCompetitorInDrawList();

        int numberOfPlayersOrRounds = competitorInDrawList.size();

        //obczaj po co to jest xd
        for (Competitor competitor: competitorList){
            for (CompetitorInDraw competitorInDraw: competitorInDrawList){
                if (competitor.getId().equals(competitorInDraw.getCompetitor().getId())){
                    sortedByCompetitorList.add(competitorInDraw);
                }
            }
        }


        int Lp = 1;

        for (Competitor competitor: competitorList){
            logger.info("competitors in list: " + competitor.getId());
        }
        String[] placements = {"I","II","III","IV","V"};

        for (CompetitorInDraw competitorInDraw : sortedByCompetitorList){
            Competitor competitor = competitorInDraw.getCompetitor();
            int placement = results.stream().filter(result -> result.getCompetitor().getId().equals(competitor.getId())).findFirst().get().getPlacement();
            PersonalDetails personalDetails = competitor.getPersonalDetails();

            updateTableContextAccorToPlacement(table,Integer.toString(Lp),placement);

            updateTableContextAccorToPlacement(table,Integer.toString(competitorInDraw.getNumberOfPlaceInDraw()),placement);

            updateTableContextAccorToPlacement(table,personalDetails.getName() + " " + personalDetails.getSurname(),placement);

            updateTableContextAccorToPlacement(table,competitor.getCountry(),placement);


            DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
            Date date = java.util.Date.from(personalDetails.getBirthDate().atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

            String formattedDate = df.format(date);

            updateTableContextAccorToPlacement(table,formattedDate,placement);

            //Wyniki ilosc rund sumapkt miejsce nie ma tego w bazie jeszcze.
            //zmienic inty na longi bo bez sensu

            int sumOfPoints = 0;

            for (int numberOfRound =1; numberOfRound<=numberOfPlayersOrRounds; numberOfRound++){
                String cellResult;
                logger.info("Competitor id: " + competitor.getId());
                if (bucketHelper.competitorHasBreak(competitor.getId())) {

                    logger.info("number of round" + numberOfRound);
                    int result = bucketHelper.getFightResultForCompetitor(numberOfRound,competitor.getId());
                    cellResult = Integer.toString(result);
                    if (result == 1)
                        sumOfPoints++;
                }else {
                    cellResult = "-";
                }
                bucketHelper.shiftElements();
                bucketHelper.updateSumOfPoints(sumOfPoints,competitor.getId());

                updateTableContextAccorToPlacement(table,cellResult,placement);
            }

            updateTableContextAccorToPlacement(table,Integer.toString(sumOfPoints),placement);

            //placemenrt

            updateTableContextAccorToPlacement(table,placements[placement-1],placement);

            Lp++;

        }
        document.add(table);

    }
    private void updateTableContextAccorToPlacement(PdfPTable table,String context,int placement){
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(context));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
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
    private void addLadder8(Document document,PdfWriter writer,List<CompetitorInDraw> competitorInDrawList,List<Competitor> competitorList,int numberOfCompetitors,List<Fight> fights) throws DocumentException {
        int[] padding = {30,100,30,150,30,100,30};
        int[] matches = {0,0,0,10,1,1,1};
        LadderHelper ladderHelper = new LadderHelper(fights,competitorInDrawList);
        ladderHelper.generateLinearTableFromFights();
        Map<Integer,Integer> map = ladderHelper.getActualFightIndexToArrayIndex();
        map.forEach((integer, integer2) -> logger.info("key: " + integer + " " + "value" + integer2));
        for (int i =0; i<7; i++) {
            addComponent8(document,writer,padding[i],3,i,8,18f,ladderHelper,matches[i]);
            //document.add(new Paragraph("\n\n\n"));
        }
        Paragraph paragraph = new Paragraph("REPECHAGE",fontSize_10_Helvetica_Bold);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        this.addRepechage8(document,writer, ladderHelper);
    }
    private void addLadder16(Document document,PdfWriter writer,List<CompetitorInDraw> competitorInDrawList,List<Competitor> competitorList,int numberOfCompetitors,List<Fight> fights) throws DocumentException {



        int[] padding = {30,100,30,150,30,100,30,200};
        LadderHelper16 ladderHelper = new LadderHelper16(fights, competitorInDrawList);
        ladderHelper.initializeActualFightIndexMap();
        int[] matches = {0,0,0,12,1,1,1,22,2,2,2,12,3,3,3};


        Map<Integer,Integer> map = ladderHelper.getActualFightIndexToArrayIndex();
        map.forEach((integer, integer2) -> logger.info("key: " + integer + " " + "value" + integer2));


        for (int i =0; i<15; i++) {

            addComponent3(document,writer,padding[i%8],2,i,16,12f,ladderHelper,matches[i]);

        }
        Paragraph paragraph = new Paragraph("REPECHAGE",fontSize_10_Helvetica_Bold);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        this.addRepechage16(document,writer,ladderHelper);
    }
    private void addComponent8(Document document, PdfWriter writer, int padding , int lineSkipp, int index, int numberOfCompetitorsRepechage, float cellSize, LadderHelper ladderHelper, int matchNumber) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;

        float pdfPageWidth = document.getPageSize().getWidth();
        //table.setWidthPercentage(10);
        table.setTotalWidth(new float[]{10f,70f});


        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true);

        //competitor left
        ladderHelper.goToMatch(matchNumber);
        if (matchNumber == 10){
            ladderHelper.loadFinal();;
        }else {
            ladderHelper.loadActualMatch();
        }

        Fight actual = ladderHelper.getActualFight();
        Fight opposite = ladderHelper.getOppositeFight();

        logger.info("actual :" + actual.getNumberOfPlaceInDraw());
        logger.info("opposite :" + opposite.getNumberOfPlaceInDraw());

        PersonalDetails competitorLeft = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
        PersonalDetails competitorRight = ladderHelper.getActualRightCompetitor().getPersonalDetails();

        updateTableContext(table,String.valueOf(ladderHelper.getNumberOfPlaceInDrawLeft()), competitorLeft.getName() + " " + competitorLeft.getSurname(), cellSize, fontSize_8);



        PdfContentByte cb = writer.getDirectContent();
        table.writeSelectedRows(0,-1,padding,positionY,cb);

        float tableWidth = table.getTotalWidth();
        float tableHeight = table.getTotalHeight();

        float moveToXLeft =  padding + tableWidth ;
        float moveToYLeft = positionY - tableHeight/2;

        float moveToXRight = pdfPageWidth - padding - tableWidth;
        float moveToYRight = moveToYLeft;


        //right
        PdfPTable tableRight = new PdfPTable(2);
        tableRight.setTotalWidth(new float[]{70f,10f});

        updateTableContext(tableRight,competitorRight.getName() + " " + competitorRight.getSurname(),String.valueOf(ladderHelper.getNumberOfPlaceInDrawRight()),cellSize,fontSize_8);

        tableRight.writeSelectedRows(0,-1,pdfPageWidth - padding - tableWidth,positionY,cb);


        String ch = "\n";
        Paragraph p = new Paragraph(ch.repeat(lineSkipp));
        document.add(p);

        writer.getVerticalPosition(false);
        float positionYNew = writer.getVerticalPosition(true);

        float diffBetweenComponent = positionYNew - positionY;


        //maly dzyndzel
        cb.moveTo(moveToXLeft,moveToYLeft);
        cb.lineTo(moveToXLeft + 4 ,moveToYLeft);
        float newMoveToXLeft = moveToXLeft + 4;

        cb.moveTo(moveToXRight,moveToYRight);
        cb.lineTo(moveToXRight -4, moveToYRight);
        float newMoveToXRight = moveToXRight -4;



        if (index % 2 == 0){

            if (upEven){
                //left
                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,previousHeight - tableHeight);

                //right
                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight, previousHeight - tableHeight);

                upEven = false;

            }  else
            {
                writer.getVerticalPosition(false);
                positionY = writer.getVerticalPosition(true);

                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,positionY);

                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight,positionY);

                upEven = true;
            }
        }else if (index  == 3){
                    float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks,moveToYLeft );

                    cb.moveTo(newMoveToXLeft + diffBetweenMidBlocks/2,moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks/2, moveToYLeft - 22f);

                    cb.stroke();

                float widthOfText = fontSize_10.getCalculatedBaseFont(true).getWidthPoint("FINAL",fontSize_10.getCalculatedSize());
                FixText("FINAL",pdfPageWidth/2 - widthOfText/2,moveToYLeft + 22f,writer,10);

                    PdfPTable finalTable = new PdfPTable(2);
                    finalTable.setTotalWidth(new float[]{10f,110f});

                    finalTable.setHorizontalAlignment(Element.ALIGN_CENTER);
                    List<Competitor> top4Competitors = ladderHelper.getTop4Competitors();

                    int placement = 1;
                    for (Competitor competitor: top4Competitors){
                        PersonalDetails personalDetails = competitor.getPersonalDetails();
                        if (placement == 4)
                            placement --;

                        if (placement == 1)
                            updateTableContextWithColor(finalTable,String.valueOf(placement),
                                    personalDetails.getName() + " " + personalDetails.getSurname(),cellSize,fontSize_10,new BaseColor(255,215,0));
                        if (placement == 2)
                            updateTableContextWithColor(finalTable,String.valueOf(placement),
                                    personalDetails.getName() + " " + personalDetails.getSurname(),cellSize,fontSize_10,new BaseColor(192,192,192));
                        if (placement == 3)
                            updateTableContextWithColor(finalTable,String.valueOf(placement),
                                    personalDetails.getName() + " " + personalDetails.getSurname(),cellSize,fontSize_10,new BaseColor(153,101,21));
                        placement ++;

                    }


                    finalTable.setTotalWidth(new float[]{10f, diffBetweenMidBlocks - 10f});
                    finalTable.writeSelectedRows(0, 4, newMoveToXLeft, moveToYLeft - 22f, cb);


            }
            else {
            drawLines(positionY, cb, tableHeight, moveToYLeft, moveToYRight, diffBetweenComponent, newMoveToXLeft, newMoveToXRight);

        }

        previousHeight = positionY;

        cb.closePathStroke();
    }

    private void addComponent3(Document document,PdfWriter writer,int padding,int lineSkipp, int index,int numberOfCompetitorsRepechage,float cellSize,LadderHelper16 ladderHelper, int matchNumber) throws DocumentException {


        Font fontSize_10 =  FontFactory.getFont(FontFactory.TIMES, 10f);

        PdfPTable table = new PdfPTable(2);

        float pdfPageWidth = document.getPageSize().getWidth();

        table.setTotalWidth(new float[]{10f,70f});

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true);


        ladderHelper.goToMatch(matchNumber);
        if (index == 7){
            ladderHelper.loadFinal();
        }
        else if (index == 11 || index == 3){
            if (index == 11){
                ladderHelper.setCounter(2);
            }
            ladderHelper.loadActualMatch(1);
            if (index == 3){
                ladderHelper.setCounter(0);
            }
        }else {
            ladderHelper.loadActualMatch(4);
        }




        PersonalDetails competitorLeft = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
        PersonalDetails competitorRight = ladderHelper.getActualRightCompetitor().getPersonalDetails();

        updateTableContext(table, ladderHelper.getNumberOfPlaceInDrawLeft(),
                competitorLeft.getName() + " " + competitorLeft.getSurname(),cellSize,fontSize_5);



        PdfContentByte cb = writer.getDirectContent();
        table.writeSelectedRows(0,-1,padding,positionY,cb);

        float tableWidth = table.getTotalWidth();
        float tableHeight = table.getTotalHeight();

        float moveToXLeft =  padding + tableWidth ;
        float moveToYLeft = positionY - tableHeight/2;

        float moveToXRight = pdfPageWidth - padding - tableWidth;
        float moveToYRight = moveToYLeft;


        PdfPTable tableRight = new PdfPTable(2);
        tableRight.setTotalWidth(new float[]{70f,10f});

        updateTableContext(tableRight,
                competitorRight.getName() + " " + competitorRight.getSurname(), ladderHelper.getNumberOfPlaceInDrawRight(), cellSize,fontSize_5);
        tableRight.writeSelectedRows(0,-1,pdfPageWidth - padding - tableWidth,positionY,cb);




        String ch = "\n";
        Paragraph p = new Paragraph(ch.repeat(lineSkipp));
        document.add(p);

        writer.getVerticalPosition(false);
        float positionYNew = writer.getVerticalPosition(true);

        float diffBetweenComponent = positionYNew - positionY;


        //maly dzyndzel
        cb.moveTo(moveToXLeft,moveToYLeft);
        cb.lineTo(moveToXLeft + 4 ,moveToYLeft);
        float newMoveToXLeft = moveToXLeft + 4;

        cb.moveTo(moveToXRight,moveToYRight);
        cb.lineTo(moveToXRight -4, moveToYRight);
        float newMoveToXRight = moveToXRight -4;



        if (index % 2 == 0){

            if (upEven){
                //left
                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,previousHeight - tableHeight);

                //right
                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight, previousHeight - tableHeight);

                upEven = false;

            }  else
            {
                writer.getVerticalPosition(false);
                positionY = writer.getVerticalPosition(true);

                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,positionY);

                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight,positionY);

                upEven = true;
            }
        }else {
            if (index  == 3 || index == 11 || index == 7){
                if (index == 7 && numberOfCompetitorsRepechage == 16){
                    float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;

                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks,moveToYLeft );

                    cb.moveTo(newMoveToXLeft + diffBetweenMidBlocks/2,moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks/2, moveToYLeft - 22f);

                    cb.stroke();

                    float widthOfText = fontSize_10.getCalculatedBaseFont(true).getWidthPoint("FINAL",fontSize_10.getCalculatedSize());
                    FixText("FINAL",pdfPageWidth/2 - widthOfText/2,moveToYLeft + 22f,writer,10);

                    List<Competitor> top4Competitors = ladderHelper.getTop4Competitors();
                    int placement = 1;
                    PdfPTable finalTable = new PdfPTable(2);

                    finalTable.setTotalWidth(new float[]{10f,110f});

                    finalTable.setHorizontalAlignment(Element.ALIGN_CENTER);


                    for (Competitor competitor: top4Competitors){
                        if (placement == 4)
                            placement --;

                        if (placement == 1)
                            updateTableContextWithColor(finalTable,String.valueOf(placement),
                                competitor.getPersonalDetails().getName() + " " + competitor.getPersonalDetails().getSurname(),cellSize,fontSize_5,new BaseColor(255,215,0));
                        if (placement == 2)
                            updateTableContextWithColor(finalTable,String.valueOf(placement),
                                    competitor.getPersonalDetails().getName() + " " + competitor.getPersonalDetails().getSurname(),cellSize,fontSize_5,new BaseColor(192,192,192));
                        if (placement == 3)
                            updateTableContextWithColor(finalTable,String.valueOf(placement),
                                    competitor.getPersonalDetails().getName() + " " + competitor.getPersonalDetails().getSurname(),cellSize,fontSize_5,new BaseColor(153,101,21));
                        placement ++;
                    }

                    finalTable.setTotalWidth(new float[]{10f, diffBetweenMidBlocks + 70f});
                    finalTable.writeSelectedRows(0, 4, moveToXLeft - 35f, moveToYLeft - 22f, cb);

                }
                else if (index == 3){
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 4 );

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY + diffBetweenComponent * 4 );


                } else {
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY - diffBetweenComponent * 4 - tableHeight);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY - diffBetweenComponent * 4 - tableHeight);

                }

            }
            else {
                if (upOdd){
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY - diffBetweenComponent * 2 - tableHeight);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY - diffBetweenComponent * 2 - tableHeight);
                    upOdd = false;

                }else {
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 2);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY + diffBetweenComponent * 2);
                    upOdd = true;
                }

            }
        }
        previousHeight = positionY;

        cb.closePathStroke();


    }
    private void drawLines(float positionY, PdfContentByte cb, float tableHeight, float moveToYLeft, float moveToYRight, float diffBetweenComponent, float newMoveToXLeft, float newMoveToXRight) {
        if (upOdd){
            cb.moveTo(newMoveToXLeft , moveToYLeft);
            cb.lineTo(newMoveToXLeft, positionY - diffBetweenComponent * 2 - tableHeight);

            cb.moveTo(newMoveToXRight, moveToYRight);
            cb.lineTo(newMoveToXRight, positionY - diffBetweenComponent * 2 - tableHeight);
            upOdd = false;

        }else {
            cb.moveTo(newMoveToXLeft , moveToYLeft);
            cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 2);

            cb.moveTo(newMoveToXRight, moveToYRight);
            cb.lineTo(newMoveToXRight, positionY + diffBetweenComponent * 2);
            upOdd = true;
        }
    }

    private void addComponent(Document document,PdfWriter writer,int padding,int lineSkipp, int index,int numberOfCompetitorsRepechage,float cellSize,LadderHelper ladderHelper) throws DocumentException {




        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;

            float pdfPageWidth = document.getPageSize().getWidth();
            //table.setWidthPercentage(10);
            table.setTotalWidth(new float[]{10f,70f});


            table.setHorizontalAlignment(Element.ALIGN_LEFT);

            writer.getVerticalPosition(false);
            float positionY = writer.getVerticalPosition(true);

            //competitor left


//            PersonalDetails competitorLeft = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
//            PersonalDetails competitorRight = ladderHelper.getActualRightCompetitor().getPersonalDetails();

            Font fontSize_8 =  FontFactory.getFont(FontFactory.TIMES, 8f);



            cell = new PdfPCell(new Phrase("-"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setFixedHeight(cellSize);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("-"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setFixedHeight(cellSize);
            table.addCell(cell);


            PdfContentByte cb = writer.getDirectContent();
            table.writeSelectedRows(0,-1,padding,positionY,cb);

            float tableWidth = table.getTotalWidth();
            float tableHeight = table.getTotalHeight();

            float moveToXLeft =  padding + tableWidth ;
            float moveToYLeft = positionY - tableHeight/2;

            float moveToXRight = pdfPageWidth - padding - tableWidth;
            float moveToYRight = moveToYLeft;


        //right
        PdfPTable tableRight = new PdfPTable(2);
        tableRight.setTotalWidth(new float[]{70f,10f});

        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        tableRight.addCell(cell);
        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        tableRight.addCell(cell);

            tableRight.writeSelectedRows(0,-1,pdfPageWidth - padding - tableWidth,positionY,cb);


            String ch = "\n";
            Paragraph p = new Paragraph(ch.repeat(lineSkipp));
            document.add(p);

            writer.getVerticalPosition(false);
            float positionYNew = writer.getVerticalPosition(true);

            float diffBetweenComponent = positionYNew - positionY;


            //maly dzyndzel
            cb.moveTo(moveToXLeft,moveToYLeft);
            cb.lineTo(moveToXLeft + 4 ,moveToYLeft);
            float newMoveToXLeft = moveToXLeft + 4;

            cb.moveTo(moveToXRight,moveToYRight);
            cb.lineTo(moveToXRight -4, moveToYRight);
            float newMoveToXRight = moveToXRight -4;



            if (index % 2 == 0){

                if (upEven){
                    //left
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft,previousHeight - tableHeight);

                    //right
                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, previousHeight - tableHeight);

                    upEven = false;

                }  else
                {
                    writer.getVerticalPosition(false);
                    positionY = writer.getVerticalPosition(true);

                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft,positionY);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight,positionY);

                    upEven = true;
                }
            }else {
                if (index == 11 || index == 7){
                    if (index == 7 && numberOfCompetitorsRepechage == 16){
                        float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;
                        cb.moveTo(newMoveToXLeft , moveToYLeft);
                        cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks,moveToYLeft );

                        cb.moveTo(newMoveToXLeft + diffBetweenMidBlocks/2,moveToYLeft);
                        cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks/2, moveToYLeft - 22f);

                        PdfPTable finalTable = new PdfPTable(2);
                        finalTable.setTotalWidth(new float[]{10f,110f});

                        finalTable.setHorizontalAlignment(Element.ALIGN_CENTER);
                        //first
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        //second
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        //third
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        //fourth
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);
                        cell = new PdfPCell(new Phrase("-"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setFixedHeight(cellSize);
                        finalTable.addCell(cell);

                        finalTable.setTotalWidth(new float[]{10f, diffBetweenMidBlocks + 40f});
                        finalTable.writeSelectedRows(0, 4, moveToXLeft - 20f, moveToYLeft - 22f, cb);
                    }
                    else {
                        cb.moveTo(newMoveToXLeft , moveToYLeft);
                        cb.lineTo(newMoveToXLeft, positionY - diffBetweenComponent * 4 - tableHeight);

                        cb.moveTo(newMoveToXRight, moveToYRight);
                        cb.lineTo(newMoveToXRight, positionY - diffBetweenComponent * 4 - tableHeight);

                    }

              }
              else {
                    drawLines(positionY, cb, tableHeight, moveToYLeft, moveToYRight, diffBetweenComponent, newMoveToXLeft, newMoveToXRight);

                }
            }
        previousHeight = positionY;

        cb.closePathStroke();


    }
    private void addComponent2(Document document,PdfWriter writer,int padding,int lineSkipp, int index,int numberOfCompetitorsRepechage,float cellSize) throws DocumentException {

        PdfPTable finalTable = new PdfPTable(2);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        finalTable.addCell(cell);
        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        finalTable.addCell(cell);

        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        finalTable.addCell(cell);
        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        finalTable.addCell(cell);

        finalTable.setTotalWidth(new float[]{10f,110f});

        finalTable.setHorizontalAlignment(Element.ALIGN_CENTER);


        PdfPTable table = new PdfPTable(2);

        float pdfPageWidth = document.getPageSize().getWidth();
        //table.setWidthPercentage(10);
        table.setTotalWidth(new float[]{10f,70f});


        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true);


        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        table.addCell(cell);


        PdfContentByte cb = writer.getDirectContent();
        table.writeSelectedRows(0,-1,padding,positionY,cb);

        float tableWidth = table.getTotalWidth();
        float tableHeight = table.getTotalHeight();

        float moveToXLeft =  padding + tableWidth ;
        float moveToYLeft = positionY - tableHeight/2;

        float moveToXRight = pdfPageWidth - padding - tableWidth;
        float moveToYRight = moveToYLeft;

        table.setTotalWidth(new float[]{70f,10f});
        table.writeSelectedRows(0,-1,pdfPageWidth - padding - tableWidth,positionY,cb);


        String ch = "\n";
        Paragraph p = new Paragraph(ch.repeat(lineSkipp));
        document.add(p);

        writer.getVerticalPosition(false);
        float positionYNew = writer.getVerticalPosition(true);

        float diffBetweenComponent = positionYNew - positionY;


        //maly dzyndzel
        cb.moveTo(moveToXLeft,moveToYLeft);
        cb.lineTo(moveToXLeft + 4 ,moveToYLeft);
        float newMoveToXLeft = moveToXLeft + 4;

        cb.moveTo(moveToXRight,moveToYRight);
        cb.lineTo(moveToXRight -4, moveToYRight);
        float newMoveToXRight = moveToXRight -4;



        if (index % 2 == 0){

            if (upEven){
                //left
                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,previousHeight - tableHeight);

                //right
                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight, previousHeight - tableHeight);

                upEven = false;

            }  else
            {
                writer.getVerticalPosition(false);
                positionY = writer.getVerticalPosition(true);

                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,positionY);

                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight,positionY);

                upEven = true;
            }
        }else {
            if (index  == 3 || index == 11 || index == 7){
                if (index == 3 && numberOfCompetitorsRepechage == 8 || index == 7 && numberOfCompetitorsRepechage == 16){
                    float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks,moveToYLeft );

                    cb.moveTo(newMoveToXLeft + diffBetweenMidBlocks/2,moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks/2, moveToYLeft - 22f);

                    cell = new PdfPCell(new Phrase("-"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setFixedHeight(cellSize);
                    finalTable.addCell(cell);
                    cell = new PdfPCell(new Phrase("-"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setFixedHeight(cellSize);
                    finalTable.addCell(cell);

                    cell = new PdfPCell(new Phrase("-"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setFixedHeight(cellSize);
                    finalTable.addCell(cell);
                    cell = new PdfPCell(new Phrase("-"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setFixedHeight(cellSize);
                    finalTable.addCell(cell);

                    if (numberOfCompetitorsRepechage == 8) {

                        finalTable.setTotalWidth(new float[]{10f, diffBetweenMidBlocks - 10f});
                        finalTable.writeSelectedRows(0, 4, newMoveToXLeft, moveToYLeft - 22f, cb);
                    }
                    if (numberOfCompetitorsRepechage == 16){

                        finalTable.setTotalWidth(new float[]{10f, diffBetweenMidBlocks + 40f});
                        finalTable.writeSelectedRows(0, 4, moveToXLeft - 20f, moveToYLeft - 22f, cb);
                    }
                }
                else if (index == 3){
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 4 );

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY + diffBetweenComponent * 4 );

                    float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;
                    cb.moveTo(newMoveToXLeft + diffBetweenMidBlocks/2,moveToYLeft);
                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks/2, moveToYLeft - 22f);

                } else {
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY - diffBetweenComponent * 4 - tableHeight);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY - diffBetweenComponent * 4 - tableHeight);

                }

            }
//                else if (index == 7){
//                    float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;
//                    cb.moveTo(newMoveToXLeft , moveToYLeft);
//                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks,moveToYLeft );
//
//                    cb.moveTo(newMoveToXLeft + diffBetweenMidBlocks/2,moveToYLeft);
//                    cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks/2, moveToYLeft - 22f);
//
//
//
//                    upOdd = false;
//
//                }
            else {
                if (upOdd){
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY - diffBetweenComponent * 2 - tableHeight);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY - diffBetweenComponent * 2 - tableHeight);
                    upOdd = false;

                }else {
                    cb.moveTo(newMoveToXLeft , moveToYLeft);
                    cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 2);

                    cb.moveTo(newMoveToXRight, moveToYRight);
                    cb.lineTo(newMoveToXRight, positionY + diffBetweenComponent * 2);
                    upOdd = true;
                }

            }
        }
        previousHeight = positionY;

        cb.closePathStroke();


    }
    private void addRepechage16(Document document,PdfWriter writer,LadderHelper16 ladderHelper) throws DocumentException {
        int[] padding = {30,100,30,150,30,100,30};
        int[] matches = {14,14,14,20,15,15,15};
        for (int i =0; i<7; i++) {
            addRepechageComponent(document,writer,padding[i],1,i,8,10f,60f,matches[i],ladderHelper);

        }
    }
    private void addRepechage8(Document document,PdfWriter writer, LadderHelper ladderHelper) throws DocumentException {
        int [] padding = {60,110,60};
        int[] matches = {6,6,6};
        ladderHelper.setCounter(0);
        for (int i = 0; i<3; i++){
            addRepechageComponent8(document,writer,padding[i],2,i,8,15f,75f,ladderHelper,matches[i]);
        }
    }
    private void addRepechageComponent8(Document document,PdfWriter writer,int padding,int lineSkipp, int index,int numberOfCompetitorsRepechage,float cellSize,float cellWidth,LadderHelper ladderHelper,int matchNumber) throws DocumentException {
        float pdfPageWidth = document.getPageSize().getWidth();

        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true);

        ladderHelper.goToMatch(matchNumber);
        ladderHelper.loadActualRepachageMatch();

        PersonalDetails competitorLeft = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
        PersonalDetails competitorRight = ladderHelper.getActualRightCompetitor().getPersonalDetails();




        PdfPTable table = new PdfPTable(2);

        table.setTotalWidth(new float[]{10f,cellWidth});
        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        updateTableContext(table,String.valueOf(ladderHelper.getNumberOfPlaceInDrawLeft()), competitorLeft.getName() + " " + competitorLeft.getSurname(), cellSize, fontSize_8);


        PdfContentByte cb = writer.getDirectContent();
        table.writeSelectedRows(0, -1, padding, positionY, cb);


        float tableWidth = table.getTotalWidth();
        float tableHeight = table.getTotalHeight();

        float moveToXLeft =  padding + tableWidth ;
        float moveToYLeft = positionY - tableHeight/2;

        float moveToXRight = pdfPageWidth - padding - tableWidth;
        float moveToYRight = moveToYLeft;

        PdfPTable tableRight = new PdfPTable(2);

        tableRight.setTotalWidth(new float[]{10f,cellWidth});
        tableRight.setHorizontalAlignment(Element.ALIGN_LEFT);

        updateTableContext(tableRight,competitorRight.getName() + " " + competitorRight.getSurname(),String.valueOf(ladderHelper.getNumberOfPlaceInDrawRight()),cellSize,fontSize_8);

        tableRight.setTotalWidth(new float[]{cellWidth,10f});
        tableRight.writeSelectedRows(0, -1, pdfPageWidth - padding - tableWidth, positionY, cb);



        String ch = "\n";
        Paragraph p = new Paragraph(ch.repeat(lineSkipp));
        document.add(p);

        writer.getVerticalPosition(false);
        float positionYNew = writer.getVerticalPosition(true);

        float diffBetweenComponent = positionYNew - positionY;


        //maly dzyndzel

            cb.moveTo(moveToXLeft, moveToYLeft);
            cb.lineTo(moveToXLeft + 4, moveToYLeft);

            float newMoveToXLeft = moveToXLeft + 4;

            cb.moveTo(moveToXRight, moveToYRight);
            cb.lineTo(moveToXRight - 4, moveToYRight);

            float newMoveToXRight = moveToXRight - 4;



        if (index % 2 == 0){

            if (upEven){
                //left
                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,previousHeight - tableHeight);

                //right
                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight, previousHeight - tableHeight);

                upEven = false;

            }  else
            {
                writer.getVerticalPosition(false);
                positionY = writer.getVerticalPosition(true);

                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,positionY);

                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight,positionY);

                upEven = true;
            }
        }else {
            if (index  == 1){
                PdfPTable thirdPlaceTable = new PdfPTable(2);
                thirdPlaceTable.setTotalWidth(new float[]{10f,cellWidth});

                //3miejsce dzyndzel w dol lewa strona
                cb.moveTo(newMoveToXLeft, moveToYLeft);
                cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 2 );

                ladderHelper.goToMatch(8);
                ladderHelper.setCounter(1); // winnerzy z danego meczu
                ladderHelper.loadActualRepachageMatch();

                PersonalDetails competitorLeftThird = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
                PersonalDetails competitorRightThird = ladderHelper.getActualRightCompetitor().getPersonalDetails();

                updateTableContext(thirdPlaceTable,String.valueOf(ladderHelper.getNumberOfPlaceInDrawLeft()), competitorLeftThird.getName() + " " + competitorLeftThird.getSurname(),cellSize,fontSize_8);

                thirdPlaceTable.writeSelectedRows(0,-1,moveToXLeft,positionY + diffBetweenComponent * 2,cb);

                //
                float widthOfText = fontSize_10.getCalculatedBaseFont(true).getWidthPoint("3. miejsca",fontSize_10.getCalculatedSize());
                FixText("3. places",pdfPageWidth/2 - widthOfText/2,positionY + diffBetweenComponent *2 + 10f ,writer,10);

                //rigth side
                PdfPTable thirdPlaceTableRight = new PdfPTable(2);

                thirdPlaceTableRight.setTotalWidth(new float[]{cellWidth,10f});

                updateTableContext(thirdPlaceTableRight,competitorRightThird.getName() + " " + competitorRightThird.getSurname(),String.valueOf(ladderHelper.getNumberOfPlaceInDrawRight()),cellSize,fontSize_8);


                thirdPlaceTableRight.writeSelectedRows(0,-1,moveToXRight - tableWidth,positionY + diffBetweenComponent * 2,cb);
                cb.moveTo(newMoveToXRight,moveToYRight);
                cb.lineTo(newMoveToXRight,positionY + diffBetweenComponent * 2);

                PdfPTable lastRowTable = new PdfPTable(2);

                ladderHelper.setCounter(2);
                ladderHelper.loadActualRepachageMatch();

                ladderHelper.setCounter(2);//back

                PersonalDetails competitorLeftLast = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
                PersonalDetails competitorRightLast = ladderHelper.getActualRightCompetitor().getPersonalDetails();

                updateTableContext(lastRowTable,String.valueOf(ladderHelper.getNumberOfPlaceInDrawLeft()),competitorLeftLast.getName() + " " + competitorLeftLast.getSurname(),cellSize,fontSize_8);

                //zawodnicy dol
                lastRowTable.setTotalWidth(new float[]{10f,cellWidth});
                lastRowTable.writeSelectedRows(0,-1,padding,positionY + diffBetweenComponent*4,cb);

                PdfPTable lastRowTableRight = new PdfPTable(2);
                lastRowTableRight.setTotalWidth(new float[]{cellWidth,10f});

                updateTableContext(lastRowTableRight,competitorRightLast.getName() + " " + competitorRightLast.getSurname(),String.valueOf(ladderHelper.getNumberOfPlaceInDrawRight()),cellSize,fontSize_8);


                lastRowTableRight.writeSelectedRows(0,-1,moveToXRight ,positionY + diffBetweenComponent*4, cb);

                cb.moveTo(moveToXLeft,positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo(moveToXLeft + 4, positionY + diffBetweenComponent*4 - tableHeight/2);

                cb.moveTo(newMoveToXLeft , positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo( newMoveToXLeft  , positionY + diffBetweenComponent*2 - tableHeight);


                cb.moveTo(moveToXRight,positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo(moveToXRight - 4 ,positionY + diffBetweenComponent*4 - tableHeight/2);

                cb.moveTo(moveToXRight - 4, positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo(newMoveToXRight,positionY + diffBetweenComponent*2 - tableHeight);


            }
              else {
                drawLines(positionY, cb, tableHeight, moveToYLeft, moveToYRight, diffBetweenComponent, newMoveToXLeft, newMoveToXRight);

            }
        }
        previousHeight = positionY;

        cb.closePathStroke();
    }

    private void addRepechageComponent(Document document,PdfWriter writer,int padding,int lineSkipp, int index,int numberOfCompetitorsRepechage,float cellSize,float cellWidth,int matchNumber,LadderHelper16 ladderHelper) throws DocumentException {


        float pdfPageWidth = document.getPageSize().getWidth();
        //table.setWidthPercentage(10);


        writer.getVerticalPosition(false);
        float positionY = writer.getVerticalPosition(true);

        Font fontSize_4 =  FontFactory.getFont(FontFactory.HELVETICA, 4f);

        PdfPTable table = new PdfPTable(2);

        table.setTotalWidth(new float[]{10f,cellWidth});
        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        ladderHelper.goToMatch(matchNumber);
        if (index == 3){
            ladderHelper.loadActualMatch(1);

        }else {
            ladderHelper.loadActualMatch(2);
        }
        PersonalDetails competitorLeft = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
        PersonalDetails competitorRight = ladderHelper.getActualRightCompetitor().getPersonalDetails();



        updateTableContext(table,ladderHelper.getNumberOfPlaceInDrawLeft(),competitorLeft.getName() + " " + competitorLeft.getSurname(),cellSize,fontSize_4);



        PdfContentByte cb = writer.getDirectContent();
        table.writeSelectedRows(0,-1,padding,positionY,cb);

        float tableWidth = table.getTotalWidth();
        float tableHeight = table.getTotalHeight();

        float moveToXLeft =  padding + tableWidth ;
        float moveToYLeft = positionY - tableHeight/2;

        float moveToXRight = pdfPageWidth - padding - tableWidth;
        float moveToYRight = moveToYLeft;

        PdfPTable tableRight = new PdfPTable(2);

        tableRight.setTotalWidth(new float[]{cellWidth,10f});

        updateTableContext(tableRight,competitorRight.getName() + " " + competitorRight.getSurname(), ladderHelper.getNumberOfPlaceInDrawRight(), cellSize,fontSize_4);

        tableRight.writeSelectedRows(0,-1,pdfPageWidth - padding - tableWidth,positionY,cb);


        String ch = "\n";
        Paragraph p = new Paragraph(ch.repeat(lineSkipp));
        document.add(p);

        writer.getVerticalPosition(false);
        float positionYNew = writer.getVerticalPosition(true);

        float diffBetweenComponent = positionYNew - positionY;


        //maly dzyndzel
        cb.moveTo(moveToXLeft,moveToYLeft);
        cb.lineTo(moveToXLeft + 4 ,moveToYLeft);
        float newMoveToXLeft = moveToXLeft + 4;

        cb.moveTo(moveToXRight,moveToYRight);
        cb.lineTo(moveToXRight -4, moveToYRight);
        float newMoveToXRight = moveToXRight -4;


        if (index % 2 == 0){

            if (upEven){
                //left
                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,previousHeight - tableHeight);

                //right
                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight, previousHeight - tableHeight);

                upEven = false;

            }  else
            {
                writer.getVerticalPosition(false);
                positionY = writer.getVerticalPosition(true);

                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft,positionY);

                cb.moveTo(newMoveToXRight, moveToYRight);
                cb.lineTo(newMoveToXRight,positionY);

                upEven = true;
            }
        }else {
            if (index  == 3){

                PdfPTable thirdPlaceTable = new PdfPTable(2);
                thirdPlaceTable.setTotalWidth(new float[]{10f,cellWidth});

                //3miejsce dzyndzel w dol lewa strona
                cb.moveTo(newMoveToXLeft, moveToYLeft);
                cb.lineTo(newMoveToXLeft, positionY + diffBetweenComponent * 2 );
                cb.stroke();

                float widthOfText = fontSize_10.getCalculatedBaseFont(true).getWidthPoint("3. miejsca",fontSize_10.getCalculatedSize());
                FixText("3. places",pdfPageWidth/2 - widthOfText/2,positionY + diffBetweenComponent *2 + 10f ,writer,10);

                ladderHelper.loadActualMatch(1);

                PersonalDetails competitorLeft1 = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
                PersonalDetails competitorRight1 = ladderHelper.getActualRightCompetitor().getPersonalDetails();


                updateTableContext(thirdPlaceTable, ladderHelper.getNumberOfPlaceInDrawLeft(), competitorLeft1.getName() + " " + competitorLeft1.getSurname(),cellSize,fontSize_4);

                thirdPlaceTable.writeSelectedRows(0,-1,moveToXLeft,positionY + diffBetweenComponent * 2,cb);

                //rigth side
                PdfPTable thirdPlaceTableRight = new PdfPTable(2);
                thirdPlaceTableRight.setTotalWidth(new float[]{cellWidth,10f});

                updateTableContext(thirdPlaceTableRight,competitorRight1.getName() + " " + competitorRight1.getSurname(), ladderHelper.getNumberOfPlaceInDrawRight(), cellSize,fontSize_4);

                thirdPlaceTableRight.writeSelectedRows(0,-1,moveToXRight - tableWidth,positionY + diffBetweenComponent * 2,cb);
                cb.moveTo(newMoveToXRight,moveToYRight);
                cb.lineTo(newMoveToXRight,positionY + diffBetweenComponent * 2);

                PdfPTable lastRowTable = new PdfPTable(2);

                ladderHelper.loadActualMatch(1);

                PersonalDetails competitorLeft2 = ladderHelper.getActualLeftCompetitor().getPersonalDetails();
                PersonalDetails competitorRight2 = ladderHelper.getActualRightCompetitor().getPersonalDetails();

                updateTableContext(lastRowTable, ladderHelper.getNumberOfPlaceInDrawLeft(), competitorLeft2.getName() + " " + competitorLeft2.getSurname(),cellSize,fontSize_4);

                //zawodnicy

                lastRowTable.setTotalWidth(new float[]{10f,cellWidth});
                lastRowTable.writeSelectedRows(0,-1,padding,positionY + diffBetweenComponent*4,cb);


                //right
                PdfPTable lastRowTableRight = new PdfPTable(2);
                lastRowTableRight.setTotalWidth(new float[]{cellWidth,10f});

                updateTableContext(lastRowTableRight,competitorRight2.getName() + " " + competitorRight2.getSurname(), ladderHelper.getNumberOfPlaceInDrawRight(), cellSize,fontSize_4);


                lastRowTableRight.writeSelectedRows(0,-1,moveToXRight ,positionY + diffBetweenComponent*4, cb);

                cb.moveTo(moveToXLeft,positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo(moveToXLeft + 4, positionY + diffBetweenComponent*4 - tableHeight/2);

                cb.moveTo(newMoveToXLeft , positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo( newMoveToXLeft  , positionY + diffBetweenComponent*2 - tableHeight);


                cb.moveTo(moveToXRight,positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo(moveToXRight - 4 ,positionY + diffBetweenComponent*4 - tableHeight/2);

                cb.moveTo(moveToXRight - 4, positionY + diffBetweenComponent*4 - tableHeight/2);
                cb.lineTo(newMoveToXRight,positionY + diffBetweenComponent*2 - tableHeight);


            }else if (index == 7){
                float diffBetweenMidBlocks = moveToXRight - moveToXLeft - 8 ;
                cb.moveTo(newMoveToXLeft , moveToYLeft);
                cb.lineTo(newMoveToXLeft + diffBetweenMidBlocks,moveToYLeft );

                upOdd = false;

            }  else {
                drawLines(positionY, cb, tableHeight, moveToYLeft, moveToYRight, diffBetweenComponent, newMoveToXLeft, newMoveToXRight);

            }
        }
        previousHeight = positionY;

        cb.closePathStroke();


    }
    private long[] shiftElements(long[] array){
        int length = array.length;
        long[] reordered = new long[length];

        for(int i=1; i<=length;i++)
            reordered[i % length] = array[i-1];
        return reordered;

    }
    private static void FixText(String text, float x, float y,PdfWriter writer,int size) {
        try {
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            cb.saveState();
            cb.beginText();
            cb.moveText(x, y);
            cb.setFontAndSize(bf, size);
            cb.showText(text);
            cb.endText();
            cb.restoreState();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
    private void updateTableContext(PdfPTable table,String contextLeft,String contextRight,float cellSize,Font fontSize){

        PdfPCell cell = new PdfPCell(new Phrase(contextLeft,fontSize));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(contextRight,fontSize));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        table.addCell(cell);
    }
    private void updateTableContextWithColor(PdfPTable table,String contextLeft,String contextRight,float cellSize,Font fontSize,BaseColor color){

        PdfPCell cell = new PdfPCell(new Phrase(contextLeft,fontSize));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(cellSize);
        cell.setBackgroundColor(color);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(contextRight,fontSize));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(color);
        cell.setFixedHeight(cellSize);
        table.addCell(cell);
    }


}
