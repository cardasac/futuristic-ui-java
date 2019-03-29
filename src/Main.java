public class Main
{
	public static void main(String[] args)
	{
		Main main = new Main();
		main.UI();
	}

	private void UI()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new UI());
	}
}