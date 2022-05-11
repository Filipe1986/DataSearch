package com.filipe.datasearch.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "S_USER")
public class User {
	
    @Id
    private String id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "password")
    private String password;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "createdAt", nullable = true)
    private Date created;

    @Temporal(TemporalType.DATE)
    @Column(name = "updatedAt", nullable = true)
    private Date updated;

    @PrePersist
    protected void onCreate() {
    	created = Calendar.getInstance().getTime();
    }

    @PreUpdate
    protected void onUpdate() {
    	updated = Calendar.getInstance().getTime();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	   
}
