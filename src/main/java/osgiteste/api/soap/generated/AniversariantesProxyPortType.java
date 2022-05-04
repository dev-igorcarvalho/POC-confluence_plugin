/**
 * AniversariantesProxyPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osgiteste.api.soap.generated;

public interface AniversariantesProxyPortType extends java.rmi.Remote {

    /**
     * Metodo para retonar um array de aniversariantes do dia ou datas
     * especificas
     */
    public ANIVERSARIANTE[] GET_NIVER(java.util.Date DDATINI, java.util.Date DDATFIM) throws java.rmi.RemoteException;

    /**
     * Metodo para retonar um array de enderecos e-mails
     */
    public EMAILFUNC[] GET_EMAIL(String CTIPORET) throws java.rmi.RemoteException;
}
