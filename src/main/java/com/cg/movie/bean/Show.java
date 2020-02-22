package com.cg.movie.bean;

import java.sql.Time;

public class Show {

	private int showId;
	private Time showStartTime;
	private Time showEndTime;
	private String showName;
	private Movie movieName;
	private int screenId;
	private int theaterId;
	
	public Show(int showId, Time showStartTime, Time showEndTime, String showName, Movie movieName, int screenId,
			int theaterId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movieName = movieName;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}

	public Show() {
		super();
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Time getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(Time showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Time getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(Time showEndTime) {
		this.showEndTime = showEndTime;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Movie getMovieName() {
		return movieName;
	}

	public void setMovieName(Movie movieName) {
		this.movieName = movieName;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	
	
	
	
	
	
	
}
