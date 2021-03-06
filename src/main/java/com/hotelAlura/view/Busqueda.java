package com.hotelAlura.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.hotelAlura.controller.HuespedController;
import com.hotelAlura.controller.ReservaController;
import com.hotelAlura.model.Huesped;
import com.hotelAlura.model.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tablaHuespedes;
	private JTable tablaReservas;
	private HuespedController huespedController;
	private ReservaController reservaController;

	private DefaultTableModel modeloHuesped;
	private DefaultTableModel modeloReserva;

	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void configurarTablaHuespedes() {
		modeloHuesped = (DefaultTableModel) tablaHuespedes.getModel();	
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Id Reserva");	
	}

	private void configurarTablaReservas() {
		modeloReserva = (DefaultTableModel) tablaReservas.getModel();
		modeloReserva.addColumn("Fecha Entrada");
		modeloReserva.addColumn("Fecha Salida");
		modeloReserva.addColumn("Forma de Pago");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Id Reserva");
	}

	private void cargarTablaHuespedes() {
		List<Huesped> listaHuespedes = huespedController.listaHuespedes();

		listaHuespedes.forEach(huesped -> {
			modeloHuesped
					.addRow(new Object[] { huesped.getNombre(), huesped.getApellido(), huesped.getFechaNacimiento(),
							huesped.getNacionalidad(), huesped.getTelefono(), huesped.getId_Reserva() });
		});
		
		
	}

	private void cargarTablaReservas() {
		List<Reserva> listaReservas = reservaController.listaReservas();

		listaReservas.forEach(reserva -> {
			modeloReserva.addRow(new Object[] { reserva.getFechaEntrada(), reserva.getFechaSalida(),
					reserva.getFormaDePago(), reserva.getValor(), reserva.getId() });
		});
	}

	private void borrarTablaHuespedes() {
		modeloHuesped.getDataVector().clear();
	}

	private void borrarTablaReservas() {
		modeloReserva.getDataVector().clear();
	}

	private void buscar(String texto) {

		try {
			int numero = Integer.valueOf(texto);
			buscarReservas(numero);
		} catch (Exception e) {
		}
		buscarHuesped(texto);
		actualizarTablas();
	}

	private void actualizarTablas() {
		tablaHuespedes.updateUI();
		tablaReservas.updateUI();
	}

	private void buscarHuesped(String texto) {
		List<Huesped> listaHuespedes = huespedController.listaHuespedes();
		String text = texto.toLowerCase();
		listaHuespedes.forEach(huesped -> {
			String apellido = huesped.getApellido().toLowerCase();
			if (apellido.contains(text)) {
				modeloHuesped
						.addRow(new Object[] { huesped.getNombre(), huesped.getApellido(), huesped.getFechaNacimiento(),
								huesped.getNacionalidad(), huesped.getTelefono(), huesped.getId_Reserva() });
			}
		});
	}

	private void buscarReservas(int numeroReserva) {

		List<Reserva> listaReservas = reservaController.listaReservas();
		listaReservas.forEach(reserva -> {
			if (reserva.getId() == numeroReserva) {
				modeloReserva.addRow(new Object[] { reserva.getFechaEntrada(), reserva.getFechaSalida(),
						reserva.getFormaDePago(), reserva.getValor(), reserva.getId() });
			}
		});
	}

	private boolean noTieneFilaElegida(JTable tabla) {
		return (tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0) ;
	}

	private void eliminarReserva() {

		if (modeloReserva.getValueAt(tablaReservas.getSelectedRow(), tablaReservas.getSelectedColumn()) != null) {

			Integer id = Integer.valueOf(modeloReserva.getValueAt(tablaReservas.getSelectedRow(), 4).toString());

			int itemsEliminados = reservaController.eliminar(id);

			modeloReserva.removeRow(tablaReservas.getSelectedRow());

			// remueve la fila en la tabla huespedes
			for (int i = 0; i < tablaHuespedes.getRowCount(); i++) {
				int idTablaReservas = (int) tablaHuespedes.getValueAt(i, 5);
				if (idTablaReservas == id) {
					modeloHuesped.removeRow(i);
					break;
				}
			}
			JOptionPane.showMessageDialog(this, itemsEliminados + " item eliminado con ??xito!");
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
		}
	}

	private void eliminarHuesped() {

		if (modeloHuesped.getValueAt(tablaHuespedes.getSelectedRow(), tablaHuespedes.getSelectedColumn()) != null) {

			Integer id = Integer.valueOf(modeloHuesped.getValueAt(tablaHuespedes.getSelectedRow(), 5).toString());

			int itemsEliminados = reservaController.eliminar(id);

			modeloHuesped.removeRow(tablaHuespedes.getSelectedRow());

			// remueve la fila en la tabla reservas
			for (int i = 0; i < tablaReservas.getRowCount(); i++) {
				int idTablaReservas = (int) tablaReservas.getValueAt(i, 4);
				if (idTablaReservas == id) {
					modeloReserva.removeRow(i);
					break;
				}
			}

			JOptionPane.showMessageDialog(this, itemsEliminados + " item eliminado con ??xito!");
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
		}
	}

	private void editarHuesped() {

		if (modeloHuesped.getValueAt(tablaHuespedes.getSelectedRow(), tablaHuespedes.getSelectedColumn()) != null) {

			Integer idReserva = Integer.valueOf(modeloHuesped.getValueAt(tablaHuespedes.getSelectedRow(), 5).toString());
			
			EditarRegistroHuesped editarHuesped = new EditarRegistroHuesped(this, huespedController, idReserva);

			this.setEnabled(false);
			
			editarHuesped.setVisible(true);
			
			editarHuesped.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					borrarTablaHuespedes();
					cargarTablaHuespedes();
					tablaHuespedes.clearSelection();
				}
			});
		
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
		}
	}
	
	private void editarReserva() {
		
		if (modeloReserva.getValueAt(tablaReservas.getSelectedRow(), tablaReservas.getSelectedColumn()) != null) {

			Integer idReserva = Integer.valueOf(modeloReserva.getValueAt(tablaReservas.getSelectedRow(), 4).toString());
			
			EditarReserva editarReserva = new EditarReserva(this, reservaController, idReserva);

			this.setEnabled(false);
			
			editarReserva.setVisible(true);
			
			editarReserva.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					borrarTablaReservas();
					cargarTablaReservas();
					tablaReservas.clearSelection();
				}
			});
		
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Busqueda() {
		
		huespedController = new HuespedController();
		reservaController = new ReservaController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(615, 90, 190, 31);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				borrarTablaHuespedes();
				borrarTablaReservas();

				String texto = txtBuscar.getText();
				if (!texto.equals("")) {
					buscar(texto);
				}
			}
		});

		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/lupa2.png")));
		btnBuscar.setBounds(815, 85, 54, 41);
		contentPane.add(btnBuscar);

		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char key = e.getKeyChar();
				
				if (key == KeyEvent.VK_ENTER) {
					btnBuscar.doClick();			
				}
			}
		});
		
		
		JButton btnEditar = new JButton("");		
		btnEditar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/editar-texto.png")));
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBounds(633, 416, 54, 41);
		contentPane.add(btnEditar);

		JLabel lblNewLabel_4 = new JLabel("Sistema de B??squeda");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_4.setBounds(155, 42, 258, 42);
		contentPane.add(lblNewLabel_4);

		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(815, 416, 54, 41);
		contentPane.add(btnSalir);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(10, 127, 874, 265);
		contentPane.add(panel);

		JScrollPane scrollPaneHuespedes = new JScrollPane();
		panel.addTab("Huespedes", new ImageIcon(Busqueda.class.getResource("/imagenes/persona.png")), scrollPaneHuespedes, null);
		
		//tablaHuespedes = new JTable();
		tablaHuespedes = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaHuespedes.setFont(new Font("Arial", Font.PLAIN, 14));
		
		scrollPaneHuespedes.setViewportView(tablaHuespedes);
		

		JScrollPane scrollPaneReservas = new JScrollPane();
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/calendario.png")), scrollPaneReservas, null);
		
		//en lugar de instanciar tablaReservas = new JTable(); se instancia la tabla sobreescribiendo el metodo isCellEditable para evitar que se puedan editar las celdas en la tabla.
		tablaReservas = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tablaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaReservas.setFont(new Font("Arial", Font.PLAIN, 14));
		

		scrollPaneReservas.setViewportView(tablaReservas);

		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (scrollPaneHuespedes.isVisible()) {
					if (noTieneFilaElegida(tablaHuespedes)) {
						JOptionPane.showMessageDialog(null, "Por favor, elije un item.");
						return;
					}
					
					int respuesta = preguntar("Eliminar el huesped?");

					if (respuesta == JOptionPane.YES_OPTION) {
						eliminarHuesped();
					}
				} else {
					if (noTieneFilaElegida(tablaReservas)) {
						JOptionPane.showMessageDialog(null, "Por favor, elije un item.");
						return;
					}
					int respuesta = preguntar("Eliminar la reserva?");
					
					if (respuesta == JOptionPane.YES_OPTION) {
						eliminarReserva();
					}
				}
				actualizarTablas();
			}

		});

		btnEliminar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/deletar.png")));
		btnEliminar.setBackground(SystemColor.menu);
		btnEliminar.setBounds(697, 416, 54, 41);
		contentPane.add(btnEliminar);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(25, 10, 104, 107);
		contentPane.add(lblNewLabel_2);

		JButton btnVerTodo = new JButton("Ver todas las reservas y huespedes");
		btnVerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTablaReservas();
				borrarTablaHuespedes();
				cargarTablaReservas();
				cargarTablaHuespedes();
				actualizarTablas();
			}
		});
		btnVerTodo.setFont(new Font("Arial", Font.BOLD, 14));
		btnVerTodo.setBounds(275, 85, 309, 41);
		contentPane.add(btnVerTodo);

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (scrollPaneHuespedes.isVisible()) {
					if (noTieneFilaElegida(tablaHuespedes)) {
						JOptionPane.showMessageDialog(null, "Por favor, elije un item");
						return;
					}
					editarHuesped();
				} else {
					if (noTieneFilaElegida(tablaReservas)) {
						JOptionPane.showMessageDialog(null, "Por favor, elije un item");
						return;
					}
					editarReserva();
				}
			}
		});

		
		setResizable(false);

		configurarTablaReservas();
		configurarTablaHuespedes();
		cargarTablaReservas();
		cargarTablaHuespedes();
	}
	
	private int preguntar(String pregunta) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(rootPane, pregunta,
				"Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				opciones, "Aceptar");
		return eleccion;
	}

}
