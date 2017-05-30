package crowly.library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import crowly.utils.*;

public interface IConstants
{
	public final String POST_BODY = "{ \"url\":\"@@URL@@\" }";
	
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1";
	
	public final String[] LISTA_VIDEOS = {
			//"https://1drv.ms/v/s!As13tanGZ53JkzHrPIWD6eqS3vMI"
			//"https://1drv.ms/v/s!As13tanGZ53JkzD3rjU6ODFK2e2f"
			//"https://1drv.ms/v/s!AmXSZYz89GQOcc3dar214bPLM10"
            //"https://1drv.ms/v/s!As13tanGZ53JkzK_ykfM79mWq3_I"
			//"https://dl.dropboxusercontent.com/s/q6kkowdqn2wzmvl/MOV_1479.mp4?dl=0"
			"https://dl.dropboxusercontent.com/s/ujlqg46p04xezb3/videouno.mp4?dl=0"
			
			
			/*
			"http://gdurl.com/r62Z",
			"http://gdurl.com/9KHx",
			"https://www.dropbox.com/s/nhc9xsxlnsn0bv8/WIN_20170503_15_26_09_Pro.mp4?dl=0"
			*/			
	}; 

	
	public final String[] LISTA_VIDEO_JSON = {
			"/home/yuberth/workspace/Crowly/2017-05-29T06:17:26.5994608Z.json"
	};
	public ArrayList<VideoInfo> VIDEOS_LIST = new ArrayList<VideoInfo>();
	public ArrayList<String> LISTA_VIDEOS_GUI = new ArrayList<String>();
	public ArrayList<String> LISTA_VIDEOS_JSON = new ArrayList<String>();
	
	
	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int ESPERA_ENTRE_LLAMADAS = 60000;
	
	public final String MCS_IDKEY = "895369e4d9724c66b1e75326fcfe50e9"; // 799dca11f3ca4e67b75c9aa34848823b
	
	public final String UTF_CENTRAL_AMERICA = "-0600";
	public final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
}
