package com.jutek.JUTEK.domain.repositories;

import com.jutek.JUTEK.domain.model.TransactionEntity;
import com.jutek.JUTEK.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
