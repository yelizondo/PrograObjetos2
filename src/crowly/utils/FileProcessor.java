package crowly.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	
	public File getFile(String pURL)
	{
		return new File(pURL);
	}
	
	public void replaceInFile(String pURL, String pToReplace, String pReplacement) throws Exception
	{
		Path path = Paths.get(pURL);
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll(pToReplace, pReplacement);
		Files.write(path, content.getBytes(charset));
	}
}
