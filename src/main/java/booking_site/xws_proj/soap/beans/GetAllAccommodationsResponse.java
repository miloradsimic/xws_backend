//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.05 at 07:17:05 AM CEST 
//


package booking_site.xws_proj.soap.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Accommodations" type="{http://beans.soap.xws_proj.booking_site}Accommodations"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accommodations"
})
@XmlRootElement(name = "GetAllAccommodationsResponse")
public class GetAllAccommodationsResponse {

    @XmlElement(name = "Accommodations", required = true)
    protected Accommodations accommodations;

    /**
     * Gets the value of the accommodations property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodations }
     *     
     */
    public Accommodations getAccommodations() {
        return accommodations;
    }

    /**
     * Sets the value of the accommodations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodations }
     *     
     */
    public void setAccommodations(Accommodations value) {
        this.accommodations = value;
    }

}
