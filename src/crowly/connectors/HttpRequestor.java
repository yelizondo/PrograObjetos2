package crowly.connectors;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import crowly.library.IConstants;
import crowly.library.VideoResponse;


public class HttpRequestor implements IConstants
{
	public static VideoResponse post(String pUrl, String pPayload, String pMSKey)
	{
		VideoResponse result = null;
		
		HttpClient httpclient = HttpClients.createDefault(); 
        try
        {
            URIBuilder builder = new URIBuilder(pUrl);
            builder.setParameter("sensitivityLevel", "low");
            builder.setParameter("frameSamplingValue", "1");
            builder.setParameter("detectionZones", "0.3,1;0.5,1;0.3,0;0.5,0");
            builder.setParameter("detectLightChange", "false");                        
            builder.setParameter("mergeTimeThreshold", "3.0");

            
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey); System.out.println(builder.toString());

            // Request body
            StringEntity reqEntity = new StringEntity(pPayload);
            request.setEntity(reqEntity);
            
            HttpResponse response = httpclient.execute(request); //System.out.println(response.getEntity().toString());
            HttpEntity entity = response.getEntity(); 
                                              
            if (entity != null) 
            {           	
                String location = response.getHeaders(LOCATION_RESULT_URL_KEY).length > 0 ? response.getHeaders(LOCATION_RESULT_URL_KEY)[0].getValue() : "";
                String key = response.getHeaders(LOCATION_RESULT_URL_KEY).length > 0 ? response.getHeaders(LOCATION_RESULT_ACCESS_KEY)[0].getValue() : "";            	
                result = new VideoResponse(location, key, EntityUtils.toString(entity)); 
                System.out.println(result.getVideoResponseURL() + "\n" + result.getVideoKey() + "\n" + result.getContent());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
		return result;
	}
	
	public static VideoResponse get(VideoResponse pVideoResponse, String pMSKey)
	{
		
		HttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder(pVideoResponse.getVideoResponseURL());

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey);

            HttpResponse response = httpclient.execute(request); System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
                                                
            if (entity != null) 
            {
                pVideoResponse.setContent(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		return pVideoResponse;
	}
}
