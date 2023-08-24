package winho.springapi.service;

import org.springframework.stereotype.Component;
import winho.springapi.entity.User;
import winho.springapi.exception.NotFoundException;
import winho.springapi.model.dto.UserDto;
import winho.springapi.model.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private static ArrayList<User> users = new ArrayList<User>();
    static {
        users.add(new User(1,"boss a", "boss.a@gmail.com", "0912345678", "boss-a.img", "123456"));
        users.add(new User(2,"boss b", "boss.b@gmail.com", "0912345678", "boss-b.img", "123456"));
        users.add(new User(3,"boss c", "boss.c@gmail.com", "0912345678", "boss-c.img", "123456"));
        users.add(new User(4,"boss d", "boss.d@gmail.com", "0912345678", "boss-d.img", "123456"));
        users.add(new User(5,"boss e", "boss.e@gmail.com", "0912345678", "boss-e.img", "123456"));
    }

    @Override
    public List<UserDto> getUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users){
            result.add(UserMapper.userDto(user));
        }
        return result;
    }

    @Override
    public UserDto findId(int id) {
        for (User user:users){
            if (user.getId() == id){
                return UserMapper.userDto(user);
            }
        }
        throw new NotFoundException(" Not Found in System");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user: users){
            if (user.getName().contains(keyword)){
                result.add(UserMapper.userDto(user));
            }
        }

        return result;
    }
}
