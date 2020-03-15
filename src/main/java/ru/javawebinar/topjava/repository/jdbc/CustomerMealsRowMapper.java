package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ru.javawebinar.topjava.model.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMealsRowMapper implements RowMapper<Meal> {
	@Override
	public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Meal(rs.getInt("ID"), rs.getTimestamp("date_time").toLocalDateTime(),rs.getString("description"), rs.getInt("calories"));
	}
}
