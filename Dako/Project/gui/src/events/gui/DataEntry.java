package events.gui;

public class DataEntry {
	private final int number;
	private final String timeStamp;
	private final String userId;
	private final String message;
	private final String sentiment;
	private final boolean geolocated;
	
	public DataEntry(int number, String timeStamp, String userId, String message, String sentiment, boolean geolocated) {
		super();
		this.number = number;
		this.timeStamp = timeStamp;
		this.userId = userId;
		this.message = message;
		this.sentiment = sentiment;
		this.geolocated = geolocated;
	}
	
	public int getNumber() {
		return this.number;
	}

	public String getUserId() {
		return userId;
	}

	public String getMessage() {
		return message;
	}

	public String getSentiment() {
		return sentiment;
	}

	public boolean isGeolocated() {
		return geolocated;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
}