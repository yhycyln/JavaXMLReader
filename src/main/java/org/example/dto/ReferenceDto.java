package org.example.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serial;
import java.io.Serializable;

@XmlType(namespace = "urn:blablablabla:AnotherSpecificValue")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 72130843294809890L;

    @XmlElement(name = "ID", required = true)
    private String id;

    @XmlElement(name = "IssueDate", required = true)
    private String issueDate;

    @XmlElement(name = "DocumentTypeCode", required = true)
    private String documentTypeCode;

    @XmlElement(name = "DocumentType", required = true)
    private String documentType;

    public ReferenceDto() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "ReferenceDto{" +
                "id='" + id + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", documentTypeCode='" + documentTypeCode + '\'' +
                ", documentType='" + documentType + '\'' +
                '}';
    }
}
