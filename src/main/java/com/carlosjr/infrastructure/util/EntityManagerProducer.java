package com.carlosjr.infrastructure.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    private EntityManagerFactory _factory;

    public EntityManagerProducer() {
        this._factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return this._factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        manager.close();
    }
}