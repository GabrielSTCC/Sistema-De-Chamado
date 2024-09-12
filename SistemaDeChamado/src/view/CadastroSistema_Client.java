package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import controller.FormCadastroControllerUser;

import javax.swing.SwingConstants;

public class CadastroSistema_Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameUser;
	private JTextField surnameUser;
	private JPasswordField senhaUser;
	private FormCadastroControllerUser controller;
	
	public JTextField getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser.setText(nameUser);
	}


	public JTextField getSurnameUser() {
		return surnameUser;
	}


	public void setSurnameUser(String surnameUser) {
		this.surnameUser.setText(surnameUser);
	}


	public JPasswordField getSenhaUser() {
		return senhaUser;
	}


	public void setSenhaUser(String senhaUser) {
		this.senhaUser.setText(senhaUser);
	}

	public CadastroSistema_Client() {
		setTitle("Cadastro Usuario");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		controller = new FormCadastroControllerUser(this);
		setBounds(100, 100, 835, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 6, 103));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 32, 62));
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		nameUser = new JTextField();
		nameUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sobrenome:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		surnameUser = new JTextField();
		surnameUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surnameUser.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		senhaUser = new JPasswordField();
		senhaUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					controller.salveUser();
				}
			}
		);
		btnNewButton.setBackground(new Color(155, 49, 247));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(CadastroSistema.class.getResource("/interfaceImg/ferramentas-de-revisao-de-codigo.png")));
		lblNewLabel_5.setAlignmentX(0.5f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 821, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
					.addGap(37))
				.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 554, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblNewLabel_4_1 = new JLabel("CADASTRO");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(new Color(155, 49, 247));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Voltar");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(CadastroSistema_Client.class.getResource("/interfaceImg/seta-esquerda (1).png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.retorno();
			}
		});
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4_1, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
					.addGap(6))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(nameUser, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(surnameUser, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(senhaUser, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(185)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(184))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(233)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(234))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(9))
						.addComponent(lblNewLabel_4_1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(nameUser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(15)
					.addComponent(surnameUser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(senhaUser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}
	

}
