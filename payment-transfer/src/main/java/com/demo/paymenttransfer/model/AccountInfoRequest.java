package com.demo.paymenttransfer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String accountId;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal balance;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 3)
    private String currency;
}
