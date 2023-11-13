package model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

	public static Map<String, Employee> data = new HashMap<>();

	static {
		Employee maria = new Analyst("Maria Isabel", 4800.50);
		maria.setExtraHours(3);
		maria.setPerExtraHourValue(100);
		
		Employee jose = new Analyst("José Pedro", 2800);
		jose.setExtraHours(10);
		jose.setPerExtraHourValue(80);
		
		data.put("maria", maria);
		data.put("jose", jose);
		data.put("pedro", new Architect("Pedro H.", 8800, 3, 2));
		data.put("gabriel", new Architect("Gabriel H.", 7800, 1, 2));
		data.put("paula", new Architect("Paula M.", 10000, 7, 5));
		data.put("seila", new Manager("Paula M.", 12000, 8, 1, 2, 3));
	}

	public static Employee getEmployee(String pk) {
		return data.get(pk);
	}
}
