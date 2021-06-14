package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import LojaCadastro.Modelo.Cliente;

public class ClienteDto {
	
	private String email;
	
	////////////CONVERTER/////////////////
	
	public ClienteDto converter(Cliente login) {
		ClienteDto DTO = new ClienteDto();
		DTO.setEmail(login.getEmail());
		return DTO;
	}
	
	 public List<ClienteDto> converter(List<Cliente> logins){
	        return logins.stream().map(login -> converter(login)).collect(Collectors.toList());
	    }
	

    //////////////GET E SET //////////////
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
