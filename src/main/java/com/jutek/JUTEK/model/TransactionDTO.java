package com.jutek.JUTEK.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private List<Bill> bills = new ArrayList<>();

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }



}
