package me.thedarksid3r.fileeditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.thedarksid3r.fileeditor.utils.Output;

public class FileEditor 
{
	public void writeJsonFile(String filePathString, JSONArray content) throws IOException
	{
		Output o = new Output();
		
		String c = content.toString().replace('[', ' ').replace(']', ' ').trim();
		
		o.log(c);
		
		writeToFile(filePathString, c);
	}
	
	@SuppressWarnings("unused")
	public String readJsonFile(String filePathString, String element) throws JSONException, IOException
	{
		Output o = new Output();
		o.log(readFile(filePathString));
		JSONObject obj = new JSONObject(readFile(filePathString));
		
		if (obj != null)
		{
			String n = obj.getString(element);
			
			if (n != null)
			{
				return n;
			}
			else
			{
				return "wot";
			}
		}
		else
		{
			o.log("JSON File no exist");
			return "l";
		}
	}
	/**
	 * Reads the content of file specified
	 * 
	 * @param filePathString - Path of file
	 * @return content of file
	 * @throws IOException 
	 */
	public String readFile(String filePathString) throws IOException
	{
		File f = new File(filePathString);
		
		String r = "nothing";
		
		if (f.exists())
		{
			BufferedReader br = new BufferedReader(new FileReader(filePathString));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null)
			{
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			
			br.close();
			
			r = sb.toString();
		}
		return r;
	}
	/**
	 * Writes to file specified
	 * 
	 * @param filePathString - Path of file (C:/Users/Zakir/Desktop/testWriter.txt)
	 * @param content - Content to be written in the file.
	 */
	public void writeToFile(String filePathString, String content) throws IOException
	{
		File f = new File(filePathString);
		Output o = new Output();
		
		String[] lol = filePathString.split("/");
		
		o.log(lol.length);
		
		//The file name is at [length - 1]
		//String fileName = lol[lol.length - 1];
		
		o.log("Checking if file exists");
		if (f.exists())
		{
			o.log("Check if file is actually a file");
			if (f.isFile() && !f.isDirectory())
			{
				FileWriter fWriter = new FileWriter(filePathString);
				PrintWriter pWriter = new PrintWriter(fWriter);
				
				pWriter.print(content);
				
				pWriter.close();
			}
		}
		else
		{
			o.log("Check if file is created");
			if (f.createNewFile())
			{
				o.log("File creation success");
				FileWriter fWriter = new FileWriter(filePathString);
				PrintWriter pWriter = new PrintWriter(fWriter);
				
				pWriter.print(content);
				
				pWriter.close();
			}
		}
	}
}
