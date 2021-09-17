package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.*;

import java.util.List;

public class WorkerDao extends AbstractJpaDao<Long, Worker>{
    public WorkerDao() {
        super(Worker.class);
    }
    public List<Worker> getAllWorker() {
        String query = "select e from Worker as e";
        return this.entityManager.createQuery(query).getResultList();
    }
}
