package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import org.springframework.data.domain.Page;

public interface PaymentHistoryService extends BaseService<PaymentHistoryRequest, PaymentHistoryResponse> {
    Page<PaymentHistoryResponse> getAllByLocationId(Long locationId, int pageNo, int pageSize, String sortBy, String sortDir);


}
