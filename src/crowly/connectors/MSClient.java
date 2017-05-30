package crowly.connectors;

import java.util.ArrayList;
import java.util.Date;

import crowly.utils.*;
import crowly.library.*;

import crowly.library.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class MSClient implements IConstants
{
	private ArrayList<Cuerpo> Cuerpos;
	private ArrayList<VideoResponse> VideosPendientes;
	private JSONProcessor processor = new JSONProcessor();
	
	public ArrayList<Cuerpo> getCuerpos() {
		return Cuerpos;
	}

	public ArrayList<VideoResponse> getVideosPendientes() {
		return VideosPendientes;
	}
	
	public MSClient()
	{
		Cuerpos = new ArrayList<Cuerpo>();
		VideosPendientes = new ArrayList<VideoResponse>();
	}
	
	public void procesarVideo(VideoInfo pVideo)
	{
		String payload = POST_BODY.replace("@@URL@@", pVideo.getURL()); 
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY);
		videoResp.setVideoDate(pVideo.getVideoDate());
		
		if (videoResp != null)
		{ 
			VideosPendientes.add(videoResp);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void procesarRespuestaVideo(VideoResponse videoResponse)
	{
		VideoResponse response = HttpRequestor.get(videoResponse, MCS_IDKEY);	
			
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response.getContent());
			
			long name = response.getVideoDate().getTime();			
			String content = (String) json.get("processingResult");

			JSONObject jsonRemastered = (JSONObject) parser.parse(content);
			jsonRemastered.put("framerate", name);
			String newContent = jsonRemastered.toJSONString();
			
			PrintWriter writer = new PrintWriter(response.getVideoDate().toString() + ".json");
			
			writer.write(newContent);
			writer.close();
					
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParseException e) 
		{			
			e.printStackTrace();
		}	
	}
		
	public void cargarCuerpos()
	{
		for (String jsonURL : LISTA_VIDEOS_JSON)
		{
			JSONObject jsonObject = processor.parseJSON(jsonURL);
			
			JSONArray array = (JSONArray) jsonObject.get(JSON_COMPONENT_FRAGMENTS); 
			long timescale = (long) jsonObject.get(JSON_COMPONENT_TIMESCALE); 
			
			for(int element = 0; element < array.size(); element++)
			{			
				if(!array.get(element).toString().contains(JSON_COMPONENT_EVENTS))
				{
					JSONObject temporaryObject = (JSONObject) array.get(element);
					long seconds;					
					
					if ((long) temporaryObject.get(JSON_COMPONENT_START) == 0)
					{
						long duration = (long) temporaryObject.get(JSON_COMPONENT_DURATION);
						seconds = duration / timescale; 
					}
					else
					{
						long start = (long) temporaryObject.get(JSON_COMPONENT_START);
						seconds = start / timescale; 			
					}					

					long cuerpoTime = (long) jsonObject.get(JSON_COMPONENT_FRAMERATE) + (seconds * SECOND_IN_MILISECONDS);
					
					Cuerpo cuerpo = new Cuerpo(new Date(cuerpoTime));
				
					Cuerpos.add(cuerpo);					
				}
			}
		}	
	}
}