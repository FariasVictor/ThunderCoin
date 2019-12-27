package com.invillia.ThunderCoin.service;

import com.invillia.ThunderCoin.domain.request.QuotationRequest;
import com.invillia.ThunderCoin.domain.request.QuotationUpdateRequest;
import com.invillia.ThunderCoin.domain.response.QuotationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuotationService {
    public Long save(QuotationRequest quotationRequest);
    public List<QuotationResponse> findAll();
    public QuotationResponse findById(Long id);
    public void update(QuotationUpdateRequest quotationUpdateRequest, final Long id);
    public void delete(Long id);
}
