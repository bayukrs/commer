package com.synrgy.commit.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private Long price;
    @Column(name = "description", columnDefinition = "TEXT")
    private String desc;
    private String image;
    @Column(name = "is_sold")
    private Boolean sold;
    @CreationTimestamp
    @Column(name = "added_date")
    private Date addedDate;
    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate;

    @OneToOne(mappedBy = "product")
    private HistoryEntity historyEntity;
}
