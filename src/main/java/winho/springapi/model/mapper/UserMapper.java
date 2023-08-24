package winho.springapi.model.mapper;

import org.mindrot.jbcrypt.BCrypt;
import winho.springapi.entity.User;
import winho.springapi.model.dto.UserDto;
import winho.springapi.model.request.CreateUserReq;
import winho.springapi.model.request.UpdateUserReq;

public class UserMapper {
    public  static UserDto userDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());

        return tmp;
    }

    public static User toUser(CreateUserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        // Hash password using BCrypt
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);
        user.setRole("USER");

        return user;
    }

    public static User toUser(UpdateUserReq req, int id) {
        User user = new User();
        user.setId(id);
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setPhone(req.getPhone());
        // Hash password using BCrypt
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);

        return user;
    }
}
