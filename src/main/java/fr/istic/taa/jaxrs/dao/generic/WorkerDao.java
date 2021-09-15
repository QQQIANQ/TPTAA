package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.metier.*;

public class WorkerDao extends AbstractJpaDao<Long, Worker>{
    public WorkerDao() {
        super(Worker.class);
    }
}
