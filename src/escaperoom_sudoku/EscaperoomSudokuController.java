/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package escaperoom_sudoku;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;


/**
 * Kim Kaufman
 * CSC 2040 Java Programming
 * 10/15/22
 */
public class EscaperoomSudokuController implements Initializable {
    

    @FXML
    private GridPane sudokuBoard;
    @FXML
    private TextField [][] cells;
    @FXML 
    private TextField field;

    
    
    @Override    
    public void initialize(URL url, ResourceBundle rb) {
        sudokuBoard.setHgap(0);
        sudokuBoard.setVgap(0);
        sudokuBoard.setStyle("-fx-border: 5px solid; -fx-border-color: black;");
        int[][] board = getRandomBoard();
        TextField[][] cells = new TextField[9][9];
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                cells[row][col] = new TextField();
                field = cells[row][col];
                field.setPrefHeight(100);
                field.setMinHeight(100);
                field.setPrefWidth(60);
                field.setMinWidth(60);
                field.setStyle("-fx-border: 10px solid; -fx-border-color: black; -fx-alignment: center; -fx-font-size: 25pt;");
                field.setText(Integer.toString(board[row][col]));
                if (field.getText().equals("0")) {
                    field.clear();
                }
                
                EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        System.out.println("key event: " + event);
                        String boardStatus = checkBoard(cells);
                        if (boardStatus.equals("invalid")) {
                            event.getSource().getId().setStyle("-fx-background-color: red");
                        }
                    }
                };
                
                field.addEventHandler(KeyEvent.KEY_TYPED, handler);

                sudokuBoard.add(field, col, row);                                                                            
            }
        } 
    };
        
    private String checkBoard(TextField[][] cells) {
        System.out.println("checking board: " + cells.length + "x" + cells[0].length);
        
        for(int row = 0; row < cells.length; row++) {
            char[] currRow = new char[cells[row].length];
            for(int col = 0; col < cells[row].length; col++) {
                char[] currCell = cells[row][col].getText().toCharArray();
                if (currCell.length == 0) {
                    return "incomplete";
                }
                currRow[col] = currCell[0];
            }
            Arrays.sort(currRow);
            String currRowStr = new String(currRow);
            if (currRowStr.equals("123456789")) {
                System.out.println("row is valid");
                return "valid";
            }
            else {
                System.out.println("row is invalid: " + currRowStr );
                return "invalid";
               
            }
        }
        
        return "valid";
    }
    
    

    private int[][] getRandomBoard() {
        int[][][] boards = {
        
            {{0,0,3,0,2,0,6,0,0},
            {9,0,0,3,0,5,0,0,1},
            {0,0,1,8,0,6,4,0,0},
            {0,0,8,1,0,2,9,0,0},
            {7,0,0,0,0,0,0,0,8},
            {0,0,6,7,0,8,2,0,0},
            {0,0,2,6,0,9,5,0,0},
            {8,0,0,2,0,3,0,0,9},
            {0,0,5,0,1,0,3,0,0}},

            {{2,0,0,0,8,0,3,0,0},
            {0,6,0,0,7,0,0,8,4},
            {0,3,0,5,0,0,2,0,9},
            {0,0,0,1,0,5,4,0,8},
            {0,0,0,0,0,0,0,0,0},
            {4,0,2,7,0,6,0,0,0},
            {3,0,1,0,0,7,0,4,0},
            {7,2,0,0,4,0,0,6,0},
            {0,0,4,0,1,0,0,0,3}},
            
            {{0,0,0,0,0,0,9,0,7},
            {0,0,0,4,2,0,1,8,0},
            {0,0,0,7,0,5,0,2,6},
            {1,0,0,9,0,4,0,0,0},
            {0,5,0,0,0,0,0,4,0},
            {0,0,0,5,0,7,0,0,9},
            {9,2,0,1,0,8,0,0,0},
            {0,3,4,0,5,9,0,0,0},
            {5,0,7,0,0,0,0,0,0}},
            
            {{0,3,0,0,5,0,0,4,0},
            {0,0,8,0,1,0,5,0,0},
            {4,6,0,0,0,0,0,1,2},
            {0,7,0,5,0,2,0,8,0},
            {0,0,0,6,0,3,0,0,0},
            {0,4,0,1,0,9,0,3,0},
            {2,5,0,0,0,0,0,9,8},
            {0,0,1,0,2,0,6,0,0},
            {0,8,0,0,6,0,0,2,0}}
        
        
        };
        
        
        int idx = (int)(Math.random() * boards.length);
        return boards[idx];
    };
    
    //private button check 
    
}
