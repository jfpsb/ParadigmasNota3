package aplicacao;

import formulario.telaprincipal.TelaPrincipal;
import util.JPAUtil;

/**
 * Início da aplicação.
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
