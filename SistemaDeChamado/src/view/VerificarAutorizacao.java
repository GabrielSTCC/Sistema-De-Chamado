package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.VerificarAutorizacaoController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VerificarAutorizacao extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	private JButton okButton;
	private JFrame telaFrame;
	private JButton cancelButton;
	private VerificarAutorizacaoController controller;

	public VerificarAutorizacao(JFrame telaFrame) {
		
		this.telaFrame = telaFrame;
		this.controller = new VerificarAutorizacaoController(this);
		
		setLocationRelativeTo(telaFrame);
		setTitle("Autorização");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(48, 6, 103));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textField.setBounds(115, 100, 206, 28);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("INSIRA O CODIGO");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(131, 10, 173, 22);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(38, 32, 62));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setBackground(new Color(155, 49, 247));
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(155, 49, 247));
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			actionPerformedCancelButtonJButton(e);
		}
		if (e.getSource() == okButton) {
			actionPerformedOkButtonJButton(e);
		}
	}
	protected void actionPerformedOkButtonJButton(ActionEvent e) {
		controller.verificar();
	}
	protected void actionPerformedCancelButtonJButton(ActionEvent e) {
		controller.fecharTela();
	}
}
