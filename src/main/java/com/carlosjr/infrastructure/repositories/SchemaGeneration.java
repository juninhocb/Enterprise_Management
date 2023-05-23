package com.carlosjr.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carlosjr.domain.model.Enterprise;

public class SchemaGeneration {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarlosJrPU");

        EntityManager em = emf.createEntityManager();

        List<Enterprise> list = em.createQuery("from Enterprise", Enterprise.class).getResultList();

        System.out.println(list);

        em.close();
        emf.close();
    }

}
