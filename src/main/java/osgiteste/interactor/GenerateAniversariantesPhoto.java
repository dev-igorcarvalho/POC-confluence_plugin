package osgiteste.interactor;

import org.springframework.stereotype.Component;
import osgiteste.util.PropertiesInteractor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class GenerateAniversariantesPhoto {
    private final PropertiesInteractor propertiesInteractor;

    public GenerateAniversariantesPhoto(PropertiesInteractor propertiesInteractor) {
        this.propertiesInteractor = propertiesInteractor;
    }

    public String execute(final String foto) {
        String requestMethod = "GET";
        int succsessMaxRange = 299;
        String fotoTratada = foto.toLowerCase().trim();
        String urlMediaRNPAniversarianteFoto = propertiesInteractor.getStringByKey("url.media.rnp.aniversariantes.fotos");
        String pathFotoBMP = urlMediaRNPAniversarianteFoto + fotoTratada + ".bmp";
        String pathFotoJPG = urlMediaRNPAniversarianteFoto + fotoTratada + ".jpg";
        URL url;
        try {
            url = new URL(pathFotoBMP);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            if (conn.getResponseCode() < succsessMaxRange) {
                return pathFotoBMP;
            } else {
                url = new URL(pathFotoJPG);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod(requestMethod);
                if (conn.getResponseCode() < succsessMaxRange) {
                    return pathFotoJPG;
                }
            }
        } catch (IOException e) {
            osgiteste.util.Logger.error("NAO FOI POSSIVEL RESGATAR A FOTO DO ANIVERSARIANTE", e);
        }
        return generateDefaultPhoto();
    }

    private String generateDefaultPhoto() {
        return "data:image/png;base64,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";
    }
}
