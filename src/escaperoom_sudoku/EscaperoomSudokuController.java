/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package escaperoom_sudoku;


import java.io.IOException;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.InputEvent;


/**
 * Kim Kaufman
 * CSC 2040 Java Programming
 * 10/15/22
 */
public class EscaperoomSudokuController implements Initializable {
    
    @FXML
    private GridPane sudokuBoard;
            
    @Override    
    public void initialize(URL url, ResourceBundle rb) {
//        sudokuBoard.setHgap(0);
//        sudokuBoard.setVgap(0);
//        sudokuBoard.setStyle("-fx-border: 5px solid; -fx-border-color: black;");
        SudokuBoard sb = new SudokuBoard();
        ArrayList<ArrayList<Integer>> board = sb.getRandomBoard();
        System.out.println("got random board" + board);

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                TextField field = new TextField();
                field.setPrefHeight(100);
                field.setMinHeight(100);
                field.setPrefWidth(60);
                field.setMinWidth(60);
                field.setStyle("-fx-border: 10px solid; -fx-border-color: black; -fx-alignment: center; -fx-font-size: 25pt;");
                String fieldValue = Integer.toString(board.get(row).get(col));
                if (!fieldValue.equals("0")) {
                    field.setText(fieldValue);
                    field.setEditable(false);
                }
                GridPane.setRowIndex(field, row);
                GridPane.setColumnIndex(field, col);
                
                field.addEventHandler(KeyEvent.KEY_TYPED, keyHandler);
                field.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseHandler);

                sudokuBoard.add(field, col, row);
            }
        }
    }

    private EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            boolean boardStatus = checkBoard(sudokuBoard);
            if (boardStatus) {
                System.out.println("player wins!");
            } else {
                System.out.println("board invalid");
            }
        }
    };
    
    private EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            boolean boardStatus = checkBoard(sudokuBoard);
            if (boardStatus) {
                System.out.println("player wins!");
            } else {
                System.out.println("board invalid");
            }
        }
    };

    private boolean checkBoard(GridPane sudokuBoard) {
        String[][] boardValues = new String[9][9];
        ObservableList<Node> children = sudokuBoard.getChildren();
        for (Node child: children) {
            TextField field = (TextField)child;
            int row = GridPane.getRowIndex(child);
            int col = GridPane.getColumnIndex(child);
            boardValues[row][col] = field.getText();
        }
//        return checkRows(boardValues) && checkCols(boardValues) && checkGrids(boardValues);
        return checkGrids(boardValues);
//        return checkCols(boardValues);
    }
    
    private boolean checkSet(String setName, String[][] boardValues) {
        for (String[] set: boardValues) {
            System.out.println(setName + ": " + Arrays.toString(set));
            String[] sortedSet = set.clone();
            Arrays.sort(sortedSet);
            String setStr = "";
            for (String cell: sortedSet) {
                setStr += cell;
            }
            System.out.println("sorted " + setName + ": " + setStr);
            
            if ("123456789".compareTo(setStr) != 0) {
                return false;
            } else {
                System.out.println("valid " + setName);
            }
        }
        return true;
    }

    private boolean checkRows(String[][] boardValues) {
        return checkSet("row", boardValues);
    }
    
    private boolean checkCols(String[][] boardValues) {
        String[][] cols = new String[9][9];
        for (int colIndex = 0; colIndex < 9; colIndex++) {
            for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
                cols[colIndex][rowIndex] = boardValues[rowIndex][colIndex];
            }
        }
        
        return checkSet("column", cols);
    }
    
    private boolean checkGrids(String[][] boardValues) {
        String[][] grids = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                int bvRowIndex = j+((i/3)*3);
                for (int k = 0; k < 3; k++) {
                    int bvColIndex = k+((i%3)*3);
                    grids[i][k+(j*3)] = boardValues[bvRowIndex][bvColIndex];
                }
            }
        }
        return checkSet("grid", grids);
    }
}