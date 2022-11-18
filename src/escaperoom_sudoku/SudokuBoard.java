/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escaperoom_sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.TextField;

/**
 *
 * @author kkauf
 */
public class SudokuBoard {
    private int[][][] gameBoards;
    
    public ArrayList<ArrayList<ArrayList<Integer>>> readFile(){
        BufferedReader reader;
        ArrayList<ArrayList<ArrayList<Integer>>> boards = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("p096_sudoku.txt"));
            String line = reader.readLine();
            
            ArrayList<ArrayList<Integer>> currentBoard = null;
            
            while (line != null) {
                if (line.startsWith("Grid")) {
                    if (currentBoard != null) {
                        boards.add(currentBoard);
                    }
                    currentBoard = new ArrayList<ArrayList<Integer>>();
                } else {
                    ArrayList<Integer> row = new ArrayList<>();
                    char[] chars = line.toCharArray();
                    for (char c: chars) {
                        row.add(Character.getNumericValue(c));
                    }
                    currentBoard.add(row);
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Read Error");
        }
        System.out.println(boards);
        return boards;
    }
    
    public int[][] getRandomBoard() {
        if (gameBoards == null) {
            ArrayList<ArrayList<ArrayList<Integer>>> boards = readFile();
            gameBoards = (int[][][])boards.toArray();
        }
        int idx = (int)(Math.random() * gameBoards.length);
        System.out.println("idx: " + idx);
        System.out.println("length: " + gameBoards.length);

        return gameBoards[idx];
    };

    
//    private String checkBoard(TextField[][] cells) {
//        System.out.println("checking board: " + cells.length + "x" + cells[0].length);
//        
//        for(int row = 0; row < cells.length; row++) {
//            char[] currRow = new char[cells[row].length];
//            for(int col = 0; col < cells[row].length; col++) {
//                char[] currCell = cells[row][col].getText().toCharArray();
//                if (currCell.length == 0) {
//                    return "incomplete";
//                }
//                currRow[col] = currCell[0];
//            }
//            Arrays.sort(currRow);
//            String currRowStr = new String(currRow);
//            if (currRowStr.equals("123456789")) {
//                System.out.println("row is valid");
//                return "valid";
//            }
//            else {
//                System.out.println("row is invalid: " + currRowStr );
//                return "invalid";
//               
//            }
//        }
//        
//        return "valid";
//    }
    
    public static void main(String[] args){
        SudokuBoard test = new SudokuBoard();
    }
    
    
//      public static boolean checkRows(){
//    String [] rowValues = new String[9];
//
//    for(int row = 0; row < 9; row++){
//      rowValues[row] = "";
//      for(int col = 0; col < 9; col++){
//        rowValues[row] += data[row][col];
//      }
//      char [] rowSort = rowValues[row].toCharArray();
//      Arrays.sort(rowSort);
//      String rowStr = "";
//      for(char c : rowSort)
//        rowStr += Character.toString(c);
//      System.out.print("\n" + rowStr);
//      if("123456789".compareTo(rowStr) != 0)
//        return false;
//    }
//    return true; // all rows valid
//  }
    
//  public static boolean checkCols(){
//    return true; // TODO - function stub
//  }
//
//  
//  public static boolean checkGrids(){
//    return true; // TODO - function stub
//  }    
    
    

    
    
}
