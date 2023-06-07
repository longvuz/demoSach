package NguyenLongVu.demoSach.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50, message = "Họ tên phải dưới 50 ký tự")
    @NotBlank
    @Column(name="name", length = 50, nullable = false)
    private String name;
    @Size(max = 250, message = "Mô tả phải dưới 250 ký tự")
    @Column(name = "description", length = 250)
    private String description;
    @ManyToMany(mappedBy = "roles")
        private Set<User> users = new HashSet<>();
}
