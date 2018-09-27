import processing.core.*;

public class Viento {

	PApplet app;
	int gettingup = 1;
	private float x ;
	private float y ;
	private float r ;
	private float g ;
	private float b ;
	private float accx = 0;
	private float accy = 0;
	private float velx = 0;
	private float vely = 0;
	int alphaval = 0;

	public Viento(PApplet app) {
		this.app = app;
		x = app.random(app.width);
		y = app.random(app.height);
		r = app.random(100, 255);
		g = app.random(100, 255);
		b = app.random(80);

	}

	void show() {
		app.strokeWeight(20);

		app.stroke(r, g, b, alphaval);
		app.point(x, y);
	}

	void update() {
		if (gettingup == 1) {
			alphaval += 3;
			if (alphaval > 300)
				gettingup = 0;
		} else
			alphaval -= 3;

	}

	void physics() {
		accx = app.mouseX - x;
		accy = app.mouseY - y;
		normalizeacc();
		accx *= 0.1;
		accy *= 0.1;
		velx += accx;
		vely += accy;
		limitvel();
		x += velx;
		y += vely;

	}

	void normalizeacc() {

		if (app.abs(accx) > app.abs(accy)) {
			accy /= app.abs((float) accx);
			accx /= app.abs((float) accx);
		} else {
			accx /= app.abs((float) accy);
			accy /= app.abs((float) accy);
		}

	}

	void limitvel() {
		float vellimit = 5;
		if (velx > vellimit) {
			velx = vellimit;
			normalizevel();
		}
		if (vely > vellimit) {
			vely = vellimit;
			normalizevel();
		}
		if (velx < -vellimit) {
			velx = -vellimit;
			normalizevel();
		}
		if (vely < -vellimit) {
			vely = -vellimit;
			normalizevel();
		}
	}

	void normalizevel() {

		if (app.abs(velx) > app.abs(vely)) {
			vely /= app.abs((float) velx);
			velx /= app.abs((float) velx);
		} else {
			velx /= app.abs((float) vely);
			vely /= app.abs((float) vely);
		}
		velx *= 5;
		vely *= 5;
	}
}

//	void mousePressed() {  VA EN LA LOGICA
//	vientos.add(new Viento());
//	}
