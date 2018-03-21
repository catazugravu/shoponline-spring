package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.model.User;
import com.iquest.shoponline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Optional<UserDto> getByEmailAndHash(String email, String passHash) {
        User model = repository.findDistinctByEmailAndPassword(email, passHash);
        if (model == null) {
            return Optional.empty();
        } else {
            UserDto userDto = new UserDto(model.getName(), model.getEmail(), model.getPassword());
            userDto.setId(model.getId());
            return Optional.of(userDto);
        }
    }

    public void create(UserDto dto) {
        User model = new User(dto.getName(), dto.getEmail(), dto.getPassword());
        repository.save(model);
    }
}
