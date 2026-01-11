package lk.ac.university.employee_management.Service.impl;

import lk.ac.university.employee_management.Dto.DepartmentDto;
import lk.ac.university.employee_management.Entity.Department;
import lk.ac.university.employee_management.Repository.DepartmentRepository;
import lk.ac.university.employee_management.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto create(DepartmentDto dto) {
        Department d = new Department(dto.getDeptId(), dto.getDeptName());
        Department saved = departmentRepository.save(d);
        return new DepartmentDto(saved.getDeptId(), saved.getDeptName());
    }

    @Override
    public DepartmentDto update(Integer deptId, DepartmentDto dto) {
        Department d = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found: " + deptId));

        d.setDeptName(dto.getDeptName());
        Department saved = departmentRepository.save(d);
        return new DepartmentDto(saved.getDeptId(), saved.getDeptName());
    }

    @Override
    public void delete(Integer deptId) {
        if (!departmentRepository.existsById(deptId)) {
            throw new RuntimeException("Department not found: " + deptId);
        }
        departmentRepository.deleteById(deptId);
    }

    @Override
    public DepartmentDto getById(Integer deptId) {
        Department d = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found: " +deptId));
        return new DepartmentDto(d.getDeptId(), d.getDeptName());
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository.findAll().stream()
                .map(d -> new DepartmentDto(d.getDeptId(), d.getDeptName()))
                .toList();
    }
}