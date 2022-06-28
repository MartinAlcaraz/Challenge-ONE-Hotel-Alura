package com.hotelAlura.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

import com.hotelAlura.controller.ReservaController;
import com.hotelAlura.model.Huesped;
import com.hotelAlura.controller.HuespedController;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<String> txtNacionalidad;
	private int idReserva;
	private ReservaController reservaController;
	private HuespedController huespedController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped(-1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistroHuesped(int idReserva) {

		reservaController = new ReservaController();
		huespedController = new HuespedController();
		this.idReserva = idReserva;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/persona.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBounds(576, 128, 255, 33);
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBounds(576, 195, 255, 33);
		contentPane.add(txtApellido);

		txtFechaN = new JDateChooser();
		// para que no pueda editarse la fecha ingresando desde teclado
		((JTextField) txtFechaN.getDateEditor()).setEditable(false);

		txtFechaN.setBounds(576, 260, 255, 33);
		contentPane.add(txtFechaN);

		txtNacionalidad = new JComboBox<String>();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 14));

		String[] nacionalidad = new String[] { "Afghanistan–Afeganistão", "Afghan–afegão", "Andorra–Andorra",
				"Andorran–andorrano", "Angola–Angola", "Angolan–angolano", "AntiguaeBarbuda–AntíguaeBarbuda",
				"Antiguan/Barbudan–antiguano", "Algeria–Argélia", "Algerian–argelino", "Argentina–Argentina",
				"Argentinian–argentino", "Armenia–Arménia", "Armenian–arménio", "Australia–Austrália",
				"Australian–australiano", "Austria–Áustria", "Austrian–austríaco", "Azerbaijan–Azerbaijão",
				"Azerbaijani–azeri", "TheBahamas–Bahamas", "Bahamian–bahamense", "Bangladesh–Bangladesh",
				"Bangladeshi–bangladés", "Barbados–Barbados", "Barbadian–barbadiano", "Bahrain–Barém",
				"Bahraini–baremita", "Belarus–Bielorrússia", "Belarusian–bielorrusso", "Belgium–Bélgica",
				"Belgian–belga", "Belize–Belize", "Belizean–belizenho", "Benin–Benim", "Beninese–beninense",
				"Bolivia–Bolívia", "Bolivian–boliviano", "Bosnia;BosniaandHerzegovina–Bósnia;BósniaeHerzegovina",
				"Bosnian–bósnio", "Botswana–Botsuana", "Motswana–bechuano", "Brazil–Brasil", "Brazilian–brasileiro",
				"Brunei–Brunei", "Bruneian–bruneano", "Bulgaria–Bulgária", "Bulgarian–búlgaro",
				"BurkinaFaso–BurkinaFaso", "Burkinabé–burquinense", "Burundi–Burundi", "Burundian–burundés",
				"Bhutan–Butão", "Bhutanese–butanense", "CapeVerde–CaboVerde", "CapeVerdean–cabo-verdiano",
				"Cameroon–Camarões", "Cameroonian–camaronense", "Cambodia–Camboja", "Cambodian–cambojano", "",
				"Canada–Canadá", "Canadian–canadense", "", "CentralAfricanRepublic–RepúblicaCentro-Africana",
				"Central-african–centroafricano", "", "Chad–Chade", "Chadian–chadiano", "", "China–China",
				"Chinese–chinés", "", "Chile–Chile", "Chilean–chileno", "", "CookIslands–IlhasCook",
				"CookIslander–cookiano", "", "Colombia–Colómbia", "Colombian–colombiano", "", "Comoros–Comores",
				"Comoran–comoriano", "", "CostaRica–CostaRica", "CostaRican–costa-riquenho", "", "Croatia–Croácia",
				"Croatian–croata", "", "Cuba–Cuba", "Cuban–Cubano", "", "Cyprus–Chipre", "Cypriot–cipriota", "",
				"CzechRepublic–RepúblicaTcheca", "Czech–tcheco", "",
				"DemocraticRepublicofCongo–RepúblicaDemocráticadoCongo", "Congolese–congolense", "",
				"Denmark–Dinamarca", "Danish–dinamarqués", "", "Djibouti–Djibuti", "Djiboutian–djibutiense", "",
				"Dominica–Dominica", "Dominican–dominiquense", "", "DominicanRepublic–RepúblicaDominicana",
				"Dominican–dominicano", "", "EastTimor–TimorLeste", "EastTimorese–timorense", "", "Ecuador–Equador",
				"Ecuadorian–equatoriano", "", "Egypt–Egito", "Egyptian–egípcio", "", "ElSalvador–ElSalvador",
				"Salvadorean–salvadorenho", "", "England–Inglaterra", "English–inglés", "",
				"EquatorialGuinea–GuinéEquatorial", "Equatoguinean–guinéu-equatoriano", "", "Eritrea–Eritreia",
				"Eritrean–eritreu", "", "Estónia–Estónia", "Estonian–estoniano", "", "Fiji–Fiji", "Fijian–fijiano", "",
				"Finland–Finlándia", "Finnish–finlandés", "", "France–França", "French–francés", "", "Gabon–Gabão",
				"Gabonese–gabonense", "", "Gambia–Gámbia", "Gambian–gambiano", "", "Georgia–Geórgia",
				"Georgian–geórgico", "", "Germany–Alemanha", "German–alemão", "", "Grenada–Granada",
				"Grenadian–granadino", "", "Greece–Grécia", "Greek–grego", "", "Guatemala–Guatemala",
				"Guatemalan–guatemalteco", "", "Guinea–Guiné", "Guinean–guineano", "", "Guinea–Bissau–GuinéBissau",
				"Bissau–guinean–guineense", "", "Guyana–Guiana", "Guyanese–guianense", "", "Haiti–Haiti",
				"Haitian–haitiano", "", "Holland–Holanda", "Dutch–holandés", "", "Honduras–Honduras",
				"Honduran–hondurenho", "", "Hungary–Hungria", "Hungarian–húngaro", "", "Iceland–Islándia",
				"Icelander–islandés", "", "India–Índia", "Indian–indiano", "", "Indonesia–Indonésia",
				"Indonesian–indonésio", "", "Iran–Irã", "Iranian–iraniano", "", "Ireland–Irlanda", "Irish–irlandés", "",
				"Israel–Israel", "Israeli–israelita", "", "Italy–Itália", "Italian–italiano", "",
				"IvoryCoast–CostadoMarfim", "Ivorian–costa-marfinense", "", "Jamaica–Jamaica", "Jamaican–jamaicano", "",
				"Japan–Japão", "Japanese–japonés", "", "Jordan–Jordánia", "Jordanian–jordão", "",
				"Kazakhstan–Cazaquistão", "Kazakh–cazaque", "", "Kenya–Quénia", "Kenyan–queniano", "",
				"Kiribati–Quiribati", "I-kiribati–quiribatiano", "", "Kyrgyzstan–Quirguistão",
				"Kyrgyzstani–quirguistanés", "", "Kwait–Kuwait", "Kwaiti–kuwaitiano", "", "Laos–Laos",
				"Laotian–laosiano", "", "Latvia–Letónia", "Latvian–letoniano", "", "Lebanon–Líbano", "Lebanese–libanés",
				"", "Lesotho–Lesoto", "Basotho–lesotiano", "", "Liberia–Libéria", "Liberian–liberiano", "",
				"Liechtenstein–Liechtenstein", "Liechtensteiner–liechtensteinense", "", "Lithuania–Lituánia",
				"Lithuanian–lituano", "", "Luxembourg–Luxemburgo", "Luxembourgish–luxemburgués", "", "Lybia–Líbia",
				"Lybian–líbio", "", "Macedonia–Macedónia", "Macedonian–macedónio", "", "Madagascar–Madagascar",
				"Malagasy–madagascarense", "", "Malaysia–Malásia", "Malaysian–malaio", "", "Malawi–Malaui",
				"Malawian–malauiano", "", "Maldives–Maldivas", "Maldivian–maldivo", "", "Mali–Máli", "Malian–maliano",
				"", "Malta–Malta", "Maltese–maltés", "", "Mauritius–Maurício", "Mauritian–mauriciano", "",
				"Mauritia–Mauritánia", "Mauritanian–mauritano", "", "MarshallIsland–IlhasMarshall",
				"MarshallIslander–marshallino", "",
				"Micronesia/FederatedStatesofMicronesia–EstadosFederadosdaMicronésia", "Micronesian–micronésio", "",
				"Mexico–México", "Mexican–mexicano", "", "Morocco–Marrocos", "Moroccan–marroquino", "",
				"Moldova–Moldavia", "Moldovan–moldávio", "", "Monaco–Mónaco", "Monacan–monegasco", "",
				"Mongolia–Mongólia", "Mongolian–mongol", "", "Montenegro–Montenegro", "Montenegrin–montenegrino", "",
				"Mozambique–Moçambique", "Mozambican–moçambicano", "", "Myanmar–Myanmar", "Burmese–birmanés", "",
				"Namibia–Namíbia", "Namibian–namibiano", "", "Nauru–Nauru", "Nauruan–nauruano", "", "Nepal–Nepal",
				"Nepali–nepalés", "", "NewZealand–NovaZelándia", "NewZealander–neozelandés", "", "Nicaragua–Nicarágua",
				"Nicaraguan–nicaraguense", "", "Niger–Níger", "Nigerien–nigerino", "", "Nigeria–Nigéria",
				"Nigerian–nigeriano", "", "Niue–Niue", "Niuean–niuano", "", "NorthKorea–CoréiadoNorte",
				"Northkorean–norte-coreano", "", "Norway–Noruega", "Norwegian–noruegués", "", "Oman–Omã",
				"Omani–omanense", "", "Palestine–Palestina", "Palestinian–palestino", "", "Pakistan–Paquistão",
				"Pakistanese–paquistanés", "", "Palau–Palau", "Palauan–palauense", "", "Panama–Panamá",
				"Panamanian–panamenho", "", "PapuaNewGuinea–PapuaNovaGuiné", "PapuaNewGuinean–papuásio", "",
				"Paraguay–Paraguai", "Paraguayan–paraguaio", "", "Peru–Peru", "Peruvian–peruano", "",
				"Philippines–Philippines", "Philippine–filipino", "", "Poland–Polónia", "Polish–polonés", "",
				"Portugal–Portugal", "Portuguese–portugués", "", "Qatar–Catar", "Qatari–catarense", "",
				"Romania–Roménia", "Romanian–romeno", "", "Russia–Rússia", "Russian–russo", "", "Rwanda–Ruanda",
				"Rwandan–ruandés", "", "Samoa–Samoa", "Samoan–samoano", "", "SaintLucia–SantaLúcia",
				"SaintLucian–santa-lucense", "", "SaintKittsandNevis–SãoCristóvãoeNevis", "Kittian–são-cristovense", "",
				"SanMarino–SãoMarino", "SanMarinan–são-marinense", "", "SaoToméandPrincipe–SãoToméePríncipe",
				"SaoTomean–são-tomense", "", "SaintVincentandtheGrenadines–SãoVicenteeGranadinas",
				"Vicentinian–são-vicentino", "", "Scotland–Escócia", "Scottish–escocés", "", "Senegal–Senegal",
				"Senegalese–senegalense", "", "Serbia–Sérvia", "Serbian–sérvio", "", "Seychelles–Seicheles",
				"Seychellois–seichelense", "", "SierraLeone–SerraLeoa", "SierraLeonean–serra-leonés", "",
				"Singapore–Singapura", "Singaporean–singapurense", "", "Slovakia–Eslováquia", "Slovak–eslovaco", "",
				"SolomonIslands–IlhasSalomão", "SolomonIslander–salomónico", "", "Somalia–Somália", "Somali–somali", "",
				"SouthAfrica–ÁfricadoSul", "SouthAfrican–sul–africano", "", "SouthKorea–CoréiadoSul", "Korean–coreano",
				"", "SouthSudan–SudãodoSul", "SouthSudanese–sul-sudanense", "", "Spain–Espanha", "Spanish–espanhol", "",
				"SriLanka–SriLanka", "SriLankan–srilankés", "", "Sudan–Sudão", "Sudanese–sudanense", "",
				"Suriname–Suriname", "Surinamese–surinamés", "", "Swaziland–Suazilándia", "Swazi–suazi", "",
				"Sweden–Suécia", "Swedish–sueco", "", "Switzerland–Suíça", "Swiss–suíço", "", "Syria–Síria",
				"Syrian–sírio", "", "Tajikistan–Tadiquistão", "Tajiki–tajique", "Tanzanian–tanzaniano",
				"Thailand–Tailándia", "Thai–tailandés", "Togo–Togo", "Togolese–togolés", "Tonga–Tonga",
				"Tongan–tonganés", "TrinidadandTobago–TrindadeeTobago", "Trinidadian–trinitário", "", "Tunisia–Tunísia",
				"Tunisian–tunisiano", "Turkmenistan–Turcomenistão", "Turkmen–turcomeno", "Turkey–Turquia",
				"Turkish–turco", "Tuvalu–Tuvalu", "Tuvaluan–tuvaluano", "Ukraine–Ucránia", "Ukrainian–ucraniano",
				"Uganda–Uganda", "Ugandan–ugandés", "Uruguay–Uruguai", "Uruguayan–uruguaio",
				"UnitedArabEmirates–EmiradosÁrabesUnidos", "Emirati–árabe", "UnitedKingdom–ReinoUnido",
				"British–británico", "UnitedStatesofAmerica–EstadosUnidos", "American–americano",
				"Uzbekistan–Usbequistão", "Uzbek–uzbeque", "Vanuatu–Vanuatu", "Ni-vanuatu–vanuatuano",
				"Venezuela–Venezuela", "Venezuelan–venezuelano", "Vietnam–Vietnã", "Vietnamese–vietnamita",
				"Wales–PaísdeGales", "Welsh–galés", "Yemen–Iémen", "Yemeni–iemenita", "Zambia–Zámbia",
				"Zambian–zambiano", "Zimbabwe–Zimbábue", "Zimbabwean–zimbabueano" };

		txtNacionalidad.setModel(new DefaultComboBoxModel<String>(nacionalidad));
		txtNacionalidad.setBounds(576, 330, 255, 33);
		contentPane.add(txtNacionalidad);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(578, 105, 253, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(576, 172, 255, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(576, 240, 255, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nacionalidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(576, 308, 255, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro.png")));
		lblNewLabel.setBounds(0, 0, 502, 556);
		contentPane.add(lblNewLabel);

		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Quiere volver atras? La reserva no se guardará.");
				if (respuesta == JOptionPane.OK_OPTION) {

					reservaController.eliminarReserva(idReserva);

					Reservas ventanaReservas = new Reservas();
					ventanaReservas.setVisible(true);
					dispose();
				}
			}
		});
		btnCancelar.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/cancelar.png")));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(764, 525, 54, 41);
		contentPane.add(btnCancelar);

		JButton btnGuardar = new JButton("");

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (camposValidos()) {
					guardarHuesped();
					Exito exito = new Exito();
					exito.setVisible(true);
					dispose();
				}
			}
		});
		btnGuardar.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/disquete.png")));
		btnGuardar.setBackground(SystemColor.menu);
		btnGuardar.setBounds(700, 525, 54, 41);
		contentPane.add(btnGuardar);

		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int respuesta = JOptionPane.showConfirmDialog(null,
						"Quiere salir al menú principal? La reserva no se guardará.");
				if (respuesta == JOptionPane.OK_OPTION) {

					reservaController.eliminarReserva(idReserva);

					MenuUsuario usuario = new MenuUsuario();
					usuario.setVisible(true);
					dispose();
				}

			}
		});
		btnSalir.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnSalir.setBackground(SystemColor.menu);
		btnSalir.setBounds(828, 525, 54, 41);
		contentPane.add(btnSalir);

		JLabel lblNewLabel_1_2 = new JLabel("Teléfono");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(578, 380, 253, 14);
		contentPane.add(lblNewLabel_1_2);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(576, 400, 255, 33);
		contentPane.add(txtTelefono);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(780, 11, 95, 95);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Registro de Huésped");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(576, 45, 198, 42);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_1_2_1 = new JLabel("Número de Reserva");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(578, 445, 253, 14);
		contentPane.add(lblNewLabel_1_2_1);

		txtNreserva = new JTextField();
		txtNreserva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNreserva.setEnabled(false);
		txtNreserva.setEditable(false);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBounds(576, 465, 255, 33);
		txtNreserva.setText(String.valueOf(idReserva));
		contentPane.add(txtNreserva);
	}

	private void guardarHuesped() {
		Date fechaNac = txtFechaN.getDate();
		java.sql.Date fechaNacSQL = new java.sql.Date(fechaNac.getTime());
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String nacionalidad = String.valueOf(txtNacionalidad.getSelectedItem());
		String telefono = txtTelefono.getText();

		Huesped huesped = new Huesped(nombre, apellido, nacionalidad, telefono, fechaNacSQL, idReserva);

		huespedController.registrar(huesped);
	}

	private boolean telefonoValido() {
		String telefono = txtTelefono.getText();

		Pattern p = Pattern.compile("[0-9]{5,14}");
		Matcher m = p.matcher(telefono);

		boolean esNumero = m.matches();

		return esNumero;
	}

	private boolean camposValidos() {

		if (txtNombre.getText().equals("") || txtApellido.getText().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Complete los campos nombre y apellido.");
			return false;
		}

		if (txtFechaN.getDate() == null) {
			JOptionPane.showMessageDialog(contentPane, "Ingrese fecha de nacimiento.");
			return false;
		}

		if (txtTelefono.getText().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Ingrese un numero de telefono.");
			return false;
		}
		if (!telefonoValido()) {
			JOptionPane.showMessageDialog(contentPane, "El telefono tiene que tener entre 5 y 14 numeros.");
			return false;
		}

		return true;
	}
}
