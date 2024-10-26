package shop.DTO;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Users {
	private Long no;
	private String id;
	private String username;
	private String password;
	private String name;
	private String email;
	private Boolean enabled = true;
	private Date createdAt;
	private Date updatedAt;
	
	public Users() {
		this.id = UUID.randomUUID().toString();	
	}

	public boolean isEmpty() {
		if( this.username == null || this.username.equals("") )
			return true;
		if( this.name == null || this.name.equals("") )
			return true;
		return false;
	}
	
}
















