package osgiteste.interactor;

import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GenerateFalhaTecnicaHtmlMailFromVelocityTemplate {
    public String execute(String errorMsg) {
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        context.put("errorMsg", errorMsg);
        return VelocityUtils.getRenderedTemplate("/templates/falhaTecnicaMail.vm", context);
    }
}
