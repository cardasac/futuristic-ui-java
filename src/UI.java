import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PFont;
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

	// button variables
	private float button_height = 50;
	private float border = 20;
	private float button_width = 200;
	private float gap = 40;


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
		smooth(8);
		fullScreen();
		millis();
	}

	public void draw_rhombus(int rx, int ry, int trans)
	{
		pushMatrix();
		translate(rx, ry);
		rotate(radians(trans));
		float length = 180;
		float side = 80;
		double height = Math.sqrt(3) / 2 * side;
		fill(190);
		noStroke();
		quad(0, 0, length, 0, length + side / 2, (float) height, 0 - side / 2, (float) height);
		popMatrix();
	}


	public void setup()
	{
		String[] fontList = PFont.list();
		printArray(fontList);
		PFont my_font = createFont("Rockwell", 32, true);
		textFont(my_font);
		load_menu_options();

		// temp variables
		bx = width / 2.0;
		by = height / 2.0;
		rectMode(RADIUS);

//		b = new Button(this, 50, 50, 100, 50, "I am a button");
//		mc = new DNA(this, (float) width / 2, (float) height / 2, 50);

		background(130);

		draw_rhombus(250, 300, 0);
		draw_rhombus(460, 135, 120);
		draw_rhombus(500, 400, 240);

		// need to animate this
		textSize(32);

		text("Loading Exit CO", 10, 30);
		draw_menu_options();
		AudioPlayer player;
		Minim minim = new Minim(this);
		player = minim.loadFile("music.mp3");
		player.play();
	}


	private void draw_menu_options()
	{
		pushMatrix();
		translate(400, 400);
		for (int i = 0; i < options.size(); i++)
		{
			Menu_Options p = options.get(i);

			float y = border + (i * (button_height + gap));
			float x = border;
			noFill();
			stroke(0);
			rect(x, y, button_width, button_height);
			textAlign(CENTER, CENTER);
			fill(30);
			textSize(32);
			text(p.getName(), x + button_width * 0.5f, y + button_height * 0.5f);
		}
		popMatrix();
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
//		int which = Integer.MIN_VALUE;
//
//		if (mouseX > bx - box_size && mouseX < bx + box_size &&
//				mouseY > by - box_size && mouseY < by + box_size)
//		{
//			overBox = true;
//			which = (int) ((mouseY - border) / (button_height + gap));
//
//			if (!locked)
//			{
//				stroke(255);
//				fill(153);
//			}
//		}
//		else
//		{
//			stroke(153);
//			fill(153);
//			overBox = false;
//		}
		// b.render();

//		System.out.println(options.get(which));

//
//		mc.update();
//		mc.render();
//		draw_menu_options();


//		if (checkKey(LEFT))
//		{
//			System.out.println("Left arrow key pressed");
//		}
	}
}

