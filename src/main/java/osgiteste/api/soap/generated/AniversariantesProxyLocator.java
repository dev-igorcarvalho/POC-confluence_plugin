/**
 * AniversariantesProxyLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osgiteste.api.soap.generated;

public class AniversariantesProxyLocator extends org.apache.axis.client.Service implements AniversariantesProxy {

    public AniversariantesProxyLocator() {
    }


    public AniversariantesProxyLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AniversariantesProxyLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AniversariantesProxyHttpSoap11Endpoint
    private String AniversariantesProxyHttpSoap11Endpoint_address = "http://barramento.rnp.br:8280/services/AniversariantesProxy.AniversariantesProxyHttpSoap11Endpoint";

    public String getAniversariantesProxyHttpSoap11EndpointAddress() {
        return AniversariantesProxyHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String AniversariantesProxyHttpSoap11EndpointWSDDServiceName = "AniversariantesProxyHttpSoap11Endpoint";

    public String getAniversariantesProxyHttpSoap11EndpointWSDDServiceName() {
        return AniversariantesProxyHttpSoap11EndpointWSDDServiceName;
    }

    public void setAniversariantesProxyHttpSoap11EndpointWSDDServiceName(String name) {
        AniversariantesProxyHttpSoap11EndpointWSDDServiceName = name;
    }

    public AniversariantesProxyPortType getAniversariantesProxyHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AniversariantesProxyHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAniversariantesProxyHttpSoap11Endpoint(endpoint);
    }

    public AniversariantesProxyPortType getAniversariantesProxyHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            AniversariantesProxySoap11BindingStub _stub = new AniversariantesProxySoap11BindingStub(portAddress, this);
            _stub.setPortName(getAniversariantesProxyHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAniversariantesProxyHttpSoap11EndpointEndpointAddress(String address) {
        AniversariantesProxyHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for AniversariantesProxyHttpsSoap11Endpoint
    private String AniversariantesProxyHttpsSoap11Endpoint_address = "https://barramento.rnp.br:8243/services/AniversariantesProxy.AniversariantesProxyHttpsSoap11Endpoint";

    public String getAniversariantesProxyHttpsSoap11EndpointAddress() {
        return AniversariantesProxyHttpsSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String AniversariantesProxyHttpsSoap11EndpointWSDDServiceName = "AniversariantesProxyHttpsSoap11Endpoint";

    public String getAniversariantesProxyHttpsSoap11EndpointWSDDServiceName() {
        return AniversariantesProxyHttpsSoap11EndpointWSDDServiceName;
    }

    public void setAniversariantesProxyHttpsSoap11EndpointWSDDServiceName(String name) {
        AniversariantesProxyHttpsSoap11EndpointWSDDServiceName = name;
    }

    public AniversariantesProxyPortType getAniversariantesProxyHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AniversariantesProxyHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAniversariantesProxyHttpsSoap11Endpoint(endpoint);
    }

    public AniversariantesProxyPortType getAniversariantesProxyHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            AniversariantesProxySoap11BindingStub _stub = new AniversariantesProxySoap11BindingStub(portAddress, this);
            _stub.setPortName(getAniversariantesProxyHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAniversariantesProxyHttpsSoap11EndpointEndpointAddress(String address) {
        AniversariantesProxyHttpsSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (AniversariantesProxyPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                AniversariantesProxySoap11BindingStub _stub = new AniversariantesProxySoap11BindingStub(new java.net.URL(AniversariantesProxyHttpSoap11Endpoint_address), this);
                _stub.setPortName(getAniversariantesProxyHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (AniversariantesProxyPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                AniversariantesProxySoap11BindingStub _stub = new AniversariantesProxySoap11BindingStub(new java.net.URL(AniversariantesProxyHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getAniversariantesProxyHttpsSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("AniversariantesProxyHttpSoap11Endpoint".equals(inputPortName)) {
            return getAniversariantesProxyHttpSoap11Endpoint();
        }
        else if ("AniversariantesProxyHttpsSoap11Endpoint".equals(inputPortName)) {
            return getAniversariantesProxyHttpsSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost", "AniversariantesProxy");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost", "AniversariantesProxyHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://localhost", "AniversariantesProxyHttpsSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("AniversariantesProxyHttpSoap11Endpoint".equals(portName)) {
            setAniversariantesProxyHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("AniversariantesProxyHttpsSoap11Endpoint".equals(portName)) {
            setAniversariantesProxyHttpsSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
