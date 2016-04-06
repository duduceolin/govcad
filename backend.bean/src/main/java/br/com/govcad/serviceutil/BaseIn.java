package br.com.govcad.serviceutil;

import java.io.Serializable;

public class BaseIn implements Serializable{

	private static final long serialVersionUID = 4470563335151178869L;
	
	private String codigoUsuario;
	private String chaveConsulta;

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getChaveConsulta() {
		return chaveConsulta;
	}

	public void setChaveConsulta(String chaveConsulta) {
		this.chaveConsulta = chaveConsulta;
	}

}
