/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services.domains;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author behera
 */
@XmlRootElement
public class CreditCard implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String creditCardNo;
    private String cvv;
    private String nameOnCard;

    @XmlElement
    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @XmlElement
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @XmlElement
    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "creditCardNo=" + creditCardNo + ", cvv=" + cvv + ", nameOnCard=" + nameOnCard + '}';
    }
    
}
