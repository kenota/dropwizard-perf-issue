package com.test.resource;


import com.codahale.metrics.annotation.Timed;
import com.test.core.VideoJPA;
import com.test.dao.VideoHibernateDao;
import io.dropwizard.hibernate.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/video-hibernate")
@Produces(MediaType.APPLICATION_JSON)
public class VideoHibernateResource {
    private VideoHibernateDao videoHibernateDao;
    private static final Logger logger = LoggerFactory.getLogger(VideoHibernateResource.class);

    public VideoHibernateResource(VideoHibernateDao videoHibernateDao) {
        this.videoHibernateDao = videoHibernateDao;
    }

    @GET
    @UnitOfWork
    public List<VideoJPA> getVideos() {
        return videoHibernateDao.findAll();
    }
}
