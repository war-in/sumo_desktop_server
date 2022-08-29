package sumo.desktop_server.Database.Fight;

import sumo.desktop_server.Controllers.Utils.Draw.DataToSaveDraw;

import java.util.List;

public interface FightService {
    Fight saveFight(Fight fightToSave);
    List<Fight> getAllFights();
}
