package com.geteat.dao.impl;

import com.geteat.dao.RsoCacheDao;
import com.geteat.model.RsoCache;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Kuba on 2017-05-13.
 */
@Repository
public class RsoCacheDaoImpl implements RsoCacheDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persistOrMerge(RsoCache rsoCache) {

    }

    @Override
    public void persist(RsoCache rsoCache) {

    }

    @Override
    public void delete(RsoCache rsoCache) {

    }
}
