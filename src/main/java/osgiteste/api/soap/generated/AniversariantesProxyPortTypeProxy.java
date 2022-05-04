package osgiteste.api.soap.generated;

public class AniversariantesProxyPortTypeProxy implements AniversariantesProxyPortType {
  private String _endpoint = null;
  private AniversariantesProxyPortType aniversariantesProxyPortType = null;
  
  public AniversariantesProxyPortTypeProxy() {
    _initAniversariantesProxyPortTypeProxy();
  }
  
  public AniversariantesProxyPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAniversariantesProxyPortTypeProxy();
  }
  
  private void _initAniversariantesProxyPortTypeProxy() {
    try {
      aniversariantesProxyPortType = (new AniversariantesProxyLocator()).getAniversariantesProxyHttpSoap11Endpoint();
      if (aniversariantesProxyPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aniversariantesProxyPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aniversariantesProxyPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aniversariantesProxyPortType != null)
      ((javax.xml.rpc.Stub)aniversariantesProxyPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public AniversariantesProxyPortType getAniversariantesProxyPortType() {
    if (aniversariantesProxyPortType == null)
      _initAniversariantesProxyPortTypeProxy();
    return aniversariantesProxyPortType;
  }
  
  public ANIVERSARIANTE[] GET_NIVER(java.util.Date DDATINI, java.util.Date DDATFIM) throws java.rmi.RemoteException{
    if (aniversariantesProxyPortType == null)
      _initAniversariantesProxyPortTypeProxy();
    return aniversariantesProxyPortType.GET_NIVER(DDATINI, DDATFIM);
  }
  
  public EMAILFUNC[] GET_EMAIL(String CTIPORET) throws java.rmi.RemoteException{
    if (aniversariantesProxyPortType == null)
      _initAniversariantesProxyPortTypeProxy();
    return aniversariantesProxyPortType.GET_EMAIL(CTIPORET);
  }
  
  
}
