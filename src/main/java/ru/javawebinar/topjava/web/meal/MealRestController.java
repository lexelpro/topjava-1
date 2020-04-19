package ru.javawebinar.topjava.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;

@RestController
@RequestMapping(MealRestController.REST_URL)
public class MealRestController extends AbstractMealController {
	public static final String REST_URL = "/rest/meals";

	@Override
	@GetMapping("/{id}")
	public Meal get(@PathVariable int id) {
		return super.get(id);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		super.delete(id);
	}

	@Override
	@GetMapping()
	public List<MealTo> getAll() {
		return super.getAll();
	}

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Meal create(@RequestBody Meal meal) {
		return super.create(meal);
	}

	@Override
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Meal meal, @PathVariable int id) {
		super.update(meal, id);
	}

	@GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MealTo> getBetween(HttpServletRequest request, Model model) {
		LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
		LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
		LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
		LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
		return super.getBetween(startDate, startTime, endDate, endTime);
	}
}
