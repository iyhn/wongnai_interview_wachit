package com.wongnai.interview.movie.search;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MovieDataService;
import com.wongnai.interview.movie.external.MovieData;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {
	@Autowired
	private MovieDataService movieDataService;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 2 => Implement this method by using data from MovieDataService
		// All test in SimpleMovieSearchServiceIntegrationTest must pass.
		// Please do not change @Component annotation on this class

		List<Movie> movieList = new ArrayList<>();
		List<String> titleArray = new ArrayList<>();
		for (MovieData i: movieDataService.fetchAll()) {
			titleArray = Arrays.asList(i.getTitle().toLowerCase().split(" "));
			if(titleArray.contains(queryText.toLowerCase())){
				movieList.add(new Movie(i));
			}
		}

		return movieList;
	}
}
