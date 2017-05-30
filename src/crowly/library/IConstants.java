package crowly.library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import crowly.utils.*;

public interface IConstants
{
	public final String POST_BODY = "{ \"url\":\"@@URL@@\" }";	
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1";
		
	public ArrayList<VideoInfo> VIDEOS_LIST = new ArrayList<VideoInfo>();
	//public ArrayList<String> LISTA_VIDEOS_GUI = new ArrayList<String>();
	public ArrayList<String> LISTA_VIDEOS_JSON = new ArrayList<String>();

	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int ESPERA_ENTRE_LLAMADAS = 60000;
	
	public final String MCS_IDKEY = "895369e4d9724c66b1e75326fcfe50e9";
	
	public final String UTF_CENTRAL_AMERICA = "-0600";
	public final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
	
	public final String JSON_COMPONENT_FRAGMENTS = "fragments";
	public final String JSON_COMPONENT_TIMESCALE = "timescale";
	public final String JSON_COMPONENT_EVENTS = "events";
	public final String JSON_COMPONENT_START = "start";
	public final String JSON_COMPONENT_DURATION = "duration";
	public final String JSON_COMPONENT_FRAMERATE = "framerate";
	public final int SECOND_IN_MILISECONDS = 1000;
	
	public final int MIDNIGHT = 0;
	public final int MIDDAY = 39600;
	public final int AFTERNOON_FOUR = 57600;
	public final int DAY_END = 86399;
	
	public final String SCATTER_PATH = "/home/yuberth/workspace/Crowly/graphics/scatter.html";
	public final String LINE_PATH = "/home/yuberth/workspace/Crowly/graphics/line.html";
	public final String BAR_PATH = "/home/yuberth/workspace/Crowly/graphics/bar.html";
	public final String GRAPHIC_ARRAY = "#ARRAY#";
}
