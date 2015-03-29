package rspasov.bam.dataset;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderReceivedDataSetTest {

	private static final Logger logger = LoggerFactory.getLogger(OrderReceivedDataSetTest.class);

	@Test
	public void testCreateMessageBodyLong() {
		OrderReceivedDataSet dataSet = new OrderReceivedDataSet();
		for (int i = 0; i < 10; i++) {
			Object body = dataSet.createMessageBody(0);
			assertNotNull(body);
			logger.info(body.toString());
		}
	}

}
