package tools.common.text;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;

public class TextUtilities {
	
	private ArrayList<?> text;
	private int span;
	private byte[] byteArray;
	
	public TextUtilities() {
		text = new ArrayList<String>();
		setSpan(75);
	}
	private void setSpan(int s) {
		span = s;
	}
	private int getSpan() {
		return span;
	}
	private void setByteArray(byte[] bytes) {
		
	}
	private byte[] getByteArray() {
		return byteArray;
	}
	private void entryFile(File file) {
		Path path;
		try{
			path = file.toPath();
			
		}catch(InvalidPathException e) {
			System.out.println("Cannot resolve file path.");
		}
	}
	private void entryText() {
		Scanner scan = new Scanner(System.in);
		byte [] bytes = new byte[4000];
		int z = 0;
		System.out.println("Input text once finished press F5 to exit.");
		while(scan.hasNextByte()) {
			z++;
			if(z > bytes.length) {
				int d = (bytes.length)*2;
				byte [] temp = new byte[d];
				for(int i = 0; i < bytes.length; i++ ) {
					temp[i] = bytes[i];
				}
				bytes = new byte[d];
				bytes = temp;
				temp = null;
			}
			byte b = scan.nextByte();
			if(b == 95) {
				break;
			}
			else {
				bytes[z] = b;
			}
		}
		scan.close();
	}
	private void writeArrayList(byte[] bytes) {
		text = new ArrayList<String>();
		int r = bytes.length;
		
	}

	public ArrayList<?> getTextArrayList(){										//text ArrayList pointer
		return text;
	}
	public void doCenterText() {
		
	}
	public void doLeftJustifyText() {
		 
	}
	public void doRightJustifyText() {
		
	}
//	if(input.nextByte() == 14) {
//		System.out.println("Back Space");
//		if(bytes.length > 0) z--;
//		else z = 0;
//		
//		bytes[z] = null;
//	}
//	if(input.hasNextByte()) {
//		z++;
//		bytes[z] = input.nextByte();
//	}
}
