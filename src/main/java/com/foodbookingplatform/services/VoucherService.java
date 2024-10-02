package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherRequest;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VoucherService {
    VoucherResponse createVoucher(VoucherRequest request);
    VoucherResponse updateVoucher(VoucherRequest request);
    Page<VoucherResponse> viewAllVoucher(int pageNo, int pageSize, String sortBy, String sortDir);
    VoucherResponse getVoucherDetail(Long id);
    VoucherResponse deleteVoucher(Long id);
    List<UserVoucherResponse> viewAllVoucherOfUser();
    UserVoucherResponse addVoucherForUser(Long id);
}
