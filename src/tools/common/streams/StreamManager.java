package tools.common.streams;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class StreamManager implements Closeable{
	/*This class creates streams for items like System.in
	 * that are not able to be reopened*/
	static InputStream sysin;
	
	public StreamManager() {
		setSystemIn();
	}
	private static void setSystemIn() {
		sysin = System.in;
	}
	public static InputStream getSystemIn() {
		return sysin;
	}
	@Override
	public void close() throws IOException {
		/*Close all open streams*/
		sysin.close();
	}
}
