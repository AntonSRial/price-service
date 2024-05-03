package org.example.ddbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    /*@Query("SELECT p FROM PriceEntity p " +
            "WHERE (:productId is null OR p.productId = :productId) " +
            "AND (:brandId is null OR p.brandId = :brandId) " +
            "ORDER BY p.priority DESC, p.priceList ASC")
    List<PriceEntity> findApplicablePrices(@Param("productId") String productId,
                                           @Param("brandId") String brandId);*/
}
