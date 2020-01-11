package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.Box;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;

public  class AddBox {
    public static void add(Game game, GameFrame gameFrame, BackgroundPanel backgroundPanel) {
        AbstractBoard board = game.getBoard();

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                        && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1)) {

                    if (gameFrame.getBoxes()[i][j] == false) {
                        Box.setBox(i, j, backgroundPanel);
                        gameFrame.getBoxes()[i][j] = true;
                    }
                }
            }
        }
    }
}
