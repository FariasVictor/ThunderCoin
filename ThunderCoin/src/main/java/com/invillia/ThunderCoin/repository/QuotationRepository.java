package com.invillia.ThunderCoin.repository;

import com.invillia.ThunderCoin.domain.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {

    List<Quotation> findAllByOrderByIdAsc();
    Quotation findTopByOrderByIdDesc();

}
