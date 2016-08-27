package aplicacao;

import arquivo.CopiarArquivo;
import formulario.telaprincipal.TelaPrincipal;

/**
 * Início da aplicação.
 * 
 * @author jfpsb
 *
 */
public class Programa {

	public static void main(String[] args) {
		//FilmesManager.CriarFilme("auihsdua", true, true, "sinopse", "imagem", 100);
		new TelaPrincipal().mostrarTela();
		
		new CopiarArquivo();
	}

}
