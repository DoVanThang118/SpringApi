package winho.springapi.service;

import org.springframework.stereotype.Service;
import winho.springapi.entity.User;
import winho.springapi.model.dto.UserDto;
import winho.springapi.model.request.CreateUserReq;
import winho.springapi.model.request.UpdateUserReq;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getUser();
    public UserDto findId(int id);
    public List<UserDto> searchUser(String keyword);
    public UserDto createUser(CreateUserReq req);
    public UserDto updateUser(UpdateUserReq req, int id);
    public void deleteUser(int id);
}
