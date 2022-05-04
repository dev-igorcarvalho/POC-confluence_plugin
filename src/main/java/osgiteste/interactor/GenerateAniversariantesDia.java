package osgiteste.interactor;

import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenerateAniversariantesDia {
    private final GenerateAniversariantesPhoto generateAniversariantesPhoto;

    public GenerateAniversariantesDia(GenerateAniversariantesPhoto generateAniversariantesPhoto) {
        this.generateAniversariantesPhoto = generateAniversariantesPhoto;
    }

    public List<ANIVERSARIANTE> execute(ANIVERSARIANTE[] aniversariantes) {
        List<ANIVERSARIANTE> result = new ArrayList<ANIVERSARIANTE>();
        for (int i = 0; i < aniversariantes.length; i++) {
            ANIVERSARIANTE aniversariante = aniversariantes[i];
            if (!aniversariante.getFUNCIONARIO_EMAIL().isEmpty() && verificaEmailValido(aniversariante.getFUNCIONARIO_EMAIL().toLowerCase())) {
                aniversariante.setFUNCIONARIO_FOTO(generateAniversariantesPhoto.execute(aniversariante.getFUNCIONARIO_FOTO()));
                result.add(aniversariante);
            }
        }
        return result;
    }

    private boolean verificaEmailValido(String email) {
        return email.endsWith("@rnp.br") ||
              email.endsWith("@terceiro.rnp.br") ||
              email.endsWith("@consultores.rnp.br");
    }

}
