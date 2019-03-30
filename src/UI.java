import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;


public class UI extends PApplet
{

	private double bx;
	private double by;
	private int box_size = 75;
	boolean overBox = false;
	boolean locked = false;
	float xOffset = 0;
	float yOffset = 0;


	private ArrayList<Menu_Options> options = new ArrayList<>();

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
		load_menu_options();

		// Use fullscreen instead of size to make your interface fullscreen
		fullScreen();
	}

	public void draw_rhombus()
	{
		float length_1 = 180;
		float side = 80;
		double height = Math.sqrt(3) / 2 * side;
		quad(0, 0, length_1, 0, length_1 + side / 2, (float) height, 0 - side / 2, (float) height);
	}

	public void setup()
	{
		// temp variables
		bx = width / 2.0;
		by = height / 2.0;
		rectMode(RADIUS);

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


		// need to animate this
		textSize(32);

		text("Loading", 10, 30);
	}

	// button variables
	private float button_height = 50;
	private float border = 20;
	private float button_width = 200;
	private float gap = 20;

	private void draw_menu_options()
	{
		for (int i = 0; i < options.size(); i++)
		{
			Menu_Options p = options.get(i);

			float y = border + (i * (button_height + gap));
			float x = border;
			noFill();
			stroke(0);
			rect(x, y, button_width, button_height);
			textAlign(CENTER, CENTER);
			fill(0);
			text(p.getName(), x + button_width * 0.5f, y + button_height * 0.5f);
		}
	}

	private void load_menu_options()
	{
		Table table = loadTable("options.csv", "header");
		for (TableRow tr : table.rows())
		{
			Menu_Options p = new Menu_Options(tr);
			options.add(p);
		}
	}

	public void draw()
	{
		int which = Integer.MIN_VALUE;

		if (mouseX > bx - box_size && mouseX < bx + box_size &&
				mouseY > by - box_size && mouseY < by + box_size)
		{
			overBox = true;
			which = (int) ((mouseY - border) / (button_height + gap));

			if (!locked)
			{
				stroke(255);
				fill(153);
			}
		}
		else
		{
			stroke(153);
			fill(153);
			overBox = false;
		}
		// b.render();

		System.out.println(options.get(which));

//
//		mc.update();
//		mc.render();
		background(127);
		draw_menu_options();


		if (checkKey(LEFT))
		{
			System.out.println("Left arrow key pressed");
		}
	}
}

