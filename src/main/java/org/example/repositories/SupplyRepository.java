package org.example.repositories;

import org.example.models.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Репозиторий для работы с поставками
 */
@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {

   /**
    * Получить список поставок, дата которых находится в указанном диапазоне
    *
    * @param startDate начальная дата диапазона
    * @param endDate   конечная дата диапазона
    * @return список поставок в указанном диапазоне дат
    */
   @Query("SELECT s FROM Supply s " +
           "WHERE s.supplyDate BETWEEN :startDate AND :endDate")
   List<Supply> getSuppliesBySupplyDateIsBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
