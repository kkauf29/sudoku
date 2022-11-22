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
    private ArrayList<ArrayList<ArrayList<Integer>>> gameBoards;
    
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
        System.out.println("readFile array" + boards);
        return boards;
    }
    
    public ArrayList<ArrayList<Integer>> getRandomBoard() {
        if (gameBoards == null) {
            ArrayList<ArrayList<ArrayList<Integer>>> boards = readFile();
            System.out.println("getRandom arraylist" + boards);
            gameBoards = boards;
        }
//        System.out.println("getRandomBoard array" + gameBoards);
        int idx = (int)(Math.random() * gameBoards.size());
        System.out.println("idx: " + idx);
        System.out.println("length: " + gameBoards.size());

        return gameBoards.get(idx);
    };

    
    public String checkRows(ArrayList<ArrayList<String>> cells) {
        System.out.println("checking board: " + cells.size() + "x" + cells.get(0).size());
        
        for(int row = 0; row < cells.size(); row++) {
            char[] currRow = new char[cells.get(row).size()];
            for(int col = 0; col < cells.get(row).size(); col++) {
                char[] currCell = cells.get(row).get(col).toCharArray();    
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
                            
}
