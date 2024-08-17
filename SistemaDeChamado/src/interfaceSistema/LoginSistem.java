package interfaceSistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estilizacao.Responsividade;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.color.ColorSpace;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.font.ImageGraphicAttribute;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.DebugGraphics;

public class LoginSistem extends JFrame {
	
	Responsividade tela;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					LoginSistem frame = new LoginSistem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LoginSistem() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLayout(new GridLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		tela = new Responsividade("/interfaceImg/ferramentas-de-revisao-de-codigo.png");
		getContentPane().add(tela);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBackground(new Color(255, 0, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(85, 492, 166, 34);
		contentPane.add(btnNewButton_1);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(85, 434, 166, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("SISTEMA DE CHAMADO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3.setBounds(10, 11, 1246, 87);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE CHAMADO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(128, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_4.setBounds(10, 11, 1246, 98);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(42, 358, 252, 41);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(42, 297, 252, 50);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(42, 245, 252, 41);
		textField.setMixingCutoutShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(),30, 30));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(42, 184, 252, 50);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		lblNewLabel.setSize(getWidth(), getHeight());
		lblNewLabel.setIcon(new ImageIcon(LoginSistem.class.getResource("/interfaceImg/ferramentas-de-revisao-de-codigo.png")));
		contentPane.add(lblNewLabel);
		
	}
}
