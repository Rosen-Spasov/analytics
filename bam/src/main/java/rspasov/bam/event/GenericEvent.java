package rspasov.bam.event;

public class GenericEvent extends AbstractEvent {

	protected final String type;

	protected final String dimensionName;

	protected final String factName;

	public GenericEvent(String dimension, double fact, String timestamp, String type, String dimensionName, String factName) {
		super(dimension, fact, timestamp);
		this.type = type;
		this.dimensionName = dimensionName;
		this.factName = factName;
	}

	@Override
	public String getDimensionName() {
		return dimensionName;
	}

	@Override
	public String getFactName() {
		return factName;
	}

	@Override
	public String getType() {
		return type;
	}

}
