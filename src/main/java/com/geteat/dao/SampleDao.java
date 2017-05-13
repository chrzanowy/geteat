package com.geteat.dao;

import com.geteat.domain.SampleDomain;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lovababu on 4/26/2015.
 */
public interface SampleDao {

    Serializable insert(SampleDomain domain);

    SampleDomain update(SampleDomain domain);

    SampleDomain get(SampleDomain domain);

    void delete(SampleDomain domain);

    List<SampleDomain> listView();

    void sessionFactory(SessionFactory sessionFactory);
}
