package aplicacao;

import formulario.telaprincipal.TelaPrincipal;
import util.JPAUtil;

/**
 * In�cio da aplica��o.
 * 
 * @author jfpsb
 *
 */
public class Programa {

	public static void main(String[] args) {
		new TelaPrincipal().mostrarTela();
		JPAUtil.closeEntityManagerChild();
	}

}
