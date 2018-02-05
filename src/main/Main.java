package main;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage theStage) {
		//Title
		theStage.setTitle("Hello World");
		
		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);
		
		Canvas canvas = new Canvas(500,500);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		Font theFont = Font.font("Times NEw Roman", FontWeight.BOLD,48);
		gc.setFont(theFont);
		
		
		Image pingu = new Image("pictures/funyy.jpg");
		Image back = new Image("pictures/back.jpg");
		gc.drawImage(back, 0, 0);
		gc.drawImage(pingu, 180	, 180);
		
		gc.fillText("Hello World", 150, 50);
		gc.strokeText("Hello World", 150, 50);
		
		
		theStage.show();
	}

}
