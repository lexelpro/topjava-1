package ru.javawebinar.topjava.service.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractTestUserService;
import ru.javawebinar.topjava.util.exception.NotFoundException;

@RunWith(SpringRunner.class)
@ActiveProfiles(Profiles.JDBC)
public class UserServiceJdbcTest extends AbstractTestUserService {
	@Override
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	@Test
	public void create() throws Exception {
		super.create();
	}

	@Override
	@Test(expected = DataAccessException.class)
	public void duplicateMailCreate() throws Exception {
		super.duplicateMailCreate();
	}

	@Override
	@Test
	public void delete() throws Exception {
		super.delete();
	}

	@Override
	@Test(expected = NotFoundException.class)
	public void deletedNotFound() throws Exception {
		super.deletedNotFound();
	}

	@Override
	@Test
	public void get() throws Exception {
		super.get();
	}

	@Override
	@Test(expected = NotFoundException.class)
	public void getNotFound() throws Exception {
		super.getNotFound();
	}

	@Override
	@Test
	public void getByEmail() throws Exception {
		super.getByEmail();
	}

	@Override
	@Test
	public void update() throws Exception {
		super.update();
	}

	@Override
	@Test
	public void getAll() throws Exception {
		super.getAll();
	}
}
