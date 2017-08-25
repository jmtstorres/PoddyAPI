package br.com.hammersoft.poddy.api;

import java.net.URL;

import com.google.gson.Gson;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import br.com.hammersoft.net.http.HttpURLConnector;
import br.com.hammersoft.poddy.api.pojo.ResultList;

public class PoddyAPI {
	
	private static final String API_ADDR = "https://itunes.apple.com/";
	private static final String API_SEARCH = "search";
	private static final String API_PARAM_INIT = "?";
	private static final String API_PARAM_SEP = "&";
	private static final String API_PARAM_TERM = "term=";
	private static final String API_PARAM_MEDIA = "media=";
	
	public PoddyAPI() {
		// TODO Auto-generated constructor stub
	}
	
	private static ResultList searchMedia(String term, String mediaType) throws Exception{
		String url = 
				API_ADDR + 
				API_SEARCH + 
				API_PARAM_INIT +
				API_PARAM_TERM +
				term +
				(mediaType != null ? 
						API_PARAM_SEP + 
						API_PARAM_MEDIA + mediaType : "");
		
		
		String response = HttpURLConnector.sendGet(url);
		Gson gson = new Gson();
		return gson.fromJson(response, ResultList.class);
	}

	public static void main(String[] args) {
		try {
			String url = PoddyAPI.searchMedia("Jovem+Nerd", null).getResults().get(0).getFeedUrl();
			SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
			System.out.println(feed.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
