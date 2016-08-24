package formulario.gerencia.filmes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import formulario.gerencia.TelaBaseEntidadeControles;

public class TelaFilme extends TelaBaseEntidadeControles {
	private static final long serialVersionUID = 1L;

	public TelaFilme() {
		super("Opcões de Filmes");

		btnCadastrarNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaFilmeCadastro cad = new TelaFilmeCadastro();
				cad.mostrarTela();
			}

		});
	}
}
