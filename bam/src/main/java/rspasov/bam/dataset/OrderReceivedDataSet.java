package rspasov.bam.dataset;

import java.time.Instant;
import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.component.dataset.DataSetSupport;

import rspasov.bam.event.OrderReceivedEvent;

public class OrderReceivedDataSet extends DataSetSupport {

	private static final String[] CUSTOMERS = { "Google", "Microsoft", "Apple" };

	private static final Random random = new Random();

	private static final double rangeMin = 10;

	private static final double rangeMax = 100;

	private OrderReceivedEvent lastEvent;

	@Override
	protected void applyHeaders(Exchange exchange, long messageIndex) {
		if (lastEvent != null) {
			exchange.getIn().setHeader("dimension", lastEvent.getDimension());
		}
	}

	@Override
	protected Object createMessageBody(long messageIndex) {
		lastEvent = new OrderReceivedEvent(dimension(), fact(), timestamp());
		return lastEvent;
	}

	private String dimension() {
		return CUSTOMERS[random.nextInt(3)];
	}

	private double fact() {
		return (int) (rangeMin + (rangeMax - rangeMin) * random.nextDouble());
	}

	private String timestamp() {
		return Instant.now().toString();
	}
}
