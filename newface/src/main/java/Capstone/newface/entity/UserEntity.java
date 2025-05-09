package Capstone.newface.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "User_mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "User_pwd", nullable = false)
    private String pwd;
}
