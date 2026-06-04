package com.pizzeria.esperadigital.repository;

import com.pizzeria.esperadigital.entity.ColaVirtual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaVirtualRepository extends JpaRepository<ColaVirtual, Long> {
}
