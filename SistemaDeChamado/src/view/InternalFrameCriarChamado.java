package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InternalFrameCriarChamado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameCriarChamado frame = new InternalFrameCriarChamado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public InternalFrameCriarChamado() {
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Formulairo Abertura de Chamado");
		setBounds(100, 100, 715, 572);
		
		JLabel lblNewLabel = new JLabel("Formulário Abertura de Chamado");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Solicitante");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 10, 134, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(21, 29, 235, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Área do Solicitante");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(21, 69, 125, 13);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(21, 92, 184, 25);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Data de Resgistro");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(304, 10, 125, 15);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(304, 29, 119, 25);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cargo");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(235, 66, 51, 18);
		panel.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(235, 92, 194, 25);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_3 = new JLabel("Área de Atendimento");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "TI", "MANUTENCAO", "SUPRIMENTO", "ADMINISTRACAO"}));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Área de Atendimento");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Incidente", "Requisição"}));
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Descrição do Chamado");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addGap(24))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(246)
							.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(184)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3)
						.addComponent(lblNewLabel_1_3_1))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblNewLabel_1_3_2)
					.addGap(10)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);

	}
}
