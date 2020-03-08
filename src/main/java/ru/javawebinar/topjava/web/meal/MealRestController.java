package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;

import java.util.List;

@Controller
public class MealRestController {

	private final MealService service;

	public MealRestController(MealService service) {
		this.service = service;
	}

	public List<MealTo> getByUserId(int authUserId) {
		return service.getByUserId(authUserId);
	}

}
