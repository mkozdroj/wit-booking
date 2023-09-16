package pl.sdacademy.booking.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.util.DatabaseUtil;

import java.util.List;

public class EventRepositoryImpl implements EventRepository{

    private EntityManager entityManager;

    public EventRepositoryImpl() {
        entityManager = DatabaseUtil.getEntityManager();
    }

    @Override
    public List<EventEntity> findEvents() {
        TypedQuery<EventEntity> query = entityManager
                .createQuery("SELECT event FROM EventEntity event", EventEntity.class);
        return query.getResultList();
    }

}
