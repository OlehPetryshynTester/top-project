package tests.api.models.args.users;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {

    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
}
