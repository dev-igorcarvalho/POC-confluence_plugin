/**
 * EMAILFUNC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osgiteste.api.soap.generated;

public class EMAILFUNC  implements java.io.Serializable {
    private String FUNC_EMAIL;

    public EMAILFUNC() {
    }

    public EMAILFUNC(
           String FUNC_EMAIL) {
           this.FUNC_EMAIL = FUNC_EMAIL;
    }


    /**
     * Gets the FUNC_EMAIL value for this EMAILFUNC.
     * 
     * @return FUNC_EMAIL
     */
    public String getFUNC_EMAIL() {
        return FUNC_EMAIL;
    }


    /**
     * Sets the FUNC_EMAIL value for this EMAILFUNC.
     * 
     * @param FUNC_EMAIL
     */
    public void setFUNC_EMAIL(String FUNC_EMAIL) {
        this.FUNC_EMAIL = FUNC_EMAIL;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EMAILFUNC)) return false;
        EMAILFUNC other = (EMAILFUNC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FUNC_EMAIL==null && other.getFUNC_EMAIL()==null) || 
             (this.FUNC_EMAIL!=null &&
              this.FUNC_EMAIL.equals(other.getFUNC_EMAIL())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFUNC_EMAIL() != null) {
            _hashCode += getFUNC_EMAIL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EMAILFUNC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://localhost", "EMAILFUNC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNC_EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNC_EMAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
