import processing.data.TableRow;

public class MenuOptions
{
	private String name;
	private String description;

	private MenuOptions(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	MenuOptions(TableRow tr)
	{
		// Constructor chaining
		this(tr.getString("Title"), tr.getString("Description"));
	}

	public String toString()
	{
		return name + "\t" + description;
	}

	String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
