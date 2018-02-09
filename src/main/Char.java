package main;

public class Char extends Sprite {
	
	private String _name;
	
	public Char(String name) {
		_name=name;
	}
	
	public Char() {
		super();
	}
	
	public void jump() {
		
	}
	
	@Override
	public String toString() {
		return super.toString() + _name.toString();
	}
	
}
