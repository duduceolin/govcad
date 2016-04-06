package br.com.govcad.integracaoservice;

import java.io.Serializable;

import br.com.govcad.serviceutil.BaseIn;

public class InBuscarPessoaFisica extends BaseIn implements Serializable {

	private static final long serialVersionUID = 8821375150746733800L;

	private String cpf;
	private String dataNascimento;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
