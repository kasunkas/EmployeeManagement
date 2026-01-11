package lk.ac.university.employee_management.Controller;

import lk.ac.university.employee_management.Dto.EmployeeAuditDto;
import lk.ac.university.employee_management.Service.EmployeeAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-audits")
@RequiredArgsConstructor
public class EmployeeAuditController {

    private final EmployeeAuditService employeeAuditService;

    @PostMapping
    public EmployeeAuditDto create(@RequestBody EmployeeAuditDto dto) {
        return employeeAuditService.create(dto);
    }

    @PutMapping("/{id}")
    public EmployeeAuditDto update(@PathVariable("id") Integer id, @RequestBody EmployeeAuditDto dto) {
        return employeeAuditService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeAuditService.delete(id);
        return "Audit deleted: " + id;
    }

    @GetMapping("/{id}")
    public EmployeeAuditDto getById(@PathVariable("id") Integer id) {
        return employeeAuditService.getById(id);
    }

    @GetMapping
    public List<EmployeeAuditDto> getAll() {
        return employeeAuditService.getAll();
    }
}
