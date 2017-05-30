package crowly.library;

import java.util.Date;

public class VideoResponse 
{
	private String VideoResponseURL;
	private String VideoKey;
	private String Content;
	private Date VideoDate;
	
	public VideoResponse(String pURL, String pKey, String pContent, Date pVideoDate)
	{
		VideoResponseURL = pURL;
		VideoKey = pKey;
		Content = pContent;
		VideoDate = pVideoDate;
	}
	
	public VideoResponse(String pURL, String pKey, String pContent)
	{
		VideoResponseURL = pURL;
		VideoKey = pKey;
		Content = pContent;;
	}

	public Date getVideoDate() {
		return VideoDate;
	}

	public void setVideoDate(Date videoDate) {
		VideoDate = videoDate;
	}

	public String getVideoResponseURL() {
		return VideoResponseURL;
	}

	public void setVideoResponseURL(String videoResponseURL) {
		VideoResponseURL = videoResponseURL;
	}

	public String getVideoKey() {
		return VideoKey;
	}

	public void setVideoKey(String videoKey) {
		VideoKey = videoKey;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
