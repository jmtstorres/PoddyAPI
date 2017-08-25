package br.com.hammersoft.poddy.api.media;

public enum MediaType {
	movie("movie"), 
	podcast("movie"), 
	music("movie"), 
	musicVideo("movie"), 
	audiobook("movie"), 
	shortFilm("movie"), 
	tvShow("movie"), 
	software("movie"), 
	ebook("movie"), 
	all("movie");
	
	private String desc;

	private MediaType(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
