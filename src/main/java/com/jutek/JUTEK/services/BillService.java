package com.jutek.JUTEK.services;

import com.jutek.JUTEK.domain.model.BillEntity;
import com.jutek.JUTEK.domain.repositories.BillRepository;
import com.jutek.JUTEK.domain.repositories.TransactionRepository;
import com.jutek.JUTEK.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void saveBill(Bill bill) {
        billRepository.save(mapper(bill));
    }


    public List<Bill> getAllBills(BillEntity bill) {
        return billRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());
    }

    private BillEntity mapper(Bill source) {
        return BillEntity.builder()
                .billValue(source.getBillValue())
                .person(source.getPerson())
                .build();
    }

    private Bill mapper(BillEntity source) {
        return Bill.builder()
                .billValue(source.getBillValue())
                .person(source.getPerson())
                .build();
    }


}
