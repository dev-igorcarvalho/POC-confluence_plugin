package osgiteste.interactor;

import org.springframework.stereotype.Component;
import osgiteste.api.soap.generated.ANIVERSARIANTE;
import osgiteste.api.soap.generated.AniversariantesProxyLocator;
import osgiteste.api.soap.generated.AniversariantesProxyPortType;

@Component
public class FecthAniversariantesDiaFromProtheus {
    public ANIVERSARIANTE[] execute() {
        ANIVERSARIANTE[] aniversariantes = null;
        try {
            AniversariantesProxyLocator locator = new AniversariantesProxyLocator();
            AniversariantesProxyPortType servico = locator.getAniversariantesProxyHttpSoap11Endpoint();
            aniversariantes = servico.GET_NIVER(null, null);
        } catch (Exception e) {
            osgiteste.util.Logger.error("ERRO AO BUSCAR ANIVERSARIANTES NO PROTHEUS", e);
            throw new RuntimeException(); //TODO TROCAR POR PERSONALZIADA
        }
        return aniversariantes;
    }
}
