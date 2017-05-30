package crowly.library;

import java.util.Date;
import java.util.UUID;

public class Cuerpo 
{
	private Date Time;
	private UUID Id;
	
	public Cuerpo(Date videoTime)
	{
		Id = UUID.randomUUID();
		Time = videoTime;
	}

	public Cuerpo() {
		Id = UUID.randomUUID();
		// TODO Auto-generated constructor stub
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) { 
		this.Time = Time;
	}

	public UUID getId() {
		return Id;
	}
}
