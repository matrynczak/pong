package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Pitch {
	private Color kolor;
	private int lineDownY;
	private int lineMiddleX;
	private int ovalX;
	private int ovalY;
	private int r;
	protected int rectx;
	protected int rectwid;
	private int recty, recthe;
	
	public Pitch(Dimension d){
		kolor = Color.yellow;
		lineDownY = d.height;
		lineMiddleX = d.width/2;
		ovalX = d.width/2;
		ovalY = d.height/2;
		r = 160;
		rectx = -3;
		recty = 2;
		rectwid = d.width+6;
		recthe = d.height-5;
	}
	
	public void paint(Graphics g){
		g.setColor(kolor);
		g.drawOval(ovalX-r/2, ovalY-r/2, r, r);
		g.drawLine(lineMiddleX, 2, lineMiddleX, lineDownY-4);
		g.drawRect(rectx, recty, rectwid, recthe);
	}

}
