import java.util.logging.*;
import java.io.*;
class LoggingException extends Exception{
	private static Logger logger = Logger.getLogger("Logging Exception");
	public LoggingException(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
public class LoggingExceptions {
	public static void main(String[] args){
		try {
			throw new LoggingException();
		} catch (LoggingException e){
			System.err.println("Caught" + e);
		}

		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught" + e);
		}
	}
}
