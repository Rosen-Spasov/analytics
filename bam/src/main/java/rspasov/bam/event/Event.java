package rspasov.bam.event;

import java.io.Serializable;

public interface Event extends Serializable {

	String getTimestamp();

	String getType();

}
