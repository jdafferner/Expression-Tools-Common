package tools.common.text;

import java.awt.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TextUtilities {
	
	private ArrayList<?> text;
	private Stream<?> in;
	
	public TextUtilities() {
		text = new ArrayList();
	}
	public TextUtilities(File file) {
		try {
			setStream(Files.lines(file.toPath()));
			text = new ArrayList<String>();
			getStream().forEach((String) ->{
				
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bulletList() {
	 
	}
	private void setStream(Stream<?> s) {
		in = s;
	}
	private Stream<?> getStream() {
		return in;
	}
	public ArrayList<?> getTextArrayList(){										//text ArrayList pointer
		return text;
	}

	
}
