package rspasov.event;

public class Tweet {
    private String name;
    private String text;
    private String timestamp;
    private String sentiment;
    private String url;
    private boolean geolocated;
    private double latitude;
    private double longtitude;

    public Tweet withName(String name) {
        this.name = name;
        return this;
    }

    public Tweet withText(String text) {
        this.text = text;
        return this;
    }
    
    public Tweet withTimestamp(String timestamp) {
    	this.timestamp = timestamp;
    	return this;
    }
    
    public Tweet withSentiment(String sentiment) {
    	this.sentiment = sentiment;
    	return this;
    }
    
    public Tweet withUrl(String url) {
    	this.url = url;
    	return this;
    }
    
    public Tweet withGeolocated(boolean geolocated) {
    	this.geolocated = geolocated;
    	return this;
    }
    
    public Tweet withLatitude(double latitude) {
    	this.latitude = latitude;
    	return this;
    }
    
    public Tweet withLongtitude(double longtitude) {
    	this.longtitude = longtitude;
    	return this;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }
    
    public String getTimestamp() {
    	return this.timestamp;
    }
    
    public String getSentiment() {
    	return this.sentiment;
    }
    
    public String getUrl() {
    	return this.url;
    }
    
    public boolean getGeolocated() {
    	return this.geolocated;
    }
    
    public Double getLatitude() {
    	return this.latitude;
    }
    
    public Double getLongtitude() {
    	return this.longtitude;
    }

	@Override
	public String toString() {
		return "Tweet [name=" + name + ", text=" + text + ", timestamp="
				+ timestamp + ", sentiment=" + sentiment + ", url=" + url
				+ ", geolocated=" + geolocated + ", latitude=" + latitude
				+ ", longtitude=" + longtitude + "]";
	}
}
