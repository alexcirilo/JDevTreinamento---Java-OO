package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout()); // Painel de componentes

	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraHora = new JTextField();

	private JLabel descricaoData = new JLabel("E-mail");
	private JTextField mostraData = new JTextField();

	private JButton botaoStart = new JButton("Add Lista");
	private JButton botaoStop = new JButton("Stop");
	private JButton botaoExit = new JButton("Exit");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaTimeThread() {
		setTitle("Minha Tela de Time com Thread");
		setSize(new Dimension(330, 230));
		setLocationRelativeTo(null);
		setResizable(false);

		/* Controlador de posicionamento de componentes */
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2; // espaço para posição dos botões ocuparem 2 posições
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);

		mostraHora.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostraHora.setEditable(true);
		jPanel.add(mostraHora, gridBagConstraints);

		descricaoData.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoData, gridBagConstraints);

		mostraData.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostraData.setEditable(true);
		jPanel.add(mostraData, gridBagConstraints);

		gridBagConstraints.gridwidth = 1; // espaço para posição dos botões ocuparem 1 posição

		botaoStart.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(botaoStart, gridBagConstraints);

		botaoStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(botaoStop, gridBagConstraints);

		botaoExit.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(botaoExit, gridBagConstraints);

		botaoStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}

				for (int qte = 0; qte < 100; qte++) { //simulando 100 envios em massa
					

					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraHora.getText());
					filaThread.setEmail(mostraData.getText() + " - "+qte);
					fila.add(filaThread);
				}
			}
		});

		botaoStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fila.stop();
				fila = null;
			}
		});

		botaoExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		fila.start();
		add(jPanel, BorderLayout.WEST);
		setVisible(true);

	}

}
