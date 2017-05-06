package crowly.library;

import java.util.Date;
import java.util.UUID;

public class Cuerpo 
{
	private Date Time;
	private int posX;
	private int posY;
	private UUID Id;
	
	public Cuerpo(int pPosX, int pPosY, Date pVideoTime)
	{
		Id = UUID.randomUUID();
		Time = pVideoTime;
		posX = pPosX;
		posY = pPosY;
	}
	
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	
}
