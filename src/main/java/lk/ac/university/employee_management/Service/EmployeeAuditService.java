package lk.ac.university.employee_management.Service;


import lk.ac.university.employee_management.Dto.EmployeeAuditDto;
import java.util.List;

public interface EmployeeAuditService {
    EmployeeAuditDto create(EmployeeAuditDto dto);
    EmployeeAuditDto update(Integer auditId, EmployeeAuditDto dto);
    void delete(Integer auditId);
    EmployeeAuditDto getById(Integer auditId);
    List<EmployeeAuditDto> getAll();
}
