public class LoadingText extends UIElement implements Loading
{
	private String message;
	private int counter;

	LoadingText(UI ui, float x, float y, String message)
	{
		this.ui = ui;
		this.coordinateX = x;
		this.coordinateY = y;
		this.message = message;
	}

	public void render()
	{
		ui.textSize(ui.width / 20);
		ui.fill(255);
		ui.textAlign(ui.LEFT, ui.CENTER);
		ui.text(message.substring(0, counter), coordinateX, coordinateY);
	}

	public void update()
	{
		counter = ui.millis() / 400;
	}

	public int returnTimer()
	{
		return counter * 400 / 1000;
	}

	public Boolean checkFinish(int timer)
	{
		return counter == message.length();
	}
}


