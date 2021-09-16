package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.*;
public class JobDao extends  AbstractJpaDao<Long, Job>{
    public JobDao() {
        super(Job.class);
    }


}
