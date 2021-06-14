package LojaCadastro.Controller.Dto;

public class TokenDto {
	
	private String token;
	private String classe;
	
	/////////GET E SET//////////////
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	///////////////////////////////////////////
	public TokenDto(String token, String classe) {
		super();
		this.token = token;
		this.classe = classe;
	}
	
	
	

}
