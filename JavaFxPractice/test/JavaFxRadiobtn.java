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
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JavaFxRadiobtn extends Application{
    public void start(Stage stage) throws Exception{
        stage.setTitle("Radio Button Test");
        
        final ToggleGroup rbgroup = new ToggleGroup();
        rb1 = new RadioButton("Home");
        rb2 = new RadioButton("Calendar");
        rb3 = new RadioButton("Contacts");
        rb1.setToggleGroup(rbgroup);
        rb2.setToggleGroup(rbgroup);
        rb3.setToggleGroup(rbgroup);
        
        
        btn = new Button("Click Me!");
        btn.setOnAction(e -> {
            if(rb1.isSelected()) System.out.println(rb1.getText());
            if(rb2.isSelected()) System.out.println(rb2.getText());
            if(rb3.isSelected()) System.out.println(rb3.getText());
        });
        
        layout1 = new BorderPane();
        leftlayout = new VBox(10);
        leftlayout.getChildren().addAll(rb1,rb2,rb3);
        
        layout1.setCenter(btn);
        layout1.setLeft(leftlayout);
        
        
        scene = new Scene(layout1, 300, 275);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
    private Button btn;
    private RadioButton rb1,rb2,rb3;
    private Scene scene;
    private BorderPane layout1;
    private VBox leftlayout;
    
}
