package za.co.lindaring.web.view;

import lombok.Getter;
import lombok.Setter;
import za.co.lindaring.web.dao.VideoDAO;
import za.co.lindaring.web.entity.Video;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Getter
@Setter
@ViewScoped
@ManagedBean(name = "addVideo")
public class AddVideo {

    @EJB
    VideoDAO videoDAO;

    private String name;
    private int yearReleased;

    public void createVideo() {
        try {
            videoDAO.createVideo(Video.builder()
                    .name(name)
                    .yearReleased(yearReleased)
                    .build());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Video added."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to save video."));
            e.printStackTrace();
        }
    }

}
