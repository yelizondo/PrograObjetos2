package crowly.library;

import java.util.Date;

public class VideoInfo 
{
	private Date VideoDate;
	private String URL;
	
	public VideoInfo(Date pVideoDate, String pURL)
	{
		this.VideoDate = pVideoDate;
		this.URL = pURL;
	}

	public Date getVideoDate() {
		return VideoDate;
	}

	public void setVideoDate(Date videoDate) {
		VideoDate = videoDate;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}	
}
