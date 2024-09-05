package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FormCadastroControllerADM;
import model.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import javax.swing.SwingConstants;


public class CadastroSistema extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameUser;
	private JTextField surnameUser;
	private JPasswordField senhaUser;
	private JComboBox<Object> cargosUser;
	private JComboBox<Object> areasUser;
	private FormCadastroControllerADM controller;
	
	public CadastroSistema() {
		setTitle("Cadastro ADM");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		controller = new FormCadastroControllerADM(this);
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
		
		JLabel lblNewLabel_2 = new JLabel("Cargo:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Area:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		senhaUser = new JPasswordField();
		senhaUser.setToolTipText("\r\nTecnico\r\nAnalista\r\nCoordenador\r\nGerente");
		senhaUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cargosUser = new JComboBox<Object>();
		cargosUser.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Tecnico", "Analista", "Coordenador", "Gerente"}));
		cargosUser.setToolTipText("");
		cargosUser.setBorder(new EmptyBorder(0, 0, 0, 0));
		cargosUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cargosUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		areasUser = new JComboBox<Object>();
		areasUser.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "TI", "MANUTENCAO", "SUPRIMENTO", "ADMINISTRACAO"}));
		areasUser.setBorder(new EmptyBorder(0, 0, 0, 0));
		areasUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		areasUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        // Passando os dados para o controller para que ele trate a lógica
				controller.salvaUserADM(nameUser.getText(), surnameUser.getText(), senhaUser.getText(),
						cargosUser.getSelectedItem().toString(), areasUser.getSelectedItem().toString());
		    }
		});
		btnNewButton.setBackground(new Color(155, 49, 247));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(CadastroSistema.class.getResource("/interfaceImg/ferramentas-de-revisao-de-codigo.png")));
		lblNewLabel_5.setAlignmentX(0.5f);
		
		JLabel lblNewLabel_3_1 = new JLabel("CADASTRO");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblNewLabel_4_1 = new JLabel("CADASTRO");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(new Color(155, 49, 247));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(137)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 847, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
					.addGap(13))
				.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 549, Short.MAX_VALUE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4_1, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
					.addGap(12))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(155)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(nameUser, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addGap(153))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(surnameUser, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(cargosUser, 0, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(areasUser, 0, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(senhaUser, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(154))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(184)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(9))
						.addComponent(lblNewLabel_4_1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(nameUser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(surnameUser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(cargosUser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(areasUser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(senhaUser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}
	
}
