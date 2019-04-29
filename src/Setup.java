import processing.data.Table;
import processing.data.TableRow;

public class Setup
{
	private static UI ui;

	public Setup(UI ui)
	{
		Setup.ui = ui;
	}

	static void load_menu_options()
	{
		Table table = ui.loadTable("options.csv", "header");
		for (TableRow tr : table.rows())
		{
			Menu_Options p = new Menu_Options(tr);
			ui.options.add(p);
		}
	}
}
