package ru.javawebinar.topjava.web.meal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.AbstractControllerTest;
import ru.javawebinar.topjava.web.json.JsonUtil;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.topjava.MealTestData.MEAL1;
import static ru.javawebinar.topjava.MealTestData.MEAL_MATCHER;
import static ru.javawebinar.topjava.UserTestData.USER_ID;
import static ru.javawebinar.topjava.web.meal.MealRestController.REST_URL;

class MealRestControllerTest extends AbstractControllerTest {

	@Autowired
	private MealService service;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void get() throws Exception {
		perform(MockMvcRequestBuilders.get(REST_URL + "/" + MEAL1.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MEAL_MATCHER.contentJson(MEAL1));
	}

	@Test
	void delete() throws Exception {
		perform(MockMvcRequestBuilders.delete(REST_URL + "/" + MEAL1.getId()))
				.andDo(print())
				.andExpect(status().isNoContent());
		assertThrows(NotFoundException.class, () -> service.get(MEAL1.getId(), USER_ID));
	}

	@Test
	void getAll() throws Exception {
		perform(MockMvcRequestBuilders.get(REST_URL))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	void create() throws Exception {
		Meal meal = new Meal(LocalDateTime.now(), "test meal", 1000);
		perform(MockMvcRequestBuilders.post(REST_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.writeValue(meal)))
				.andExpect(status().isCreated())
				.andExpect(result -> assertThat(JsonUtil.readValue(result.getResponse().getContentAsString(), Meal.class))
						.isEqualToIgnoringGivenFields(meal, "id"))
				.andExpect(result -> assertThat(JsonUtil.readValue(result.getResponse().getContentAsString(), Meal.class).getId()).isNotNull());
	}

	@Test
	void update() throws Exception {
		Meal meal = service.get(MEAL1.getId(), USER_ID);
		meal.setCalories(300);
		perform(MockMvcRequestBuilders.put(REST_URL + "/" + meal.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.writeValue(meal)))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

	@Test
	void getBetween() {
	}
}
