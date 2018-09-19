package com.azeus.exam.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    private Long id;
    private String name;
    private Long quantity;
    private java.sql.Date created;
    private java.sql.Date updated;
    private String madeIn;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "QUANTITY")
    public Long getQuantity() {
        return quantity;
    }


    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "CREATED")
    public java.sql.Date getCreated() {
        return created;
    }

    public void setCreated(java.sql.Date created) {
        this.created = created;
    }

    @Basic
    @Column(name = "UPDATED")
    public java.sql.Date getUpdated() {
        return updated;
    }

    public void setUpdated(java.sql.Date updated) {
        this.updated = updated;
    }

    @Basic
    @Column(name = "MADE_IN ")
    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String made_in) {
        this.madeIn = made_in;
    }
}
