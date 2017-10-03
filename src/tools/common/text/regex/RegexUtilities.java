package tools.common.text.regex;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class RegexUtilities{
	private String fp;
	private File data;
	private Path datapath;
	private LinkedList<RegexNode> regexList;
	private boolean isduplicate =false;
	private int hits = 0;
	
	public RegexUtilities() {
		setPathString("MenuBuilder/docs/textfiles/regexes.txt"); 	//May set new constructor for a path string from caller
		if(setFilePath() && setFile(getFilePath()))					//Constructor is a chained validation 
			buildListFromFile();
	}
	private void setHits() {
		hits++;
	}
	private void setRegexList(){
		regexList = new LinkedList<RegexNode>();
	}
	private RegexNode setNode(String [] arr) {
		RegexNode node = new RegexNode(arr[0],arr[1]);
		return node;	
	}
	private boolean setFilePath() {
		datapath = Paths.get(getPathString());
		if(datapath.resolve(getPathString()) != null) {
			return true;
		}
		return false;
	}
	private boolean setFile(Path validpath) {
		if(Files.isReadable(validpath)) {
			data = validpath.toFile();
			return true;
		}
		return false;
	}
	private int getHits() {
		return hits;
	}
	private void setPathString(String apath) {
		fp = apath;
	}
	private void setDuplicate() {
		isduplicate = true;
		setHits();
	}
	private void resetDuplicate() {
		isduplicate = false;
	}
	private void resetHits() {
		hits = 0;
	}
	public boolean getDuplicate() {
		return isduplicate;
	}
	public String getPathString() {
		return fp;
	}
	public Path getFilePath() {
		return datapath;
	}
	public File getFile() {		
		return data;
	}
	public LinkedList<RegexNode> getRegexList(){
		return regexList;
	}
	private void buildListFromFile() {
		List<String> list;
		setRegexList();
		try {		
			list = Files.readAllLines(getFilePath());
			list.forEach(String ->{	
				String [] parts = String.split(",");
				if(getRegexList().isEmpty()) {
					getRegexList().addFirst(setNode(parts));
				}else {
					getRegexList().iterator().forEachRemaining(node ->{
						if(node.getRegexString().contentEquals(parts[1])) {
							setDuplicate();
						}
					});
					if(getDuplicate() == false) {
						getRegexList().add(setNode(parts));
						resetDuplicate();
					}
				}
			});
			if(getHits() > 0 && writeBackToFile()) resetHits();	
		} catch (FileNotFoundException e) {
			System.out.printf("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Path error");
			e.printStackTrace();
		}	
	}
	private boolean writeBackToFile() {
	try (PrintWriter pw = new PrintWriter(getFile())){
		getRegexList().forEach(node->{
			pw.write(node.toCSVFile());
		});;
		return true;		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}
	public void printList() {
		getRegexList().forEach(node ->{
			System.out.printf("List Item : %d Node Information\n%s",getRegexList().indexOf(node), node.toString());
		});
	}
}
		
