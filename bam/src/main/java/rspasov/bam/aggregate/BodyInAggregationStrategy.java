package rspasov.bam.aggregate;

import java.time.Instant;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import rspasov.bam.event.Event;
import rspasov.bam.event.GenericEvent;

public class BodyInAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			return newExchange;
		}

		Event oldEvent = oldExchange.getIn().getBody(Event.class);
		Event newEvent = newExchange.getIn().getBody(Event.class);

		double fact = oldEvent.getFact() + newEvent.getFact();
		GenericEvent aggregated = new GenericEvent(oldEvent.getDimension(), fact, timestamp(), oldEvent.getType(), oldEvent.getDimensionName(),
				oldEvent.getFactName());
		oldExchange.getIn().setBody(aggregated);
		return oldExchange;
	}

	private String timestamp() {
		return Instant.now().toString();
	}

}
