package lk.ac.university.employee_management.Service;

import lk.ac.university.employee_management.Dto.EmployeeCreateDto;
import lk.ac.university.employee_management.Dto.EmployeeResponseDto;
import lk.ac.university.employee_management.Dto.EmployeeUpdateDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto create(EmployeeCreateDto dto);
    EmployeeResponseDto getById(Integer empId);
    List<EmployeeResponseDto> getAll();
    EmployeeResponseDto update(Integer empId, EmployeeUpdateDto dto);
    void delete(Integer empId);
}
