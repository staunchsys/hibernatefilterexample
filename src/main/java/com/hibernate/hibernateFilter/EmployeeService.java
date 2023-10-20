package com.hibernate.hibernateFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getList(HibernateFilter filter) {
        employeeRepository.enableFilter(AbstractEntity.IS_NOT_DELETED_FILTER);
        if (filter.isIncludeDeleted()) {
            employeeRepository.disableFilter(AbstractEntity.IS_NOT_DELETED_FILTER);
        }
        return employeeRepository.findAll();
    }
}
