package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Unmarshaller;
import org.example.dto.XMLSampleFile;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class Main {
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
}