/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Using different layouts in a scene
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class HelloJavaFx_EmbeddingLayouts extends Application{
   private Stage window; 
   private HBox toplayout;
   private VBox leftlayout;
   private Scene scene1;
   private Button btnA,btnB,btnC,btnD,btnE,btnF;
   
    public static void main(String args[]){
       launch(args);
   }
    @Override
   public void start(Stage stage){
       window = stage;
       window.setTitle("Layouts!");
       window.setOnCloseRequest(eh -> System.exit(0));
       
       btnA = new Button("File");
       btnB = new Button("Edit");
       btnC = new Button("View");
       btnD = new Button("D");
       btnE = new Button("E");
       btnF = new Button("F");
       
       toplayout = new HBox();
       leftlayout = new VBox();
       toplayout.getChildren().addAll(btnA,btnB,btnC);
       leftlayout.getChildren().addAll(btnD,btnE,btnF);
       
       BorderPane mainlayout = new BorderPane();
       mainlayout.setTop(toplayout);
       mainlayout.setLeft(leftlayout);
       
       scene1 = new Scene(mainlayout, 300, 200);
       window.setScene(scene1);
       window.show();
   }
}
