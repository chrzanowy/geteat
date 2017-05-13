package com.geteat.service;

import com.geteat.dao.SampleDao;
import com.geteat.domain.SampleDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lovababu on 4/26/2015.
 */

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleDao sampleDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Serializable insert(SampleDomain domain) {
        return sampleDao.insert(domain);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SampleDomain update(SampleDomain domain) {
        return sampleDao.update(domain);
    }

    @Override
    @Transactional(readOnly = true)
    public SampleDomain get(SampleDomain domain) {
        return sampleDao.get(domain);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(SampleDomain domain) {
        sampleDao.delete(domain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SampleDomain> listView(){
        return sampleDao.listView();
    }

}
