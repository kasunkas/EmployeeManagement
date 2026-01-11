package lk.ac.university.employee_management.Controller;

import lk.ac.university.employee_management.Dto.DepartmentDto;
import lk.ac.university.employee_management.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentDto create(@RequestBody DepartmentDto dto) {
        return departmentService.create(dto);
    }

    @PutMapping("/{id}")
    public DepartmentDto update(@PathVariable("id") Integer id, @RequestBody DepartmentDto dto) {
        return departmentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        departmentService.delete(id);
        return "Department deleted: " + id;
    }

    @GetMapping("/{id}")
    public DepartmentDto getById(@PathVariable("id") Integer id) {
        return departmentService.getById(id);
    }

    @GetMapping
    public List<DepartmentDto> getAll() {
        return departmentService.getAll();
    }
}

