package NguyenLongVu.demoSach.entity;

import NguyenLongVu.demoSach.validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank
    @Size(max = 50, message = "Tên tài khoản phải dưới 50 kí tự")
    @ValidUsername
    private String username;
    @Column(name = "password", length = 250, nullable = false)
    @NotBlank
    private String password;
    @Column(name = "email", length = 50)
    @Size(max = 50, message = "Email phải dưới 50 kí tự")
    private String email;
    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 50, message = "Họ và tên phải dưới 50 kí tự")
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}
