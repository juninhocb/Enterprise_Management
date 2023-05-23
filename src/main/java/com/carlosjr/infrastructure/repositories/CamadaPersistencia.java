package com.carlosjr.infrastructure.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carlosjr.domain.model.Enterprise;
import com.carlosjr.domain.model.DescActivity;
import com.carlosjr.domain.model.EnterpriseType;

public class CamadaPersistencia {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarlosJrPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Declarando os repositórios
        DescActivityRepository _descriptionActivityReposoitory = new DescActivityRepository(em);
        EnterpriseRepository _enterpriseRepository = new EnterpriseRepository(em);

        // Buscando as informações do banco
        List<DescActivity> descActivityList = _descriptionActivityReposoitory.findByDescription("");
        List<Enterprise> enterprisesList = _enterpriseRepository.findByName("");
        System.out.println(enterprisesList);

        // Criando uma Enterprise
        Enterprise enterprise = new Enterprise();
        enterprise.setFantasyName("João da Silva");
        enterprise.setIdentity("41.952.519/0001-57");
        enterprise.setSocialName("João da Silva 41952519000157");
        enterprise.setEnterpriseType(EnterpriseType.MEI);
        enterprise.setCreatedDate(new Date());
        enterprise.setDescriptionActivity(descActivityList.get(0));

        // Salvando a Enterprise
        _enterpriseRepository.save(enterprise);

        em.getTransaction().commit();

        // Verificando se a inserção funcionou
        List<Enterprise> listOfEnterprise2 = _enterpriseRepository.findByName("");
        System.out.println(listOfEnterprise2);

        em.close();
        emf.close();
    }

}

