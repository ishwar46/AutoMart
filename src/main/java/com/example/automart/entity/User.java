package  com.example.automart.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username", unique = true)
    @NotEmpty
    @NotNull
    private String username;

    @Column(name = "email", unique = true)
    @Email
    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private String passwordConfirm;

    @Column(name = "fullName")
    private String fullName;


    @Column(name = "city")
    private String city;


    @Column(name = "balance")
    private BigDecimal balance;

}
