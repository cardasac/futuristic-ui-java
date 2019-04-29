import static processing.core.PApplet.radians;

class DNA extends UIElement
{

	private float radius;
	private float translate_x;
	private float translate_y;
	private float rotate_y;
	private float translateAll = 50;

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
		ui.translate(translateAll, 0);
		ui.box(80, radius / 5, radius / 5);

		ui.noStroke();
		ui.translate(translateAll, 0);
		ui.fill(255);
		ui.sphere(radius);

		ui.popMatrix();
	}

	void update()
	{
		rotate_y = y + radians(ui.frameCount);
		translate_x = x + translateAll;
		translate_y = 0;
	}
}
