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
    private static int SIZE = 3;     // field size
    private static boolean SILLY_MODE = true;     // field size

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
            System.out.println("Введите координаты ячейки (X Y)");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        }
        while(!isCellValid(x, y));

        map[y][x] = DOT_X;
    }
    /*
     * Метод, реализующий проверку корректности ввода координат
     * */
    private static boolean isCellValid(int x, int y){
        boolean result = true;

        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) { // invalid - out of map
            result = false;
        }

        if(map[y][x] != DOT_EMPTY){ // cell is already busy
            result = false;
        }

        return result;
    }
    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

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
        }

        return result;
    }
    /*
    * Метод, реализующий ход компьютера
    * */
    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if(SILLY_MODE){
            do {
                x = random.nextInt(SIZE);// случайным образом получаем координату Х и проверяем ее на незанятость
                y = random.nextInt(SIZE);// случайным образом получаем координату Х и проверяем ее на незанятость
            } while(!isCellValid(x, y));
        }
        else{
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    // Проверяем клетки по направлениям
                }
            }
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }
    /*
    *
    * */
    private static boolean isEndGame(char playerSymbol) {
        boolean result = true;

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
            if(result == false) // чтобы не крутить цикл дишний раз проверяем - была ли найдена свободная ячейка
            {break;}
        }

        return result;

    }






}
