package v2.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private Integer idUser;
    private String login;
    private String password;
    private String role;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreate;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String mail;
}
