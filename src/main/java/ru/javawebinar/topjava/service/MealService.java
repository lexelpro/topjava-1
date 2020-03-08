package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.Collection;
import java.util.List;

@Service
public class MealService {

	private final MealRepository repository;

	public MealService(MealRepository repository) {
		this.repository = repository;
	}

	public List<MealTo> getByUserId(int authUserId) {
		Collection<Meal> meals = repository.getAllByUserId(authUserId);
		return MealsUtil.getTos(meals, SecurityUtil.authUserCaloriesPerDay());
	}
}
