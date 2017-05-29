package crowly.connectors;

import java.util.ArrayList;
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
	
	public void procesarVideo(String pURLVideo)
	{
		// puedo tener el URL hardcoded y aqui armo el PayLoad
		String payload = POST_BODY.replace("@@URL@@", pURLVideo); 
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY);
		if (videoResp != null)
		{ 
			VideosPendientes.add(videoResp);
		}
	}
	
	public void procesarRespuestaVideo(VideoResponse videoResponse)
	{
		VideoResponse response = HttpRequestor.get(videoResponse, MCS_IDKEY);		
		
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response.getContent());
			
			String name = (String) json.get("createdDateTime");
			String content = (String) json.get("processingResult");
						
			PrintWriter writer = new PrintWriter(name + ".json");
			writer.write(content);
			writer.close();
					
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}	
	}
	
		
	public void cargarCuerpos()
	{
		for (String json : LISTA_VIDEOS_JSON)
		{
			
		}
		
	}
}








