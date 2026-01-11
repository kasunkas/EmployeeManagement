package lk.ac.university.employee_management.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_name", nullable = false, length = 100)
    private String deptName;
}
