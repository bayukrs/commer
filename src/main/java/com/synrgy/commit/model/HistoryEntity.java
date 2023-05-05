package com.synrgy.commit.model;

import com.synrgy.commit.model.oauth.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_history_entity")
@Getter
@Setter
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @Column(name = "link_payment")
    private String linkPayment;
    @Column(name = "is_pay")
    private Boolean payed;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @CreationTimestamp
    @Column(name = "added_date")
    private Date addedDate;
    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate;
}
