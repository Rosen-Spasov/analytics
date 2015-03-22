package events.main;


import org.apache.camel.spring.Main;
import org.apache.log4j.Logger;

public class Application {
	
	private static final Logger LOGGER = Logger.getLogger(Application.class);
	
	public static void main(String[] args) throws Exception {
		Application app = new Application();
		app.run();
	}
	
	public void run() throws Exception {
		LOGGER.info("Starting application.");
		Main camel = new Main();
		camel.enableHangupSupport();
		camel.run();
		LOGGER.info("Shutting down application.");
	}

}
