package shop.DTO;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserAuth {
	
	private Long no;
	private String id;
	private String username;
	private String auth;
	private Date createdAt;
	private Date updatedAt;
	
	public UserAuth() {
		this.id = UUID.randomUUID().toString();	
	}
	
}









