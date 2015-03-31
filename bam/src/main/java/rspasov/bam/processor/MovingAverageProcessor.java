package rspasov.bam.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import rspasov.bam.event.BusinessEvent;
import rspasov.bam.event.ChartEvent;
import rspasov.bam.event.GenericEvent;

public class MovingAverageProcessor implements Processor {

	private int count;

	private double average;

	private GenericEvent averageEvent(BusinessEvent event) {
		return new GenericEvent(event.getDimension(), average, event.getTimestamp(), event.getType(), event.getDimensionName(),
				event.getDimensionName());
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Object body = exchange.getIn().getBody();
		if (body instanceof BusinessEvent) {
			BusinessEvent event = (BusinessEvent) body;
			recalculateAverage(event);
			ChartEvent chartEvent = new ChartEvent(event.getTimestamp(), event, averageEvent(event));
			exchange.getIn().setBody(chartEvent);
		}
	}

	private void recalculateAverage(BusinessEvent event) {
		double sum = count * average;
		sum += event.getFact();
		count++;
		average = sum / count;
	}

}
