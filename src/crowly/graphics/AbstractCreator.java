package crowly.graphics;

public abstract class AbstractCreator
{
	public static final int BAR_ID = 1;
	public static final int LINE_ID = 2;
	public static final int SCATTER_ID= 3;
	
	public static final String BAR = "Bar";
	public static final String LINE = "Line";
	public static final String SCATTER = "Scatter";
	
	public abstract IGraphic create(int pType);
	public abstract IGraphic createForName(String pType);
}
