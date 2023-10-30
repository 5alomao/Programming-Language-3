package model;

import java.util.HashMap;
import java.util.Map;

public class Dados {

	public static Map<String, Cargo> cargos = new HashMap<>();

	static {
		cargos.put("analista", new Analista(5));
		cargos.put("arquiteto", new Arquiteto(5, 3));
		cargos.put("lidertec", new LiderTecnico(5, 10));
		cargos.put("gerente", new Gerente(5, 10, 2));
	}

	public static Cargo getCargo(String idCargo) {
		return cargos.get(idCargo);
	}
}
