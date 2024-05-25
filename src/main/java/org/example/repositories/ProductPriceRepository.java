package org.example.repositories;

import org.example.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Репозиторий для работы с ценами продуктов
 */
@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    /**
     * Найти цену продукта на указанную дату от указанного поставщика
     *
     * @param date        дата, на которую нужно найти цену
     * @param productId   идентификатор продукта
     * @param supplierId  идентификатор поставщика
     * @return цена продукта на указанную дату от указанного поставщика
     */
    @Query("SELECT p.price FROM ProductPrice p " +
            "WHERE p.productId = :productId " +
            "AND p.supplierId = :supplierId " +
            "AND :date BETWEEN p.startDate AND p.endDate")
    double findPrice(@Param("date") Date date,
                     @Param("productId") Long productId,
                     @Param("supplierId") Long supplierId);
}
