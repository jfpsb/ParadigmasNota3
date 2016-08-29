package formulario.vendaDeIngressos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import aplicacao.manager.SessaoManager;
import entidades.Ingresso;
import entidades.Sessao;

public class TelaFinalizarVenda extends TelaFinalizarVendaControles {
	private JDialog localOwner = this;
	private int colunaEscolhida;
	private int linhaEscolhida;

	public TelaFinalizarVenda(JFrame owner, Sessao sessaoEscolhida) {
		super(owner, sessaoEscolhida);

		tabelaPoltrona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				colunaEscolhida = tabelaPoltrona.getSelectedColumn();
				linhaEscolhida = tabelaPoltrona.getSelectedRow();
			}
		});

		btnFinalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean meia = chkMeia.isSelected();
				double preco = sessaoEscolhida.getPreco();

				if (meia) {
					preco /= 2;
				}

				Ingresso ingresso = new Ingresso(funcionarios.get(cmbFuncionarios.getSelectedIndex()), sessaoEscolhida,
						meia, preco);

				boolean result = SessaoManager.reservarPoltrona(sessaoEscolhida, ingresso, colunaEscolhida,
						linhaEscolhida);

				if (result) {
					JOptionPane.showMessageDialog(localOwner, "Venda registrada com sucesso!");
					localOwner.dispose();
				} else {
					JOptionPane.showMessageDialog(localOwner,
							"Venda não foi registrada! Cheque se a poltrona está disponível!");
				}
			}

		});
	}

}
