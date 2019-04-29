import processing.core.PApplet;

public class AbstergoLogo implements Loading
{
	private UI ui;
	private int counter;
	private float coordinateX;
	private float coordinateY;

	AbstergoLogo(UI ui, float x, float y)
	{
		this.ui = ui;
		this.coordinateX = x;
		this.coordinateY = y;
	}

	private void draw_trapezium(int trans)
	{
		ui.pushMatrix();
		ui.translate(coordinateX, coordinateY);
		ui.rotate(PApplet.radians(trans));
		ui.translate(-ui.width / 8, ui.height / 36);
		float length = ui.width / 7;
		float side = ui.height / 9;
		double height = Math.sqrt(3) / 2 * side;
		ui.fill(255);
		ui.noStroke();
		ui.quad(0, 0, length, 0, length + side / 2, (float) height, -side / 2, (float) height);
		ui.popMatrix();
	}

	private void draw_logo()
	{
		draw_trapezium(0);
		draw_trapezium(120);
		draw_trapezium(240);
		ui.fill(255, ui.millis() / 10 % 255);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.text("LOADING", coordinateX, ui.height - ui.height / 5);
	}

	public void render()
	{
		draw_logo();
	}

	public void update()
	{
		counter = ui.millis() / 1000;
	}

	public int return_timer()
	{
		return counter;
	}

	public Boolean check_finish(int timer)
	{
		return counter == timer + 4;
	}
}
