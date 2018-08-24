package com.example.demo.services;

import java.util.List;
import com.example.demo.dal.dao.User;

public interface UserService {
	public User findUserByName(String name);
	public List<User> findAll();
}