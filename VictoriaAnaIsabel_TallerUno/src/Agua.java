import processing.core.*;

public class Agua extends Elemento {
	float scalar = 0.2f;
	  float angle = 0.0f;
	  float speed = 0.01f;
	  int age = 0;
	  float strokew = tam/5;
	  float xv = -3+app.random(1,5);
	  float yv = -app.random(3);
	  float maxYV = 1;
	  boolean esca = false;	  
	public Agua(PApplet app, float x, float y) {
		super(app, x, y);
		pos = new PVector(x,y);
		tam = 40;
		vel1= 0.5f;
		if(pos.x == app.mouseX && pos.y == app.mouseY) {
			esca = true;
		}
		
		  
	}

@Override
public void pintar() {
	  app.ellipseMode(app.CENTER);

      app.noFill();
      app.stroke(255, alfa);
      app.strokeWeight(2);
      app.fill(8,224,215, alfa);
      app.ellipse(pos.x,pos.y,tam,tam);
      app.noFill();
      app.strokeWeight(1.5f);
      app.strokeCap(app.ROUND);
      app.arc(pos.x,pos.y,tam-15,tam-15,5.65f,6.56f);
      app.strokeWeight(strokew*1);
      app.arc(pos.x,pos.y,tam-15,tam-15,0.79f,1.16f);
      
      pos.y+=vel1;
      if(app.frameCount% 15 ==0) {
    	  vel1*=-1;
      }
 	 if(esca == true) {
		  actualizar();
 	 }
}

	@Override
	public void actualizar() {
    pos.x++;
	}

	@Override
	public void pintar2() {
		// TODO Auto-generated method stub
		
	}

}
