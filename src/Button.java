class Button extends UIElement
{
	private float rectWidth;
	private float rectHeight;
	private String text1;
	private String text2;
	private float textColor;
	private float backgroundColor;

	Button(UI ui, float x, float y, float rectWidth, float rectHeight, String text1, String text2, float textColor, float backgroundColor)
	{
		this.ui = ui;
		this.coordinateX = x;
		this.coordinateY = y;
		this.rectWidth = rectWidth;
		this.rectHeight = rectHeight;
		this.text1 = text1;
		this.text2 = text2;
		this.textColor = textColor;
		this.backgroundColor = backgroundColor;
	}

	float getX()
	{
		return coordinateX;
	}

	public void setX(float x)
	{
		this.coordinateX = x;
	}

	float getY()
	{
		return coordinateY;
	}

	public void setY(float y)
	{
		this.coordinateY = y;
	}

	float getRectWidth()
	{
		return rectWidth;
	}

	public void setRectWidth(float rectWidth)
	{
		this.rectWidth = rectWidth;
	}

	float getRectHeight()
	{
		return rectHeight;
	}

	public void setRectHeight(float rectHeight)
	{
		this.rectHeight = rectHeight;
	}

	void render()
	{
		ui.fill(backgroundColor);
		ui.noStroke();
		ui.rect(coordinateX, coordinateY, rectWidth, rectHeight, ui.width / 64);

		ui.fill(textColor);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.textSize(ui.width / 40);
		ui.text(text1, coordinateX + rectWidth / 2, coordinateY + rectHeight / 2);

		ui.fill(textColor);
		ui.textAlign(ui.CENTER, ui.CENTER);
		ui.textSize(ui.width / 60);
		ui.text(text2, coordinateX + rectWidth / 2, coordinateY + rectHeight / 1.25f);
	}

	void update()
	{

	}
}