package com.hibernate.hibernateFilter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableJpaRepositories(basePackages = {"com.hibernate.hibernateFilter"}, repositoryBaseClass = BaseRepositoryImpl.class)
@EntityScan(basePackages = {"com.hibernate.hibernateFilter"})
public class JpaConfiguration {

}
