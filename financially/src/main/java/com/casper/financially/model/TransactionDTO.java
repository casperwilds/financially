package com.casper.financially.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TransactionDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String institution;

    private Double amount;

    private Double balance;

    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private String rawDescription;

    @Size(max = 255)
    private String category;

    @Size(max = 255)
    private String subcategory;

    private LocalDate transactionDate;

}
