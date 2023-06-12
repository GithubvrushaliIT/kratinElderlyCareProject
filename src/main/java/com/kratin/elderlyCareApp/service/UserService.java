package com.kratin.elderlyCareApp.service;

import java.util.List;

import com.kratin.elderlyCareApp.entity.User;
import com.kratin.elderlyCareApp.payload.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userid);
	

}
