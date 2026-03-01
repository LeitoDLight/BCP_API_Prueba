package com.example.BCPAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locals")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localId;

    private String name;
    private String floor;


    @OneToOne(mappedBy = "local")
    private Manager manager;
    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }

    //Generate Getters and Setter
    public Local() {}
    public Long getLocalId() { return localId; }
    public void setLocalId(Long localId) { this.localId = localId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFloor() { return floor; }
    public void setFloor(String floor) { this.floor = floor; }
}
