package ru.javawebinar.topjava.web;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class SecurityUtil {
	private static final Logger log = getLogger(SecurityUtil.class);
	private static int authUserId = 1;
    public static int getAuthUserId() {
        return authUserId;
    }
    public static void setAuthUserId(int id) {
    	log.info("setAuthUserId id {}", id);
    	authUserId = id;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}
