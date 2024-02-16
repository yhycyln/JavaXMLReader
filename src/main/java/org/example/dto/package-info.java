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