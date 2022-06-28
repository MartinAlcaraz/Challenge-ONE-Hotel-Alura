package com.hotelAlura.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import com.hotelAlura.controller.ReservaController;
import com.hotelAlura.model.Reserva;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Reservas extends JFrame {

	private JPanel contentPanel;
	private JTextField txtValor;
	private JComboBox<String> txtFormaPago;
	private JDateChooser txtFechaE, txtFechaS;
	private ReservaController reservaController;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reservas() {

		reservaController = new ReservaController();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/imagenes/calendario.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 540);
		setResizable(false);
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 900, 502);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtValor = new JTextField();
		txtValor.setBackground(Color.WHITE);
		txtValor.setForeground(Color.WHITE);
		txtValor.setEnabled(false);
		txtValor.setEditable(false);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValor.setText("50");
		txtValor.setBounds(88, 303, 235, 33);
		panel.add(txtValor);
		txtValor.setColumns(10);

		txtFechaE = new JDateChooser();
		// para que no pueda editarse la fecha ingresando desde teclado
		((JTextField) this.txtFechaE.getDateEditor()).setEditable(false);

		txtFechaE.setBounds(88, 166, 235, 33);
		panel.add(txtFechaE);

		JLabel lblNewLabel_1 = new JLabel("Fecha de Check In");
		lblNewLabel_1.setBounds(88, 142, 133, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Check Out");
		lblNewLabel_1_1.setBounds(88, 210, 133, 14);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);

		txtFechaS = new JDateChooser();
		txtFechaS.setBounds(88, 234, 235, 33);
		txtFechaS.getCalendarButton().setBackground(Color.WHITE);
		((JTextField) this.txtFechaS.getDateEditor()).setEditable(false);
		panel.add(txtFechaS);

		JLabel lblNewLabel_1_1_1 = new JLabel("Valor de la Reserva");
		lblNewLabel_1_1_1.setBounds(88, 278, 133, 14);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1);

		txtFormaPago = new JComboBox<String>();
		txtFormaPago.setBounds(88, 373, 235, 33);
		txtFormaPago.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFormaPago.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Tarjeta de Credito", "Tarjeta de Debito", "Dinero en efectivo" }));

		panel.add(txtFormaPago);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Forma de pago");
		lblNewLabel_1_1_1_1.setBounds(88, 347, 133, 24);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_4 = new JLabel("Sistema de Reservas");
		lblNewLabel_4.setBounds(108, 93, 199, 42);
		lblNewLabel_4.setForeground(new Color(65, 105, 225));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_4);

		JButton btnReservar = new JButton("Continuar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtFechaE.getDate() != null && txtFechaS.getDate() != null) {
					int dias = diasDeReserva();
					if (dias > 0) {
						
						int idReserva = reservar(dias);
						
						RegistroHuesped huesped = new RegistroHuesped(idReserva);
						huesped.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(contentPanel, "Ajuste la fecha de entrada o de salida");
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel, "Ingrese fecha de entrada y salida");
				}
			}
		});

		btnReservar.setForeground(Color.WHITE);
		btnReservar.setBounds(183, 436, 140, 33);
		btnReservar.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/calendario.png")));
		btnReservar.setBackground(new Color(65, 105, 225));
		btnReservar.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(btnReservar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(399, 0, 491, 502);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -16, 500, 539);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/reservas-img-2.png")));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(15, 6, 104, 107);
		panel.add(lblNewLabel_2);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
				dispose();
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtras.setBackground(new Color(65, 105, 225));
		btnAtras.setBounds(88, 426, 67, 52);
		panel.add(btnAtras);
	}

	private int reservar(int dias) {

		Date fechaE = txtFechaE.getDate();
		Date fechaS = txtFechaS.getDate();

		java.sql.Date fechaEntradaSQL = new java.sql.Date(fechaE.getTime());
		java.sql.Date fechaSalidaSQL = new java.sql.Date(fechaS.getTime());

		String formaDePago = (String) txtFormaPago.getSelectedItem();

		Double tarifa = Double.valueOf(txtValor.getText());

		Double valorReserva = tarifa * dias;

		Reserva reserva = new Reserva(fechaEntradaSQL, fechaSalidaSQL, formaDePago, valorReserva);

		int idReserva = reservaController.reservar(reserva);

		return idReserva;
	}

	private int diasDeReserva() {

		Date fechaE = txtFechaE.getDate();
		Date fechaS = txtFechaS.getDate();

		java.sql.Date fechaEntradaSQL = new java.sql.Date(fechaE.getTime());
		java.sql.Date fechaSalidaSQL = new java.sql.Date(fechaS.getTime());

		LocalDate entrada = LocalDate.parse(fechaEntradaSQL.toString());
		LocalDate salida = LocalDate.parse(fechaSalidaSQL.toString());

		long dias = ChronoUnit.DAYS.between(entrada, salida);

		return (int) dias;
	}

	private static void addPopup(Component component, JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
