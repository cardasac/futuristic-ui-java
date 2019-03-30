import processing.data.*;

public class Menu_Options
{
	private String name;
	private float price;

	public Menu_Options(String name, float price)
	{
		this.name = name;
		this.price = price;
	}

	public String toString()
	{
		return name + "\t" + price;
	}

	public Menu_Options(TableRow tr)
	{
		// Constructor chaining
		this(tr.getString("Title"), tr.getFloat("Description"));
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price)
	{
		this.price = price;
	}
}
