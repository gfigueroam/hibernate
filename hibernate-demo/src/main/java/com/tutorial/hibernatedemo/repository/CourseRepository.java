package com.tutorial.hibernatedemo.repository;

import com.tutorial.hibernatedemo.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;


    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public Course save(Course course){
        if(course.getId() == null){
            em.persist(course);
        }else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }


    public void playWithTimestamps(){
        Course course = findById(1001L);
        course.setName("test");

        logger.info("Lastupdated date = {}", course.getLastUpdatedDate());
        logger.info("created date = {}", course.getCreatedDate());

    }

    public void playingWithEM(){
        Course course1 = new Course("test course 1");
        em.persist(course1);
        em.flush();

        course1.setName("test course 1 update");

        em.refresh(course1);
        em.clear();
        Course course2 = new Course("test course 2");
        em.persist(course2);
        em.flush();
        em.detach(course2);

        course2.setName("test course 2 update");
        em.flush();

    }
}
