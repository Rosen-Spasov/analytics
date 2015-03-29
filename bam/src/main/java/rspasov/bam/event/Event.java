package rspasov.bam.event;

public interface Event {
	
	String getType();
	
	String getDimension();
	
	String getDimensionName();
	
	double getFact();
	
	String getFactName();
	
	String getTimestamp();

}
