package com.rakovets.course.datapersistence.solution.jpa.dal.dao;

import com.google.protobuf.Message;
import com.rakovets.course.datapersistence.solution.jpa.dal.entity.MessageEntity;
import com.rakovets.course.datapersistence.solution.jpa.util.DynamicEntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MessageDao extends Dao<MessageEntity>{
    @Override
    public void save(MessageEntity messageEntity) {
        EntityManager entityManager = DynamicEntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(messageEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public MessageEntity findMessageEntityById(int id) {
        EntityManager entityManager = DynamicEntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        MessageEntity foundMessageEntity = entityManager.find(MessageEntity.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return foundMessageEntity;
    }
}
