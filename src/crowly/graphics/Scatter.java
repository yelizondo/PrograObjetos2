package crowly.graphics;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import crowly.library.Cuerpo;
import crowly.library.IConstants;
import crowly.utils.DateParser;
import crowly.utils.FileProcessor;

public class Scatter implements IGraphic, IConstants
{
	private FileProcessor Processor = new FileProcessor();
	private int cantidadCuerpos[] = new int[3]; // ["manana","medio dia","tarde"]
	
	@Override
	public void Graficar() throws Exception 
	{		
		fillGraphics();
		
		File htmlFile = new File(SCATTER_PATH);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void getCuerpos(ArrayList<Cuerpo> pCuerpos) 
	{
		for (Cuerpo cuerpo : pCuerpos)
		{
			int cuerpoTime = DateParser.toSeconds(cuerpo.getTime().getHours(), cuerpo.getTime().getMinutes(), cuerpo.getTime().getSeconds());
			if (cuerpoTime > MIDNIGHT && cuerpoTime <= MIDDAY)
			{
				cantidadCuerpos[0] += 1;
			} 
			else if (cuerpoTime > MIDDAY && cuerpoTime <= AFTERNOON_FOUR)
			{
				cantidadCuerpos[1] += 1;
			} 
			else if (cuerpoTime > AFTERNOON_FOUR && cuerpoTime <= DAY_END)
			{
				cantidadCuerpos[2] += 1; System.out.println("tarde");
			}
		}
	}

	@Override
	public void fillGraphics() throws Exception
	{
		String first = String.valueOf(cantidadCuerpos[0]);
		String second = String.valueOf(cantidadCuerpos[1]);
		String third = String.valueOf(cantidadCuerpos[2]); 
				
		String array = new String("[" + first + "," + second + "," + third + "]");
		
		Processor.replaceInFile(SCATTER_PATH, GRAPHIC_ARRAY , array);
	}
}
