
package org.lle.biblio.batch.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NotFoundException", targetNamespace = "http://service.biblio.lle.org/")
public class NotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NotFoundException_Exception(String message, NotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NotFoundException_Exception(String message, NotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.lle.biblio.batch.generated.NotFoundException
     */
    public NotFoundException getFaultInfo() {
        return faultInfo;
    }

}
