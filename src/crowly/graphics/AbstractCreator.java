package crowly.graphics;

public abstract class AbstractCreator
{
	public static final String BAR = "Bar";
	public static final String LINE = "Line";
	public static final String SCATTER = "Scatter";

	public abstract IGraphic createForName(String pType);
}
