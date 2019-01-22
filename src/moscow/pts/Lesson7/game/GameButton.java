package moscow.pts.Lesson7.game;

import javax.swing.*;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int gameButtonIndex, GameBoard currentGameBoard) {
        buttonIndex = gameButtonIndex;
        board = currentGameBoard;

        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellsize - 5, GameBoard.cellsize - 5);
        addActionListener(new GameActionListener(this));
    }

    public GameBoard getBoard() {
        return board;
    }
    public int getButtonIndex() {
        return buttonIndex;
    }



}
