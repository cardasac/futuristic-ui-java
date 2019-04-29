import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import processing.data.Table;
import processing.data.TableRow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UI extends PApplet
{
	private AudioPlayer player;
	private Minim minim;
	private ArrayList<DNA> dna1 = new ArrayList<>();
	private ArrayList<DNA> dna2 = new ArrayList<>();
	private ArrayList<Menu_Options> options = new ArrayList<>();
	private Loading_Text loading_message;
	private AbstergoLogo abstergoLogo;
	private MemoryLegend memoryLegend1;
	private MemoryLegend memoryLegend2;
	private ArrayList<Button> buttonList = new ArrayList<>();

	public void settings()
	{
		size(1280, 720, P3D);
//		size(1600, 900, P3D);
//		smooth(8);
		pixelDensity(displayDensity());
	}

	public void setup()
	{
		PFont my_font = createFont("Arial", width / 20, true);
		textFont(my_font);
		load_menu_options();
		set_menu_options();

		loadMusic();

		for (int i = 0; i < 10; i++)
		{
			DNA s = new DNA(this, 100, 150 + i * 50, 20);
			dna1.add(s);
		}

		for (int i = 0; i < 10; i++)
		{
			DNA s = new DNA(this, width - 300, 150 + i * 50, 20);
			dna2.add(s);
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormat.format(new Date());

		String message = "" + strDate + " ";
		loading_message = new Loading_Text(this, width / 8, height / 2, message);
		abstergoLogo = new AbstergoLogo(this, width / 2, height / 2);

		PVector al = new PVector(width - width / 4, height / 9);
		memoryLegend1 = new MemoryLegend(this, al, 255, true);
		memoryLegend2 = new MemoryLegend(this, al, 0, false);
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

	private void set_menu_options()
	{
		float ratio = width / 15f;
		float rectWidth = ratio * (11 / 3f);
		float rectHeight = height / 6;
		for (int i = 0; i < options.size(); i++)
		{
			float textPlacement = ratio + (ratio + rectWidth) * i + rectWidth / 2;
			float ratioFormula = ratio + (ratio + rectWidth) * i;
			Menu_Options p = options.get(i);
			Button but = new Button(this, ratioFormula, height - height / 3, rectWidth, rectHeight, textPlacement, p.getName(), p.getDescription());
			buttonList.add(but);
		}
	}

	private void draw_menu_options()
	{
		for (Button button : buttonList)
		{
			button.render();
		}
	}

	private void draw_lines(int y)
	{
		float ratio = width / 10;
		float line_size = ratio * (8 / 3f);
		stroke(255);
		for (int i = 0; i < 3; i++)
		{
			line((line_size + ratio) * i, y, line_size * (i + 1) + ratio * (i), y);
		}
	}

	private void draw_sequence()
	{
		int lineSize = 5;
		float placement1 = height / 2.8f;
		float placement2 = height - height / 2.8f;
		for (int i = 0; i < width; i += width / 100)
		{
			line(i, placement1, i, placement1 + lineSize);
			line(i, placement2, i, placement2 + lineSize);
		}
	}

	public void draw()
	{
//		int side = 30;
		background(37, 84, 199);

//		triangle(width / 2 - side / 2, height / 2, width / 2, height / 2f - (sqrt(3) * (side / 2f)), width / 2 + side / 2, height / 2);
		draw_lines(height - height / 9);
		draw_lines(height / 9);

		int timer;
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
			draw_sequence();
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

			textAlign(CENTER, BOTTOM);
			textSize(width / 80);
			text(mouseX, width / 20, height / 9);
			textAlign(CENTER, BOTTOM);
			textSize(width / 80);
			text(mouseY, width / 10, height / 9);

			draw_menu_options();
		}
	}

	// finished method
	private void loadMusic()
	{
		minim = new Minim(this);
		player = minim.loadFile("vr.mp3");

		player.play();
		player.loop();
	}

	public void stop()
	{
		// always close Minim audio classes when you are done with them
		player.close();
		minim.stop();
		super.stop();
	}
}

