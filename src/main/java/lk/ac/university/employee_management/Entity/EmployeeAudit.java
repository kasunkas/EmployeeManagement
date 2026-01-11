package lk.ac.university.employee_management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "employee_audit")
public class EmployeeAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Integer auditId;

    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "action_type", length = 20)
    private String actionType;

    @Column(name = "action_time")
    private LocalDateTime actionTime;

    @Column(name = "details", length = 255)
    private String details;
}
