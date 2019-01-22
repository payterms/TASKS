package moscow.pts.Lesson7.game;

import java.util.Random;

public class GamePlayer {
    private char playerSign;    // символ которым играет игрок
    private boolean realPlayer = true;// признак - кто играет

    public GamePlayer(boolean isRealPlayer, char playerSign) {
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    public boolean isRealPlayer() {
        return realPlayer;
    }

    public char getPlayerSign() {
        return playerSign;
    }

    public void updateByPlayersData(GameButton button) {
        int row = button.getButtonIndex()/GameBoard.dimension;
        int cell = button.getButtonIndex()%GameBoard.dimension;
        // обновить матрицу игры
        button.getBoard().updateGameField(row, cell);

        // обновить содержимое клетки

        button.setText(Character.toString(button.getBoard().getGame().getCurrentPlayer().getPlayerSign()));

        if (button.getBoard().checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли!");
            button.getBoard().emptyField();
        } else {
            button.getBoard().getGame().passTurn(); // передаем ход компьютеру
        }
    }

    public void updateByAiData(GameButton button) {
        int x=0, y=0;
        boolean pcWin = false, humanWin = false;
        Random rnd = new Random();
        int cellIndex = 0;

        /*do {
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        } while (!board.isTurnable(x, y));*/

        //Пытаемся придумать ход для ПК

        //атакующая стратегия
        for (int i = 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++) {
                if (button.getBoard().isTurnable(i, j)) {
                    button.getBoard().updateGameField(i, j);
                    if (button.getBoard().checkWin()) {
                        x = i;
                        y = j;
                        pcWin = true;
                    }
                    button.getBoard().zeroGameField(i, j);
                }
            }
        }
        button.getBoard().getGame().passTurn(); // передаем ход человеку и просчитываем его выигрышные варианты
        if (!pcWin) {
            for (int i = 0; i < GameBoard.dimension; i++) {
                for (int j = 0; j < GameBoard.dimension; j++) {
                    if (button.getBoard().isTurnable(i, j)) {
                        button.getBoard().updateGameField(i, j);
                        if (button.getBoard().checkWin()) {
                            x = i;
                            y = j;
                            humanWin = true;
                        }
                        button.getBoard().zeroGameField(i, j);
                    }
                }
            }
        }
        button.getBoard().getGame().passTurn(); // передаем ход обратно компу
        if (!pcWin && !humanWin) {
            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!button.getBoard().isTurnable(x, y));
        }
        //System.out.println("Компьютер выбрал " + (y + 1) + " " + (x + 1));

        // обновляем матрицу игры
        button.getBoard().updateGameField(x, y);
        // обновляем содержимое кнопки
        cellIndex = GameBoard.dimension * x + y;
        button.getBoard().getButton(cellIndex).setText(Character.toString(button.getBoard().getGame().getCurrentPlayer().getPlayerSign()));
        // проверить победу
        if (button.getBoard().checkWin()) {
            button.getBoard().getGame().showMessage("PC выиграл!");
            button.getBoard().emptyField();
        } else {
            button.getBoard().getGame().passTurn(); // передаем ход
        }
    }

}
