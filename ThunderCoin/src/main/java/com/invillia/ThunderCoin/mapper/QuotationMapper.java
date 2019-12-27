package com.invillia.ThunderCoin.mapper;

import com.invillia.ThunderCoin.domain.Quotation;
import com.invillia.ThunderCoin.domain.request.QuotationRequest;
import com.invillia.ThunderCoin.domain.request.QuotationUpdateRequest;
import com.invillia.ThunderCoin.domain.response.QuotationResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuotationMapper {
    public Quotation quotationRequestToQuotation(QuotationRequest quotationRequest){
        Quotation quotation= new Quotation();
        quotation.setValue(quotationRequest.getValue());
        quotation.setActive(quotationRequest.getActive());
        return quotation;
    }

    public List<QuotationResponse> quotationToQuotationResponse(List<Quotation> quotations){
        ArrayList<QuotationResponse> quotationResponses= new ArrayList<QuotationResponse>();
        for (Quotation quotation:quotations) {
            quotationResponses.add(quotationToQuotationResponse(quotation));
        }
        return quotationResponses;
    }

    public QuotationResponse quotationToQuotationResponse(Quotation quotation){
        QuotationResponse quotationResponse= new QuotationResponse();

        quotationResponse.setId(quotation.getId());
        quotationResponse.setValue(quotation.getValue());
        quotationResponse.setActive(quotation.getActive());
        quotationResponse.setCreatedAt(quotation.getCreatedAt());

        return quotationResponse;
    }

    public void quotationUpdateRequestToQuotation(QuotationUpdateRequest quotationUpdateRequest, Quotation quotation) {
        quotation.setValue(quotationUpdateRequest.getValue());
    }
}
