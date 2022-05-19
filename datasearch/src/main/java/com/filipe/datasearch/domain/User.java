package com.filipe.datasearch.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "S_USER")
public class User {
	
    @Id
    private String id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "CREATED_AT", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Instant created;

    @Column(name = "UPDATED_AT", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Instant updated;

    @PrePersist
    protected void onCreate() {
    	created = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
    	updated = Instant.now();
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

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getUpdated() {
		return updated;
	}

	public void setUpdated(Instant updated) {
		this.updated = updated;
	}
	   
}
