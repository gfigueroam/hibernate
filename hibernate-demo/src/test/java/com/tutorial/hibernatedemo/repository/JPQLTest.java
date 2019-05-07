package com.tutorial.hibernatedemo.repository;

import com.tutorial.hibernatedemo.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void query_basic() {
			List<Course> courses = em.createQuery("Select c from Course c").getResultList();
			logger.info("selec from result = {}", courses);

	}

	@Test
	public void query_2_basic() {
		List<Course> courses = em.createNamedQuery("query_get_all_courses").getResultList();
		logger.info("selec from result = {}", courses);

	}

	@Test
	public void query_where_basic() {
		List<Course> courses = em.createNamedQuery("query_get_all_100_courses").getResultList();
		logger.info("selec from result = {}", courses);

	}

	@Test
	public void typedquery_basic() {
		List<Course> courses = em.createQuery("Select c from Course c",Course.class).getResultList();
		logger.info("selec from result = {}", courses);

	}

	@Test
	public void where_basic() {
		List<Course> courses = em.createQuery("Select c from Course c where name like '%test%'",Course.class).getResultList();
		logger.info("selec from result = {}", courses);

	}

}
