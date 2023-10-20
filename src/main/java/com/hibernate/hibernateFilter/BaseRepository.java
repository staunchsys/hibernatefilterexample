package com.hibernate.hibernateFilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    void disableFilter(String filtername);

    void enableFilter(String filtername);
}
