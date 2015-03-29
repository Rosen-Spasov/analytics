package rspasov.bam;

import org.apache.camel.spring.Main;

public class BAMApplication {

	public static void main(String[] args) throws Exception {
		Main camel = new Main();
		camel.enableHangupSupport();
		camel.run();
	}

}
