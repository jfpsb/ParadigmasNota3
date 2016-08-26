package outrasclasses;

import javax.swing.JFrame;

import excecoes.TelaAbertaException;

/**
 * Classe para checar propriedades de telas.
 * 
 * @author jfpsb
 *
 */
public class ChecarTela {

	/**
	 * Checa se a tela está aberta no momento. Se sim, é lançada a exceção.
	 * 
	 * @throws TelaAbertaException
	 */
	public static void checaTelaAberta(JFrame frame) throws TelaAbertaException {
		if (frame != null && (frame.isVisible() || frame.isDisplayable()))
			throw new TelaAbertaException("Uma instância desta tela já está aberta.");
	}

}
