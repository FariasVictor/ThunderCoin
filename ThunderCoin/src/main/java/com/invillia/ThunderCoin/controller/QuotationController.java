package com.invillia.ThunderCoin.controller;

import com.invillia.ThunderCoin.domain.Quotation;
import com.invillia.ThunderCoin.domain.request.QuotationRequest;
import com.invillia.ThunderCoin.domain.request.QuotationUpdateRequest;
import com.invillia.ThunderCoin.domain.response.QuotationResponse;
import com.invillia.ThunderCoin.service.QuotationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class QuotationController {

    private QuotationServiceImpl quotationServiceImpl;

    @Autowired
    public QuotationController(QuotationServiceImpl quotationServiceImpl) {
        this.quotationServiceImpl = quotationServiceImpl;
    }

    @PostMapping("/")
    public HttpEntity<?> save(@Valid @RequestBody QuotationRequest quotationRequest){
        Long id=quotationServiceImpl.save(quotationRequest);
        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path(("/{id}")).build(id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/")
    public List<QuotationResponse> findAll(){
        return quotationServiceImpl.findAll();
//        return quotationServiceImpl.findMaxId();
    }


    @GetMapping("/{id}")
    public QuotationResponse findById(@PathVariable Long id){
        return quotationServiceImpl.findById(id);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@Valid @RequestBody QuotationUpdateRequest quotationUpdateRequest, @PathVariable final Long id){
        quotationServiceImpl.update(quotationUpdateRequest, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable final Long id){
        quotationServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

}
