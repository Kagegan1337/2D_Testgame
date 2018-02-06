package main;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

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
		
		Sprite main = new Sprite();
		Sprite back = new Sprite();
		
		System.out.println(main);
		System.out.println(back);
		
		back.setImage("pictures/back.jpg");
		back.setPosi(0, 0);
		main.setImage("pictures/hinderniss.jpg");
		main.setPosi(0, 256);
		
		//controll
		ArrayList<String> input = new ArrayList<String>();
		
		theScene.setOnKeyPressed(
					new EventHandler<KeyEvent>() {
						public void handle(KeyEvent e) {
							String code = e.getCode().toString();
							System.out.println(code + " pressed");
							if( !input.contains(code)) {
								input.add(code);
							}
						}
					}
				);
		theScene.setOnKeyReleased( 
				new EventHandler<KeyEvent>() {
					public void handle(KeyEvent e) {
						System.out.println("released");
						String code = e.getCode().toString();
						input.remove(code);
					}
		});
		//move up
		//move down
		//move right
		//Animation
		
		LongValue lastNanoTime = new LongValue(System.nanoTime());
		
			new AnimationTimer() {
				@Override
				public void handle(long currentNanoTime) {
					double elapsedTime = (currentNanoTime - lastNanoTime.value)/100000000.0;
					lastNanoTime.value = currentNanoTime;
					
					main.setVelo(0, 0);
					back.setVelo(0, 0);
					if(input.contains("LEFT"))
						main.addVelo(-50, 0);
					if(input.contains("RIGHT"))
						main.addVelo(50, 0);
					if(input.contains("UP"))
						main.addVelo(0, -50);
					if(input.contains("DOWN"))
						main.addVelo(0, 50);
					
					if(main.getPosiX()<0) {
						main.setPosi(512, main.getPosiY());
					}
					if(main.getPosiX()>400) {
						back.addVelo(-100, 0);
						main.setPosi(400, main.getPosiY());
					}
					
					if(main.getPosiY()<0) {
						main.setPosi(main.getPosiX(), 512);
					}
					if(main.getPosiY()>512) {
						main.setPosi(main.getPosiX(),0);
					}
				
					
					back.update(elapsedTime);
					main.update(elapsedTime);
					back.render(gc);
					main.render(gc);
					gc.setFill(Color.YELLOW);
					gc.fillText(main.toString(), 25, 25);
				}
			}.start();
		theStage.show();
	}

}
