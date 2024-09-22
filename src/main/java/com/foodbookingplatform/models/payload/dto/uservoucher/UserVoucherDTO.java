package com.foodbookingplatform.models.payload.dto.uservoucher;

import com.foodbookingplatform.models.entities.UserVoucher;
import com.foodbookingplatform.models.entities.Voucher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVoucherDTO {
    private Voucher voucher;
    private UserVoucher userVoucher;
}
