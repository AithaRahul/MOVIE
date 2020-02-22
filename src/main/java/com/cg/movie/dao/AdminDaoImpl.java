package com.cg.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.movie.bean.Movie;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class AdminDaoImpl implements AdminDao {
	Map<Integer, Theater> map = null;
	private List<Movie> listOfMovies;

	Theater obj = null;

	public AdminDaoImpl() {

		map = new HashMap<Integer, Theater>();
		listOfMovies = new ArrayList<Movie>();
		obj = new Theater();

	}

	@Override
	public Theater addTheater(Theater theater) throws MovieException {

		boolean flag = map.containsKey(theater.getTheaterId());
		if (flag) {
			throw new MovieException("Id already exists");

		}
		obj = theater;
		map.put(theater.getTheaterId(), obj);

		return theater;
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {
		boolean flag = map.containsKey(theaterId);
		if (flag) {
			map.remove(theaterId);
			return true;
		} else {
			throw new MovieException(theaterId + "Id is not found");
		}

	}

	@Override
	public Movie addMovie(int theaterId, Movie movie) throws MovieException {

		List<Integer> list = listOfMovies.stream().map(p -> p.getMovieId()).collect(Collectors.toList());

		boolean flag1 = list.contains(movie.getMovieId());
		if (flag1) {
			throw new MovieException("Movie ID already exists");
		}

		listOfMovies.add(movie);
		obj.setMoviesList(listOfMovies);

		return movie;
	}

	@Override
	public boolean deleteMovie(int theaterId, int movieId) throws MovieException {

		boolean flag = false;

		List<Integer> list1 = listOfMovies.stream().map(p -> p.getMovieId()).collect(Collectors.toList());
		flag = list1.contains(movieId);
		if (flag) {
			for (Movie m : listOfMovies) {
				if (m.getMovieId() == movieId) {
					listOfMovies.remove(m);
					flag = true;
					break;
				}
			}

		}

		else {

			throw new MovieException("Movie ID Does Not Exist");

		}
		return flag;
	}

}
