package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;

public class EscolhaDeCadastro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	
	
	

	/**
	 * Create the frame.
	 */
	public EscolhaDeCadastro() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(48, 6, 103));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Escolha de Cadastro");
		setResizable(true);
		setBounds(100, 100, 866, 564);
		setBackground(new Color(48, 6, 103));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 32, 62));
		
		JLabel lblNewLabel_1 = new JLabel("Qual o tipo de usuario?");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarAutorizacao autorizacao = new VerificarAutorizacao(EscolhaDeCadastro.this);
				autorizacao.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(155, 49, 247));
		
		btnNewButton_1 = new JButton("CADASTRAR");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(155, 49, 247));
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("Usuario ADM");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Voltar");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(EscolhaDeCadastro.class.getResource("/interfaceImg/seta-esquerda (1).png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginSistema loginSistema = new LoginSistema();
				loginSistema.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EscolhaDeCadastro.class.getResource("/interfaceImg/ferramentas-de-revisao-de-codigo.png")));
		lblNewLabel.setAlignmentX(0.5f);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 869, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addGap(64))
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 541, Short.MAX_VALUE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(159)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addGap(159))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(202)
					.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addGap(84))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(53)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(125)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(54))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(249)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(249))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(68)
					.addComponent(lblNewLabel_1)
					.addGap(86)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(84)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(48))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1JButton(e);
		}
	}
	protected void actionPerformedBtnNewButton_1JButton(ActionEvent e) {
		CadastroSistema_Client cadastroSistema_Client =  new CadastroSistema_Client();
		cadastroSistema_Client.setVisible(true);
		dispose();
	}
}
