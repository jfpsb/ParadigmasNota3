package aplicacao;

import arquivo.CopiarArquivo;
import formulario.telaprincipal.TelaPrincipal;

/**
 * In�cio da aplica��o.
 * 
 * @author jfpsb
 *
 */
public class Programa {

	public static void main(String[] args) {
		new TelaPrincipal().mostrarTela();
		
		new CopiarArquivo();
	}

}
