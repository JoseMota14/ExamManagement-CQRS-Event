package springboot.Configuration.dto;

public class PayloadDTO {
	
	public String descr;
	public String type;

	public PayloadDTO() {
		
	}
	
	public PayloadDTO(String descr, String type) {
		this.descr = descr;
		this.type = type;
	}
}
