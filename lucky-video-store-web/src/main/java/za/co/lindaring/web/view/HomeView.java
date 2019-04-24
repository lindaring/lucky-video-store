package za.co.lindaring.web.view;

import lombok.Getter;
import lombok.Setter;
import za.co.lindaring.web.dao.VideoDAO;
import za.co.lindaring.web.entity.Video;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@Getter
@Setter
@RequestScoped
@ManagedBean(name = "homeView")
public class HomeView {

    private List<Video> videos;

    @EJB
    VideoDAO videoDAO;

    public void deleteVideo(Long videoId) {
        videoDAO.deleteVideo(videoId);
        videos = videoDAO.getAllVideos();
    }

    @PostConstruct
    public void init() {
        videos = videoDAO.getAllVideos();
    }

}
