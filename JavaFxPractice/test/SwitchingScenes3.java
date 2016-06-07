/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L3000n100
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

public class SwitchingScenes3 extends Application{
    public static void main (String args[]){ launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Switching Scenes 3");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        
        initialize();
        setPositions();
        
        btn1.setOnAction(e -> {
            mainLayout.setCenter(grid1);
        });
        btn2.setOnAction(e -> {
            mainLayout.setCenter(grid2);
        });
        btn3.setOnAction(e -> {
            mainLayout.setCenter(grid3);
        });
        
        primaryStage.setScene(sceneMain);
        primaryStage.show();
    }
    public void setPositions(){
        left.getChildren().addAll(btn1, btn2);
        right.getChildren().add(btn3);
        mainLayout.setLeft(left);
        mainLayout.setRight(right);
        
        insideGrid1.getChildren().add(new Label("Grid1 > vbox1"));
        grid1.add(insideGrid1, 0, 0);
        
        insideGrid2.getChildren().add(new Label("Grid2 > vbox2"));
        grid2.add(insideGrid2, 0, 0);
        
        insideGrid3.getChildren().add(new Label("Grid3 > vbox3"));
        grid3.add(insideGrid3, 0, 0);
        
        mainLayout.setCenter(grid1);
    }
    public void initialize(){
        mainLayout = new BorderPane();
        insideGrid1 = new VBox(10);
        insideGrid2 = new VBox(10);
        insideGrid3 = new VBox(10);
        left = new VBox(10);
        right = new VBox(10);
        
        initializeGrids();
        
        btn1 = new ToggleButton("A");
        btn2 = new ToggleButton("B");
        btn3 = new ToggleButton("C");
        btnGroup = new ToggleGroup();
        btn1.setToggleGroup(btnGroup);
        btn2.setToggleGroup(btnGroup);
        btn3.setToggleGroup(btnGroup);
        btn1.setSelected(true);
        
        sceneMain = new Scene(mainLayout);
    }
    public void initializeGrids(){
        grid1 = new GridPane();
        grid2 = new GridPane();
        grid3 = new GridPane();
        
        grid1.setPadding(new Insets(10,10,10,10));
        grid1.setHgap(8);
        grid1.setVgap(8);
        
        grid2.setPadding(new Insets(10,10,10,10));
        grid2.setHgap(8);
        grid2.setVgap(8);
        
        grid3.setPadding(new Insets(10,10,10,10));
        grid3.setHgap(8);
        grid3.setVgap(8);
        
        grid1.setGridLinesVisible(true);
        grid2.setGridLinesVisible(true);
        grid3.setGridLinesVisible(true);
    }
    
    private Scene sceneMain;
    private ToggleButton btn1, btn2, btn3;
    private ToggleGroup btnGroup;
    
    private VBox insideGrid1, insideGrid2, insideGrid3, left, right;
    private BorderPane mainLayout;
    private GridPane grid1, grid2, grid3;
}
