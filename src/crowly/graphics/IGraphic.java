package crowly.graphics;
import java.util.ArrayList;

import crowly.library.*;

public interface IGraphic
{
	public void Graficar() throws Exception;
	public void getCuerpos(ArrayList<Cuerpo> pCuerpos);
	public void fillGraphics() throws Exception;
}
