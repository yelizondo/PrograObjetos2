package crowly.program;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import crowly.connectors.*;
import crowly.library.Cuerpo;
import crowly.library.IConstants;
import crowly.library.VideoResponse;

public class VideoProcessor implements IConstants
{
	private MSClient MsClient;
	private ArrayList<Cuerpo> CuerposTodosLosVideos;
	
	public VideoProcessor()
	{
		MsClient = new MSClient();
	}
	
	public void analizarVideos()
	{
		try 
		{
			for(String urlVideo : LISTA_VIDEOS) 
			{
				MsClient.procesarVideo(urlVideo);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			
			Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			
			for(VideoResponse video : MsClient.getVideosPendientes()) 
			{
				MsClient.procesarRespuestaVideo(video);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}			
			CuerposTodosLosVideos = MsClient.getCuerpos();
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		VideoProcessor proc = new VideoProcessor();
		proc.analizarVideos();
	}
}
