package lk.ac.university.employee_management.Dto;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeUpdateDto {
    private String empName;
    private Integer deptId;
    private BigDecimal salary;
    private String email;
    private String city;
}
