package br.com.hammersoft.poddy.api;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import br.com.hammersoft.net.http.HttpURLConnector;
import br.com.hammersoft.poddy.api.exception.PoddyAPIException;
import br.com.hammersoft.poddy.api.media.MediaType;
import br.com.hammersoft.poddy.api.pojo.Result;
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
	
	public static ResultList searchMedia(String term, MediaType type) throws PoddyAPIException {
		String url = 
				API_ADDR + 
				API_SEARCH + 
				API_PARAM_INIT +
				API_PARAM_TERM +
				term +
				(type != null ? 
						API_PARAM_SEP + 
						API_PARAM_MEDIA + type.getDesc() : "");

		String response;
		try {
			response = HttpURLConnector.sendGet(url);
		} catch (IOException e) {
			throw new PoddyAPIException(e); 
		}
		Gson gson = new Gson();
		return gson.fromJson(response, ResultList.class);
	}
	
	public static SyndFeed getPodcastFeed(Result result) throws PoddyAPIException {
		String url = result.getFeedUrl();
		System.out.println(url);
		SyndFeed feed = null;
		try {
			feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
		} catch (IllegalArgumentException | FeedException | IOException e) {
			System.out.println("Url com erro: " + url + " | " + result.getArtistName());
			throw new PoddyAPIException(e);
		}
		
		return feed;
	}
}
