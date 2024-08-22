package com.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Scheme")
public class Scheme extends BaseEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @OneToMany(mappedBy = "scheme")
    @JsonManagedReference
    private List<Benefit> benefits;

    @OneToMany(mappedBy = "scheme")
    @JsonManagedReference
    private List<SchemeCriteria> schemeCriteria;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Benefit> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public List<SchemeCriteria> getSchemeCriteria() {
        return schemeCriteria;
    }

    public void setSchemeCriteria(List<SchemeCriteria> schemeCriteria) {
        this.schemeCriteria = schemeCriteria;
    }
}
