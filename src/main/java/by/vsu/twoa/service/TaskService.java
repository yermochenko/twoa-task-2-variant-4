package by.vsu.twoa.service;

import by.vsu.twoa.dao.DaoException;
import by.vsu.twoa.dao.TaskDao;
import by.vsu.twoa.dao.UserDao;
import by.vsu.twoa.domain.Task;
import by.vsu.twoa.domain.User;
import by.vsu.twoa.geometry.*;
import by.vsu.twoa.service.exception.ServiceException;
import by.vsu.twoa.service.exception.TaskNotExistsException;
import by.vsu.twoa.service.exception.UserNotExistsException;

import java.util.Date;
import java.util.List;

public class TaskService {
	private TaskDao taskDao;
	private UserDao userDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Task> findByOwner(Integer id) throws ServiceException {
		try {
			User owner = userDao.read(id).orElseThrow(() -> new UserNotExistsException(id));
			List<Task> tasks = taskDao.readByOwner(id);
			tasks.forEach(task -> task.setOwner(owner));
			return tasks;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Task findById(Integer id) throws ServiceException {
		try {
			Task task = taskDao.read(id).orElseThrow(() -> new TaskNotExistsException(id));
			task.setOwner(userDao.read(task.getOwner().getId()).orElseThrow(() -> new UserNotExistsException(id)));
			Point a = task.getVertex1();
			Point b = task.getVertex2();
			Vector v = new Vector(a, b);
			double radius = v.length();
			v = v.rotate(90);
			Point c1 = v.put(b);
			Point d1 = v.put(a);
			v = v.multiply(-1);
			Point c2 = v.put(b);
			Point d2 = v.put(a);
			task.setSquareVariant1(new Square(a, b, c1, d1));
			task.setInscribedCircleVariant1(new Circle(new Segment(a, c1).middle(), radius));
			task.setSquareVariant2(new Square(a, b, c2, d2));
			task.setInscribedCircleVariant2(new Circle(new Segment(a, c2).middle(), radius));
			return task;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Integer save(Task task) throws ServiceException {
		try {
			if(task.getId() == null) {
				task.setCreated(new Date(0));
				return taskDao.create(task);
			} else {
				throw new RuntimeException("Update operation not implemented yet");
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}
