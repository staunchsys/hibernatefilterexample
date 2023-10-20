package com.hibernate.hibernateFilter;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@FilterDef(name = AbstractEntity.IS_NOT_DELETED_FILTER, parameters = {@ParamDef(name = "deleted", type = Boolean.class)})
@Filter(name = AbstractEntity.IS_NOT_DELETED_FILTER, condition = "deleted =:deleted")
@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractEntity {

    public static final String IS_NOT_DELETED_FILTER = "isNotDeletedFilter";

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "deleted", columnDefinition = "boolean default false", nullable = false)
    @Setter
    private boolean deleted = false;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String createdBy;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private String updatedBy;

//    @Column(nullable = false)
    private int version;
}
