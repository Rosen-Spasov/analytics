package rspasov.bam.event;

public class OrderReceivedEvent extends AbstractBusinessEvent {

	private static final long serialVersionUID = 1L;

	public OrderReceivedEvent(String dimension, double fact, String timestamp) {
		super(dimension, fact, timestamp);
	}

	@Override
	public String getDimensionName() {
		return "Customer";
	}

	@Override
	public String getFactName() {
		return "Quantity";
	}

	@Override
	public String getType() {
		return "OrderReceived";
	}

}
