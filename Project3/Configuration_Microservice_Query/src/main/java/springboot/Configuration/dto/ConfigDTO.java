package springboot.Configuration.dto;

public class ConfigDTO {
	
	public String descr;
	public String type;

	public ConfigDTO() {
		
	}
	
	public ConfigDTO(String descr, String type) {
		this.descr = descr;
		this.type = type;
	}
}
