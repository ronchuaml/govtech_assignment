package com.demo.assignment.entity;

import com.demo.assignment.enums.EmploymentStatus;
import com.demo.assignment.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheme_criteria")
public class SchemeCriteria extends BaseEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheme_id", nullable = false)
    @JsonBackReference
    private Scheme scheme;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_status")
    private EmploymentStatus employmentStatus;

    @Column(name = "has_children")
    private Boolean hasChildren;
    @Column(name = "children_min_age")
    private Integer childrenMinAge;

    @Column(name = "children_max_age")
    private Integer childrenMaxAge;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }


    public Integer getChildrenMinAge() {
        return childrenMinAge;
    }

    public void setChildrenMinAge(Integer childrenMinAge) {
        this.childrenMinAge = childrenMinAge;
    }

    public Integer getChildrenMaxAge() {
        return childrenMaxAge;
    }

    public void setChildrenMaxAge(Integer childrenMaxAge) {
        this.childrenMaxAge = childrenMaxAge;
    }
}