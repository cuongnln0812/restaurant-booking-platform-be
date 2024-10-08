package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.uservoucher.ApplyUserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherRequest;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface VoucherService {
    VoucherResponse createVoucher(VoucherRequest request);
    VoucherResponse updateVoucher(VoucherRequest request);
    Page<VoucherResponse> viewAllVoucher(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams);
    VoucherResponse getVoucherDetail(Long id);
    VoucherResponse deleteVoucher(Long id);
    List<UserVoucherResponse> viewAllVoucherOfUser();
    UserVoucherResponse addVoucherForUser(Long id);
    Float applyVoucher(Long voucherId, Float totalPrice);
    List<ApplyUserVoucherResponse> getUsableVoucherListOfUser(Float totalPrice);
}
