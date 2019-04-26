import static processing.core.PApplet.radians;

class DNA
{
	private float x;
	private float y;
	private float radius;
	private UI ui;
	private float translate_x;
	private float translate_y;
	private float rotate_y;

	DNA(UI ui, float x, float y, float size)
	{
		this.ui = ui;
		this.x = x;
		this.y = y;
		radius = size / 2;
	}

	void render()
	{
		ui.pushMatrix();

		ui.translate(translate_x, translate_y);
		ui.rotateY(rotate_y);
		ui.translate(-translate_x, translate_y);

		ui.noStroke();
		ui.translate(x, y);
		ui.fill(255);
		ui.sphere(radius);

		ui.noStroke();
		ui.fill(255);
		ui.translate(100, 0);
		ui.box(150, radius / 5, radius / 5);

		ui.noStroke();
		ui.translate(100, 0);
		ui.fill(255);
		ui.sphere(radius);

		ui.popMatrix();
	}

	void update()
	{
		rotate_y = y + radians(ui.frameCount);
		translate_x = x + 100;
		translate_y = 0;
	}
}
