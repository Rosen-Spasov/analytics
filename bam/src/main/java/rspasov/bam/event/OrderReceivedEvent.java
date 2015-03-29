package rspasov.bam.event;

public class OrderReceivedEvent extends AbstractEvent {

	public OrderReceivedEvent(String dimension, double fact, String timestamp) {
		super(dimension, fact, timestamp);
	}

	@Override
	public String getType() {
		return "OrderReceived";
	}

	@Override
	public String getDimensionName() {
		return "Customer";
	}

	@Override
	public String getFactName() {
		return "Quantity";
	}

}
