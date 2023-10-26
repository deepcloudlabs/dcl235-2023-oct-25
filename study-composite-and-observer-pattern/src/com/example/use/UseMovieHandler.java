package com.example.use;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

import com.example.domain.Movie;
import com.example.handler.GenericHandler;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class UseMovieHandler {

    public static void main(String[] args) {

        try {
			XMLReader parser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            GenericHandler<Movie> handler = new GenericHandler<Movie>(Movie.class);
            parser.setContentHandler(handler);
            parser.parse("resources/movies.xml");
            for (Movie movie : handler.getElements(Movie.class)) {
                System.err.println("Movie Title: " + movie.getTitle());
                System.err.println("Movie Genres: "+movie.getGenres());
                System.err.println("Movie Year: "+movie.getYear());
                System.err.println("IMDB: "+movie.getImdb());
                System.err.println("------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
