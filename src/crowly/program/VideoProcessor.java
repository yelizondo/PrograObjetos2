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
			CuerposTodosLosVideos = MsClient.getCuerpos();
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws ParseException
	{

		//MSClient s = new MSClient();
		//s.cargarCuerpos();                                "yyyy-MM-dd'T'HH:mm:ssZ"
		VIDEOS_LIST.add(new VideoInfo(DateParser.dateParser("2017-05-29T17:45:10"), "https://dl.dropboxusercontent.com/s/ujlqg46p04xezb3/videouno.mp4?dl=0"));
		
		VideoProcessor proc = new VideoProcessor();
		proc.analizarVideos();
		
		
			

	}
}
