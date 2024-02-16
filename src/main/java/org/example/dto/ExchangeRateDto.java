package org.example.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlType(namespace = "urn:blablablabla:AnotherSpecificValue")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRateDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 6124248444331892472L;

    @XmlElement(name = "SourceCurrencyCode", required = true)
    private String sourceCurrencyCode;

    @XmlElement(name = "Rate", required = true)
    private BigDecimal rate;


    public ExchangeRateDto() {
        super();
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ExchangeRateDto{" +
                "sourceCurrencyCode='" + sourceCurrencyCode + '\'' +
                ", rate=" + rate +
                '}';
    }
}
