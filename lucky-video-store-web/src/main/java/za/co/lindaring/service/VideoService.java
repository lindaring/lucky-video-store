package za.co.lindaring.service;

import lombok.Getter;
import lombok.Setter;
import za.co.lindaring.model.Video;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@ApplicationScoped
@ManagedBean(name = "carService")
public class VideoService {

    private final static String[] movies;

    static {
        movies = new String[10];
        movies[0] = "The Matrix";
        movies[1] = "The Number Sleven";
        movies[2] = "Hitch";
        movies[3] = "Catch Me If You Can";
    }

    public List<Video> createMovies(int size) {
        List<Video> list = new ArrayList<Video>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Video(getRandomId(), getRandomMovie(), getRandomYear()));
        }

        return list;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomMovie() {
        return movies[(int) (Math.random() * 10)];
    }

}
