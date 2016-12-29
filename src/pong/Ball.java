package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	protected int x;
	protected int y;
	private Color kolor;
	protected Random gen;
	protected int dx;
	protected int dy;
	protected int r;
	private int direct[] = {-1,1};
	private int ranDirect;
	
	public Ball(Dimension d){
		gen = new Random();
		kolor = new Color (gen.nextFloat(), gen.nextFloat(), gen.nextFloat());
		x = d.width/2;
		y = d.height/2;
		r = 20;
		ranDirect = gen.nextInt(2);
		dx =  direct[ranDirect] * (5 + gen.nextInt(10));
		dy = direct[ranDirect] * (5 + gen.nextInt(10));
	}
	
	public void paint(Graphics g){
		g.setColor(kolor);
		g.fillOval(x-r/2, y-r/2, r, r);
	}
	
	public void ballMoving(Dimension d){
		x = x + dx;
		y = y + dy;
		
		if (y <= 2 || y >= d.height-5) dy *= -1;
	}

}
