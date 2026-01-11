package lk.ac.university.employee_management.Service;

import lk.ac.university.employee_management.Dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(DepartmentDto dto);
    DepartmentDto update(Integer deptId, DepartmentDto dto);
    void delete(Integer deptId);
    DepartmentDto getById(Integer deptId);
    List<DepartmentDto> getAll();
}
