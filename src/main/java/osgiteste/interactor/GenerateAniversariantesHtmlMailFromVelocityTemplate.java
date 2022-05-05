package osgiteste.interactor;

import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.springframework.stereotype.Component;
import osgiteste.api.soap.generated.ANIVERSARIANTE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GenerateAniversariantesHtmlMailFromVelocityTemplate {
    public String execute(List<ANIVERSARIANTE> aniversariantes) {
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        context.put("aniversariantes", getAniversariantesMatrix(aniversariantes));
        context.put("matrizAniversariantes", getAniversariantesMatrix(aniversariantes));
        return VelocityUtils.getRenderedTemplate("/templates/aniversariantesMail.vm", context);
    }

    private List<List<ANIVERSARIANTE>> getAniversariantesMatrix(List<ANIVERSARIANTE> aniversariantes) {
        List<List<ANIVERSARIANTE>> result = new ArrayList<>();
        for (int i = 0; i < aniversariantes.size(); i++) {
            int element = i;
            int nextElement = i + 2;
            if (i == aniversariantes.size() - 1) {
                result.add(Arrays.asList(aniversariantes.get(element)));
            } else {
                result.add(aniversariantes.subList(element, nextElement));
                i++;
            }
        }
        return result;
    }
}
