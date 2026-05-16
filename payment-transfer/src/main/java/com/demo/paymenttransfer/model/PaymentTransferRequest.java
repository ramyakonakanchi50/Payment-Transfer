package com.demo.paymenttransfer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransferRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String senderId;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String receiverId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String currency;
}
