package lk.ac.university.employee_management.Repository;

import lk.ac.university.employee_management.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
