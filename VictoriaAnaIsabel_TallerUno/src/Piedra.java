import processing.core.*;
import java.util.*;
public class Piedra {

	private int tam1=5;
	private int tam2=10;
	private int tam3=20;
	private int tam4=25;
	private int r;
	PApplet app;
	PVector pos;
	PVector vel;
	boolean esca = false;
	
	public Piedra(PApplet app) {
		this.app=app;
		r= (int) app.random(1,3);
		pos = new PVector(app.random(-200, 1400),app.random(-100 , -300));
		if(pos.x<0) {
			vel = new PVector(5,(int)app.random(1,5));
		} else if(pos.x > app.width) {	
			vel = new PVector(-5,(int)app.random(1,5));
		} else if(pos.x < app.width) {	
			if(r==1) {
				vel = new PVector(5,(int)app.random(1,5));
			}
			if(r==2) {
				vel = new PVector(-5,(int)app.random(1,5));
			}
			}
	}

	public void pintar(){
		app.noStroke();
		app.fill(89,53,31);
		app.beginShape();
		app.vertex(pos.x,pos.y);
		app.vertex((pos.x),(pos.y)+tam3);
		app.vertex((pos.x)+tam2,(pos.y)+tam4);
		app.vertex((pos.x)+tam3,(pos.y)+tam3);
		app.vertex((pos.x)+tam3,(pos.y));
		app.vertex((pos.x)+tam2,(pos.y)-tam1);
		app.endShape(app.CLOSE);	
	}
	public void mover() {
		pos.add(vel);
    if(pos.y>=900) {
    	pos.y = app.random(-100, -200);
    	r= (int) app.random(1,3);
		pos.x = app.random(-200, 1400);
		if(pos.x<0) {
			vel = new PVector(5,(int)app.random(1,5));
		} else if(pos.x > app.width) {	
			vel = new PVector(-5,(int)app.random(1,5));
		} else if(pos.x < app.width) {	
			if(r==1) {
				vel = new PVector(5,(int)app.random(1,5));
			}
			if(r==2) {
				vel = new PVector(-5,(int)app.random(1,5)
						
						);
			}
			}
    }
	}
	

	}

