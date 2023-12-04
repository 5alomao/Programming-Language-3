package model;

import model.br.EmployeeFactoryBR;
import model.us.EmployeeFactoryUS;

public class CountryEmployeeFactory {

	public static EmployeeFactory createEmployeeFactory(Country country) {

		if (country == Country.BR)
			return new EmployeeFactoryBR();

		if (country == Country.US)
			return new EmployeeFactoryUS();

		return null;
	}

}
