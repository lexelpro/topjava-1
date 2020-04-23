package ru.javawebinar.topjava.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.web.meal.MealAjaxController.REST_URL;

@RestController
@RequestMapping(REST_URL)
public class MealAjaxController extends AbstractMealController {
	static final String REST_URL = "/ajax/profile/meals";

	@Override
	@GetMapping("/{id}")
	public Meal get(@PathVariable int id) {
		return super.get(id);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		super.delete(id);
	}

	@Override
	@GetMapping
	public List<MealTo> getAll() {
		return super.getAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Meal create(
			@RequestParam Integer id,
			@RequestParam(name = "dateTime") String dateTimeString,
			@RequestParam String description,
			@RequestParam Integer calories) {
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
		Meal meal = new Meal(dateTime, description, calories);
		return super.create(meal);
	}

	@PutMapping(value = "/{userId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(
			@RequestParam Integer id,
			@RequestParam(name = "dateTime") String dateTimeString,
			@RequestParam String description,
			@RequestParam Integer calories,
			@PathVariable int userId) {
		Meal meal = new Meal(id, LocalDateTime.parse(dateTimeString), description, calories);
		super.update(meal, userId);
	}

	@Override
	public List<MealTo> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
		return super.getBetween(startDate, startTime, endDate, endTime);
	}
}
