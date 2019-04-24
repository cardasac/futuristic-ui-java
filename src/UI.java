import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class UI extends PApplet
{
	String message1 = "Rome // Italy ";
	String message2 = "2012-09-02 // 10:";
	private AudioPlayer player;
	private Minim minim;
	private ArrayList<DNA> dna1 = new ArrayList<>();
	private ArrayList<DNA> dna2 = new ArrayList<>();
	private ArrayList<Menu_Options> options = new ArrayList<>();
	private Loading_Text loading_message;
	private AbstergoLogo abstergoLogo;
	private MemoryLegend memoryLegend1;
	private MemoryLegend memoryLegend2;

	// button variables
	private float button_height = 50;
	private float border = 20;
	private float button_width = 200;
	private float gap = 40;

	public void settings()
	{
		fullScreen(P3D);
//		smooth(8);
//		pixelDensity(2);
	}

	public void setup()
	{
		PFont my_font = createFont("Arial", 64, true);
		textFont(my_font);
		load_menu_options();

//		b = new Button(this, 50, 50, 100, 50, "I am a button");
//		mc = new DNA(this, (float) width / 2, (float) height / 2, 50);

		loadMusic();

		for (int i = 0; i < 15; i++)
		{
			DNA s = new DNA(this, 100, 150 + i * 50, 50);
			dna1.add(s);
		}

		for (int i = 0; i < 15; i++)
		{
			DNA s = new DNA(this, width - 300, 150 + i * 50, 50);
			dna2.add(s);
		}

		loading_message = new Loading_Text(this, 300, 300, message1);
		abstergoLogo = new AbstergoLogo(this);
		memoryLegend1 = new MemoryLegend(this, 600, 200, 255, true);
		memoryLegend2 = new MemoryLegend(this, 600, 200, 0, false);
	}

	// finished method
	private void loadMusic()
	{
		minim = new Minim(this);
		player = minim.loadFile("vr.mp3");

		player.play();
		player.loop();
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

	private void draw_lines(int y)
	{
		int line_size = width / 3;
		for (int i = 0; i < 5; i++)
		{
			if (i % 2 == 1)
			{
				continue;
			}
			stroke(240);
			line(i * width / 5, y, i * width / 5 + line_size, y);
		}
	}

	public void draw()
	{
		background(17, 66, 214);
//		triangle(width / 2 - side/2, height / 2, width / 2, height / 2f - (sqrt(3) * (side / 2f)), width / 2 + side/2, height / 2);


		camera(mouseX, mouseY, 1000, width / 2, height / 2, 0,
				0, 1, 0);

		draw_lines(height - 100);
		draw_lines(100);

		int timer = 0;

		timer = loading_message.return_timer();

		if (!loading_message.check_finish())
		{
			loading_message.render();
			loading_message.update();

		}
		else if (!abstergoLogo.check_finish(timer))
		{
			abstergoLogo.render();
			abstergoLogo.update();
		}

		else
		{
			memoryLegend1.render();
			memoryLegend2.render();

			for (DNA value : dna1)
			{
				value.render();
				value.update();
			}

			for (DNA value : dna2)
			{
				value.render();
				value.update();
			}
			lights();
			text(mouseX, 50, 50);
			text(mouseY, 50, 100);

			draw_menu_options();
		}
	}

	public void stop()
	{
		// always close Minim audio classes when you are done with them
		player.close();
		minim.stop();
		super.stop();
	}
}

