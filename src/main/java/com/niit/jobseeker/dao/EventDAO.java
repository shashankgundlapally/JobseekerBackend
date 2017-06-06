package com.niit.jobseeker.dao;

import java.util.List;

import com.niit.jobseeker.model.Event;

public interface EventDAO {

	public boolean saveOrUpdate(Event event);

	public boolean delete(Event event);

	public Event get(int id);

	public List<Event> list();

}
