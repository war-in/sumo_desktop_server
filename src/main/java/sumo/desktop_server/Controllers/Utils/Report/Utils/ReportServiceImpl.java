package sumo.desktop_server.Controllers.Utils.Report.Utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sumo.desktop_server.Database.AgeCategory.AgeCategoryRepository;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetitionRepository;
import sumo.desktop_server.Database.Competition.CompetitionRepository;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDrawRepository;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Draw.DrawRepository;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Fight.FightService;
import sumo.desktop_server.Database.PointsClassification.PointsClassificationRepository;
import sumo.desktop_server.Database.Results.Result;
import sumo.desktop_server.Database.Results.ResultService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportServiceImpl implements ReportService{
    private final ResultService resultService;
    private final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    private final DrawRepository drawRepository;
    private final CompetitorInDrawRepository competitorInDrawRepository;
    private final FightService fightService;

    public IndividualReportData getDataForIndividualReport(Long categoryAtCompetitionId){
        List<Competitor> competitors = resultService.getCompetitorsByCategoryAtCompetitionId(categoryAtCompetitionId);
        List<Result> results = resultService.getResultsByCategoryAtCompetitionId(categoryAtCompetitionId);


        CategoryAtCompetition categoryAtCompetition = categoryAtCompetitionRepository.findCategoryAtCompetitionById(categoryAtCompetitionId);
        Draw draw = drawRepository.findByCategoryAtCompetitionId(categoryAtCompetitionId);

        //bedzie jeden draw

        List<Fight> competitorsAndFightsInDraw = fightService.getFightsByDrawId(draw.getId());

        List<CompetitorInDraw> competitorInDrawList = competitorInDrawRepository.findAllByDraw(draw);

        return new IndividualReportData(competitors,results,draw,competitorInDrawList,competitorsAndFightsInDraw,categoryAtCompetition);

    }

}
