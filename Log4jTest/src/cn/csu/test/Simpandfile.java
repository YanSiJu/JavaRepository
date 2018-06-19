package cn.csu.test;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.Logger;


public class Simpandfile {

	public Simpandfile() {

	}

	private static Logger logger = LogManager.getLogger(Simpandfile.class);
	
	
	public static void main(String args[]) {
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = null;
		
		try {
			appender = new FileAppender(layout,"log.txt");
		} catch (Exception e) {
		}
		logger.addAppender(appender);
		logger.setLevel(Level.DEBUG);
		logger.debug("Here is some DEBUG");
		logger.info("Here is some INFO");
		logger.warn("Here is some WARN");
		logger.error("Here is some ERROR");
		logger.fatal("Here is some FATAL");
	}
}
