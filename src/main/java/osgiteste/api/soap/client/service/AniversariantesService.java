package osgiteste.api.soap.client.service;

import java.util.Date;
import java.util.Map;


public interface AniversariantesService {
	
	Map<String, Object> getAniversariantesDoDia();
	
	Map<String, Object> getAniversariantesPorPeriodo(Date inicio, Date fim);
	
}
