package crowly.graphics;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import crowly.library.Cuerpo;
import crowly.library.IConstants;
import crowly.utils.DateParser;
import crowly.utils.FileProcessor;

public class Bar implements IGraphic, IConstants
{
	private FileProcessor Processor = new FileProcessor();
	private int cantidadCuerpos[] = new int[3]; // ["manana","medio dia","tarde"]
	
	
	@Override
	public void Graficar() throws Exception 
	{
		fillGraphics();
		
		File htmlFile = new File(BAR_PATH);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}


	@Override
	public void getCuerpos(ArrayList<Cuerpo> pCuerpos) {
		for (Cuerpo cuerpo : pCuerpos)
		{
			@SuppressWarnings("deprecation")
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
				cantidadCuerpos[2] += 1; 
			}
		}	
	}

	@Override
	public void fillGraphics() throws Exception 
	{
		// TODO Auto-generated method stub
		String first = String.valueOf(cantidadCuerpos[0]);
		String second = String.valueOf(cantidadCuerpos[1]);
		String third = String.valueOf(cantidadCuerpos[2]); 
				
		String array = new String("[" + first + "," + second + "," + third + "]");
		
		Processor.replaceInFile(BAR_PATH, GRAPHIC_ARRAY , array);
		
	}
}