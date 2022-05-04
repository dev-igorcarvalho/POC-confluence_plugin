package osgiteste.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.client.service.AniversariantesService;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;
import osgiteste.interactor.GenerateHtmlPageFromVelocityTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


@Component
public class AniversariantesMacro implements Macro {
    private final GenerateHtmlPageFromVelocityTemplate generateHtmlPageFromVelocityTemplate;

    public AniversariantesMacro(GenerateHtmlPageFromVelocityTemplate generateHtmlPageFromVelocityTemplate) {
        this.generateHtmlPageFromVelocityTemplate = generateHtmlPageFromVelocityTemplate;
    }

    @Override
    public String execute(Map<String, String> arg0, String arg1, ConversionContext arg2)
          throws MacroExecutionException {

//        Date dataAtual = new Date();
//        Locale BRAZIL = new Locale("pt", "BR");
//        SimpleDateFormat formatador = new SimpleDateFormat("dd MMMM", BRAZIL);
//        String dataFormatada = formatador.format(dataAtual);
//
//        AniversariantesService service = new AniversariantesServiceImpl();
//
//        Map<String, Object> result = service.getAniversariantesDoDia();
//
//        Map<String, Object> context = MacroUtils.defaultVelocityContext();
//        Object aniversariantes = result.get("aniversariantes");
//        context.put("aniversariantes", result.get("aniversariantes"));
//        context.put("msg", result.get("msg"));
//        context.put("dataAtual", dataFormatada.toUpperCase());
//        // Render the Template
//        return VelocityUtils.getRenderedTemplate("/templates/aniversariantes.vm", context);
        return generateHtmlPageFromVelocityTemplate.execute();

    }


    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }


}
