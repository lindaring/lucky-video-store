package za.co.lindaring.web.dao;

import za.co.lindaring.web.entity.Video;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VideoDAO {

    @PersistenceContext(unitName = "VideoStorePU")
    EntityManager em;

    public List<Video> getAllVideos() {
        TypedQuery<Video> result = em.createNamedQuery("Video.findAll", Video.class);
        return result.getResultList();
    }

    public void createVideo(Video video) {
        em.persist(video);
    }

}
