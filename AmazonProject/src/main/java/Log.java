import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
    static Logger logger = Logger.getLogger(Log.class);

    // create a "log4j.xml" configuration file
    public Log(){
        DOMConfigurator.configure("log4j.xml");
    }
    // Get info logs from Logger class
    public void info(String message) {
        logger.info(message);
    }
    // Get warning logs from Logger class
    public void warning(String message) {
        logger.warn(message);
    }
    // Get error logs from Logger class
    public void error(String message) {
        logger.error(message);
    }
}
