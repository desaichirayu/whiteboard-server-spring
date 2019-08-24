package com.example.cs5610su19javaservercdesai.utils;

import com.example.cs5610su19javaservercdesai.models.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSearchUtils {

	private Map<String, Object> fieldValueMap;

	public UserSearchUtils() {
		super();
		this.fieldValueMap = new HashMap<>();
	}

	public void initializeCriteria(User user) throws IllegalAccessException {
		Class<? extends Object> c = user.getClass();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (name != "id") {
				field.setAccessible(true);
				Object value = field.get(user);
				if (value instanceof String) {
					if (!((String) value).equals("")) {
						this.fieldValueMap.put(name, value);
					}
				} else {
					this.fieldValueMap.put(name, value);
				}

			}
		}
	}

	public List<User> doSearch(List<User> data, User queryUser) throws NoSuchFieldException, IllegalAccessException {
		List<User> results = new ArrayList<>();
		for (User dataUser : data) {
			if (compareObjects(queryUser, dataUser)) {
				results.add(dataUser);
			}
		}
		return results;
	}

	private boolean compareObjects(User queryUser, User dataUser) throws NoSuchFieldException, IllegalAccessException {
		boolean match = true;
		for (String fieldName : this.fieldValueMap.keySet()) {
			Field queryField = queryUser.getClass().getDeclaredField(fieldName);
			Field dataField = dataUser.getClass().getDeclaredField(fieldName);
			queryField.setAccessible(true);
			dataField.setAccessible(true);
			Object queryValue = queryField.get(queryUser);
			Object dataValue = dataField.get(dataUser);
			if (queryValue instanceof String && dataValue instanceof String) {
				match = match && ((String) dataValue).toLowerCase().contains(((String) queryValue).toLowerCase());
			} else {
				match = match && queryValue.equals(dataValue);
			}
		}
		return match;
	}
}
