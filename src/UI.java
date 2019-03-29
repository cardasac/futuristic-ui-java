import processing.core.PApplet;

public class UI extends PApplet
{
	private Button b;
	private DNA mc;

	private boolean[] keys = new boolean[1024];

	public void keyPressed()
	{
		keys[keyCode] = true;
	}

	public void keyReleased()
	{
		keys[keyCode] = true;
	}

	private boolean checkKey(int c)
	{
		return keys[c] || keys[Character.toUpperCase(c)];
	}


	public void settings()
	{
		size(800, 800);
		// Use fullscreen instead of size to make your interface fullscreen
//		fullScreen();
	}

	public void draw_rhombus()
	{
		float length_1 = 180;
		float side = 80;
		double height = Math.sqrt(3)/2 * side;
		quad(0, 0, length_1, 0, length_1 + side / 2, (float)height, 0 - side / 2, (float)height);
	}

	public void setup()
	{
//		b = new Button(this, 50, 50, 100, 50, "I am a button");
//		mc = new DNA(this, (float) width / 2, (float) height / 2, 50);


		background(130);

		// first rhombus
		pushMatrix();
		translate(250, 300);

		noStroke();
		fill(190);
		draw_rhombus();

		popMatrix();

		// second rhombus
		pushMatrix();
		translate(460, 135);
		rotate(radians(120));

		noStroke();
		fill(190);
		draw_rhombus();

		popMatrix();


		// third rhombus
		pushMatrix();
		translate(500, 400);
		rotate(radians(240));

		fill(190);
		draw_rhombus();

		popMatrix();

		textSize(32);

		text("Loading", 10, 30);
	}

	public void draw()
	{

		// second rhombus


//		b.render();
//
//		mc.update();
//		mc.render();

		if (checkKey(LEFT))
		{
			System.out.println("Left arrow key pressed");
		}
	}
}

