package com.sit.commons;

import java.util.List;

public interface CommonDao<T> {
	T findById(Long id);
	
	default List<T> findAll() {
		return null;
	}
	
	default T add(T obj) {
		return null;
	}
	
	default T update(T obj) {
		return null;
	}
	
	default void delete(T obj) {
		
	}
}
