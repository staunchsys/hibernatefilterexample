package com.hibernate.hibernateFilter;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, UUID> {
}
