package org.example.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Invoice", namespace = "urn:blablablabla:lorem")
public class XMLSampleFile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1890274981273817234L;

    @XmlElement(name = "DOCUMENT_ID", namespace = "urn:blablablabla:AnotherSpecificValue", required = true)
    private String documentId;

    @XmlElement(name = "CurrencyCode", namespace = "urn:blablablabla:AnotherSpecificValue", required = true)
    private String currencyCode;


    @XmlElement(name = "Reference")
    private List<ReferenceDto> referenceList;


    @XmlElement(name = "Total")
    private TotalAmountDto totalAmountDto;


    public XMLSampleFile() {
        super();
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<ReferenceDto> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(List<ReferenceDto> referenceList) {
        this.referenceList = referenceList;
    }

    public TotalAmountDto getTotalAmountDto() {
        return totalAmountDto;
    }

    public void setTotalAmountDto(TotalAmountDto totalAmountDto) {
        this.totalAmountDto = totalAmountDto;
    }

    @Override
    public String toString() {
        return "XMLSampleFile{" +
                "documentId='" + documentId + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", referenceList=" + referenceList +
                ", totalAmountDto=" + totalAmountDto +
                '}';
    }
}
