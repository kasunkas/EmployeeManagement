package lk.ac.university.employee_management.Repository;

import lk.ac.university.employee_management.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
