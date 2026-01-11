package lk.ac.university.employee_management.Service.impl;

import lk.ac.university.employee_management.Dto.EmployeeAuditDto;
import lk.ac.university.employee_management.Entity.EmployeeAudit;
import lk.ac.university.employee_management.Repository.EmployeeAuditRepository;
import lk.ac.university.employee_management.Service.EmployeeAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeAuditServiceImpl implements EmployeeAuditService {

    private final EmployeeAuditRepository employeeAuditRepository;

    @Override
    public EmployeeAuditDto create(EmployeeAuditDto dto) {
        EmployeeAudit audit = new EmployeeAudit();
        audit.setEmpId(dto.getEmpId());
        audit.setActionType(dto.getActionType());
        audit.setActionTime(dto.getActionTime() != null ? dto.getActionTime() : LocalDateTime.now());
        audit.setDetails(dto.getDetails());

        EmployeeAudit saved = employeeAuditRepository.save(audit);
        return toDto(saved);
    }

    @Override
    public EmployeeAuditDto update(Integer auditId, EmployeeAuditDto dto) {
        EmployeeAudit audit = employeeAuditRepository.findById(auditId)
                .orElseThrow(() -> new RuntimeException("Audit not found: " + auditId));

        if (dto.getEmpId() != null) audit.setEmpId(dto.getEmpId());
        if (dto.getActionType() != null) audit.setActionType(dto.getActionType());
        if (dto.getActionTime() != null) audit.setActionTime(dto.getActionTime());
        if (dto.getDetails() != null) audit.setDetails(dto.getDetails());

        EmployeeAudit saved = employeeAuditRepository.save(audit);
        return toDto(saved);
    }

    @Override
    public void delete(Integer auditId) {
        if (!employeeAuditRepository.existsById(auditId)) {
            throw new RuntimeException("Audit not found: " + auditId);
        }
        employeeAuditRepository.deleteById(auditId);
    }

    @Override
    public EmployeeAuditDto getById(Integer auditId) {
        EmployeeAudit audit = employeeAuditRepository.findById(auditId)
                .orElseThrow(() -> new RuntimeException("Audit not found: " + auditId));
        return toDto(audit);
    }

    @Override
    public List<EmployeeAuditDto> getAll() {
        return employeeAuditRepository.findAll().stream().map(this::toDto).toList();
    }

    private EmployeeAuditDto toDto(EmployeeAudit a) {
        return new EmployeeAuditDto(
                a.getAuditId(),
                a.getEmpId(),
                a.getActionType(),
                a.getActionTime(),
                a.getDetails()
        );
    }
}
