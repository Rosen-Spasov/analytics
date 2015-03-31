package rspasov.bam.aggregate;

import rspasov.bam.event.AggregatedByTimestampEvent;
import rspasov.bam.event.Event;

public class AggregateByTimestampStrategy extends AbstractEventAggregationStrategy {

	@Override
	protected Event aggregateEvents(Event oldEvent, Event newEvent) {
		AggregatedByTimestampEvent aggregatedEvent;
		if (oldEvent instanceof AggregatedByTimestampEvent) {
			aggregatedEvent = (AggregatedByTimestampEvent) oldEvent;
		} else {
			aggregatedEvent = new AggregatedByTimestampEvent(oldEvent.getTimestamp());
			aggregatedEvent.addEvent(oldEvent);
		}
		aggregatedEvent.addEvent(newEvent);
		return aggregatedEvent;
	}

}
