package sumo.desktop_server.Controllers.Utils.Report.Utils;

import sumo.desktop_server.Database.CategoryAtCompetition.CategoryAtCompetition;
import sumo.desktop_server.Database.Competitor.Competitor;
import sumo.desktop_server.Database.CompetitorInDraw.CompetitorInDraw;
import sumo.desktop_server.Database.Draw.Draw;
import sumo.desktop_server.Database.Fight.Fight;
import sumo.desktop_server.Database.Results.Result;

import java.util.List;

public record IndividualReportData(List<Competitor> competitors, List<Result> results, Draw draw, List<CompetitorInDraw> competitorInDrawList,
                                   List<Fight> competitorsAndFightsInDraw, CategoryAtCompetition categoryAtCompetition) {
}
