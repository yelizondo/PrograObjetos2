package crowlyy;

import crowly.program.MSClient;
import crowly.library.*;
import java.util.ArrayList;

public class VideoProcessor implements IConstants
{
	private MSClient MsClient;
	private ArrayList<Cuerpo> cuerposTodosLosVideos;
	
	public VideoProcessor()
	{
		MsClient = new MSClient();
	}
	
	public void analizarVideos()
	{
		try
		{
			for (String urlVideo : LISTA_VIDEOS)
			{
				MsClient.processVideo(urlVideo);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			cuerposTodosLosVideos = MsClient.getCuerpos(); 
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
