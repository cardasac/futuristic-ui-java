import processing.data.TableRow;

public class Menu_Options
{
	private String name;
	private String description;

	public Menu_Options(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public Menu_Options(TableRow tr)
	{
		// Constructor chaining
		this(tr.getString("Title"), tr.getString("Description"));
	}

	public String toString()
	{
		return name + "\t" + description;
	}
}
