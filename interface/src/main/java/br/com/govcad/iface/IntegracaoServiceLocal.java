package br.com.govcad.iface;

import br.com.govcad.integracaoservice.InBuscarPessoaFisica;
import br.com.govcad.integracaoservice.OutBuscarPessoaFisica;

public interface IntegracaoServiceLocal {

	public OutBuscarPessoaFisica consultarSituacaoCadastralCPF(InBuscarPessoaFisica inBuscarPessoaFisica);

}
