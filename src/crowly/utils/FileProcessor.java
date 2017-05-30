package crowly.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;

public class FileProcessor 
{
	public byte[] readFile(String pURL)
	{		
		try 
		{			
			byte[] data = Files.readAllBytes(new File(pURL).toPath());
			return data;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
