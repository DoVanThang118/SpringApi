package winho.springapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import winho.springapi.entity.User;
import winho.springapi.exception.DuplicateRecordException;
import winho.springapi.exception.InternalServerException;
import winho.springapi.exception.NotFoundException;
import winho.springapi.model.dto.UserDto;
import winho.springapi.model.mapper.UserMapper;
import winho.springapi.model.request.CreateUserReq;
import winho.springapi.model.request.UpdateUserReq;
import winho.springapi.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.userDto(user));
        }
        return result;
    }

    @Override
    public UserDto findId(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Not Found In System");
        }
        return UserMapper.userDto(user.get());
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.userDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new DuplicateRecordException("Email is already in use");
        }
        user = UserMapper.toUser(req);
        userRepository.save(user);

        return UserMapper.userDto(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Not Found User");
        }

        User update = UserMapper.toUser(req, id);
        try {
            userRepository.save(update);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InternalServerException("Database error. Can't update user");
        }

        return UserMapper.userDto(update);
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Not Found User");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new InternalServerException("Database error. Can't delete user");
        }
    }
}