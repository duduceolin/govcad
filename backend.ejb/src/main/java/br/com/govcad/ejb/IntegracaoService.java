package br.com.govcad.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.govcad.helper.SituacaoCadastralHelper;
import br.com.govcad.iface.IntegracaoServiceLocal;
import br.com.govcad.integracaoservice.InBuscarPessoaFisica;
import br.com.govcad.integracaoservice.OutBuscarPessoaFisica;

@Stateless
@WebService(serviceName = "IntegracaoService", targetNamespace = "http://integracaoservice.govcad.com.br")
public class IntegracaoService implements IntegracaoServiceLocal {

	@Override
	@WebMethod
	@WebResult(name = "outConsultarSituacaoCadastral")
	public OutBuscarPessoaFisica consultarSituacaoCadastralCPF(
			@WebParam(name = "inConsultarSituacaoCadastral") InBuscarPessoaFisica inBuscarPessoaFisica) {
		OutBuscarPessoaFisica out = new OutBuscarPessoaFisica();
		SituacaoCadastralHelper helper = new SituacaoCadastralHelper();
		//helper.abrirPagina();
		
		out.setTeste(inBuscarPessoaFisica.getChaveConsulta());
		return out;
	}

}
