public class MemoryLegend
{
	private UI ui;
	private float coordinateX;
	private float coordinateY;
	private float colourMemory;
	private boolean inverted;


	MemoryLegend(UI ui, float coordinateX, float coordinateY, float colourMemory, boolean inverted)
	{
		this.ui = ui;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.colourMemory = colourMemory;
		this.inverted = inverted;
	}

	void render()
	{
		float circleSize = 40;
		float rectHeight = 60;
		float rectWidth = 15;

		if (inverted)
		{
			ui.noStroke();
			ui.fill(colourMemory);
			ui.circle(coordinateX + rectWidth / 2, coordinateY - rectHeight, circleSize);
			ui.noStroke();
			ui.fill(colourMemory);
			ui.rect(coordinateX, coordinateY, rectWidth, -rectHeight);
		}
		else
		{
			ui.noStroke();
			ui.fill(colourMemory);
			ui.circle(coordinateX + rectWidth / 2, coordinateY + rectHeight, circleSize);
			ui.noStroke();
			ui.fill(colourMemory);
			ui.rect(coordinateX, coordinateY, rectWidth, rectHeight);
		}

	}

	void update()
	{

	}

}
