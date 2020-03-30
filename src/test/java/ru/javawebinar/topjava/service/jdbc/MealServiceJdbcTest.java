package ru.javawebinar.topjava.service.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractTestMealService;

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(Profiles.DATAJPA)
public class MealServiceJdbcTest extends AbstractTestMealService {

	@Override
	@Test
	public void delete() throws Exception {
		super.delete();
	}

	@Override
	@Test
	public void deleteNotFound() throws Exception {
		super.deleteNotFound();
	}

	@Override
	@Test
	public void deleteNotOwn() throws Exception {
		super.deleteNotOwn();
	}

	@Override
	@Test
	public void create() throws Exception {
		super.create();
	}

	@Override
	@Test
	public void get() throws Exception {
		super.get();
	}

	@Override
	@Test
	public void getNotFound() throws Exception {
		super.getNotFound();
	}

	@Override
	@Test
	public void getNotOwn() throws Exception {
		super.getNotOwn();
	}

	@Override
	@Test
	public void update() throws Exception {
		super.update();
	}

	@Override
	@Test
	public void updateNotFound() throws Exception {
		super.updateNotFound();
	}

	@Override
	@Test
	public void getAll() throws Exception {
		super.getAll();
	}

	@Override
	@Test
	public void getBetweenInclusive() throws Exception {
		super.getBetweenInclusive();
	}

	@Override
	@Test
	public void getBetweenWithNullDates() throws Exception {
		super.getBetweenWithNullDates();
	}
}
