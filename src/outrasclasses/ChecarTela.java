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
	 * Checa se a tela est� aberta no momento. Se sim, � lan�ada a exce��o.
	 * 
	 * @throws TelaAbertaException
	 */
	public static void checaTelaAberta(JFrame frame) throws TelaAbertaException {
		if (frame != null && (frame.isVisible() || frame.isDisplayable()))
			throw new TelaAbertaException("Uma inst�ncia desta tela j� est� aberta.");
	}

}
