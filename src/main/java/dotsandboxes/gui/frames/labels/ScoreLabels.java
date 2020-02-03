package dotsandboxes.gui.frames.labels;

import dotsandboxes.gui.graphics.lists.LabelsList;
import gamesuite.game.Game;

public class ScoreLabels {

    public static void setLabels(Game game, LabelsList labels) {
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText(game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i)));
        }
    }
}
