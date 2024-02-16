
How to read data from a structured XML file with multiple namespaces, JAVA 17 with Jakarta

dependencies (gradle example shown below)

    implementation(group = "jakarta.xml.bind", name = "jakarta.xml.bind-api", version = "4.0.1")
    implementation(group = "org.glassfish.jaxb", name = "jaxb-runtime", version = "4.0.4")


JAVA 17 program to read XML file from byte array;

    public XMLSampleFile getXMLFields(byte[] fileByteArray) {
        XMLSampleFile file;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new String(fileByteArray, StandardCharsets.UTF_8).getBytes());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLSampleFile.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader someSource = factory.createXMLEventReader(inputStream);
            file = jaxbUnmarshaller
                    .unmarshal(someSource, XMLSampleFile.class)
                    .getValue();
			
			System.out.println(file);
            inputStream.close();
        } catch (JAXBException | XMLStreamException e) {
            // Log and throw error
        } catch (IOException e) {
            // Log and throw error
        }
		return file;
    }

JAVA 17 program to read XML file from directory;


    public static void main(String[] args) {

        XMLSampleFile file;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLSampleFile.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<XMLSampleFile> jaxbFileElement = jaxbUnmarshaller
                    .unmarshal(new StreamSource(new File("./src/main//resources/sample.xml")), XMLSampleFile.class);
            file = jaxbFileElement.getValue();

            System.out.println(file);
        } catch (Exception e) {
            // Log and throw error
            System.out.println(e);
        }
    }


In order to test the codes above a sample case created below...



Let's start with defining sample XML file.
XML file will be simplified but 4 different types of field access included along list and nested tags.


<Invoice xmlns="urn:blablablabla:lorem" xmlns:aaa="urn:blablablabla:SpecificValue" xmlns:bbb="urn:blablablabla:AnotherSpecificValue">
    <bbb:DOCUMENT_ID>8a978bn30284c7c9p-98x2n239-bx8230x23</bbb:DOCUMENT_ID>
    <bbb:CurrencyCode>TRY</bbb:CurrencyCode>
    <aaa:Reference>
        <bbb:ID>f232v346v2346-g4v23g6v</bbb:ID>
        <bbb:IssueDate>2025-02-02</bbb:IssueDate>
        <bbb:DocumentTypeCode>CUSTOMER_ID</bbb:DocumentTypeCode>
    </aaa:Reference>
    <aaa:Reference>
        <bbb:ID>1</bbb:ID>
        <bbb:IssueDate>2025-02-02</bbb:IssueDate>
        <bbb:DocumentTypeCode>DOCUMENT_TYPE</bbb:DocumentTypeCode>
        <bbb:DocumentType>XSL</bbb:DocumentType>
    </aaa:Reference>
    <aaa:Total>
		<aaa:ExchangeRate>
			<bbb:SourceCurrencyCode>TRY</bbb:SourceCurrencyCode>
			<bbb:Rate>1</bbb:Rate>
		</aaa:ExchangeRate>
        <bbb:Amount currencyID="TRY">222200.00</bbb:Amount>
        <bbb:Amount2 currencyID="TRY">955500.00</bbb:Amount2>
    </aaa:Total>
</Invoice>



--> There should be a package info file to define multiple namespaces, in the same directory with XML data classes.

--> package-info.java


@XmlSchema(
        namespace = "urn:blablablabla:SpecificValue",
        elementFormDefault= XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "", namespaceURI = "urn:blablablabla:lorem"),
                @XmlNs(prefix = "aaa", namespaceURI = "urn:blablablabla:SpecificValue"),
                @XmlNs(prefix = "bbb", namespaceURI = "urn:blablablabla:AnotherSpecificValue")
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
package org.example.dto;;

import jakarta.xml.bind.annotation.*;


****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************

--> Root Object to map XML


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
}

****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************

--> Reference tag list in XML -> ReferenceDto


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
}
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************

--> Total tag in XML -> TotalAmountDto


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
}


****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************
****************************************************************************************************************************************************

--> ExchangeRate tag in XML -> ExchangeRateDto

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
}


program output will be;

> Task :Main.main()
XMLSampleFile{documentId='8a978bn30284c7c9p-98x2n239-bx8230x23', currencyCode='TRY',
referenceList=[ReferenceDto{id='f232v346v2346-g4v23g6v', issueDate='2025-02-02', documentTypeCode='CUSTOMER_ID', documentType='null'},
ReferenceDto{id='1', issueDate='2025-02-02', documentTypeCode='DOCUMENT_TYPE', documentType='XSL'}],
totalAmountDto=TotalAmountDto{exchangeRateDto=ExchangeRateDto{sourceCurrencyCode='TRY', rate=1}, amount=222200.00, amountSecond=955500.00}}


