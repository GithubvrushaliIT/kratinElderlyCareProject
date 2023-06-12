package com.kratin.elderlyCareApp.service.iml;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratin.elderlyCareApp.entity.User;
import com.kratin.elderlyCareApp.exception.ResourceNotFoundException;
import com.kratin.elderlyCareApp.payload.UserDto;
import com.kratin.elderlyCareApp.repository.UserRepo;
import com.kratin.elderlyCareApp.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto)
	{
		User user=this.dtoToUser(userDto);
	   User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		User updateUser=this.userRepo.save(user);
		UserDto userdto1=this.userToDto(updateUser);
		return userdto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		List<UserDto> userdtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userdtos;
	}

	@Override
	public void deleteUser(Integer userid) {
		User user=this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User","id",userid));
         this.userRepo.delete(user);
	}
	private User dtoToUser(UserDto userDto)
	{
		User user=this.modelMapper.map(userDto, User.class);
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setFirstName(userDto.getFirstName());
//		user.setLastName(userDto.getLastName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	public UserDto userToDto(User user)
	{
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setFirstName(user.getFirstName());
//		userDto.setLastName(user.getLastName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
		
	}

}
