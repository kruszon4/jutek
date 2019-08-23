package com.jutek.JUTEK.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bills")
@Builder
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private Long addDate;
    private String person;
    private String billValue;

}
