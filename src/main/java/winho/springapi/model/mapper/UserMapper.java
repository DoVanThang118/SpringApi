package winho.springapi.model.mapper;

import winho.springapi.entity.User;
import winho.springapi.model.dto.UserDto;

public class UserMapper {
    public  static UserDto userDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());

        return tmp;
    }
}
