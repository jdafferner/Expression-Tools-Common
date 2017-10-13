package tools.common.text;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Scanner;


import org.apache.commons.io.IOUtils;

import tools.common.streams.StreamManager;

public class TextUtilities {
	
	private ArrayList<?> text;
	private int span;
	private byte[] byteArray;
	private final int cr = 15;
	private final int lf = 12;
	
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
	private boolean setByteArray(InputStream ins, int length) {
		byteArray = new byte[length];
		try {
			if(ins.read(byteArray) > -1);
			else {
				return true;
			}
		} catch (IOException e) {
			System.out.println("IOException in setByteArray()");
			e.printStackTrace();
		}
		return false;
	}
	private byte[] getByteArray() {
		return byteArray;
	}
	private void entryFile(File file) {
		int length = (int) file.length();
			try {
				FileInputStream fis = new FileInputStream(file);
				setByteArray(fis, length);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private void entryText() {
		Scanner scan = new Scanner(StreamManager.getSystemIn());
		ByteArrayInputStream bis;
		byte [] bytes = new byte[4000];
		int z = 0;
		System.out.println("Input text once finished press F5 to exit.");
		while(scan.hasNextByte()) {
			z++;
			if(z > bytes.length) {											//make byte[] larger
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
			if(b == 95) {													//byte value as int (F5)
				break;
			}
			else {
				bytes[z] = b;
			}
		}
		scan.close();
		int length = z;
		bis = new ByteArrayInputStream(bytes);
		setByteArray(bis, length);
	}
	private void setArrayList() {
		
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
