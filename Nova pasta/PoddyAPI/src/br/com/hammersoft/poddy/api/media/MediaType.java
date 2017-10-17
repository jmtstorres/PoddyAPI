package br.com.hammersoft.poddy.api.media;

public enum MediaType {
	movie("movie"), 
	podcast("podcast"), 
	music("music"), 
	musicVideo("musicVideo"), 
	audiobook("audiobook"), 
	shortFilm("shortFilm"), 
	tvShow("tvShow"), 
	software("software"), 
	ebook("ebook"), 
	all("all");
	
	private String desc;

	private MediaType(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
