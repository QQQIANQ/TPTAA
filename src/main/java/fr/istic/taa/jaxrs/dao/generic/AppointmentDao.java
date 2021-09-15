package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.metier.*;

public class AppointmentDao extends AbstractJpaDao<Long, Appointment> {

    public AppointmentDao() {
        super(Appointment.class);
    }

}
