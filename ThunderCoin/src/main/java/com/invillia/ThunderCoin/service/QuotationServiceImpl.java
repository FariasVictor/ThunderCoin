package com.invillia.ThunderCoin.service;

import com.invillia.ThunderCoin.domain.Quotation;
import com.invillia.ThunderCoin.domain.request.QuotationRequest;
import com.invillia.ThunderCoin.domain.response.QuotationResponse;
import com.invillia.ThunderCoin.exception.EntityNotFoundException;
import com.invillia.ThunderCoin.mapper.QuotationMapper;
import com.invillia.ThunderCoin.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationServiceImpl implements QuotationService {

    private QuotationRepository quotationRepository;
    private QuotationMapper quotationMapper;

    @Autowired
    public QuotationServiceImpl(final QuotationRepository quotationRepository, final QuotationMapper quotationMapper) {
        this.quotationRepository = quotationRepository;
        this.quotationMapper = quotationMapper;
    }

    @Override
    public Long save(final QuotationRequest quotationRequest) {
        Quotation quotation=quotationMapper.quotationRequestToQuotation(quotationRequest);
        Long id= quotationRepository.save(quotation).getId();
        return id;
    }

    @Override
    public List<QuotationResponse> findAll() {
        List<Quotation> quotations= quotationRepository.findAll();
        return quotationMapper.quotationToQuotationResponse(quotations);
    }

    @Override
    public QuotationResponse findById(final Long id) {
        Quotation quotation= quotationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Quotation "));
        return quotationMapper.quotationToQuotationResponse(quotation);
    }

    @Override
    public void update(QuotationRequest quotationRequest, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
