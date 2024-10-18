package shop.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersistenceLogins {
	private int no;
	private String username;
	private String token;
	private Date expiryDate; 
	private Date regDate; 
	private Date updDate; 
}





