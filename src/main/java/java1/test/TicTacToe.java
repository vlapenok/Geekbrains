package java1.test;

import java.util.Scanner;

public class TicTacToe {
    private char[][] map;
    private final int SIZE = 3;
    private final char PLAYER = 'X';
    private final char AI = 'O';
    private final char EMPTY = '_';
    private final int winLength = 3;

    TicTacToe() {
        initialize();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (checkWin1(PLAYER)) {
                System.out.println("Выйграл человек");
                break;
            }
            if (isMapFull()) {
                break;
            }

            aiTurn();
            printMap();
            if (checkWin1(AI)) {
                System.out.println("Выйграл компьютер");
                break;
            }
            if (isMapFull()) {
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    private boolean checkWin(char element) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(checkLine(i, j, 1, 0, element)) {
                    return true;
                }
                if(checkLine(i, j, 0, 1, element)) {
                    return true;
                }
                if(checkLine(i, j, 1, 1, element)) {
                    return true;
                }
                if(checkLine(i, j, 1, -1, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int startX, int startY, int vX, int vY, char element) {
        if(startX + winLength * vX > SIZE || startY + winLength * vY > SIZE || startY + winLength * vY < 0) {
            return false;
        }
        for (int i = 0; i < winLength; i++) {
            if(map[startX + i * vX][startY + i * vY] != element) {
                return false;
            }
        }
        return true;
    }

    private void playerTurn() {
        Scanner sc = new Scanner(System.in);
        int x, y;
        System.out.println("Введите координаты");
        do {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellEmpty(x, y));
        map[y][x] = PLAYER;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = (int) (Math.random() * SIZE);
            y = (int) (Math.random() * SIZE);
        } while (isCellEmpty(x, y));
        map[y][x] = AI;
        System.out.println("Компьютер ходит на " + (x + 1) + ", " + (y + 1));
    }

    private boolean isCellEmpty(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[y][x] == EMPTY) {
            return false;
        }
        System.out.println("Нельзя поставить на " + (x + 1) + ", " + (y + 1));
        return true;
    }

    private boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void initialize() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    private void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkWin1(char element) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(checkLine1(i, j, 1, 0, element)) {
                    return true;
                }
                if(checkLine1(i, j, 0, 1, element)) {
                    return true;
                }
                if(checkLine1(i, j, 1, 1, element)) {
                    return true;
                }
                if(checkLine1(i, j, 1, -1, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine1(int x, int y, int vX, int vY, char element) {
        if(x + winLength * vX > SIZE || y + winLength * vY > SIZE || y + winLength * vY < 0) {
            return false;
        }
        for (int i = 0; i < winLength; i++) {
            if(map[x + i * vX][y + i * vY] != element) {
                return false;
            }
        }
        return true;
    }
}
