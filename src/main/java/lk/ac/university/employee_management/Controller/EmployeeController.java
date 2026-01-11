package lk.ac.university.employee_management.Controller;

import lk.ac.university.employee_management.Dto.*;
import lk.ac.university.employee_management.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto create(@RequestBody EmployeeCreateDto dto) {
        return employeeService.create(dto);
    }

    @GetMapping
    public List<EmployeeResponseDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getById(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto update(@PathVariable("id") Integer id, @RequestBody EmployeeUpdateDto dto) {
        return employeeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "Employee deleted: " + id;
    }
}
