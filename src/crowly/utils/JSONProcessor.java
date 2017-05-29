package crowly.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONProcessor 
{
	public JSONObject parseJSON(String pURL)
	{
		JSONParser parser = new JSONParser();
		JSONObject result = null;
		
		try 
        {
            Object obj = parser.parse(new FileReader(pURL));
            result = (JSONObject) obj;
            return result;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
		finally
		{
			return result;
		}
	}

}
