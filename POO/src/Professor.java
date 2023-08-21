
public class Professor extends User{
	
	private String siape;
	private String level;
	private String area;
	
	public Professor(int id, String siape) {
		super(id);
		this.siape = siape;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSiape() {
		return siape;
	}
	
	@Override
	public String formatPersonalData() {
		String userData = super.formatPersonalData();
		String professorData = String.format("Siape: %s\nNivel: %s\nArea: %s\n", siape,level, area);
		return userData+professorData;
	}
	
}
