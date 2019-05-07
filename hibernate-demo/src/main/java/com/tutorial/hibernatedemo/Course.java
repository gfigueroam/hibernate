package com.tutorial.hibernatedemo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Course") // the name the table is called
@NamedQueries(
        value = {
                @NamedQuery(name = "query_get_all_courses",query = "Select c from Course c"),
                @NamedQuery(name = "query_get_all_100_courses",query = "Select c from Course c where fullname like '%test%'")
        }
)

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="fullname", nullable = false)
    private String name;

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @UpdateTimestamp
    @Column(name= "created_date")
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    @Column(name="last_updated_date")
    private LocalDateTime createdDate;


    protected Course(){}

    public Course(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
