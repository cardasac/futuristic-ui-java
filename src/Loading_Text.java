import processing.core.PApplet;

public class Loading_Text extends PApplet
{
	public void render()
	{
		text("Loading", 30, 30);

	}

	public void update()
	{
		float text_x = 50;
		float text_y = 50;

		float timer = 0;
		while (timer != 30000)
		{
			for(int i=0; i )
			text("Loading", text_x, text_y);

			timer++;
		}
	}
}
