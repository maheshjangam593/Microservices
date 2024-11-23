package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoService {

	static List<User> users = new ArrayList();
	private static int count = 3;

	static {
		users.add(new User(1, "mahesh", new Date()));
		users.add(new User(2, "raj", new Date()));
		users.add(new User(3, "mahesh", new Date()));
	}

	public List<User> FindAll() {
		return users;
	}

	public User Save(User user) {
		if (user.getId() <= 3) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(int id) {
		/*
		 * for (User user : users) { if (user.getId() == id) { return user; } }
		 */
		Iterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
