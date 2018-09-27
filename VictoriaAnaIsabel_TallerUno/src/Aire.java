import processing.core.PApplet;
import processing.core.PVector;

public class Aire extends Elemento {

	float r;
	float theta;
	float angle;
	int num = 8, units = 8, frames = 1200;
	int d=20;
	int currentAngle = 0;
	int s;
	float f;
	boolean esca = false;


	
	public Aire(PApplet app, float x, float y) {
		super(app, x, y);		
		pos = new PVector(x,y);
		if(pos.x == app.mouseX && pos.y == app.mouseY) {
			esca = true;
		}
		
		
	}

	@Override
	public void pintar() {
		
		 app.fill(200, alfa);
		  app.noStroke();
		  for (int i=0; i<num; i++) {
		    pintarCirculo(i+1, 10-i*2);
		  } 
		  theta += app.TWO_PI/frames;
		 //esca=esta cayendo 
		  if(esca == true) {
			  actualizar();
		  }
		  
		}

		void pintarCirculo(int speed, float sz) {
			app.strokeWeight(1);
		  app.pushMatrix(); 
		  app.translate(pos.x, pos.y); 
		  app.rotate(theta*speed); 
		  if (speed == 2) {
		    app.noStroke();
		  } else {
		    app.stroke(255,alfa);
		  }
		  for (int i=0; i<units; i++) {
		    float x = app.cos(angle)*d; 
		    float y = app.sin(angle)*d; 
		    app.ellipse(x, y, sz, sz);
		    angle=units*i;
		  }
		  app.popMatrix();
		}
		
		public void pintarTriangulo(int r, int a) {
			app.translate(0, r);
			app.triangle(-30, -30, 30, -30, 30, 30);
			
		}
	

	@Override
	public void actualizar() {
		
		pos.x++;
		
	}

	@Override
	public void pintar2() {
		float c = app.radians(f+currentAngle);
		app.translate(800, 500);
		app.rotate(c);// Rotate based on currentAngle
		app.pushMatrix();
		app.translate(600, app.height / 2);
		app.fill(0, 255, 0);// Sets the colour for the interior of the rectangle
		for (int j = 0; j < 2; j++) {
			s *= -1;
			pintarTriangulo(s * (j + 1), 30 * (j + 1));
		}
		app.popMatrix();

//			app.rotate(app.radians(1));

		currentAngle += 2;
		if (currentAngle > 360) {
			currentAngle = 0;
		}
//		}
	}

		
		
		
	}
	
	
	
	

