import java.util.LinkedList;

import processing.core.*;
public class Incendio {

	 PVector pos, vel;
	  float life;
	  PApplet app;
	  float P_RADIOUS = 7;

	 public Incendio(PVector pos, PApplet app){
	    this.pos = pos;
	    vel = new PVector(0, 0);
	    life = 1.0f;
	    this.app = app;
	  }
	  
	  void update(){
		  app.noStroke();
	    float accAng = app.random(app.TWO_PI);
	    float accSize = app.random(0.1f, 0.2f);
	    PVector acc = new PVector(accSize * app.cos(accAng), accSize * app.sin(accAng));
	    vel.add(acc);
	    pos.add(vel);
	    life *= app.random(0.98f, 0.995f);
	  }
	  
	  void display(){
	    float r = P_RADIOUS * app.sqrt(life);
	    float a = 255 * app.pow(life, 1.0f / 3);
	    app.fill(255,0,0, a);
	    app.ellipse(pos.x, pos.y, r * 2, r * 2);
	  }
	  
	  boolean isDead(){
	    return life < 0.01f;
	  }
	}
	

