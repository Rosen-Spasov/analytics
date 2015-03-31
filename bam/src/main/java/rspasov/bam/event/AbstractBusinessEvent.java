package rspasov.bam.event;

abstract class AbstractBusinessEvent extends AbstractEvent implements BusinessEvent {

	private static final long serialVersionUID = 1L;

	protected String dimension;

	protected double fact;

	public AbstractBusinessEvent(String dimension, double fact, String timestamp) {
		super(timestamp);
		setDimension(dimension);
		setFact(fact);
	}

	@Override
	public String getDimension() {
		return dimension;
	}

	@Override
	public double getFact() {
		return fact;
	}

	protected void setDimension(String dimension) {
		this.dimension = dimension;
	}

	protected void setFact(double fact) {
		this.fact = fact;
	}

	@Override
	public String toString() {
		return getType() + " [dimension=" + dimension + ", fact=" + fact + ", timestamp=" + getTimestamp() + "]";
	}

}
