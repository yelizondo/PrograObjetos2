package crowly.program;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import crowly.connectors.*;
import crowly.library.Cuerpo;
import crowly.library.IConstants;
import crowly.library.VideoInfo;
import crowly.library.VideoResponse;
import crowly.utils.DateParser;

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
			for(VideoInfo video : VIDEOS_LIST) 
			{
				MsClient.procesarVideo(video);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			
			Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			
			for(VideoResponse video : MsClient.getVideosPendientes()) 
			{
				MsClient.procesarRespuestaVideo(video);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}				
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void procesarVideos()
	{
		MsClient.cargarCuerpos();
	}
	
	public ArrayList<Cuerpo> getCuerpos()
	{
		return MsClient.getCuerpos();
	}
}
