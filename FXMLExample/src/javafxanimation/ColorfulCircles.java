/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimation;

/**
 *
 * @author L3000n100
 * Tutorial on Javafx Animation and Visual Effects
 */
import static java.lang.Math.random;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ColorfulCircles extends Application{
    public static void main(String args[]){ launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Group root = new Group();
        Group circles = new Group();
        
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);
        
        for(int i = 0; i < 30; i++){
            Circle c = new Circle(150, Color.web("white", 0.05));
            c.setStrokeType(StrokeType.OUTSIDE);
            c.setStroke(Color.web("white", 0.16));
            c.setStrokeWidth(4);
            circles.getChildren().add(c);
        }
        
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, 
            new Stop[]{
                new Stop(0, Color.web("#f8bd55")),
                new Stop(0.14, Color.web("#c0fe56")),
                new Stop(0.28, Color.web("#5dfbc1")),
                new Stop(0.43, Color.web("#64c2f8")),
                new Stop(0.57, Color.web("#be4af7")),
                new Stop(0.71, Color.web("#ed5fc2")),
                new Stop(0.85, Color.web("#ef504c")),
                new Stop(1, Color.web("#f2660f")),
            }));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        
        
        circles.setEffect(new BoxBlur(10, 10, 3));
        //root.getChildren().addAll(colors, circles);
        Group blendModeGroup = new Group(new Group(
            new Rectangle(scene.getWidth(), scene.getHeight(),
                Color.BLACK), circles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        
        Timeline timeline = new Timeline();
        for(Node circle : circles.getChildren()){
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)),
                new KeyFrame(new Duration(40000),
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)
                )
            );
        }
        timeline.play();
        primaryStage.show();
    }
    
}
