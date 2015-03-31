package rspasov.bam.event;

abstract class AbstractEvent implements Event {

	private static final long serialVersionUID = 1L;

	private String timestamp;

	public AbstractEvent(String timestamp) {
		super();
		this.timestamp = timestamp;
	}

	@Override
	public String getTimestamp() {
		return timestamp;
	}

	protected void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return getType() + " [timestamp=" + timestamp + "]";
	}

}
