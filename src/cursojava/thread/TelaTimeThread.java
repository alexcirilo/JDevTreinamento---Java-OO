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
	
	private JLabel descricaoHora = new JLabel("Time Thread 1");
	private JTextField mostraHora = new JTextField();
	
	private JLabel descricaoData = new JLabel("Time Thread 2");
	private JTextField mostraData = new JTextField();
	
	private JButton botaoStart = new JButton("Start");
	private JButton botaoStop = new JButton("Stop");
	private JButton botaoExit = new JButton("Exit");
	
	private Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {

			while(true) { //sempre executando
				mostraHora.setText(new SimpleDateFormat("dd/MM/yyyy "
						+ "hh:mm.ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	};
	
private Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {

			while(true) { //sempre executando
				mostraData.setText(new SimpleDateFormat("dd/MM/yyyy "
						+ "hh:mm:ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	};
	
	private Thread thread1Time; 
	private Thread thread2Time; 
	
	
	public TelaTimeThread() {
		setTitle("Minha Tela de Time com Thread");
		setSize(new Dimension(330, 230));
		setLocationRelativeTo(null);
		setResizable(false);

		/*Controlador de posicionamento de componentes*/
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2; //espaço para posição dos botões ocuparem 2 posições
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora,gridBagConstraints);
		
		mostraHora.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++;
		mostraHora.setEditable(false);
		jPanel.add(mostraHora,gridBagConstraints);
		
		
		
		descricaoData.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoData,gridBagConstraints);
		
		mostraData.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy++;
		mostraData.setEditable(false);
		jPanel.add(mostraData,gridBagConstraints);
		
		
		gridBagConstraints.gridwidth = 1; //espaço para posição dos botões ocuparem 1 posição
		
		botaoStart.setPreferredSize(new Dimension(92,25));
		gridBagConstraints.gridy++;
		jPanel.add(botaoStart,gridBagConstraints);
		
		botaoStop.setPreferredSize(new Dimension(92,25));
		gridBagConstraints.gridx ++;
		jPanel.add(botaoStop,gridBagConstraints);
		
		botaoExit.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jPanel.add(botaoExit,gridBagConstraints);
		
		botaoStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				thread1Time = new Thread(thread1);
				thread1Time.start();
				thread2Time = new Thread(thread2);
				thread2Time.start();
				botaoStart.setEnabled(false);
				botaoStop.setEnabled(true);
				
			}
		});
		
		botaoStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				thread1Time.stop();
				thread2Time.stop();
				botaoStart.setEnabled(true);
				botaoStop.setEnabled(false);
				
			}
		});
		
		botaoExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		botaoStop.setEnabled(false);
		add(jPanel,BorderLayout.WEST);
		setVisible(true);
		
		
		
	}

}
