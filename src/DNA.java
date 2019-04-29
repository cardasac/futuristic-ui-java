import static processing.core.PApplet.radians;

class DNA extends UIElement
{
	private float radius;
	private float translate_x;
	private float translate_y;
	private float rotate_x;
	private float translateAll;

	DNA(UI ui, float x, float y, float size)
	{
		this.ui = ui;
		this.coordinateX = x;
		this.coordinateY = y;
		radius = size / 2;
		translateAll = ui.height / 20;
	}

	void render()
	{
		ui.pushMatrix();

		ui.translate(translate_x, translate_y);
		ui.rotateX(rotate_x);
		ui.translate(translate_x, -translate_y);

		ui.noStroke();
		ui.translate(coordinateX, coordinateY);
		ui.fill(255);
		ui.sphere(radius);

		ui.noStroke();
		ui.fill(255);
		ui.translate(0, translateAll);
		ui.box(radius / 5, ui.height / 9, radius / 5);

		ui.noStroke();
		ui.translate(0, translateAll);
		ui.fill(255);
		ui.sphere(radius);

		ui.popMatrix();
	}

	void update()
	{
		rotate_x = coordinateX + radians(ui.frameCount);
		translate_y = coordinateY + translateAll;
		translate_x = 0;
	}
}
