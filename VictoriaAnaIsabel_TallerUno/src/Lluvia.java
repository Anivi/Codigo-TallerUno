import processing.core.PApplet;
import processing.core.PVector;

public class Lluvia {
	PApplet app;
	PVector pos;
	PVector vel;
	float largo;

	public Lluvia(PApplet app) {
		this.app = app;
		pos = new PVector(app.random(app.width), app.random(-500, -50), app.random(0,20));
		vel = new PVector(0, app.map(pos.z, 0, 20, 4, 10));
		largo = app.map(pos.z, 0, 20, 2, 5);
	}

	void caer() {

		pos.add(vel);
		float gravedad = app.map(pos.z, 0, 20, 0, 0.2f);
		vel.y = vel.y + gravedad;
		if (pos.y > app.height) {
			pos.y = app.random(-200, -100);
			vel.y = app.map(pos.z, 0, 20, 4, 10);
		}

	}

	void pintar() {
		float grueso = app.map(pos.z, 0, 20, 1, 2);
		app.strokeWeight(grueso);
		app.stroke(76, 147, 154, 150);
		app.ellipse(pos.x, pos.y, largo, largo);
		//app.line(pos.x, pos.y, pos.x, pos.y - largo);
	}

}
