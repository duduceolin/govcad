package br.com.govcad.integracaoservice;

import br.com.govcad.serviceutil.BaseIn;

public class InBuscarPessoaJuridica extends BaseIn {

	private static final long serialVersionUID = 7492680068942044914L;

	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
