class Button
{
	private UI ui;
	private float x;
	private float y;
	private float rectWidth;
	private float rectHeight;
	private String text1;
	private String text2;
	private float textPlacement;

	Button(UI ui, float x, float y, float rectWidth, float rectHeight, float textPlacement, String text1, String text2)
	{
		this.ui = ui;
		this.x = x;
		this.y = y;
		this.rectWidth = rectWidth;
		this.rectHeight = rectHeight;
		this.textPlacement = textPlacement;
		this.text1 = text1;
		this.text2 = text2;
	}

	void render()
	{
		ui.noFill();
		ui.stroke(255);
		ui.rect(x, y, rectWidth, rectHeight);

		ui.fill(255);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.textSize(ui.width / 40);
		ui.text(text1, textPlacement, ui.height - ui.height / 3f + rectHeight / 2);

		ui.fill(255);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.textSize(ui.width / 80);
		ui.text(text2, textPlacement, ui.height - ui.height / 3.5f + rectHeight / 2);
	}
}