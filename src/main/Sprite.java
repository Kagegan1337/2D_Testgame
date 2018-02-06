package main;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	private Image image;
	private double posiX;
	private double posiY;
	private double veloX;
	private double veloY;

	
	public Sprite() {
		posiX = 0;
		posiY = 0;
		veloX = 0;
		veloY = 0;
		
	}
	
	public void setImage(Image i) {
		image = i;
	
	}
	
	public void setImage(String filename) {
		Image i = new Image(filename);
		setImage(i);
	}
	
	public void setPosi(double x, double y) {
		posiX = x;
		posiY = y;
	}
	
	public double getPosiX() {
		return posiX;
	}
	
	public double getPosiY() {
		return posiY;
	}
	
	public void setVelo(double x, double y) {
		veloX = x;
		veloY = y;
	}
	
	public void addVelo(double x, double y) {
		veloX += x;
		veloY += y;
	}
	
	public void update(double time) {
		posiX += veloX * time;
		posiY += veloY * time;
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(image, posiX, posiY);
	}
	
	@Override
	public String toString() {
		return String.format("[[X:]" + getPosiX() + " [Y:] "+ getPosiY() + " ]");
	}
}
