package za.co.lindaring.view;

import lombok.Getter;
import lombok.Setter;
import za.co.lindaring.model.Video;
import za.co.lindaring.service.VideoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@Getter
@Setter
@ViewScoped
@ManagedBean(name = "homeView")
public class HomeView {

    private List<Video> movies;

    @ManagedProperty("#{carService}")
    private VideoService videoService;

    @PostConstruct
    public void init() {
        movies = videoService.createMovies(10);
    }

}
