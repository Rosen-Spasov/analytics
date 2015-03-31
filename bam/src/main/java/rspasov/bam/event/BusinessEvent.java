package rspasov.bam.event;

public interface BusinessEvent extends Event {

	String getDimension();

	String getDimensionName();

	double getFact();

	String getFactName();

}
