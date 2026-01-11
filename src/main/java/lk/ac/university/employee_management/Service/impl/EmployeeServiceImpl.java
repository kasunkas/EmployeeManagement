package lk.ac.university.employee_management.Service.impl;

import lk.ac.university.employee_management.Dto.*;
import lk.ac.university.employee_management.Entity.Department;
import lk.ac.university.employee_management.Entity.Employee;
import lk.ac.university.employee_management.Repository.DepartmentRepository;
import lk.ac.university.employee_management.Repository.EmployeeRepository;
import lk.ac.university.employee_management.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public EmployeeResponseDto create(EmployeeCreateDto dto) {
        Department dept = departmentRepository.findById(dto.getDeptId())
                .orElseThrow(() -> new RuntimeException("Department not found: " + dto.getDeptId()));

        Employee e = new Employee();
        e.setEmpId(dto.getEmpId());
        e.setEmpName(dto.getEmpName());
        e.setDepartment(dept);
        e.setSalary(dto.getSalary());
        e.setEmail(dto.getEmail());
        e.setCity(dto.getCity());

        Employee saved = employeeRepository.save(e);
        return toResponse(saved);
    }

    @Override
    public EmployeeResponseDto getById(Integer empId) {
        return employeeRepository.findById(empId)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + empId));
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public EmployeeResponseDto update(Integer empId, EmployeeUpdateDto dto) {
        Employee e = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + empId));

        if (dto.getDeptId() != null) {
            Department dept = departmentRepository.findById(dto.getDeptId())
                    .orElseThrow(() -> new RuntimeException("Department not found: " + dto.getDeptId()));
            e.setDepartment(dept);
        }

        if (dto.getEmpName() != null) e.setEmpName(dto.getEmpName());
        if (dto.getSalary() != null) e.setSalary(dto.getSalary());
        if (dto.getEmail() != null) e.setEmail(dto.getEmail());
        if (dto.getCity() != null) e.setCity(dto.getCity());

        Employee saved = employeeRepository.save(e);
        return toResponse(saved);
    }

    @Override
    @Transactional
    public void delete(Integer empId) {
        if (!employeeRepository.existsById(empId)) {
            throw new RuntimeException("Employee not found: " + empId);
        }
        employeeRepository.deleteById(empId);
    }

    private EmployeeResponseDto toResponse(Employee e) {
        Integer deptId = e.getDepartment() != null ? e.getDepartment().getDeptId() : null;
        String deptName = e.getDepartment() != null ? e.getDepartment().getDeptName() : null;

        return new EmployeeResponseDto(
                e.getEmpId(),
                e.getEmpName(),
                deptId,
                deptName,
                e.getSalary(),
                e.getEmail(),
                e.getCity()
        );
    }
}
