package tools.common.text.menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import tools.common.text.regex.RegexUtilities;

public class TextMenuBuilder {
	private List<String> menuText;
	private RegexUtilities regexFunction;
	private Properties systemProperties;
	Pattern isPathRegex;
	Date date;
	private Scanner in = new Scanner(System.in);
	/*Has no file path so prompt*/
	public TextMenuBuilder() {
		regexFunction = new RegexUtilities();
	}
	private Scanner getConsoleScanner() {		
		return in;
	}

	private boolean readFile(Path aPath)throws IOException{
		try (Stream<String> stream = Files.lines(aPath)){
			menuText = new ArrayList<String>();
			stream.forEach((String)->{
				menuText.add(String);
				System.out.printf("%s\n",String);
			});
			return true;
		}catch(IOException e){
			System.out.println("File cannot be read.");

			return false;
		}
	}
	public boolean buildMenuData(){//in work
		//while(aPath == null) {
		System.out.println(getEnvironment());
		System.out.println("Create Menu Header from a text file.");
		System.out.println("Enter a Windows File path");
		String sPath = checkWinFilepath(getConsoleScanner().nextLine());
		try {
			readFile(Paths.get(sPath));
			return true;
		} catch (IOException e) {
			System.out.println("Error creating filepath");
			//e.printStackTrace();
		}

		return false;

	}
	public String checkWinFilepath(String sPath) {
		return sPath;

	}
	/*Returns the environment as Windows,Nix-like or Unknown
	 * as determined by the OS file separator.  I'm using this
	 * to catch as many variants of Nix or Windows as I can*/
	private String getEnvironment() {	
		String osType = "";													
		systemProperties = new Properties(System.getProperties());
		String separator = systemProperties.getProperty("file.separator");
		if(separator.contains("\\")) osType = "Windows";					
		if(separator.contains("/")) osType = "Nix-based";		
		return osType;
	}
	/*Returns a SimpleDateString that contains no spaces*/
	private String unixDate(){
		date = new Date();
	    DateFormat dfm = new SimpleDateFormat("yyyyMMddHHmm");
	    String time = String.format("%s",dfm.format(date));
	    return time;
	}
}
