/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package escaperoom_sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Kim Kaufman
 * CSC 2040
 * 10/16/22
 */
public class Escaperoom_sudoku extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            // Instantiate the FXMLLoader object and reference the Escaperoom Sudoku view file
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("EscaperoomSudokuView.fxml"));
            // Set the ViewController to the loader
            loader.setController(new EscaperoomSudokuController());
            // Using the loader, load the view into a Parent root container: SceneGraph
            Parent root = loader.load();
            // Instantiate the Scene object and initialize it with the root container (SceneGraph)
            Scene scene = new Scene(root);
            // Set the scene on the stage
            primaryStage.setScene(scene);
            // Set stage title
            primaryStage.setTitle("Escape Room: SuDoku");
            // Show the stage
            primaryStage.show();
            } 
        catch(Exception ex) {System.out.println("Error FXMLLoader - start()"); }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
