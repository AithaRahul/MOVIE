package com.cg.movie.dao;

import com.cg.movie.bean.Movie;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminDao 
{
	
	public Theater addTheater(Theater theater) throws MovieException; 
	public boolean deleteTheater(int theaterId) throws MovieException; 
	public Movie addMovie(int theaterId,Movie movie) throws MovieException; 
	public boolean deleteMovie(int theaterId,int movieId) throws MovieException; 
	
}

