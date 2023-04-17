package v2.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer idUser;
    private String login;
    private String password;
    private String role;
    private Date dateCreate;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String mail;
}
