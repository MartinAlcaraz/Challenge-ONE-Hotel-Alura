package com.hotelAlura.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Exito extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Exito dialog = new Exito(-1);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Exito(int idReserva) {		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/aH-40px.png")));
		setBounds(100, 100, 394, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
			lblNewLabel.setBounds(123, 11, 100, 100);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente.");
			lblNewLabel_1.setForeground(new Color (12, 138, 199));
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
			lblNewLabel_1.setBounds(27, 122, 322, 21);
			contentPanel.add(lblNewLabel_1);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Su numero de reserva es:");
		lblNewLabel_1.setForeground(new Color(12, 138, 199));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(27, 154, 195, 21);
		contentPanel.add(lblNewLabel_1);
		
		JLabel id_Reserva = new JLabel(String.valueOf(idReserva));
		id_Reserva.setForeground(Color.BLACK);
		id_Reserva.setFont(new Font("Arial", Font.BOLD, 16));
		id_Reserva.setBounds(224, 154, 74, 21);
		contentPanel.add(id_Reserva);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();//sirve para cerrar la ventana actual
						MenuUsuario usuario = new MenuUsuario(); 
						usuario.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
