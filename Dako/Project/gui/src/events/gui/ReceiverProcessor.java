package events.gui;

import java.awt.Color;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import events.Tweet;


public class ReceiverProcessor implements Processor {
	
	private TableModel tableModel;
	private JMapViewer map;
	
	public ReceiverProcessor(TableModel tableModel, JMapViewer map) throws Exception {
		this.tableModel = tableModel;
		this.map = map;
		System.out.println("Receiver processor initialized.");
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Tweet tweet = exchange.getIn().getBody(Tweet.class);
		
		String timeStamp= tweet.getTimestamp();
		String userId = tweet.getName();
		String message = tweet.getText();
		String sentiment = tweet.getSentiment();
		boolean geolocated = tweet.getGeolocated();
		int number = tableModel.getRowCount();
		
		if (tweet.getGeolocated()) {
			double latitue = tweet.getLatitude();
			double longtitude = tweet.getLongtitude();
			if (sentiment.equalsIgnoreCase("pos")){
				MapMarkerDot dot = new MapMarkerDot(Color.GREEN, latitue, longtitude);
				dot.setBackColor(Color.GREEN);
//				dot.setName(Integer.toString(number));
				map.addMapMarker(dot);
			} else if (sentiment.equalsIgnoreCase("neg")){
				MapMarkerDot dot = new MapMarkerDot(Color.RED, latitue, longtitude);
				dot.setBackColor(Color.RED);
//				dot.setName(Integer.toString(number));
				map.addMapMarker(dot);
			} else {
				MapMarkerDot dot = new MapMarkerDot(Color.GRAY, latitue, longtitude);
				dot.setBackColor(Color.GRAY);
//				dot.setName(Integer.toString(number));
				map.addMapMarker(dot);
			}
		}
		
		DataEntry newEntry = new DataEntry(number, timeStamp, userId, message, sentiment, geolocated);
		tableModel.addEntry(newEntry);
	}
}
