import processing.core.*;

public class Fuego extends Elemento {
	private boolean mov = false;
	private int v;
	boolean esca = false;
	
	public Fuego(PApplet app, float x, float y) {
		super(app, x, y);
		pos = new PVector(x,y);
		v = 1;
		if(pos.x == app.mouseX && pos.y == app.mouseY) {
			esca = true;
		}
		
	}
	

	@Override
	public void pintar() {
		app.noStroke();
		app.fill(231,37,18, alfa);
		app.triangle(pos.x+v, pos.y, (pos.x+40)+v, pos.y, (pos.x+20)+v, pos.y-40);
		if(app.frameCount%2==0) {
			mov=!mov;
			 if(esca == true) {
				  actualizar();
			 }
			
		}
		if(mov==true) {
			v*=-1;
		}
	}

	@Override
	public void actualizar() {
		pos.x ++;
		
	}


	@Override
	public void pintar2() {
		// TODO Auto-generated method stub
		
	}

	public void mover(float x, float y) {
		pos.x=x;
		pos.y=y;
		
	}
}
