package rspasov.bam.event;

import java.io.Serializable;

public interface Event extends Serializable {

	String getDimension();

	String getDimensionName();

	double getFact();

	String getFactName();

	String getTimestamp();

	String getType();

}
