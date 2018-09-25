import processing.core.*;

public class Fuego extends Elemento {
	private boolean mov = false;
	private int v;
	public Fuego(PApplet app, float x, float y) {
		super(app, x, y);
		pos = new PVector(x,y);
		v = 1;
		
	}
	

	@Override
	public void pintar() {
		app.noStroke();
		app.fill(231,37,18);
		app.triangle(pos.x+v, pos.y, (pos.x+40)+v, pos.y, (pos.x+20)+v, pos.y-40);
		if(app.frameCount%2==0) {
			mov=!mov;
			
		}
		if(mov==true) {
			v*=-1;
		}
	}

	@Override
	public void actualizar() {
		
		
	}


	@Override
	public void pintar2() {
		// TODO Auto-generated method stub
		
	}

}
