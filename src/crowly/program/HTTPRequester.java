package crowly.program;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPRequester 
{
	private final static String USER_AGENT = "Mozilla/5.0";
	
	public static String post(String pUrl, String pPayload) throws IOException
	{
		URL obj = new URL(pUrl);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = pPayload;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + pUrl);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		return response.toString();

	}
	
	public static void main (String[] args) throws IOException
	{
		 String postMessage = "HTTP/1.1 "+
		            "Content-Type: application/json\n"+
		            "Host: westus.api.cognitive.microsoft.com\n"+
		            "Ocp-Apim-Subscription-Key: 3a59935cc4524a03a93b80fe3a747593\n"+
		            "{ \"url\":\"http://www.example.com/sample.mp4\" } ";
		        String url = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1";
		        System.out.println(HTTPRequester.post(url, postMessage));
	}
}
