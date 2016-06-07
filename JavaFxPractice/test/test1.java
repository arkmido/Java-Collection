
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class test1 extends Application{
    
    private Button btn1 = new Button("Open new stage");
    private Stage window;
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Stage 1");

        StackPane layout1 = new StackPane();
        layout1.getChildren().add(btn1);
        btn1.setOnAction(e -> TheAlertBox.display("Stage 2", "Hello there!"));
        
        Scene scene1 = new Scene(layout1, 200, 200);
        window.setScene(scene1);
        window.show();
        
    }
}

class TheAlertBox{
    private static Button btn1;
    private static Label lb1;
    
    public static void display(String title, String msg){
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        
        lb1 = new Label(msg);
        btn1 = new Button("Close");
        btn1.setOnAction(e -> window.close());
        
        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(lb1, btn1);
        layout1.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout1, 300, 200);
        window.setScene(scene1);
        
        window.showAndWait();
    }
}
