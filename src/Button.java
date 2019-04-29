class Button extends UIElement
{
	private float rectWidth;
	private float rectHeight;
	private String text1;
	private String text2;
	private float textPlacementX;
	private float textPlacementY;

	Button(UI ui, float x, float y, float rectWidth, float rectHeight, float textPlacementX, float textPlacementY, String text1, String text2)
	{
		this.ui = ui;
		this.coordinateX = x;
		this.coordinateY = y;
		this.rectWidth = rectWidth;
		this.rectHeight = rectHeight;
		this.textPlacementX = textPlacementX;
		this.textPlacementY = textPlacementY;
		this.text1 = text1;
		this.text2 = text2;
	}

	public float getX()
	{
		return coordinateX;
	}

	public void setX(float x)
	{
		this.coordinateX = x;
	}

	public float getY()
	{
		return coordinateY;
	}

	public void setY(float y)
	{
		this.coordinateY = y;
	}

	public float getRectWidth()
	{
		return rectWidth;
	}

	public void setRectWidth(float rectWidth)
	{
		this.rectWidth = rectWidth;
	}

	public float getRectHeight()
	{
		return rectHeight;
	}

	public void setRectHeight(float rectHeight)
	{
		this.rectHeight = rectHeight;
	}

	void render()
	{
		ui.noFill();
		ui.stroke(255);
		ui.rect(coordinateX, coordinateY, rectWidth, rectHeight);

		ui.fill(255);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.textSize(ui.width / 40);
		ui.text(text1, textPlacementX, textPlacementY + rectHeight / 2);

		ui.fill(255);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.textSize(ui.width / 80);
		ui.text(text2, textPlacementX, textPlacementY + rectHeight / 1.25f);
	}

	void update()
	{

	}
}