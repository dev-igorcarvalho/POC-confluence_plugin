package osgiteste.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PropertiesInteractor {

    private final String DEFAULT_PROPERTIES = "osgi.properties";
    private Properties principal;

    public PropertiesInteractor() {
        setDefaultProperties();
    }

    private void setDefaultProperties() {
        this.principal = getPropertiesFromResources(DEFAULT_PROPERTIES);
    }

    public String getStringByKey(String key) {
        return this.principal.getProperty(key);
    }

    public String getStringByKey(String key, String defaultValue) {
        return this.principal.getProperty(key, defaultValue);
    }

    public Integer getIntByKey(String key) {
        try {
            return Integer.valueOf(this.principal.getProperty(key));
        } finally {
            return null;
        }
    }

    public Integer getIntByKey(String key, int defaultValue) {
        try {
            return Integer.valueOf(this.principal.getProperty(key));
        } finally {
            return defaultValue;
        }
    }

    public Properties getPropertiesFromResources(String fileName) {
        Properties p = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES);
        if (is != null) {
            try {
                p.load(is);
            } catch (IOException e) {
                osgiteste.util.Logger.error("NAO FOI POSSIVEL CARREGAR ARQUIVO DE PROPRIEDADES!", e);
            }
        }
        return p;
    }
}
