package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.model.UserEntity;
import com.example.repo.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public UserEntity createUser(UserDto userDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		StringBuffer sb = new StringBuffer();
		sb.append(userDto.getPassword());
		userEntity.setEncryptedPassword(sb.reverse().toString());
		return userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
}
