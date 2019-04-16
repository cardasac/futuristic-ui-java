import processing.core.PApplet;

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
//		ui.rotateY(ui.PI * timer / ui.width);
		ui.translate(-50, -50, -1000);
		ui.rotateY(PApplet.radians(timer/20));

		ui.noStroke();
		ui.lights();
		ui.translate(x, y, 0);
		ui.sphere(radius);

		ui.noStroke();
		ui.lights();

		ui.translate(50, 0, 0);
		ui.box(150, radius / 5, radius / 5);

		ui.noStroke();
		ui.lights();
		ui.translate(100, 0, 0);
		ui.sphere(radius);
	}

	void update()
	{
		timer = ui.millis();
	}
}
