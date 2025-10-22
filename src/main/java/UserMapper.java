
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sport.sports_reservations.auth.model.UserDTO;


@Mapper
public interface UserMapper {

    @Select("SELECT id, username, password FROM users WHERE username = #{username}")
    Optional<UserDTO> findByUsername(String username);

    @Insert("INSERT INTO users(username, password, role) VALUES(#{username}, #{password}, #{role})")
    void insert(UserDTO user);
}
