package cn.csu.test;

import java.io.FileOutputStream;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.Logger;

public class Htmlandwrite {

	public Htmlandwrite() {

	}
	private static Logger logger = LogManager.getLogger(Simpandfile.class);

	public static void main(String args[]) {
		HTMLLayout layout = new HTMLLayout();
		WriterAppender appender = null;
		try {
			FileOutputStream output = new FileOutputStream("output.html");
			appender = new WriterAppender(layout, output);
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
