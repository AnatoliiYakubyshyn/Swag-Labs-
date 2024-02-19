package com.zebrunner.carina.demo.db.mappers;

import com.zebrunner.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
