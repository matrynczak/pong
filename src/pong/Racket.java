package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Racket {
	protected int x;
	protected int y;
	protected int szer;
	protected int wys;
	private Color kolor;
	Random gen;
	private int dyUp;
	private int dyDown;
	
	public Racket(Dimension d, int yy){
		gen = new Random();
		szer = 15;
		wys = 70;
		y = d.width/2 - szer/2;
		x = 5 + yy;
		kolor = new Color (gen.nextFloat(), gen.nextFloat(), gen.nextFloat());
		dyUp = -10;
		dyDown = 10;
	}
	
	public void paint(Graphics g){
		g.setColor(kolor);
		g.fillRoundRect(x, y, szer, wys, 7, 7);
	}
	
	public void racketMovinguP(){
		y = y + dyUp;
	}
	
	public void racketMovingDown(){
		y = y + dyDown;
	}

}
