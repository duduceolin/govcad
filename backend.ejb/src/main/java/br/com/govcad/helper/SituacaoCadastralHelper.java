package br.com.govcad.helper;

import org.openqa.selenium.WebElement;

import br.com.govcad.integracaoservice.InBuscarPessoaJuridica;
import br.com.govcad.utils.BaseHelper;

public class SituacaoCadastralHelper extends BaseHelper {

	public static final String LINK_PAGINA = "http://www.receita.fazenda.gov.br/aplicacoes/atcta/cpf/consultapublica.asp";

	private static final String ID_CAMPO_CNPJ = "cnpj";

	private InBuscarPessoaJuridica inBuscar;

	@Override
	public void iniciarProcessamento(Object entrada) {

		inBuscar = (InBuscarPessoaJuridica) entrada;

		try {
			this.carregarEndereco(LINK_PAGINA);
			this.mudarFrame("main");
			WebElement campoCnpj = this.buscarElementoPeloId(ID_CAMPO_CNPJ);
			this.alterarValorCampo(campoCnpj, inBuscar.getCnpj());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// DownloadImage(By.id("imgCaptcha"), "Z:/image.png");
		// driver.close();

	}

}
