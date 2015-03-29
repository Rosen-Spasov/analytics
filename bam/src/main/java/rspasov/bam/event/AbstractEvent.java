package rspasov.bam.event;

abstract class AbstractEvent implements Event {

	private static final long serialVersionUID = 1L;

	protected String dimension;

	protected double fact;

	protected String timestamp;

	public AbstractEvent(String dimension, double fact, String timestamp) {
		super();
		setDimension(dimension);
		setFact(fact);
		setTimestamp(timestamp);
	}

	@Override
	public String getDimension() {
		return dimension;
	}

	@Override
	public double getFact() {
		return fact;
	}

	@Override
	public String getTimestamp() {
		return timestamp;
	}

	protected void setDimension(String dimension) {
		this.dimension = dimension;
	}

	protected void setFact(double fact) {
		this.fact = fact;
	}

	protected void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return getType() + " [dimension=" + dimension + ", fact=" + fact + ", timestamp=" + timestamp + "]";
	}

}
