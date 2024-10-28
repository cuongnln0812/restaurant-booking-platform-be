package com.foodbookingplatform.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.entities.MonthlyCommissionPayment;
import com.foodbookingplatform.models.enums.PaymentStatus;
import com.foodbookingplatform.models.payload.dto.paymenthistory.LocationRevenueReportPaginationResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.LocationRevenueReportResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.MonthlyRevenueResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.RecentPaymentResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import vn.payos.type.Webhook;
import vn.payos.type.WebhookData;

public interface PaymentHistoryService extends BaseService<PaymentHistoryRequest, PaymentHistoryResponse> {
    Page<PaymentHistoryResponse> getAllByLocationId(Long locationId, int pageNo, int pageSize, String sortBy, String sortDir);

    ObjectNode payOsTransferHandler(ObjectNode body) throws JsonProcessingException, IllegalArgumentException;

    MonthlyCommissionPayment getMonthlyPaymentOfLocationAdminByMonthAndYear(int month, int year);

    double getTotalRevenueOfSystem(int month, int year);

    List<MonthlyRevenueResponse> getTotalRevenueOfSystemForYear(int year);

    List<RecentPaymentResponse> getRecentPaymentHistories(PaymentStatus status, int top);

    LocationRevenueReportPaginationResponse getLocationRevenueReports(int pageNo, int pageSize, String sortBy, String sortDir, int month, int year);
}
