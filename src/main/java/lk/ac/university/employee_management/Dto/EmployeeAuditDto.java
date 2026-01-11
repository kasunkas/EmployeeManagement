package lk.ac.university.employee_management.Dto;


import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeAuditDto {
    private Integer auditId;
    private Integer empId;
    private String actionType;
    private LocalDateTime actionTime;
    private String details;
}
