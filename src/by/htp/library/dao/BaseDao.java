package by.htp.library.dao;

import java.util.List;

import by.htp.library.model.BaseEntity;



public interface BaseDao<T extends BaseEntity> {

	boolean create(T entity);

	T read(int id);

	List<T> readAll();

	boolean update(T entiy);

	boolean delete(T entity);
}
