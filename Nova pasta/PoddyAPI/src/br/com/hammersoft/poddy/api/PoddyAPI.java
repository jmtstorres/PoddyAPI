package br.com.hammersoft.poddy.api;

import java.net.URL;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import br.com.hammersoft.net.http.HttpURLConnector;

public class PoddyAPI {
	
	//https://www.mixcloud.com/developers/
	//https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/
	

	public PoddyAPI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			System.out.println(HttpURLConnector.sendGet("http://api.digitalpodcast.com/v2r/search/?appid=podcastsearchdemo&keywords=rock%20and%20roll&format=opml&sort=rating&searchsource=title&contentfilter=noadult&start=1&results=3"));
			
			String url = "https://stackoverflow.com/feeds/tag?tagnames=rome";
			SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL("http://www.americanheartbreak.com/rnrgeekwp/feed/")));
			System.out.println(feed.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
