import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDefaultConfig {
    private static final Logger LOGGER = LogManager.getLogger(Log4JDefaultConfig.class);

    public static void main(String[] args) {
        LOGGER.fatal("This is an FATAL level log message!");
        LOGGER.error("This is an ERROR level log message!");
        LOGGER.warn("This is an WARN level log message!");
        LOGGER.info("This is an INFO level log message!");
        LOGGER.debug("This is an DEBUG level log message!");
        LOGGER.trace("This is an TRACE level log message!");
    }
}
