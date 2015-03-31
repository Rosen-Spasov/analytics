package rspasov.bam.event;

public class ChartEvent extends AbstractEvent {

	private static final long serialVersionUID = 1L;

	private final BusinessEvent originalEvent;

	private final BusinessEvent movingAverageEvent;

	public ChartEvent(String timestamp, BusinessEvent originalEvent, BusinessEvent movingAverageEvent) {
		super(timestamp);
		this.originalEvent = originalEvent;
		this.movingAverageEvent = movingAverageEvent;
	}

	public BusinessEvent getMovingAverageEvent() {
		return movingAverageEvent;
	}

	public BusinessEvent getOriginalEvent() {
		return originalEvent;
	}

	@Override
	public String getType() {
		return "ChartEvent";
	}
}
