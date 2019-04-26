import processing.core.PApplet;

public class AbstergoLogo
{
	private UI ui;
	private int counter;

	AbstergoLogo(UI ui)
	{
		this.ui = ui;
	}

	public void draw_trapezium(int rx, int ry, int trans)
	{
		ui.pushMatrix();
		ui.translate(rx, ry);
		ui.rotate(PApplet.radians(trans));
		float length = 180;
		float side = 80;
		double height = Math.sqrt(3) / 2 * side;
		ui.fill(190);
		ui.noStroke();
		ui.quad(0, 0, length, 0, length + side / 2, (float) height, 0 - side / 2, (float) height);
		ui.popMatrix();
	}

	public void draw_logo()
	{
		ui.pushMatrix();
		ui.translate(ui.width / 4f, ui.height / 5);
		draw_trapezium(250, 300, 0);
		draw_trapezium(460, 135, 120);
		draw_trapezium(500, 400, 240);
		ui.fill(240, ui.millis() / 10 % 255);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.text("LOADING", 400, 500);
		ui.popMatrix();
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
		return 10;
	}

	public Boolean check_finish(int timer)
	{
		return counter == timer - 4;
	}
}
