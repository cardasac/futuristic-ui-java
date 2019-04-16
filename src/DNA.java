import static processing.core.PApplet.radians;

class DNA
{
	private float x;
	private float dx = 1;
	private float y;
	private float diameter;
	private float radius;
	protected UI ui;
	int timer;

	DNA(UI ui, float x, float y, float diameter)
	{
		this.ui = ui;
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		radius = diameter / 2;
	}

	void render()
	{
		ui.pushMatrix();
		ui.translate(500, 0);
		ui.rotateY(y+ radians(ui.frameCount));
		ui.translate(-500, 0);

		ui.fill(240);
//		ui.rotateY(ui.PI * timer / ui.width);
//		ui.rotateY(PApplet.radians(timer/20));

		// rotate around the center of the sketch
		ui.noStroke();
		ui.lights();
		ui.translate(x, y);
		ui.fill(240);

		ui.sphere(radius);

		ui.noStroke();
		ui.lights();

		ui.translate(100, 0);
		ui.box(150, radius / 5, radius / 5);

		ui.noStroke();
		ui.lights();
		ui.translate(100, 0);
		ui.fill(240);
		ui.sphere(radius);
		ui.popMatrix();
	}

	void update()
	{


	}
}
