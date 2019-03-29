import processing.core.PApplet;

class DNA
{
	private PApplet ui;
	private float x;
	private float dx = 1;
	private float y;
	private float diameter;
	private float radius;

	DNA(PApplet ui, float x, float y, float diameter)
	{
		this.ui = ui;
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		radius = diameter / 2;
	}

	void render()
	{
		ui.stroke(255);
		ui.noFill();
		ui.ellipse(x, y, diameter, diameter);
		ui.fill(255);

		// static field refers to all the classes
		ui.textAlign(PApplet.CENTER, PApplet.CENTER);
		ui.text("I am a moving circle", x, y);
	}

	void update()
	{
		x += dx;
		if ((x > ui.width - radius) || (x < radius))
		{
			dx *= -1;
		}
	}
}
