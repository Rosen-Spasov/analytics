package rspasov.core;

import org.apache.camel.spring.Main;

public class SemanticAnalysisApplication {

	public static void main(String[] args) throws Exception {
		Main camel = new Main();
		camel.enableHangupSupport();
		camel.run();
	}

}