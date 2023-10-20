package com.hibernate.hibernateFilter;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private final EntityManager entityManager;

    @Autowired
    public BaseRepositoryImpl(JpaEntityInformation entityInformation,
                              EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public void disableFilter(String filtername) {
        this.entityManager.unwrap(Session.class).disableFilter(filtername);
    }

    @Override
    public void enableFilter(String filtername) {
        this.entityManager.unwrap(Session.class).enableFilter(filtername).setParameter("deleted", false);
    }
}
