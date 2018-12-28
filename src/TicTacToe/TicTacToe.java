/*
 * Created by MVG
 * (C)2018, 2019
 * */

package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /* Vars definition section */
    private static char[][] map;    // game field
    private static final int SIZE = 3;     // field size
    private static boolean SILLY_MODE = false;     // field size

    private static final char DOT_EMPTY = '*';  // empty cell
    private static final char DOT_X = 'X';      // X cell
    private static final char DOT_O = 'O';      // 0 cell


    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    /* Main */
    public static void main(String[] args) {
		initMap();
		PrintMap();
		
		while(true){
			humanTurn(); // Human's turn
			if(isEndGame(DOT_X)){
				break;
			}

			computerTurn();// computer's turn

            if(isEndGame(DOT_O)){
                break;
            }
		}
	
    }
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i ++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void PrintMap() {
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i =0; i < SIZE; i++){
            System.out.print((i+1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    /*
     * Метод, реализующий ход игрока
     * */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки (Y - строка; X - столбец )");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        }
        while(!isCellValid(x, y));

        map[y][x] = DOT_X;
    }
    /*
     * Метод, реализующий проверку корректности ввода координат
     * y - строка
     * x - столбец
     * */
    private static boolean isCellValid(int x, int y){
        boolean result = true;

        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) { // invalid - out of map
            result = false;
            return result;
        }

        if(map[y][x] != DOT_EMPTY){ // cell is already busy
            result = false;
        }

        return result;
    }
    private static boolean isCellInRange(int x, int y){
        boolean result = true;

        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) { // invalid - out of map
            result = false;
            return result;
        }
        return result;
    }
    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if(checkDiagonals(playerSymbol)||checkLines(playerSymbol)){
            result = true;
        }
        return result;
    }
    private static boolean checkDiagonals(char playerSymbol) {
        boolean result = false;
        boolean leftRight, rightLeft;
        leftRight = true;
        rightLeft = true;

        for(int i=0; i<SIZE; i++)
        {
            leftRight &= (map[i][i] == playerSymbol);
            rightLeft &= (map[SIZE-i-1][i] == playerSymbol);
        }

        if(leftRight||rightLeft){
            result = true;
        }
        /*
        if(
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)){
            result = true;
        }*/

        return result;
    }
    private static boolean checkLines(char playerSymbol) {
        boolean result = false;
        boolean cols, rows;
        cols = false;
        rows = false;


        for(int col=0; col<SIZE; col++)
        {
            cols = true;
            rows = true;
            for(int row=0; row<SIZE; row++)
            {
               cols &= (map[col][row] == playerSymbol);
               rows &= (map[row][col] == playerSymbol);
            }
        }

        if(cols||rows){
            result = true;
        }

        return result;
    }
    /*
    * Метод, реализующий ход компьютера
    * */
    private static void computerTurn(){
        int x = -1;
        int y = -1;
        int cur_weight = 0, max_weight = 0;
        int x_max=-1;
        int y_max=-1;

        if(SILLY_MODE){
            do {
                x = random.nextInt(SIZE);// случайным образом получаем координату Х и проверяем ее на незанятость
                y = random.nextInt(SIZE);// случайным образом получаем координату Х и проверяем ее на незанятость
            } while(!isCellValid(x, y));
        }
        else{// SMART MODE
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    // Проверяем клетки по весу каждой из них
                    cur_weight = CalcWeight( j, i, DOT_O);// рассчитываем вес
                    if (cur_weight > max_weight) // сравниваем с максимальным найденным весом
                    {
                        max_weight = cur_weight;// новый максимальный вес
                        x_max = j;              // фиксируем координаты ячейки с максимальным весом
                        y_max = i;
                    }
                    System.out.println("Вес ячейки " + (i + 1) + " " + (j + 1) + " " + "равен" + " " + (cur_weight));
                }
            }
            if ((x_max >= 0)&& (y_max >= 0)){// нашли ячейку с максимальным весом
                x = x_max;
                y = y_max;
                System.out.println("Координаты ячейки " + (x_max+1) + " " + (y_max + 1) + " " + "равен" + " " + (cur_weight));
            }else{// иначе выбираем любую свободную ячейку
                if(isCellValid(1, 1)){/*Проверяем - занята ли центральная ячейка (она попадает в большее число пересечений)*/
                    x = 1;
                    y = 1;
                }
                else {//выбираем произвольную ячейку
                    do {
                        x = random.nextInt(SIZE);// случайным образом получаем координату Х и проверяем ее на незанятость
                        y = random.nextInt(SIZE);// случайным образом получаем координату Х и проверяем ее на незанятость
                    } while (!isCellValid(x, y));
                }
            }


        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }
    /*
    *Метод, реализующий проверку игры на окончание - победа или ничья
    * */
    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        PrintMap();

        if(checkWin(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if (isMapFull()){
            System.out.println("НИЧЬЯ!");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {
        boolean result = true;

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT_EMPTY){
                    result = false; // есть свободная ячейка - можем продолжать игру
                    break;
                }
            }
            if(!result) // чтобы не крутить цикл дишний раз проверяем - была ли найдена свободная ячейка
            {break;}
        }

        return result;

    }
    private static int CalcWeight(int x, int y, char playerSymbol) {
        int weight = 0;
        int cur_x, cur_y;
        cur_x = x;
        cur_y = y;
        if (isCellValid(cur_x,cur_y)) {/*клетка не занята - проверяем ее окружение*/
            cur_x = x-1;
            cur_y = y-1;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x;
            cur_y = y-1;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x+1;
            cur_y = y-1;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x-1;
            cur_y = y;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x+1;
            cur_y = y;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x-1;
            cur_y = y+1;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x;
            cur_y = y+1;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
            cur_x = x+1;
            cur_y = y+1;
            if (isCellInRange(cur_x,cur_y))
                if (map[cur_y][cur_x] == playerSymbol){
                    weight++;
                }
        }
        return weight;
    }
}
