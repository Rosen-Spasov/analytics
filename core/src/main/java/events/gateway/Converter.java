package events.gateway;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;

import com.aliasi.classify.ConditionalClassification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.util.AbstractExternalizable;

import events.Tweet;

@SuppressWarnings("rawtypes")
public class Converter implements Processor {
	
	private static final Logger logger = LoggerFactory.getLogger(Converter.class);
	
	private LMClassifier classfier;
	private static String urlPatternString = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	private static Pattern urlPattern = Pattern.compile(urlPatternString,Pattern.CASE_INSENSITIVE);
	private static String smileyPatternString = ":\\)|:\\(|:P|;\\)|\\^\\.\\^|:~\\(|:\\-o|:\\*\\-/|:\\-c|:\\-D|:'|:bow:|:whistle:|:zzz:|:kiss:|:rose:";
	private static Pattern smileyPattern = Pattern.compile(smileyPatternString,Pattern.CASE_INSENSITIVE);
	
	
	public Converter() throws Exception {
		classfier = (LMClassifier) AbstractExternalizable.readObject(new File("classifier.txt"));
		logger.info("Converter initialized.");
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Status status = exchange.getIn().getBody(Status.class);
		Date temp = status.getCreatedAt();
		Calendar time = Calendar.getInstance();
		time.setTime(temp);
		String timeStamp = "[" + time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE) + ":"  + time.get(Calendar.SECOND) + "]";
		
		logger.info("Event " + timeStamp + ":" + status.getId());
		
		String username = status.getUser()!=null ? status.getUser().getScreenName() : "not available";
		String url = status.getUser()!=null ? ("https://twitter.com/" + status.getUser().getId() +  "/status/" + status.getId()) : "https://www.twitter.com";
		
		Tweet tweet = new Tweet()
        	.withName(username)
        	.withText(status.getText())
        	.withTimestamp(timeStamp)
        	.withSentiment(this.classify(status.getText()))
        	.withUrl(url);
		
		if (status.getGeoLocation()!=null){
			tweet.withGeolocated(true)
				.withLatitude(status.getGeoLocation().getLatitude())
				.withLongtitude(status.getGeoLocation().getLongitude());
		}
		
		exchange.getIn().setBody(tweet);
	}
	
	private String classify(String text) {
		text = sanitizeText(text);
		
		ConditionalClassification classification = classfier.classify(text);
		return classification.bestCategory();
	}
	
	private String sanitizeText(String text){
		String result = text;
		//remove #insta
		result = result.replaceAll("#insta", "");
		//remove hashtags
		result = result.replaceAll("#", "");
		//remove urls
		result = removeUrls(result);
		//remove smileys
		result = removeSmileys(result);
		return result;
	}
	
	public String removeSmileys(String targetString) {
		Matcher matcher = smileyPattern.matcher(targetString);
		StringBuffer result = new StringBuffer();
		while(matcher.find()){
		   matcher.appendReplacement(result, "");
		}
		matcher.appendTail(result);
		return result.toString();
	}
	
	private String removeUrls(String targetString) {
		
		String result = targetString;

		Matcher m = urlPattern.matcher(result);
		int i = 0;
		while (m.find()) {
			result = result.replaceAll(m.group(i), "").trim();
			i++;
		}
		return result;
	}
}
