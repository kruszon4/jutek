package com.jutek.JUTEK.domain.repositories;

import com.jutek.JUTEK.domain.model.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {


}
