package osgiteste.api.soap.client.service;

import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.ANIVERSARIANTE;
import osgiteste.api.soap.client.AniversariantesProxyLocator;
import osgiteste.api.soap.client.AniversariantesProxyPortType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class AniversariantesServiceImpl implements AniversariantesService {

    Properties properties;

    public AniversariantesServiceImpl() {
        this.properties = carregaPropriedades();
    }

    @Override
    public Map<String, Object> getAniversariantesDoDia() {

        Map<String, Object> result = new HashMap<String, Object>();

        result = getAniversariantesPorPeriodo(null, null);

        return result;
    }

    @Override
    public Map<String, Object> getAniversariantesPorPeriodo(Date inicio, Date fim) {

        Map<String, Object> result = new HashMap<String, Object>();

        ANIVERSARIANTE[] aniversariantes = null;
        try {
            AniversariantesProxyLocator locator = new AniversariantesProxyLocator();
            AniversariantesProxyPortType servico = locator.getAniversariantesProxyHttpSoap11Endpoint();

            //===================== TESTE ===============================
			/*DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date data = format.parse("31/03/2018"); 
			aniversariantes = servico.GET_NIVER(data, data);*/

            /*===========================================================*/
            aniversariantes = servico.GET_NIVER(inicio, fim);
        } catch (Exception e) {
            System.out.println("ERRO AO EXECUTAR MACRO DE ANIVERSARIANTES!");
        }

        String msg = "";

        List<ANIVERSARIANTE> aniversariantesList = new ArrayList<ANIVERSARIANTE>();

        for (int i = 0; i < aniversariantes.length; i++) {
            ANIVERSARIANTE aniversariante = aniversariantes[i];
            if (!aniversariante.getFUNCIONARIO_EMAIL().isEmpty() && verificaEmailValido(aniversariante.getFUNCIONARIO_EMAIL().toLowerCase())) {

                aniversariante.setFUNCIONARIO_FOTO(buscaFoto(aniversariante.getFUNCIONARIO_FOTO()));

                aniversariantesList.add(aniversariante);
            }

        }

        if (aniversariantesList.isEmpty()) {
            msg = properties.getProperty("aniversariantes.msg.semAniversariantes");
        }

        result.put("aniversariantes", aniversariantesList);
        result.put("msg", msg);

        return result;
    }

    private String buscaFoto(String funcionario_FOTO) {
        String nomeFoto = null;

        //Properties properties = carregaPropriedades();

        String base_dir = properties.getProperty("aniversariantes.diretorio.fotos");

        final String BMP_EXTENSION = ".bmp";
        final String JPG_EXTENSION = ".jpg";

        if (base_dir != null && !base_dir.isEmpty()) {

            File foto_bmp = new File(base_dir + funcionario_FOTO + BMP_EXTENSION);
            File foto_jpg = new File(base_dir + funcionario_FOTO + JPG_EXTENSION);

            if (foto_bmp.exists()) {
                nomeFoto = funcionario_FOTO + BMP_EXTENSION;
            } else if (foto_jpg.exists()) {
                nomeFoto = funcionario_FOTO + JPG_EXTENSION;
            }
        }

        return nomeFoto;
    }

    private boolean verificaEmailValido(String email) {
        return email.endsWith("@rnp.br") ||
              email.endsWith("@terceiro.rnp.br") ||
              email.endsWith("@consultores.rnp.br");
    }

    private Properties carregaPropriedades() {
        Properties p = new Properties();

        InputStream is = getClass().getClassLoader().getResourceAsStream("osgi.properties");

        if (is != null) {
            try {
                p.load(is);
            } catch (IOException e) {
                System.err.println("NAO FOI POSSIVEL CARREGAR ARQUIVO DE PROPRIEDADES!");
                e.printStackTrace();
            }
        }

        return p;
    }

}
