/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Demonstrates switching of stages
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFx_SwitchingScenes2 extends Application{

    public static void main(String[] args){ launch(args); }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("First Stage");
        
        ToggleGroup tgGroup = new ToggleGroup();
        
        bp = new BorderPane();
        
        // initialize toggelButtons
        tgbtnBurger = initializeToggleButtons(tgbtnBurger, "Burgers", tgGroup, true);
        tgbtnDrinks = initializeToggleButtons(tgbtnDrinks, "Drinks", tgGroup, false);
        tgbtnSides = initializeToggleButtons(tgbtnSides, "Sides", tgGroup, false);
        tgbtnDesserts = initializeToggleButtons(tgbtnDesserts, "Desserts", tgGroup, false);
                
        
        // adding bp's left layout, the toggleButtons
        VBox leftLayout = new VBox(8);
        leftLayout.getChildren().addAll(tgbtnBurger, tgbtnDrinks, tgbtnSides, tgbtnDesserts);
        bp.setLeft(leftLayout);
        
        // initialize tilepanes and create tiles
        tpBurgers = initializeTilePane(tpBurgers);
        tpDrinks = initializeTilePane(tpDrinks);
        tpSides = initializeTilePane(tpSides);
        tpDesserts = initializeTilePane(tpDesserts);
        createTiles(burgers, tpBurgers, "Burger", 12);
        createTiles(drinks, tpDrinks, "Drinks", 4);
        createTiles(sides, tpSides, "Sides", 3);
        createTiles(desserts, tpDesserts, "Desserts", 3);
        
        sp1 = initializeScrollPane(sp1); // The ScrollPane
        sp1.setContent(tpBurgers);
        
        // toggelButton events
        tgbtnBurger.setOnAction(e -> sp1.setContent(tpBurgers) );
        tgbtnDrinks.setOnAction(e -> sp1.setContent(tpDrinks) );
        tgbtnSides.setOnAction(e -> sp1.setContent(tpSides));
        tgbtnDesserts.setOnAction(e -> sp1.setContent(tpDesserts));
        
        // setting the centerlayout of borderpane
        centerLayout = setBPCenterSP(bp, centerLayout, sp1);
        
        // creating the scene and applying tile panels sizes
        Scene scene1 = new Scene(bp, 300, 150);
        setTilePaneLayout(tpBurgers, scene1);
        setTilePaneLayout(tpDrinks, scene1);
        
        window.setScene(scene1);
        window.show();
    }

    private void clicked(ActionEvent e) {
        Button btn = (Button) e.getSource();
        HelloJavaFx_SwitchingScenes2_alertBox.display("AlertBox 1.5", btn.getText());
    }
    private void setTilePaneLayout(TilePane tp, Scene s){
        tp.setPrefHeight(s.getHeight());
        tp.setPrefWidth(s.getWidth());
        tp.setOrientation(Orientation.VERTICAL);
    }
    private void createTiles(Button[] btn, TilePane tp, String name, int numberOfTiles){
        btn = new Button[numberOfTiles];
        
        for(int i = 0; i < numberOfTiles; i++){
            btn[i] = new Button(name+i);
            btn[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    clicked(event);
                }
            });
            tp.getChildren().add(btn[i]);
        }
    }
    
    private TilePane initializeTilePane(TilePane tp){
        tp = new TilePane();
        tp.setPadding(new Insets(5,5,5,5));
        tp.setVgap(8);
        tp.setHgap(8);
        
        return tp;
    }
    
    private ScrollPane initializeScrollPane(ScrollPane sp){
        sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        
        return sp;
    }
    
    private VBox setBPCenterSP(BorderPane bp, VBox vb, ScrollPane sp){
        vb = new VBox(8);
        vb.getChildren().addAll(sp);
        bp.setCenter(vb);
        return vb;
    }
    private ToggleButton initializeToggleButtons(ToggleButton tgbtn,String name, ToggleGroup tg, boolean isSelected){
        tgbtn = new ToggleButton(name);
        tgbtn.setSelected(isSelected);
        tgbtn.setToggleGroup(tg);
        
        return tgbtn;
    }
    
    Stage window;
    TilePane tpBurgers,tpDrinks, tpSides, tpDesserts;
    ScrollPane sp1;
    Button[] burgers, drinks, sides, desserts;
    BorderPane bp;
    ToggleButton tgbtnBurger, tgbtnDrinks, tgbtnSides, tgbtnDesserts;
    VBox centerLayout;
}
