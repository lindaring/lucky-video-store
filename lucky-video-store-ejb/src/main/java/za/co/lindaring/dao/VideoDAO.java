package za.co.lindaring.dao;

import za.co.lindaring.model.Video;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@Startup
public class VideoDAO {

    @PersistenceContext(unitName = "VideoStorePU")
    EntityManager em;

    public List<Video> getAll() {
        return em.createNamedQuery("Video.findAll", Video.class).getResultList();
    }

    @PostConstruct
    public void test() {
        System.out.println("working " + getAll().size());
    }

}
