import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

public class Tierra extends Elemento {
LinkedList<Piedra>piedras;
float angle;
float vel;
private int tam1=5;
private int tam2=10;
private int tam3=20;
private int tam4=25;
private boolean crecer=true;

	public Tierra(PApplet app, float x, float y) {
		super(app, x, y);
		pos = new PVector(x,y);
		vel = 0.3f;
        piedras= new LinkedList<Piedra>();
        for (int i = 0; i < 20; i++) {
        	piedras.add(new Piedra(app));
			
		}
	}

	@Override
	public void pintar() {
	app.pushMatrix();
	app.rotate(angle);
	app.fill(89,53,31);
	app.beginShape();
	app.vertex(pos.x,pos.y);
	app.vertex((pos.x),(pos.y)+tam3);
	app.vertex((pos.x)+tam2,(pos.y)+tam4);
	app.vertex((pos.x)+tam3,(pos.y)+tam3);
	app.vertex((pos.x)+tam3,(pos.y));
	app.vertex((pos.x)+tam2,(pos.y)-tam1);
	app.endShape(app.CLOSE);
	app.popMatrix();
	if(crecer==true) {
	if(tam1<15) {
		tam1++;
	}
	if(tam2<20) {
		tam2++;
	}
	if(tam3<30) {
		tam3++;
	}
	if(tam4<35) {
		tam4++;
	}
	if(tam1==15) {
		crecer=false;
	}
	}else {
		if(tam1>5) {
			tam1--;
		}
		if(tam2>10) {
			tam2--;
		}
		if(tam3>20) {
			tam3--;
		}
		if(tam4>25) {
			tam4--;
		}
		if(tam1==5) {
			crecer=true;
		}
	}
	}
	

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pintar2() {
	
		for (int i = 0; i < piedras.size(); i++) {
			piedras.get(i).pintar();
			piedras.get(i).mover();
		}
		
	}
	
	
	
}
