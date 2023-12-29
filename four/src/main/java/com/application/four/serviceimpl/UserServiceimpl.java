package com.application.four.serviceimpl;

import com.application.four.entity.Users;
import com.application.four.payload.UserDto;
import com.application.four.repository.UserRepository;
import com.application.four.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = userDtoToEntity(userDto);
        Users savedUser = userRepository.save(user);
        return entityToUserDto(savedUser);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }


    private Users userDtoToEntity(UserDto userDto) {
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return users;
    }

    private UserDto entityToUserDto(Users savedUser) {
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setEmail(savedUser.getEmail());
        userDto.setName(savedUser.getName());
        userDto.setPassword(savedUser.getPassword());

        return userDto;
    }
}
