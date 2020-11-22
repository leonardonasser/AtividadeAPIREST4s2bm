package com.ads.programacaoII.persistence;


import java.util.Objects;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id
    private String id;

    public BaseEntity() {
        id = UUID.randomUUID().toString();
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }    

    public String getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o.getClass().equals(this.getClass()))) {
            return false;
        }
        BaseEntity baseEntity = (BaseEntity) o;
        return Objects.equals(id, baseEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    
}