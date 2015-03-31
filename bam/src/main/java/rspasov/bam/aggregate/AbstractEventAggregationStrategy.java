package rspasov.bam.aggregate;

import java.time.Instant;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import rspasov.bam.event.Event;

public abstract class AbstractEventAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null || oldExchange.getIn() == null || oldExchange.getIn().getBody() == null) {
			return newExchange;
		}

		Event oldEvent = oldExchange.getIn().getBody(Event.class);
		Event newEvent = newExchange.getIn().getBody(Event.class);

		oldExchange.getIn().setBody(aggregateEvents(oldEvent, newEvent));
		return oldExchange;
	}

	protected abstract Event aggregateEvents(Event oldEvent, Event newEvent);

	protected String timestamp() {
		return Instant.now().toString();
	}

}
