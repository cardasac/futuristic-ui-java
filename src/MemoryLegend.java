import processing.core.PVector;

class MemoryLegend extends UIElement
{
	private float colourMemory;
	private boolean inverted;

	MemoryLegend(UI ui, PVector al, float colourMemory, boolean inverted)
	{
		this.ui = ui;
		this.coordinateX = al.x;
		this.coordinateY = al.y;
		this.colourMemory = colourMemory;
		this.inverted = inverted;
	}

	void render()
	{
		float circleSize = ui.width / 36;
		float rectHeight = ui.height / 15;
		float rectWidth = ui.width / 85;

		if (inverted)
		{
			ui.noStroke();
			ui.fill(colourMemory);
			ui.circle(coordinateX + rectWidth / 2, coordinateY - rectHeight, circleSize);
			ui.noStroke();
			ui.fill(colourMemory);
			ui.rect(coordinateX, coordinateY, rectWidth, -rectHeight);
			ui.textAlign(ui.CENTER, ui.BOTTOM);
			ui.textSize(ui.width / 80);
			ui.text("Complete Memory", coordinateX + ui.width / 12f, coordinateY);
		}
		else
		{
			ui.noStroke();
			ui.fill(colourMemory);
			ui.circle(coordinateX + rectWidth / 2, coordinateY + rectHeight, circleSize);
			ui.noStroke();
			ui.fill(colourMemory);
			ui.rect(coordinateX, coordinateY, rectWidth, rectHeight);
			ui.textAlign(ui.CENTER, ui.TOP);
			ui.textSize(ui.width / 80);
			ui.text("Incomplete Memory", coordinateX + ui.width / 12f, coordinateY);
		}
	}

	void update()
	{

	}
}
