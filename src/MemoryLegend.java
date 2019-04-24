public class MemoryLegend
{
	private UI ui;
	private float coordinateX;
	private float coordinateY;
	private float rotation;
	private float colourMemory;

	private float rectHeight;
	private float rectWidth;
	private float circleSize;


	MemoryLegend(UI ui, float coordinateX, float coordinateY, float rotation, float colourMemory)
	{
		this.ui = ui;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.rotation = rotation;
		this.colourMemory = colourMemory;
	}

	void render()
	{
		ui.fill(colourMemory);
		rectHeight = 60;
		rectWidth = 20;
		ui.circle();
		ui.rect(coordinateX, coordinateY, rectHeight, rectWidth);
	}

	void update()
	{

	}

}
