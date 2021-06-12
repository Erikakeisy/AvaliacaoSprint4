package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import LojaCadastro.Modelo.Endereco;

public class EnderecoDto {
	
	
	private String estado;
	
	private String cidade;
	
	private String cep;
	
	private String rua;
	
	private String pais;
	
	
	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getPais() {
		return pais;
	}
	
		public EnderecoDto(Endereco endereco) {
	    this.pais = endereco.getPais();
	    this.estado = endereco.getEstado();
	    this.cidade = endereco.getCidade();
	    this.rua = endereco.getRua();
	    this.cep = endereco.getCep();
	}
	


	public static List<EnderecoDto> converter(List<Endereco> endereco){
		return endereco.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}
	
	
	}

	


