package rspasov.application;

import org.apache.camel.spring.Main;

public class Application {

	public static void main(String[] args) throws Exception {
		Main camel = new Main();
		camel.enableHangupSupport();
		camel.run();
	}

}
