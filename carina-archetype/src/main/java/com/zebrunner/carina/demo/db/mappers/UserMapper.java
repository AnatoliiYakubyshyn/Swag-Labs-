package com.zebrunner.carina.demo.db.mappers;

import com.zebrunner.carina.demo.db.models.User;

public interface UserMapper {

	void create(User user);

	User findById(long id);

	User findByUserName(String username);

	void update(User user);

	void delete(User user);
}
