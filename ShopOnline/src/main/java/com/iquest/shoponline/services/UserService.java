package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.model.User;
import com.iquest.shoponline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
            return Optional.of(new UserDto(model.getName(), model.getEmail(), model.getPassword()));
        }
    }

    public void create(UserDto dto) {
        User model = new User(dto.getName(), dto.getEmail(), dto.getPassword());
        repository.save(model);
    }

    public UserDto create(User user) {
        return new UserDto(user.getName(), user.getEmail(), user.getPassword());
    }

    public void update(UserDto userDto) {
        User model = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword());
        repository.save(model);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public UserDto findOne(Integer id) {
        User user = repository.findOne(id);
        return new UserDto(user.getName(), user.getEmail(), user.getOrders());
    }

    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        for (User user : repository.findAll())
            users.add(new UserDto(user.getName(), user.getEmail(), user.getOrders()));
        return users;
    }
}
