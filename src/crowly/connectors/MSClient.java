package crowly.connectors;

import java.util.ArrayList;

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
			
			String name = response.getVideoDate().toString();
			
			String content = (String) json.get("processingResult");
			
			
			
			
			
			JSONObject jsonRemastered = (JSONObject) parser.parse(content);
			jsonRemastered.put("framerate", name);
			String newContent = jsonRemastered.toJSONString();
			
			PrintWriter writer = new PrintWriter(name + ".json");
			
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
		for (String jsonURL : LISTA_VIDEO_JSON)
		{
			JSONObject jsonObject = processor.parseJSON(jsonURL);
			
			JSONArray array = (JSONArray) jsonObject.get("fragments"); 
			
			for(int element = 0; element < array.size(); element++)
			{			
				if(!array.get(element).toString().contains("events"))
				{
					System.out.println(array.get(element).toString());
					Cuerpo cuerpo = new Cuerpo();
					
					Cuerpos.add(cuerpo);					
				}
			}
		}	
	}
}