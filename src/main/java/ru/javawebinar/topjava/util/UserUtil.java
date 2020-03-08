package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserUtil {

	public static final int ADMIN = 1;
	public static final int USER = 2;

	public static final List<User> users = Arrays.asList(
			new User(1, "admin", "admin@topjava.ru", "admin", Role.ROLE_ADMIN),
			new User(2, "user1", "user1@topjava.ru", "user1", Role.ROLE_USER)
	);

	public static List<User> getUsers(){
		return users.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
	}
}
