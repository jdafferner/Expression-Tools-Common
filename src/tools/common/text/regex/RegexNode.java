package tools.common.text.regex;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class RegexNode {
	private String regexname;
	private String regexstring;
	private Pattern regexpattern;
	private static int counter;
	private RegexNode mynode;
	public RegexNode(String name, String value){
		counter++;
		setNodeReference(this);
		setName(name);
		setRegexString(value);
		setPattern(value);
	}
	private void setName(String name) {
		regexname = name;
	}
	private void setNodeReference(RegexNode node) {
		mynode = node;
	}
	private void setRegexString(String regex) {
		regexstring = regex;
	}
	private void setPattern(String regex) {
		try {
		 regexpattern = Pattern.compile(regex);
		}catch(PatternSyntaxException e){
			System.out.print("Pattern cannot be compiled");
		}
	}
	public String getName() {
		return regexname;		
	}
	public String getRegexString() {
		return regexstring;
	}
	public Pattern getPattern() {
		return regexpattern;
	}
	public int getNodeCount() {
		return counter;
	}
	public RegexNode getNodeReference() {
			return mynode;
	}
	public void deleteNode(RegexNode node) {
		setName("");
		setPattern("");
		setRegexString("");
		counter--;
		setNodeReference(null);
	}
	public String toCSVFile() {
		return String.format("%s,%s\n", getName(),getRegexString());
		}
	@Override
	public String toString() {
		return String.format("Name is %s\nRegex is %s\n", getName(),getRegexString());
		
	}
}
