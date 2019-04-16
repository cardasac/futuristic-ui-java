public class Loading_Text
{
	private String message;
	private float text_x;
	private float text_y;
	private UI ui;
	private int counter;

	Loading_Text(UI ui, float x, float y, String message)
	{
		this.ui = ui;
		this.text_x = x;
		this.text_y = y;
		this.message = message;
	}

	public void render()
	{
		ui.lights();
		ui.fill(255,255);
		ui.textAlign(ui.LEFT, ui.CENTER);
		ui.text(message.substring(0, counter), text_x, text_y);
	}

	public void update()
	{
		counter = ui.millis() / 1000;
	}
}


