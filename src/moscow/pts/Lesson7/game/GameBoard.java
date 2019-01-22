package moscow.pts.Lesson7.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 3;               // размерность поля - количество клеток в строке/столбце
    static int cellsize = 150;              // размер в пикселях одной кнопки/клетки
    private char[][] gameField;             // матрица игры
    private GameButton[] gameButtons;       // массив кнопок
    private Game game;                      // ссылка на игру
    static final char nullSymbol = '\u0000';           // null symbol


    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }
    /**
     * Метод инициализации и отрисовки игрового поля
     */
    private void initField(){
        // задаем основные настройки окна игры
        setBounds(cellsize*dimension, cellsize*dimension, 400,300);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(); // Панель управления игрой
        JButton newGameButton = new JButton("New game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });
        controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellsize*dimension, cellsize);

        JPanel gameFieldPanel = new JPanel(); // игровое поле
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellsize*dimension,cellsize*dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension*dimension];

        // инициализация игрового поля
        for (int i = 0 ; i<(dimension*dimension); i++){
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i]= fieldButton;
        }
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    /**
     * Метод очистки поля и матрицы игры
     */
    void emptyField(){
        for (int i=0; i < (dimension*dimension);i++){
            gameButtons[i].setText("");

            int x = i/GameBoard.dimension;
            int y = i%GameBoard.dimension;

            gameField[y][x] = nullSymbol;
        }
    }

    Game getGame(){
        return game;
    }

    /**
     * Метод проверки доступности клетки для хода
     * @param x - по горизонтали
     * @param y - по вертикали
     * @return boolean
     *
     */
    boolean isTurnable(int x, int y){
        boolean result = false;

        if ((x < GameBoard.dimension)&&(x>=0)&&(y < GameBoard.dimension)&&(y>=0)) {
            if (gameField[y][x] == nullSymbol)
                result = true;
        }
        return result;
    }
    /**
     * Обновление матрицы игры после ходе
     * @param x - по горизонтали
     * @param y - по вертикали
     */
    void updateGameField(int x , int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }
    void zeroGameField(int x , int y){
        gameField[y][x] = nullSymbol;
    }

    /**
     * Проверка победы по линиям и столбцам
     */
    boolean checkWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if(checkDiagonals(playerSymbol)||checkLines(playerSymbol)){
            result = true;
        }
        return result;
    }
    private  boolean checkDiagonals(char playerSymbol) {
        boolean result = false;
        boolean leftRight, rightLeft;
        leftRight = true;
        rightLeft = true;

        for(int i=0; i<dimension; i++)
        {
            leftRight &= (gameField[i][i] == playerSymbol);
            rightLeft &= (gameField[dimension-i-1][i] == playerSymbol);
        }

        if(leftRight||rightLeft){
            result = true;
        }
        return result;
    }
    private boolean checkLines(char playerSymbol) {
        boolean result = false;
        boolean cols, rows;
        cols = false;
        rows = false;


        for(int col=0; col<dimension; col++)
        {
            cols = true;
            rows = true;
            for(int row=0; row<dimension; row++)
            {
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }
            if(cols||rows){
                result = true;
                break;
            }
            if(result){
                break;
            }
        }

        return result;
    }
    protected boolean isFull() {
        boolean result = true;

        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(gameField[i][j] == nullSymbol){
                    result = false; // есть свободная ячейка - можем продолжать игру
                    break;
                }
            }
            if(!result) // чтобы не крутить цикл дишний раз проверяем - была ли найдена свободная ячейка
            {break;}
        }

        return result;

    }
    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }

}
