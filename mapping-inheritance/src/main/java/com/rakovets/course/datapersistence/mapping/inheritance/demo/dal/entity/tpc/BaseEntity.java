package com.rakovets.course.datapersistence.mapping.inheritance.demo.dal.entity.tpc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@ToString
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Getter
    @Setter
    private Long id;
}
