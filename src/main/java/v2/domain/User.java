//package v2.domain;
//
//import io.micrometer.common.KeyValues;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import v2.logic.PasswordConverter;
//
//import java.util.Collection;
//
//@Data
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "Name")
//    private String username;
//
//    // указываем, что сохраняем зашифрованный пароль
//    @Column(name = "password")
//    @Convert(converter = PasswordConverter.class)
//    private String password;
//
//
//    // поля, методы getter/setter, конструкторы
//}