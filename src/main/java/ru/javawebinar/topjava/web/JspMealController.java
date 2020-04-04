package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class JspMealController {
	private static final Logger logger = getLogger(JspMealController.class);
	@Autowired
	private MealService mealService;

	@GetMapping("/meals")
	public String getMeals(Model model) {
		int userId = SecurityUtil.authUserId();
		List<Meal> meals = mealService.getAll(userId);
		model.addAttribute("meals", MealsUtil.getTos(meals, SecurityUtil.authUserCaloriesPerDay()));
		return "meals";
	}

	@GetMapping("/meals/update/{id}")
	public String getEditMealForm(@PathVariable Integer id, Model model) {
		logger.info("updateMeal id {}", id);
		Meal meal = mealService.get(id, SecurityUtil.authUserId());
		model.addAttribute("meal", meal);
		return "mealForm";
	}

	@PostMapping("/meals")
	public String setMeal(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		int userId = SecurityUtil.authUserId();
		Meal meal = new Meal(
				LocalDateTime.parse(request.getParameter("dateTime")),
				request.getParameter("description"),
				Integer.parseInt(request.getParameter("calories")));

		if (StringUtils.isEmpty(request.getParameter("id"))) {
			checkNew(meal);
			mealService.create(meal, userId);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			assureIdConsistent(meal, id);
			meal.setId(id);
			mealService.update(meal, userId);
		}
		return "redirect:/meals";
	}

}
