package winho.springapi.service;

import org.springframework.stereotype.Service;
import winho.springapi.entity.User;
import winho.springapi.model.dto.UserDto;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getUser();
    public UserDto findId(int id);
}
