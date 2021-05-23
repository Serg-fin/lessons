package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class TicTacToeVisual {

    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;
    private static final char DOT_EMPTY = '∙';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final String FRAME_TITLE = "Крестики-Нолики"; // задаем название окна
    private static final String START_GAME_MSG = "Игра началаcь!"; // передаем пользователю сообщение при запуске программы
    public static char[][] map = new char[SIZE][SIZE];


    private final JLabel[][] gameField = new JLabel[SIZE][SIZE]; // создаем игровое поле (размеры задаем через константу SIZE)

    private JLabel gameStateLabel;
    private JPanel gamePanel;
    private JFrame frame;

    public TicTacToeVisual() {
        initFrame();
        frame.setVisible(true);
    }

    private void initFrame() { // инициализируем рамку
        frame = new JFrame();
        frame.setTitle(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 400);

        gameStateLabel = new JLabel(START_GAME_MSG);
        gameStateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(gameStateLabel, BorderLayout.NORTH);

        JButton restartGameButton = new JButton("Начать заново");
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                startGame();
            }
        });

        frame.add(restartGameButton, BorderLayout.SOUTH);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(SIZE, SIZE));
        initCells(gamePanel); // инициализируем ячейки
        frame.add(gamePanel, BorderLayout.CENTER);
    }

    private void initCells(JPanel gamePanel) {
        Font font = new Font("Arial", Font.BOLD, 50);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JLabel cell = new JLabel(String.valueOf(DOT_EMPTY));
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                cell.setVerticalAlignment(SwingConstants.CENTER);
                cell.setFont(font);
                cell.setBorder(BorderFactory.createLineBorder(Color.blue));

                final int rowIndex = i;
                final int colIndex = j;
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (!cell.isEnabled()) {
                            return;
                        }

                        setCell(rowIndex, colIndex, DOT_X);
                        makeTurn(DOT_X, cell);

                        if (checkEndGameState(DOT_X, "Человек")) {
                            return;
                        }

                        int[] computerCellIndex = computerTurn();
                        JLabel computerCell = gameField[computerCellIndex[0]][computerCellIndex[1]];
                        makeTurn(DOT_O, computerCell);

                        checkEndGameState(DOT_O, "Компьютер");
                    }
                });

                gamePanel.add(cell);
                gameField[i][j] = cell;
            }
        }
    }

    private void makeTurn(char symbol, JLabel cell) {
        cell.setText(String.valueOf(symbol));
        cell.setEnabled(false);
    }

    private boolean checkEndGameState(char symbol, String playerName) {
        if (isWin(symbol)) {
            setEndGameState(String.format("%s победил!", playerName));
            return true;
        }
        else if (isMapFull()) {
            setEndGameState("Ничья!");
            return true;
        }

        return false;
    }

    private void setEndGameState(String messageState) {
        setEnabledGameField(false);
        gameStateLabel.setText(messageState);
    }

    private void startGame() {
        setEnabledGameField(true);
        gameStateLabel.setText(START_GAME_MSG);
        initMap();
        refreshGameField();
    }

    private void refreshGameField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameField[i][j].setText(String.valueOf(TicTacToeVisual.map[i][j]));
            }
        }
    }

    private void setEnabledGameField(boolean enabled) {
        gamePanel.setEnabled(true);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameField[i][j].setEnabled(enabled);
            }
        }
    }



    private static int[] getNextCellToWin(char symbol) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                if(map[rowIndex][colIndex] == DOT_EMPTY && isGameMoveWinning(rowIndex, colIndex, symbol)) {
                    return  new  int[]{rowIndex, colIndex};
                }

            }

        }
        return null;
    }

    private static boolean isGameMoveWinning(int rowIndex, int colIndex, char symbol) {
        setCell(rowIndex, colIndex, symbol);
        boolean result = isWin(symbol);
        setCell(rowIndex, colIndex, DOT_EMPTY);
        return result;
    }

    public static void setCell(int rowIndex, int colIndex, char symbol) {
        map[rowIndex][colIndex] = symbol;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }

            }

        }
        return true;
    }

    public static boolean isWin(char symbol) {
        if (checkRowsAndCols(symbol)) {
            return true;
        } else {
            return checkDiagonals(symbol);
        }
    }

    private static boolean checkDiagonals(char symbol) {
        int mainDiagCounter = 0;
        int sideDiagCounter = 0;
        for (int i = 0; i < SIZE; i++) {
            mainDiagCounter = (map[i][i] == symbol) ? mainDiagCounter + 1 : 0;
            sideDiagCounter = (map[i][map.length - 1 - i] == symbol) ? sideDiagCounter + 1 : 0;
            if (mainDiagCounter == DOTS_TO_WIN || sideDiagCounter == DOTS_TO_WIN) {
                return  true;
            }
        }
        return false;
    }

    private static boolean checkRowsAndCols(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                rowCounter = (map[i][j] == symbol) ? rowCounter + 1 : 0;
                colCounter = (map[j][i] == symbol) ? colCounter + 1 : 0;
                if(rowCounter == DOTS_TO_WIN || colCounter == DOTS_TO_WIN) {
                    return true;
                }

            }

        }
        return false;
    }

    public static int[] computerTurn() {
        int[] cell = getNextCellToWin(DOT_O);
        if(cell == null) {
            cell = getNextCellToWin(DOT_X);
            if (cell == null) {
                cell = getRandomEmptyCell();
            }
        }
        int rowIndex = cell[0];
        int colIndex = cell[1];

        setCell(rowIndex, colIndex, DOT_O);
        return cell;
    }

    private static int[] getRandomEmptyCell() {
        int x;
        int y;
        Random random = new Random();

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (map[x][y] != DOT_EMPTY);

        return new int[] {x, y};
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void main(String[] args) {
        TicTacToeVisual ticTacToeVisual = new TicTacToeVisual();
        ticTacToeVisual.startGame();

        initMap();
        while (true) {
            if (isWin(DOT_X)) {
                break;
            }
            if (isMapFull()) {
                break;
            }
            if (isWin(DOT_O)) {
                break;
            }
        }
    }
}

