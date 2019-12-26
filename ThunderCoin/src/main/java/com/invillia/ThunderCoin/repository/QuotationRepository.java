package com.invillia.ThunderCoin.repository;

import com.invillia.ThunderCoin.domain.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {
}
