package osgiteste.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import osgiteste.api.soap.client.service.AniversariantesService;
import osgiteste.api.soap.client.service.AniversariantesServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


public class AniversariantesMacro implements Macro {

    public AniversariantesMacro() {

    }

    @Override
    public String execute(Map<String, String> arg0, String arg1, ConversionContext arg2)
          throws MacroExecutionException {

        Date dataAtual = new Date();
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat formatador = new SimpleDateFormat("dd MMMM", BRAZIL);
        String dataFormatada = formatador.format(dataAtual);

        AniversariantesService service = new AniversariantesServiceImpl();

        Map<String, Object> result = service.getAniversariantesDoDia();

        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        context.put("aniversariantes", result.get("aniversariantes"));
        context.put("msg", result.get("msg"));
        context.put("dataAtual", dataFormatada.toUpperCase());
        // Render the Template
        return VelocityUtils.getRenderedTemplate("/templates/aniversariantes.vm", context);

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
