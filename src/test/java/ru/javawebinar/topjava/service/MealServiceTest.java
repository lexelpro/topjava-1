package ru.javawebinar.topjava.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
@ContextConfiguration({
		"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

	static {
		// Only for postgres driver logging
		// It uses java.util.logging and logged via jul-to-slf4j bridge
		SLF4JBridgeHandler.install();
	}
	@Autowired
	private MealService service;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() {
    }

	@Test(expected = NotFoundException.class)
	public void getAlienFood() {
    	service.get(100003, UserTestData.ADMIN_ID);
	}

    @Test
    public void delete() {
    }

    @Test
    public void getBetweenHalfOpen() {
    }

    @Test
    public void getAll() {
		List<Meal> meals = service.getAll(UserTestData.USER_ID);
		assertThat(meals.size()).isGreaterThan(0);
	}

    @Test
    public void update() {
    }

    @Test
    public void create() {
		Meal meal = MealTestData.getNew();
		Meal created = service.create(meal, UserTestData.USER_ID);
		Integer newId = created.getId();
		meal.setId(newId);
		assertThat(newId).isNotNull();
	}
}
