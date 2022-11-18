/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package escaperoom_sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
        SudokuBoard board = new SudokuBoard();
        int[][] board1 = board.getRandomBoard();
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
                field.setText(Integer.toString(board1[row][col]));
                if (field.getText().equals("0")) {
                    field.clear();
                }
                                
//                field.addEventHandler(KeyEvent.KEY_TYPED, handler);

                sudokuBoard.add(field, col, row);                                                                            
            }
        } 
    };
    
//                    EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
//                    @Override
//                    public void handle(KeyEvent event) {
//                        System.out.println("key event: " + event);
//                        String boardStatus = checkBoard(cells);
////                        if (boardStatus.equals("invalid")) {
////                            cellEvent = event.getSource().getClass();
////                            cellEvent.setStyle("-fx-background-color: red");
////                        }
//                    }
//                };
        
 
    //private button check 
    
//}
}