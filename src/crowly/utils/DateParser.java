package crowly.utils;

import java.text.ParseException;
import crowly.library.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser implements IConstants
{
	public static Date dateParser(String pDate) throws ParseException
	{
		return new SimpleDateFormat(DATE_FORMAT).parse(pDate + UTF_CENTRAL_AMERICA);
	}
	
	public static int toSeconds(int pHours, int pMinutes, int pSeconds)
	{
		return (pHours * 60 * 60) + (pMinutes * 60) + pSeconds;
	}
}
