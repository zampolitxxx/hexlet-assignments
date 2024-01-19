package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter

public class UsersPage {
    private String header;
    private List<User> users;
}
// END
