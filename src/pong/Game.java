package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.applet.*;

public class Game extends Applet{
	private Ball pilka;
	private Racket paletka1;
	private Racket paletka2;
	private Pitch boisko;
	private Integer scoreLeft = 0;
	private Integer scoreRight =0;
	@Override
	public void init() {
		setBackground(Color.black);
		setSize(500,500);
		Dimension d = getSize();
		pilka = new Ball(d);
		paletka1 = new Racket(d, 0);
		paletka2 = new Racket(d, 475);
		boisko = new Pitch(d);
		
		class Animacja extends TimerTask{

			@Override
			public void run() {
				pilka.ballMoving(d);	
				bouncing(pilka, paletka1, paletka2);
				leftPlayerScoring();
				rightPlayerScoring();
				repaint();
				
			}
		}
		
		Timer move = new Timer();
		move.schedule(new Animacja(), 1000, 100);
		
		addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W)
					paletka1.racketMovinguP();
				if(e.getKeyCode() == KeyEvent.VK_S)
					paletka1.racketMovingDown();
				if(e.getKeyCode() == KeyEvent.VK_UP)
					paletka2.racketMovinguP();
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
					paletka2.racketMovingDown();
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		pilka.paint(g);
		paletka1.paint(g);
		paletka2.paint(g);
		boisko.paint(g);
		g.drawString("GRACZ 1: "+Integer.toString(scoreLeft), 20, 40);
		g.drawString("GRACZ 2: "+Integer.toString(scoreRight), 410, 40);
	}
	
	
	public void bouncing(Ball pilka, Racket paletka1, Racket paletka2){
		if(((pilka.y >= paletka1.y && pilka.y <= paletka1.y + paletka1.wys) && (pilka.x <= paletka1.x + paletka1.szer)) ||
				((pilka.y >= paletka2.y && pilka.y <= paletka2.y + paletka2.wys) && (pilka.x  >= paletka2.x )))
		{
			pilka.dx *= -1;
//			pilka.dy *= pilka.gen.nextInt(4);
		}
	}
	
	public void leftPlayerScoring(){
		if(pilka.x == boisko.rectx) 
			scoreLeft++;
	}
	
	public void rightPlayerScoring(){
		if(pilka.x == boisko.rectx + boisko.rectwid)
			scoreRight++;
	}
	
}
