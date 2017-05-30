package crowly.graphics;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import crowly.utils.FileProcessor;


public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		
		AbstractCreator cre = new CreatorForName();
		
		/*IGraphic lineChart = cre.createForName(AbstractCreator.LINE);
		lineChart.Graficar();
		
		IGraphic barChart = cre.createForName(AbstractCreator.BAR);
		barChart.Graficar();*/
		
		IGraphic scatterChart = cre.createForName(AbstractCreator.SCATTER);
		scatterChart.Graficar();
		
		

	}		

}
