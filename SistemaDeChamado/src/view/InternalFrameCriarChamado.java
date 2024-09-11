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

import controller.FormChamadoController;
import model.Usuario;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InternalFrameCriarChamado extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldArea;
	private JTextField textFieldData;
	private JTextField textFieldCargo;
	JComboBox<Object> comboBoxArea;
	JComboBox<Object> comboBoxTitulo;
	JTextArea textDescricao;
	private JButton btnCriarChamado;
	private FormChamadoController controllerChamado;

	public InternalFrameCriarChamado() {
	    // Inicializa os componentes e configura o layout
	    setMaximizable(true);
	    setClosable(true);
	    setResizable(true);
	    setIconifiable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setTitle("Formulário Abertura de Chamado");
	    setBounds(100, 100, 715, 572);

	    // Cria os componentes
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

	    textFieldNome = new JTextField();
	    textFieldNome.setForeground(Color.BLACK);
	    textFieldNome.setEnabled(false);
	    textFieldNome.setFont(new Font("Tahoma", Font.BOLD, 15));
	    textFieldNome.setBounds(21, 29, 235, 25);
	    panel.add(textFieldNome);
	    textFieldNome.setColumns(10);

	    JLabel lblNewLabel_1_1 = new JLabel("Área do Solicitante");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_1_1.setBounds(21, 69, 125, 13);
	    panel.add(lblNewLabel_1_1);

	    textFieldArea = new JTextField();
	    textFieldArea.setEnabled(false);
	    textFieldArea.setFont(new Font("Tahoma", Font.BOLD, 15));
	    textFieldArea.setColumns(10);
	    textFieldArea.setBounds(21, 92, 184, 25);
	    panel.add(textFieldArea);

	    JLabel lblNewLabel_1_2 = new JLabel("Data de Registro");
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_1_2.setBounds(304, 10, 125, 15);
	    panel.add(lblNewLabel_1_2);

	    textFieldData = new JTextField();
	    textFieldData.setEnabled(false);
	    textFieldData.setFont(new Font("Tahoma", Font.BOLD, 15));
	    textFieldData.setColumns(10);
	    textFieldData.setBounds(304, 29, 119, 25);
	    panel.add(textFieldData);

	    JLabel lblNewLabel_1_1_1 = new JLabel("Cargo");
	    lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_1_1_1.setBounds(235, 66, 51, 18);
	    panel.add(lblNewLabel_1_1_1);

	    textFieldCargo = new JTextField();
	    textFieldCargo.setEnabled(false);
	    textFieldCargo.setFont(new Font("Tahoma", Font.BOLD, 15));
	    textFieldCargo.setColumns(10);
	    textFieldCargo.setBounds(235, 92, 194, 25);
	    panel.add(textFieldCargo);

	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

	    JLabel lblNewLabel_1_3 = new JLabel("Área de Atendimento");
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

	    comboBoxArea = new JComboBox<Object>();
	    comboBoxArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    comboBoxArea.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "TI", "Manutenção", "Suprimento", "Administração"}));

	    JLabel lblNewLabel_1_3_1 = new JLabel("Solicitação");
	    lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

	    comboBoxTitulo = new JComboBox<Object>();
	    comboBoxTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    comboBoxTitulo.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Incidente", "Requisição"}));

	    JLabel lblNewLabel_1_3_2 = new JLabel("Descrição do Chamado");
	    lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

	    textDescricao = new JTextArea();
	    textDescricao.setFont(new Font("Monospaced", Font.PLAIN, 13));
	    textDescricao.setBorder(new LineBorder(new Color(0, 0, 0)));
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

	    btnCriarChamado = new JButton("Criar");
	    btnCriarChamado.addActionListener(this);
	    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	    gl_panel_1.setHorizontalGroup(
	        gl_panel_1.createParallelGroup(Alignment.LEADING)
	            .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
	                .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
	                    .addGroup(gl_panel_1.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(btnCriarChamado, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(gl_panel_1.createSequentialGroup()
	                        .addGap(9)
	                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
	                            .addComponent(textDescricao, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
	                            .addGroup(gl_panel_1.createSequentialGroup()
	                                .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
	                                .addGap(246)
	                                .addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
	                            .addGroup(gl_panel_1.createSequentialGroup()
	                                .addComponent(comboBoxArea, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
	                                .addGap(184)
	                                .addComponent(comboBoxTitulo, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
	                            .addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
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
	                    .addComponent(comboBoxArea, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(comboBoxTitulo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	                .addGap(10)
	                .addComponent(lblNewLabel_1_3_2)
	                .addGap(10)
	                .addComponent(textDescricao, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
	                .addGap(23)
	                .addComponent(btnCriarChamado)
	                .addContainerGap())
	    );
	    panel_1.setLayout(gl_panel_1);
	    getContentPane().setLayout(groupLayout);

	    // Cria o controlador após a inicialização dos componentes
	    controllerChamado = new FormChamadoController(this);
	    controllerChamado.preencherChamado();
	}


	public JTextField getTextFieldNome() {
	    return textFieldNome;
	}

	public void setTextFieldNome(String nome) {
	    if (textFieldNome != null) {
	        textFieldNome.setText(nome);
	    }
	}

	public JTextField getTextFieldArea() {
	    return textFieldArea;
	}

	public void setTextFieldArea(String area) {
	    if (textFieldArea != null) {
	        textFieldArea.setText(area);
	    }
	}

	public JTextField getTextFieldData() {
	    return textFieldData;
	}

	public void setTextFieldData(String data) {
	    if (textFieldData != null) {
	        textFieldData.setText(data);
	    }
	}

	public JTextField getTextFieldCargo() {
	    return textFieldCargo;
	}

	public void setTextFieldCargo(String cargo) {
	    if (textFieldCargo != null) {
	        textFieldCargo.setText(cargo);
	    }
	}

	public JComboBox<Object> getComboBoxArea() {
	    return comboBoxArea;
	}

	public void setComboBoxArea(JComboBox<Object> comboBoxArea) {
	    this.comboBoxArea = comboBoxArea;
	}

	public JComboBox<Object> getComboBoxTitulo() {
	    return comboBoxTitulo;
	}

	public void setComboBoxTitulo(JComboBox<Object> comboBoxTitulo) {
	    this.comboBoxTitulo = comboBoxTitulo;
	}

	public JTextArea getTextDescricao() {
	    return textDescricao;
	}

	public void setTextDescricao(JTextArea textDescricao) {
	    this.textDescricao = textDescricao;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCriarChamado) {
			actionPerformedBtnCriarChamadoJButton(e);
		}
	}
	protected void actionPerformedBtnCriarChamadoJButton(ActionEvent e) {
		controllerChamado.criarChamado();
	}
}
