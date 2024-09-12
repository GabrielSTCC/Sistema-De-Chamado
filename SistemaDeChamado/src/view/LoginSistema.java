package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.lang.classfile.TypeAnnotation.ThrowsTarget;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import controller.FormLoginController;

import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;

public class LoginSistema extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passwordText;
	private FormLoginController controller;
	
	public JTextField getUserText() {
		return userText;
	}


	public void setUserText(JTextField userText) {
		this.userText = userText;
	}


	public JPasswordField getPasswordText() {
		return passwordText;
	}


	public void setPasswordText(JPasswordField passwordText) {
		this.passwordText = passwordText;
	}
	
	
	public LoginSistema() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controller = new FormLoginController(this);
		setBounds(100, 100, 872, 567);
		setBackground(new Color(48, 6, 103));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 6, 103));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setIgnoreRepaint(true);
		panel.setBackground(new Color(38, 32, 62));
		
		
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastro();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(155, 49, 247));
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					controller.login();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(155, 49, 247));
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE CHAMADO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(155, 49, 247));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setForeground(new Color(255, 255, 255));
		senhaLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel nomeLabel = new JLabel("Usuario:");
		nomeLabel.setBackground(new Color(255, 255, 255));
		nomeLabel.setForeground(new Color(255, 255, 255));
		nomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		userText = new JTextField();
		userText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("SISTEMA DE CHAMADO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_4, lblNewLabel_3, btnNewButton_1, btnNewButton, senhaLabel, nomeLabel, userText, passwordText}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(nomeLabel, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addGap(158))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(151)
					.addComponent(userText, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addGap(151))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(158)
					.addComponent(senhaLabel, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addGap(158))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(151)
					.addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addGap(151))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(201)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addGap(201))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(201)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addGap(201))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(9))
						.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addGap(0)
					.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(userText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(senhaLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon(LoginSistema.class.getResource("/interfaceImg/ferramentas-de-revisao-de-codigo.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(179)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 922, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(52))
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 540, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
