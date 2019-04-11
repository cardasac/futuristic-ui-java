import processing.core.PApplet;

public class Loading_Text extends PApplet
{
	String message = null;
	float text_x = 0;
	float text_y = 0;

	Loading_Text(float x, float y, String message)
	{
		this.text_x = x;
		this.text_y = y;
		this.message = message;
	}

	public void render()
	{
		text(message, text_x, text_y);
	}

	public void update()
	{
		float timer = 0;
		while (timer != 30000)
		{
			for (int i = 0; i < 360; i++)
			{
				fill(0, 51);
				text(message, text_x, text_y);
			}
			timer++;
		}
	}
}
