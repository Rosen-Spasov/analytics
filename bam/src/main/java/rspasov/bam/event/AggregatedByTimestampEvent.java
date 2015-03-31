package rspasov.bam.event;

import java.util.ArrayList;
import java.util.List;

public class AggregatedByTimestampEvent extends AbstractEvent {

	private static final long serialVersionUID = 1L;

	private final List<Event> events = new ArrayList<>();

	public AggregatedByTimestampEvent(String timestamp) {
		super(timestamp);
	}

	public boolean addEvent(Event event) {
		return events.add(event);
	}

	public List<Event> getEvents() {
		return events;
	}

	@Override
	public String getType() {
		return "AggregatedByTimestampEvent";
	}

}
