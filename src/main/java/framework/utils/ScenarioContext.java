package framework.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private final Map<String, Object> context = new HashMap<>();
	
	public void adicionarContexto(String key, Object value) {
		context.put(key, value);
	}
	
	public Object pegarContexto(String key) {
		return context.get(key);
	}
	
	public boolean existeContexto(String key) {
		return context.containsKey(key);
	}
	
}
