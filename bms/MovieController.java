package interview.practise.lld.bms;

import interview.practise.lld.bms.enums.City;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    MovieController(){
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }


    //ADD movie to a particular city, make use of cityVsMovies map
    void addMovie(Movie movie, City city) {

        allMovies.add(movie);

        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }


    Movie getMovieByName(String movieName) {

        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }


    List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }
    //REMOVE movie from a particular city, make use of cityVsMovies map
    void removeMovieByCity(City city,String movieName){
        if(!cityVsMovies.containsKey(city)){
            System.out.println("City does not exist");
        }
        else{
            List<Movie> movies = getMoviesByCity(city);
            boolean flag = false;
            for(Movie movie : movies){
                if(movie.getMovieName().equalsIgnoreCase(movieName)){
                    movies.remove(movie);
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println("Movie " + movieName + " has been removed for the city " + city.toString());
            }
            else{
                System.out.println("Movie " + movieName + " is not present for the city " + city.toString());
            }
        }
    }

    //UPDATE movie of a particular city, make use of cityVsMovies map
    void updateMovieByCity(City city, String movieName){
        if(!cityVsMovies.containsKey(city)){
            System.out.println("City does not exist");
        }
        else {
            List<Movie> movies = getMoviesByCity(city);
            Movie newMovie = new Movie();
            newMovie.setMovieId(3);
            newMovie.setMovieName(movieName);
            newMovie.setMovieDuration(50);
            movies.add(newMovie);
            cityVsMovies.put(city,movies);
            System.out.println("Movies updated for city - "+ city.toString());
        }
    }

    //CRUD operation based on Movie ID, make use of allMovies list

}
