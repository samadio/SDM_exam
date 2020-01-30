package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;

import javax.swing.*;

public class BoxSetter {


    public static void addBox(AbstractBoard board, GridSettings gridSettings, GameFrame gameFrame, BackgroundPanel backgroundPanel) {

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (isSquare(board,i,j)) {

                    if (!gameFrame.getBoxes()[i][j]) {
                        SetElementsInGrid.setBox(i, j,gridSettings, backgroundPanel);
                        gameFrame.getBoxes()[i][j] = true;
                    }
                }
            }
        }
    }

    private static boolean isSquare(AbstractBoard board, Integer i, Integer j) {
        return board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1);
    }
}
