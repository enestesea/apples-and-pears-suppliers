package org.example.repositories;


import org.example.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Репозиторий для работы с поставщиками
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}