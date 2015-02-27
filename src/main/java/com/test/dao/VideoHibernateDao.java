package com.test.dao;

import com.test.core.VideoJPA;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kenota on 26/02/15.
 */
public class VideoHibernateDao extends AbstractDAO<VideoJPA> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public VideoHibernateDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<VideoJPA> findAll() {
        return list(currentSession().createQuery("FROM VideoJPA v"));
    }
}
