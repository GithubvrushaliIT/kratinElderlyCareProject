package com.kratin.elderlyCareApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratin.elderlyCareApp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
