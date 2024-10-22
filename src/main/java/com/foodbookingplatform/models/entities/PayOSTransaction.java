package com.foodbookingplatform.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payos_transaction")
public class PayOSTransaction extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long orderCode;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private String description;
    @Column(name = "account_number",nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private String reference;
    @Column(name = "transaction_date_time", nullable = false)
    private String transactionDateTime;
    @Column(nullable = false)
    private String currency;
    @Column(name = "payment_link_id", nullable = false)
    private String paymentLinkId;
    @Column(nullable = false)
    private String code;
    @Column(name = "transaction_desc", nullable = false)
    private String desc;
    @Column(name = "counter_account_bank_id")
    private String counterAccountBankId;
    @Column(name = "counter_account_bank_name")
    private String counterAccountBankName;
    @Column(name = "counter_account_name")
    private String counterAccountName;
    @Column(name = "counter_account_number")
    private String counterAccountNumber;
    @Column(name = "virtual_account_name")
    private String virtualAccountName;
    @Column(name = "virtual_account_number")
    private String virtualAccountNumber;
    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;
}
