package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.*;

public class AppointmentDao extends AbstractJpaDao<Long, Appointment> {

    public AppointmentDao() {
        super(Appointment.class);
    }

}
