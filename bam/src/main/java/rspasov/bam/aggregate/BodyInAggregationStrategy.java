package rspasov.bam.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import rspasov.bam.event.Event;

public class BodyInAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			return newExchange;
		}

		Event oldBody = oldExchange.getIn().getBody(Event.class);
		Event newBody = newExchange.getIn().getBody(Event.class);
		oldExchange.getIn().setBody(oldBody + "+" + newBody);
		return oldExchange;
	}

}
