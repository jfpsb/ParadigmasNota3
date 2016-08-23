package excecoes;

/**
 * Se alguma tela em MDI estiver aberta aciona a exce��o.
 * 
 * @author jfpsb
 *
 */
@SuppressWarnings("serial")
public class TelaAbertaException extends Exception {
	
	public TelaAbertaException() {
	}

	public TelaAbertaException(String message) {
		super(message);
	}
}
