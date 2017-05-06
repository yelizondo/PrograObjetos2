package crowly.library;

public interface IConstants 
{
	public final String POST_BODY = "HTTP/1.1 "+
            "Content-Type: application/json\n"+
            "Host: westus.api.cognitive.microsoft.com\n"+
            "Ocp-Apim-Subscription-Key: 3a59935cc4524a03a93b80fe3a747593\n"+
            "{ \"url\":\"http://www.example.com/sample.mp4\" } ";
	
	public final String MSC_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1";
    
	public final int ESPERA_ENTRE_LLAMADAS = 25000;
	
	public final String[] LISTA_VIDEOS = 
	{
			"http://gdurl.com/9KHX/download",
			"http://gdurl.com/9KHX/download",
			"http://gdurl.com/9KHX/download"
	};
}
