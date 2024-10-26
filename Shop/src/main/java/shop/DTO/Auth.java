package shop.DTO;

public enum Auth {

	USER, ADMIN;
	
	public String toString() {
		return "ROLE_" + name();
	}
}
