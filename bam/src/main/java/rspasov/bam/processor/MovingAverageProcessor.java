package rspasov.bam.processor;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import rspasov.bam.event.BusinessEvent;
import rspasov.bam.event.ChartEvent;
import rspasov.bam.event.GenericEvent;

public class MovingAverageProcessor implements Processor {

	private static final int MAX_COUNT = 20;

	private double average;

	private Queue<Double> queue = new LinkedList<>();

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
		double sum = queue.size() * average;

		double oldestValue = 0;
		if (queue.size() == MAX_COUNT) {
			oldestValue = queue.poll();
		}
		double newestValue = event.getFact();
		queue.offer(newestValue);

		sum -= oldestValue;
		sum += newestValue;
		average = sum / queue.size();
	}
}
