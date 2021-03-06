package br.com.hammersoft.poddy.api.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("wrapperType")
	@Expose
	private String wrapperType;
	@SerializedName("kind")
	@Expose
	private String kind;
	@SerializedName("collectionId")
	@Expose
	private Integer collectionId;
	@SerializedName("trackId")
	@Expose
	private Integer trackId;
	@SerializedName("artistName")
	@Expose
	private String artistName;
	@SerializedName("collectionName")
	@Expose
	private String collectionName;
	@SerializedName("trackName")
	@Expose
	private String trackName;
	@SerializedName("collectionCensoredName")
	@Expose
	private String collectionCensoredName;
	@SerializedName("trackCensoredName")
	@Expose
	private String trackCensoredName;
	@SerializedName("collectionViewUrl")
	@Expose
	private String collectionViewUrl;
	@SerializedName("feedUrl")
	@Expose
	private String feedUrl;
	@SerializedName("trackViewUrl")
	@Expose
	private String trackViewUrl;
	@SerializedName("artworkUrl30")
	@Expose
	private String artworkUrl30;
	@SerializedName("artworkUrl60")
	@Expose
	private String artworkUrl60;
	@SerializedName("artworkUrl100")
	@Expose
	private String artworkUrl100;
	@SerializedName("collectionPrice")
	@Expose
	private Double collectionPrice;
	@SerializedName("trackPrice")
	@Expose
	private Double trackPrice;
	@SerializedName("trackRentalPrice")
	@Expose
	private Double trackRentalPrice;
	@SerializedName("collectionHdPrice")
	@Expose
	private Double collectionHdPrice;
	@SerializedName("trackHdPrice")
	@Expose
	private Double trackHdPrice;
	@SerializedName("trackHdRentalPrice")
	@Expose
	private Double trackHdRentalPrice;
	@SerializedName("releaseDate")
	@Expose
	private String releaseDate;
	@SerializedName("collectionExplicitness")
	@Expose
	private String collectionExplicitness;
	@SerializedName("trackExplicitness")
	@Expose
	private String trackExplicitness;
	@SerializedName("trackCount")
	@Expose
	private Integer trackCount;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("currency")
	@Expose
	private String currency;
	@SerializedName("primaryGenreName")
	@Expose
	private String primaryGenreName;
	@SerializedName("contentAdvisoryRating")
	@Expose
	private String contentAdvisoryRating;
	@SerializedName("artworkUrl600")
	@Expose
	private String artworkUrl600;
	@SerializedName("genreIds")
	@Expose
	private List<String> genreIds = null;
	@SerializedName("genres")
	@Expose
	private List<String> genres = null;

	public String getWrapperType() {
		return wrapperType;
	}

	public void setWrapperType(String wrapperType) {
		this.wrapperType = wrapperType;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getCollectionCensoredName() {
		return collectionCensoredName;
	}

	public void setCollectionCensoredName(String collectionCensoredName) {
		this.collectionCensoredName = collectionCensoredName;
	}

	public String getTrackCensoredName() {
		return trackCensoredName;
	}

	public void setTrackCensoredName(String trackCensoredName) {
		this.trackCensoredName = trackCensoredName;
	}

	public String getCollectionViewUrl() {
		return collectionViewUrl;
	}

	public void setCollectionViewUrl(String collectionViewUrl) {
		this.collectionViewUrl = collectionViewUrl;
	}

	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}

	public String getTrackViewUrl() {
		return trackViewUrl;
	}

	public void setTrackViewUrl(String trackViewUrl) {
		this.trackViewUrl = trackViewUrl;
	}

	public String getArtworkUrl30() {
		return artworkUrl30;
	}

	public void setArtworkUrl30(String artworkUrl30) {
		this.artworkUrl30 = artworkUrl30;
	}

	public String getArtworkUrl60() {
		return artworkUrl60;
	}

	public void setArtworkUrl60(String artworkUrl60) {
		this.artworkUrl60 = artworkUrl60;
	}

	public String getArtworkUrl100() {
		return artworkUrl100;
	}

	public void setArtworkUrl100(String artworkUrl100) {
		this.artworkUrl100 = artworkUrl100;
	}

	public Double getCollectionPrice() {
		return collectionPrice;
	}

	public void setCollectionPrice(Double collectionPrice) {
		this.collectionPrice = collectionPrice;
	}

	public Double getTrackPrice() {
		return trackPrice;
	}

	public void setTrackPrice(Double trackPrice) {
		this.trackPrice = trackPrice;
	}

	public Double getTrackRentalPrice() {
		return trackRentalPrice;
	}

	public void setTrackRentalPrice(Double trackRentalPrice) {
		this.trackRentalPrice = trackRentalPrice;
	}

	public Double getCollectionHdPrice() {
		return collectionHdPrice;
	}

	public void setCollectionHdPrice(Double collectionHdPrice) {
		this.collectionHdPrice = collectionHdPrice;
	}

	public Double getTrackHdPrice() {
		return trackHdPrice;
	}

	public void setTrackHdPrice(Double trackHdPrice) {
		this.trackHdPrice = trackHdPrice;
	}

	public Double getTrackHdRentalPrice() {
		return trackHdRentalPrice;
	}

	public void setTrackHdRentalPrice(Double trackHdRentalPrice) {
		this.trackHdRentalPrice = trackHdRentalPrice;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCollectionExplicitness() {
		return collectionExplicitness;
	}

	public void setCollectionExplicitness(String collectionExplicitness) {
		this.collectionExplicitness = collectionExplicitness;
	}

	public String getTrackExplicitness() {
		return trackExplicitness;
	}

	public void setTrackExplicitness(String trackExplicitness) {
		this.trackExplicitness = trackExplicitness;
	}

	public Integer getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPrimaryGenreName() {
		return primaryGenreName;
	}

	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}

	public String getContentAdvisoryRating() {
		return contentAdvisoryRating;
	}

	public void setContentAdvisoryRating(String contentAdvisoryRating) {
		this.contentAdvisoryRating = contentAdvisoryRating;
	}

	public String getArtworkUrl600() {
		return artworkUrl600;
	}

	public void setArtworkUrl600(String artworkUrl600) {
		this.artworkUrl600 = artworkUrl600;
	}

	public List<String> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<String> genreIds) {
		this.genreIds = genreIds;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
}