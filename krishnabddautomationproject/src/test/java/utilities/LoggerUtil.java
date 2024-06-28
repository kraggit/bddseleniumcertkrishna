package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	
	public static void setTimeForLogger() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	public static Logger getLogger(String classAndMethodName) {
		Logger log=Logger.getLogger(classAndMethodName);
		PropertyConfigurator.configure("log4j.properties");
		log.debug("testing");
		return log;
	}

}
