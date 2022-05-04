/**
 * ANIVERSARIANTE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osgiteste.api.soap.generated;

public class ANIVERSARIANTE  implements java.io.Serializable {
    private String FUNCIONARIO_AREA;

    private String FUNCIONARIO_EMAIL;

    private String FUNCIONARIO_FILIAL;

    private String FUNCIONARIO_FOTO;

    private String FUNCIONARIO_ID;

    private String FUNCIONARIO_NOME;

    private String FUNCIONARIO_NOME_COMPLETO;

    private String FUNCIONARIO_NUCLEO;

    public ANIVERSARIANTE() {
    }

    public ANIVERSARIANTE(
           String FUNCIONARIO_AREA,
           String FUNCIONARIO_EMAIL,
           String FUNCIONARIO_FILIAL,
           String FUNCIONARIO_FOTO,
           String FUNCIONARIO_ID,
           String FUNCIONARIO_NOME,
           String FUNCIONARIO_NOME_COMPLETO,
           String FUNCIONARIO_NUCLEO) {
           this.FUNCIONARIO_AREA = FUNCIONARIO_AREA;
           this.FUNCIONARIO_EMAIL = FUNCIONARIO_EMAIL;
           this.FUNCIONARIO_FILIAL = FUNCIONARIO_FILIAL;
           this.FUNCIONARIO_FOTO = FUNCIONARIO_FOTO;
           this.FUNCIONARIO_ID = FUNCIONARIO_ID;
           this.FUNCIONARIO_NOME = FUNCIONARIO_NOME;
           this.FUNCIONARIO_NOME_COMPLETO = FUNCIONARIO_NOME_COMPLETO;
           this.FUNCIONARIO_NUCLEO = FUNCIONARIO_NUCLEO;
    }


    /**
     * Gets the FUNCIONARIO_AREA value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_AREA
     */
    public String getFUNCIONARIO_AREA() {
        return FUNCIONARIO_AREA;
    }


    /**
     * Sets the FUNCIONARIO_AREA value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_AREA
     */
    public void setFUNCIONARIO_AREA(String FUNCIONARIO_AREA) {
        this.FUNCIONARIO_AREA = FUNCIONARIO_AREA;
    }


    /**
     * Gets the FUNCIONARIO_EMAIL value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_EMAIL
     */
    public String getFUNCIONARIO_EMAIL() {
        return FUNCIONARIO_EMAIL;
    }


    /**
     * Sets the FUNCIONARIO_EMAIL value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_EMAIL
     */
    public void setFUNCIONARIO_EMAIL(String FUNCIONARIO_EMAIL) {
        this.FUNCIONARIO_EMAIL = FUNCIONARIO_EMAIL;
    }


    /**
     * Gets the FUNCIONARIO_FILIAL value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_FILIAL
     */
    public String getFUNCIONARIO_FILIAL() {
        return FUNCIONARIO_FILIAL;
    }


    /**
     * Sets the FUNCIONARIO_FILIAL value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_FILIAL
     */
    public void setFUNCIONARIO_FILIAL(String FUNCIONARIO_FILIAL) {
        this.FUNCIONARIO_FILIAL = FUNCIONARIO_FILIAL;
    }


    /**
     * Gets the FUNCIONARIO_FOTO value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_FOTO
     */
    public String getFUNCIONARIO_FOTO() {
        return FUNCIONARIO_FOTO;
    }


    /**
     * Sets the FUNCIONARIO_FOTO value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_FOTO
     */
    public void setFUNCIONARIO_FOTO(String FUNCIONARIO_FOTO) {
        this.FUNCIONARIO_FOTO = FUNCIONARIO_FOTO;
    }


    /**
     * Gets the FUNCIONARIO_ID value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_ID
     */
    public String getFUNCIONARIO_ID() {
        return FUNCIONARIO_ID;
    }


    /**
     * Sets the FUNCIONARIO_ID value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_ID
     */
    public void setFUNCIONARIO_ID(String FUNCIONARIO_ID) {
        this.FUNCIONARIO_ID = FUNCIONARIO_ID;
    }


    /**
     * Gets the FUNCIONARIO_NOME value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_NOME
     */
    public String getFUNCIONARIO_NOME() {
        return FUNCIONARIO_NOME;
    }


    /**
     * Sets the FUNCIONARIO_NOME value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_NOME
     */
    public void setFUNCIONARIO_NOME(String FUNCIONARIO_NOME) {
        this.FUNCIONARIO_NOME = FUNCIONARIO_NOME;
    }


    /**
     * Gets the FUNCIONARIO_NOME_COMPLETO value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_NOME_COMPLETO
     */
    public String getFUNCIONARIO_NOME_COMPLETO() {
        return FUNCIONARIO_NOME_COMPLETO;
    }


    /**
     * Sets the FUNCIONARIO_NOME_COMPLETO value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_NOME_COMPLETO
     */
    public void setFUNCIONARIO_NOME_COMPLETO(String FUNCIONARIO_NOME_COMPLETO) {
        this.FUNCIONARIO_NOME_COMPLETO = FUNCIONARIO_NOME_COMPLETO;
    }


    /**
     * Gets the FUNCIONARIO_NUCLEO value for this ANIVERSARIANTE.
     * 
     * @return FUNCIONARIO_NUCLEO
     */
    public String getFUNCIONARIO_NUCLEO() {
        return FUNCIONARIO_NUCLEO;
    }


    /**
     * Sets the FUNCIONARIO_NUCLEO value for this ANIVERSARIANTE.
     * 
     * @param FUNCIONARIO_NUCLEO
     */
    public void setFUNCIONARIO_NUCLEO(String FUNCIONARIO_NUCLEO) {
        this.FUNCIONARIO_NUCLEO = FUNCIONARIO_NUCLEO;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ANIVERSARIANTE)) return false;
        ANIVERSARIANTE other = (ANIVERSARIANTE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FUNCIONARIO_AREA==null && other.getFUNCIONARIO_AREA()==null) || 
             (this.FUNCIONARIO_AREA!=null &&
              this.FUNCIONARIO_AREA.equals(other.getFUNCIONARIO_AREA()))) &&
            ((this.FUNCIONARIO_EMAIL==null && other.getFUNCIONARIO_EMAIL()==null) || 
             (this.FUNCIONARIO_EMAIL!=null &&
              this.FUNCIONARIO_EMAIL.equals(other.getFUNCIONARIO_EMAIL()))) &&
            ((this.FUNCIONARIO_FILIAL==null && other.getFUNCIONARIO_FILIAL()==null) || 
             (this.FUNCIONARIO_FILIAL!=null &&
              this.FUNCIONARIO_FILIAL.equals(other.getFUNCIONARIO_FILIAL()))) &&
            ((this.FUNCIONARIO_FOTO==null && other.getFUNCIONARIO_FOTO()==null) || 
             (this.FUNCIONARIO_FOTO!=null &&
              this.FUNCIONARIO_FOTO.equals(other.getFUNCIONARIO_FOTO()))) &&
            ((this.FUNCIONARIO_ID==null && other.getFUNCIONARIO_ID()==null) || 
             (this.FUNCIONARIO_ID!=null &&
              this.FUNCIONARIO_ID.equals(other.getFUNCIONARIO_ID()))) &&
            ((this.FUNCIONARIO_NOME==null && other.getFUNCIONARIO_NOME()==null) || 
             (this.FUNCIONARIO_NOME!=null &&
              this.FUNCIONARIO_NOME.equals(other.getFUNCIONARIO_NOME()))) &&
            ((this.FUNCIONARIO_NOME_COMPLETO==null && other.getFUNCIONARIO_NOME_COMPLETO()==null) || 
             (this.FUNCIONARIO_NOME_COMPLETO!=null &&
              this.FUNCIONARIO_NOME_COMPLETO.equals(other.getFUNCIONARIO_NOME_COMPLETO()))) &&
            ((this.FUNCIONARIO_NUCLEO==null && other.getFUNCIONARIO_NUCLEO()==null) || 
             (this.FUNCIONARIO_NUCLEO!=null &&
              this.FUNCIONARIO_NUCLEO.equals(other.getFUNCIONARIO_NUCLEO())));
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
        if (getFUNCIONARIO_AREA() != null) {
            _hashCode += getFUNCIONARIO_AREA().hashCode();
        }
        if (getFUNCIONARIO_EMAIL() != null) {
            _hashCode += getFUNCIONARIO_EMAIL().hashCode();
        }
        if (getFUNCIONARIO_FILIAL() != null) {
            _hashCode += getFUNCIONARIO_FILIAL().hashCode();
        }
        if (getFUNCIONARIO_FOTO() != null) {
            _hashCode += getFUNCIONARIO_FOTO().hashCode();
        }
        if (getFUNCIONARIO_ID() != null) {
            _hashCode += getFUNCIONARIO_ID().hashCode();
        }
        if (getFUNCIONARIO_NOME() != null) {
            _hashCode += getFUNCIONARIO_NOME().hashCode();
        }
        if (getFUNCIONARIO_NOME_COMPLETO() != null) {
            _hashCode += getFUNCIONARIO_NOME_COMPLETO().hashCode();
        }
        if (getFUNCIONARIO_NUCLEO() != null) {
            _hashCode += getFUNCIONARIO_NUCLEO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ANIVERSARIANTE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://localhost", "ANIVERSARIANTE"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_AREA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_AREA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_EMAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_FILIAL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_FILIAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_FOTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_FOTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_NOME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_NOME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_NOME_COMPLETO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_NOME_COMPLETO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FUNCIONARIO_NUCLEO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost", "FUNCIONARIO_NUCLEO"));
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
