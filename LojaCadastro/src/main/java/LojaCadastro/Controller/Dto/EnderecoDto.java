package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;
import LojaCadastro.Modelo.Endereco;

/////////////////CLASSE DTO//////////////////
	public class EnderecoDto {
	
	
	private String estado;
	
	private String cidade;
	
	private String rua;
	
	
	
////////////////////GET E SET///////////////////	
	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	
	public String getRua() {
		return rua;
	}

	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}

///////////////COSNTRUCTOR////////////////////	
	public static EnderecoDto converter(Endereco e) {
		EnderecoDto dEnd = new EnderecoDto();
		dEnd.setEstado(e.getEstado());
		dEnd.setCidade(e.getCidade());
		dEnd.setRua(e.getRua());
		return dEnd;
	}

	public static List<EnderecoDto> converter(List<Endereco> endereco){
		return endereco.stream().map(end -> converter (end)).collect(Collectors.toList());
	}
	
	
	}

	


