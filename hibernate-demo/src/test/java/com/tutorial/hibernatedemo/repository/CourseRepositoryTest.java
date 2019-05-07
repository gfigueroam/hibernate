package com.tutorial.hibernatedemo.repository;

import com.tutorial.hibernatedemo.Course;
import com.tutorial.hibernatedemo.HibernateDemoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	@Test
	public void findById_basic() {
		Course course = repository.findById(1001L);
		Assert.assertEquals("jpa test course1",course.getName());

	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(1002L);
		Assert.assertNull(repository.findById(1002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = repository.findById(1001L);
		Assert.assertEquals("jpa test course1",course.getName());

		course.setName("This is a test");

		repository.save(course);
		Assert.assertEquals("This is a test",course.getName());
	}

	@Test
	@DirtiesContext
	public void playing_em_basic(){
		repository.playingWithEM();
	}

	@Test
	@DirtiesContext
	public void playing_dates_basic(){
		repository.playWithTimestamps();
	}



}
