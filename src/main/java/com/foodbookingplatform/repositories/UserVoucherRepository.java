package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.entities.UserVoucher;
import com.foodbookingplatform.models.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserVoucherRepository  extends JpaRepository<UserVoucher, Long> {
    UserVoucher findByVoucher(Voucher voucher);
    List<UserVoucher> findByUserUserName(String username);
    boolean existsByVoucher(Voucher voucher);
}
