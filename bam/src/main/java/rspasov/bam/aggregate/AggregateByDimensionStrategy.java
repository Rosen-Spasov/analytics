package rspasov.bam.aggregate;

import rspasov.bam.event.BusinessEvent;
import rspasov.bam.event.Event;
import rspasov.bam.event.GenericEvent;

public class AggregateByDimensionStrategy extends AbstractEventAggregationStrategy {

	@Override
	protected Event aggregateEvents(Event oldEvent, Event newEvent) {
		if (oldEvent instanceof BusinessEvent && newEvent instanceof BusinessEvent) {
			BusinessEvent oldBE = (BusinessEvent) oldEvent;
			BusinessEvent newBE = (BusinessEvent) newEvent;
			double fact = oldBE.getFact() + newBE.getFact();
			return new GenericEvent(oldBE.getDimension(), fact, timestamp(), oldBE.getType(), oldBE.getDimensionName(), oldBE.getFactName());
		} else {
			throw new RuntimeException("Either one or both events are not instance of BusinessEvent.");
		}
	}

}
