package lk.ac.university.employee_management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "employees",
        uniqueConstraints = {@UniqueConstraint(name = "uq_email", columnNames = "email")})
public class Employee {

    @Id
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_name", nullable = false, length = 100)
    private String empName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", foreignKey = @ForeignKey(name = "fk_dept"))
    private Department department;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "city", length = 50)
    private String city; // DB default will apply if not provided
}
