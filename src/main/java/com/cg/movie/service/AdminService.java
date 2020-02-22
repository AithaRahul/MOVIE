package com.cg.movie.service;

import com.cg.movie.bean.Movie;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminService {
	public Theater addTheater(Theater theater) throws MovieException;

	public boolean deleteTheater(int theaterId) throws MovieException;

	public boolean validateId(int id) throws MovieException;

	public boolean validateContact(String num) throws MovieException;

	public boolean validateName(String name) throws MovieException;

	public boolean validateMovieId(int id) throws MovieException;

	public Movie addMovie(int theaterId, Movie movie) throws MovieException;

	public boolean deleteMovie(int theaterId, int movieId) throws MovieException;

}
