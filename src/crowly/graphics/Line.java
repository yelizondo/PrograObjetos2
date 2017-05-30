package crowly.graphics;

import java.util.ArrayList;

import crowly.library.Cuerpo;
import crowly.library.IConstants;
import crowly.utils.FileProcessor;

public class Line implements IGraphic, IConstants
{
	private FileProcessor Processor = new FileProcessor();
	
	@Override
	public void Graficar() 
	{	
		fillGraphics();
	}


	@Override
	public void getCuerpos(ArrayList<Cuerpo> pCuerpos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillGraphics() {
		// TODO Auto-generated method stub
		
	}
}
