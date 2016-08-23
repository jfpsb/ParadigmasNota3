package formulario.gerencia.funcionarios;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Tela onde ficar�o controles das op��es de funcion�rios (cadastro, atualizar,
 * etc). Estende de JInteralFrame porque vai ser um formul�rio que vai abrir
 * dentro de outro (MDI)
 * 
 * @author jfpsb
 *
 */
public class TelaFuncionariosControles extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipalTelaFuncionario;

	public TelaFuncionariosControles() {
		super("Op��es De Funcion�rios");
		inicializarControles();
	}

	public void inicializarControles() {
		panelPrincipalTelaFuncionario = new JPanel();

		panelPrincipalTelaFuncionario.add(new JButton("AEHOOOOOO"));

		// telaFilmes
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(640, 360));
		this.setClosable(true);
		this.add(panelPrincipalTelaFuncionario);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
