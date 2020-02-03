package dotsandboxes.gui.DBlabels.labelSetters;

import dotsandboxes.gui.DBlabels.LabelsList;
import gamesuite.game.Game;

import java.util.stream.IntStream;

public class ScoreLabels {

    public static void setLabels(Game game, LabelsList labels) {
        IntStream stream= IntStream.range(0,labels.size());
        stream.forEach(i->labels.get(i).setText(game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i))));

/*        for (int i = 0; i < labels.size(); i++) {
            Player currentPlayer=game.getPlayers().get(i);
            labels.get(i).setText(currentPlayer.getName() + "   " + game.getScore().get(currentPlayer));
        }

 */
    }
}
