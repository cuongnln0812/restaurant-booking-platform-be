package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.entities.UserVoucher;
import com.foodbookingplatform.models.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserVoucherRepository  extends JpaRepository<UserVoucher, Long> {
    UserVoucher findByVoucher(Voucher voucher);
    Optional<UserVoucher> findByVoucher_IdAndUserUserName(Long voucherId, String userName);
    List<UserVoucher> findByUserUserName(String username);
    boolean existsByVoucher(Voucher voucher);
}
