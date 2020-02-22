package com.cg.movie.service;

import com.cg.movie.bean.Movie;

import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public AdminServiceImpl() {
		adminDao = new AdminDaoImpl();
	}

	@Override
	public Theater addTheater(Theater theater) throws MovieException {
		int id = theater.getTheaterId();
		boolean flag = validateId(id);

		if (flag == false) {

			throw new MovieException("Theater Id must be 4 digit starting with 2");
		}
		String name = theater.getTheaterName();
		boolean flag1 = validateName(name);

		if (flag1 == true) {
			throw new MovieException("Theater Name must not be Null ");
		}

		String mname = theater.getManagerName();
		boolean flag2 = validateName(mname);

		if (flag2 == true) {
			throw new MovieException("Manager Name must not be Null ");
		}
		String mcontact = theater.getManagerContact();
		boolean flag3 = validateContact(mcontact);

		if (flag3 == false) {
			throw new MovieException("Manager Contact Number must be 10 digits");
		}
		Theater th = adminDao.addTheater(theater);

		return th;

	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {
		boolean flag = validateId(theaterId);

		if (flag == false) {

			throw new MovieException("Theater Id must be 4 digit starting with 2");
		}

		boolean flag1 = adminDao.deleteTheater(theaterId);

		return flag1;
	}

	@Override
	public boolean validateId(int id) throws MovieException {
		boolean flag = false;

		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);
			flag = s.matches("(2)[0-9]{3}");

		}

		return flag;
	}

	@Override
	public boolean validateContact(String num) throws MovieException {
		boolean flag = false;
		flag = num.matches("[0-9]{10}");

		return flag;
	}

	@Override
	public boolean validateMovieId(int id) throws MovieException {
		boolean flag = false;

		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);
			flag = s.matches("[0-9]{4}");

		}

		return flag;
	}

	@Override
	public boolean validateName(String name) throws MovieException {
		boolean flag = false;
		flag = name.isEmpty();

		if (flag) {
			flag = true;

		}

		return flag;
	}

	@Override
	public Movie addMovie(int theaterId, Movie movie) throws MovieException {
		int id = movie.getMovieId();

		boolean flag = validateMovieId(id);
		if (flag == false) {
			throw new MovieException("Movie Id must be 4 digits");
		}
		String name = movie.getMovieName();
		boolean flag1 = validateName(name);

		if (flag1 == true) {
			throw new MovieException("Movie Name must not be Null");
		}
		String dname = movie.getMovieDirector();
		boolean flag2 = validateName(dname);

		if (flag2 == true) {
			throw new MovieException("Director Name must not be Null");
		}
		Movie m = adminDao.addMovie(theaterId, movie);
		return m;

	}

	@Override
	public boolean deleteMovie(int theaterId, int movieId) throws MovieException {
		boolean flag = validateMovieId(movieId);

		if (!flag) {
			throw new MovieException("Movie Id must be 4 digits");
		}
		boolean flag1 = adminDao.deleteMovie(theaterId, movieId);

		return flag1;
	}

}
