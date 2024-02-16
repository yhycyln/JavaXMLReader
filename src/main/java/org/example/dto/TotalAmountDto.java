package org.example.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlType
public class TotalAmountDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 6510165782660271849L;

    @XmlElement(name = "ExchangeRate", required = true)
    private ExchangeRateDto exchangeRateDto;

    @XmlElement(name = "Amount", namespace = "urn:blablablabla:AnotherSpecificValue", required = true)
    private BigDecimal amount;

    @XmlElement(name = "Amount2", namespace = "urn:blablablabla:AnotherSpecificValue", required = true)
    private BigDecimal amountSecond;


    public TotalAmountDto() {
        super();
    }

    public ExchangeRateDto getExchangeRateDto() {
        return exchangeRateDto;
    }

    public void setExchangeRateDto(ExchangeRateDto exchangeRateDto) {
        this.exchangeRateDto = exchangeRateDto;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountSecond() {
        return amountSecond;
    }

    public void setAmountSecond(BigDecimal amountSecond) {
        this.amountSecond = amountSecond;
    }

    @Override
    public String toString() {
        return "TotalAmountDto{" +
                "exchangeRateDto=" + exchangeRateDto +
                ", amount=" + amount +
                ", amountSecond=" + amountSecond +
                '}';
    }
}
