package crowly.program;

import java.io.IOException;
import java.util.ArrayList;

import crowly.library.Cuerpo;
import crowly.library.IConstants;

public class MSClient implements IConstants
{

	//key
	ArrayList<Cuerpo> Cuerpos;
	
	public ArrayList<Cuerpo> getCuerpos() {
		return Cuerpos;
	}

	public void setCuerpos(ArrayList<Cuerpo> cuerpos) {
		Cuerpos = cuerpos;
	}

	public MSClient()
	{
		Cuerpos = new ArrayList<Cuerpo>();
	}
	
	public void processVideo(String pURLVideo) throws IOException
	{
		// Puedo tner el URL hardcoded y aqui armo el Payload
		//
		
		String payload = POST_BODY.replace("@@URL@@", pURLVideo);
		String JSonResult = HTTPRequester.post(MSC_URL, payload);
		CargarCuerpos(JSonResult);		
	}
	
	private void CargarCuerpos(String pResult)
	{
		// aqui proceso el json creando los objetos cuerpo que vienen 
		// en el jason y los meto uno a uno en la lista de Cuerpos
		
		
		
		
		
		
	}
	
	private void analize(String pResponse)
	{
		// 
	}
}
