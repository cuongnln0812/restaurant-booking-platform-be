package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.entities.Voucher;
import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    boolean existsByCode(String code);
    @Query("SELECT new com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherDTO(v, uv) FROM Voucher v JOIN v.userVouchers uv WHERE uv.user = :user")
    List<UserVoucherDTO> findVouchersWithUserDataByUser(@Param("user") User user);
}
