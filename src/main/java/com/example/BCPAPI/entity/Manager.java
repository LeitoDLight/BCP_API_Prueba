package com.example.BCPAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "local_id", referencedColumnName = "localId")
    private Local local;

    //Generate Getters and Setter
    public Manager() {}

    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Local getLocal() { return local; }
    public void setLocal(Local local) { this.local = local; }
}
