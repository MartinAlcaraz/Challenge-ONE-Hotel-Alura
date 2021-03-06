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
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class EditarRegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<String> txtNacionalidad;
	private int idReserva;
	private HuespedController huespedController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frameBusqueda = null;
					HuespedController huespedController = null;
					EditarRegistroHuesped frame = new EditarRegistroHuesped(frameBusqueda, huespedController, -1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditarRegistroHuesped(Busqueda frameBusqueda, HuespedController huespedControllerArg, int idReserva) {

		this.huespedController = huespedControllerArg;
		this.idReserva = idReserva;
		Huesped huesped = huespedController.getHuesped(idReserva);

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/persona.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 444, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 128, 255, 33);
		txtNombre.setText(huesped.getNombre());
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBounds(76, 195, 255, 33);
		txtApellido.setText(huesped.getApellido());
		contentPane.add(txtApellido);

		txtFechaN = new JDateChooser();
		// para que no pueda editarse la fecha ingresando desde teclado
		((JTextField) txtFechaN.getDateEditor()).setEditable(false);

		txtFechaN.setBounds(76, 260, 255, 33);

		// evita seleccionar fecha de nacimiento menor de 18 a??os.

		Date fecha = java.sql.Date.valueOf(LocalDate.now().minusYears(18));
		txtFechaN.setMaxSelectableDate(fecha);

		txtFechaN.setDate(huesped.getFechaNacimiento());
		contentPane.add(txtFechaN);

		txtNacionalidad = new JComboBox<String>();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 14));

		String[] nacionalidad = new String[] { "Afghanistan???Afeganist??o", "Afghan???afeg??o", "Andorra???Andorra",
				"Andorran???andorrano", "Angola???Angola", "Angolan???angolano", "AntiguaeBarbuda???Ant??guaeBarbuda",
				"Antiguan/Barbudan???antiguano", "Algeria???Arg??lia", "Algerian???argelino", "Argentina???Argentina",
				"Argentinian???argentino", "Armenia???Arm??nia", "Armenian???arm??nio", "Australia???Austr??lia",
				"Australian???australiano", "Austria?????ustria", "Austrian???austr??aco", "Azerbaijan???Azerbaij??o",
				"Azerbaijani???azeri", "TheBahamas???Bahamas", "Bahamian???bahamense", "Bangladesh???Bangladesh",
				"Bangladeshi???banglad??s", "Barbados???Barbados", "Barbadian???barbadiano", "Bahrain???Bar??m",
				"Bahraini???baremita", "Belarus???Bielorr??ssia", "Belarusian???bielorrusso", "Belgium???B??lgica",
				"Belgian???belga", "Belize???Belize", "Belizean???belizenho", "Benin???Benim", "Beninese???beninense",
				"Bolivia???Bol??via", "Bolivian???boliviano", "Bosnia;BosniaandHerzegovina???B??snia;B??sniaeHerzegovina",
				"Bosnian???b??snio", "Botswana???Botsuana", "Motswana???bechuano", "Brazil???Brasil", "Brazilian???brasileiro",
				"Brunei???Brunei", "Bruneian???bruneano", "Bulgaria???Bulg??ria", "Bulgarian???b??lgaro",
				"BurkinaFaso???BurkinaFaso", "Burkinab?????burquinense", "Burundi???Burundi", "Burundian???burund??s",
				"Bhutan???But??o", "Bhutanese???butanense", "CapeVerde???CaboVerde", "CapeVerdean???cabo-verdiano",
				"Cameroon???Camar??es", "Cameroonian???camaronense", "Cambodia???Camboja", "Cambodian???cambojano", "",
				"Canada???Canad??", "Canadian???canadense", "", "CentralAfricanRepublic???Rep??blicaCentro-Africana",
				"Central-african???centroafricano", "", "Chad???Chade", "Chadian???chadiano", "", "China???China",
				"Chinese???chin??s", "", "Chile???Chile", "Chilean???chileno", "", "CookIslands???IlhasCook",
				"CookIslander???cookiano", "", "Colombia???Col??mbia", "Colombian???colombiano", "", "Comoros???Comores",
				"Comoran???comoriano", "", "CostaRica???CostaRica", "CostaRican???costa-riquenho", "", "Croatia???Cro??cia",
				"Croatian???croata", "", "Cuba???Cuba", "Cuban???Cubano", "", "Cyprus???Chipre", "Cypriot???cipriota", "",
				"CzechRepublic???Rep??blicaTcheca", "Czech???tcheco", "",
				"DemocraticRepublicofCongo???Rep??blicaDemocr??ticadoCongo", "Congolese???congolense", "",
				"Denmark???Dinamarca", "Danish???dinamarqu??s", "", "Djibouti???Djibuti", "Djiboutian???djibutiense", "",
				"Dominica???Dominica", "Dominican???dominiquense", "", "DominicanRepublic???Rep??blicaDominicana",
				"Dominican???dominicano", "", "EastTimor???TimorLeste", "EastTimorese???timorense", "", "Ecuador???Equador",
				"Ecuadorian???equatoriano", "", "Egypt???Egito", "Egyptian???eg??pcio", "", "ElSalvador???ElSalvador",
				"Salvadorean???salvadorenho", "", "England???Inglaterra", "English???ingl??s", "",
				"EquatorialGuinea???Guin??Equatorial", "Equatoguinean???guin??u-equatoriano", "", "Eritrea???Eritreia",
				"Eritrean???eritreu", "", "Est??nia???Est??nia", "Estonian???estoniano", "", "Fiji???Fiji", "Fijian???fijiano", "",
				"Finland???Finl??ndia", "Finnish???finland??s", "", "France???Fran??a", "French???franc??s", "", "Gabon???Gab??o",
				"Gabonese???gabonense", "", "Gambia???G??mbia", "Gambian???gambiano", "", "Georgia???Ge??rgia",
				"Georgian???ge??rgico", "", "Germany???Alemanha", "German???alem??o", "", "Grenada???Granada",
				"Grenadian???granadino", "", "Greece???Gr??cia", "Greek???grego", "", "Guatemala???Guatemala",
				"Guatemalan???guatemalteco", "", "Guinea???Guin??", "Guinean???guineano", "", "Guinea???Bissau???Guin??Bissau",
				"Bissau???guinean???guineense", "", "Guyana???Guiana", "Guyanese???guianense", "", "Haiti???Haiti",
				"Haitian???haitiano", "", "Holland???Holanda", "Dutch???holand??s", "", "Honduras???Honduras",
				"Honduran???hondurenho", "", "Hungary???Hungria", "Hungarian???h??ngaro", "", "Iceland???Isl??ndia",
				"Icelander???island??s", "", "India?????ndia", "Indian???indiano", "", "Indonesia???Indon??sia",
				"Indonesian???indon??sio", "", "Iran???Ir??", "Iranian???iraniano", "", "Ireland???Irlanda", "Irish???irland??s", "",
				"Israel???Israel", "Israeli???israelita", "", "Italy???It??lia", "Italian???italiano", "",
				"IvoryCoast???CostadoMarfim", "Ivorian???costa-marfinense", "", "Jamaica???Jamaica", "Jamaican???jamaicano", "",
				"Japan???Jap??o", "Japanese???japon??s", "", "Jordan???Jord??nia", "Jordanian???jord??o", "",
				"Kazakhstan???Cazaquist??o", "Kazakh???cazaque", "", "Kenya???Qu??nia", "Kenyan???queniano", "",
				"Kiribati???Quiribati", "I-kiribati???quiribatiano", "", "Kyrgyzstan???Quirguist??o",
				"Kyrgyzstani???quirguistan??s", "", "Kwait???Kuwait", "Kwaiti???kuwaitiano", "", "Laos???Laos",
				"Laotian???laosiano", "", "Latvia???Let??nia", "Latvian???letoniano", "", "Lebanon???L??bano", "Lebanese???liban??s",
				"", "Lesotho???Lesoto", "Basotho???lesotiano", "", "Liberia???Lib??ria", "Liberian???liberiano", "",
				"Liechtenstein???Liechtenstein", "Liechtensteiner???liechtensteinense", "", "Lithuania???Litu??nia",
				"Lithuanian???lituano", "", "Luxembourg???Luxemburgo", "Luxembourgish???luxemburgu??s", "", "Lybia???L??bia",
				"Lybian???l??bio", "", "Macedonia???Maced??nia", "Macedonian???maced??nio", "", "Madagascar???Madagascar",
				"Malagasy???madagascarense", "", "Malaysia???Mal??sia", "Malaysian???malaio", "", "Malawi???Malaui",
				"Malawian???malauiano", "", "Maldives???Maldivas", "Maldivian???maldivo", "", "Mali???M??li", "Malian???maliano",
				"", "Malta???Malta", "Maltese???malt??s", "", "Mauritius???Maur??cio", "Mauritian???mauriciano", "",
				"Mauritia???Maurit??nia", "Mauritanian???mauritano", "", "MarshallIsland???IlhasMarshall",
				"MarshallIslander???marshallino", "",
				"Micronesia/FederatedStatesofMicronesia???EstadosFederadosdaMicron??sia", "Micronesian???micron??sio", "",
				"Mexico???M??xico", "Mexican???mexicano", "", "Morocco???Marrocos", "Moroccan???marroquino", "",
				"Moldova???Moldavia", "Moldovan???mold??vio", "", "Monaco???M??naco", "Monacan???monegasco", "",
				"Mongolia???Mong??lia", "Mongolian???mongol", "", "Montenegro???Montenegro", "Montenegrin???montenegrino", "",
				"Mozambique???Mo??ambique", "Mozambican???mo??ambicano", "", "Myanmar???Myanmar", "Burmese???birman??s", "",
				"Namibia???Nam??bia", "Namibian???namibiano", "", "Nauru???Nauru", "Nauruan???nauruano", "", "Nepal???Nepal",
				"Nepali???nepal??s", "", "NewZealand???NovaZel??ndia", "NewZealander???neozeland??s", "", "Nicaragua???Nicar??gua",
				"Nicaraguan???nicaraguense", "", "Niger???N??ger", "Nigerien???nigerino", "", "Nigeria???Nig??ria",
				"Nigerian???nigeriano", "", "Niue???Niue", "Niuean???niuano", "", "NorthKorea???Cor??iadoNorte",
				"Northkorean???norte-coreano", "", "Norway???Noruega", "Norwegian???noruegu??s", "", "Oman???Om??",
				"Omani???omanense", "", "Palestine???Palestina", "Palestinian???palestino", "", "Pakistan???Paquist??o",
				"Pakistanese???paquistan??s", "", "Palau???Palau", "Palauan???palauense", "", "Panama???Panam??",
				"Panamanian???panamenho", "", "PapuaNewGuinea???PapuaNovaGuin??", "PapuaNewGuinean???papu??sio", "",
				"Paraguay???Paraguai", "Paraguayan???paraguaio", "", "Peru???Peru", "Peruvian???peruano", "",
				"Philippines???Philippines", "Philippine???filipino", "", "Poland???Pol??nia", "Polish???polon??s", "",
				"Portugal???Portugal", "Portuguese???portugu??s", "", "Qatar???Catar", "Qatari???catarense", "",
				"Romania???Rom??nia", "Romanian???romeno", "", "Russia???R??ssia", "Russian???russo", "", "Rwanda???Ruanda",
				"Rwandan???ruand??s", "", "Samoa???Samoa", "Samoan???samoano", "", "SaintLucia???SantaL??cia",
				"SaintLucian???santa-lucense", "", "SaintKittsandNevis???S??oCrist??v??oeNevis", "Kittian???s??o-cristovense", "",
				"SanMarino???S??oMarino", "SanMarinan???s??o-marinense", "", "SaoTom??andPrincipe???S??oTom??ePr??ncipe",
				"SaoTomean???s??o-tomense", "", "SaintVincentandtheGrenadines???S??oVicenteeGranadinas",
				"Vicentinian???s??o-vicentino", "", "Scotland???Esc??cia", "Scottish???escoc??s", "", "Senegal???Senegal",
				"Senegalese???senegalense", "", "Serbia???S??rvia", "Serbian???s??rvio", "", "Seychelles???Seicheles",
				"Seychellois???seichelense", "", "SierraLeone???SerraLeoa", "SierraLeonean???serra-leon??s", "",
				"Singapore???Singapura", "Singaporean???singapurense", "", "Slovakia???Eslov??quia", "Slovak???eslovaco", "",
				"SolomonIslands???IlhasSalom??o", "SolomonIslander???salom??nico", "", "Somalia???Som??lia", "Somali???somali", "",
				"SouthAfrica?????fricadoSul", "SouthAfrican???sul???africano", "", "SouthKorea???Cor??iadoSul", "Korean???coreano",
				"", "SouthSudan???Sud??odoSul", "SouthSudanese???sul-sudanense", "", "Spain???Espanha", "Spanish???espanhol", "",
				"SriLanka???SriLanka", "SriLankan???srilank??s", "", "Sudan???Sud??o", "Sudanese???sudanense", "",
				"Suriname???Suriname", "Surinamese???surinam??s", "", "Swaziland???Suazil??ndia", "Swazi???suazi", "",
				"Sweden???Su??cia", "Swedish???sueco", "", "Switzerland???Su????a", "Swiss???su????o", "", "Syria???S??ria",
				"Syrian???s??rio", "", "Tajikistan???Tadiquist??o", "Tajiki???tajique", "Tanzanian???tanzaniano",
				"Thailand???Tail??ndia", "Thai???tailand??s", "Togo???Togo", "Togolese???togol??s", "Tonga???Tonga",
				"Tongan???tongan??s", "TrinidadandTobago???TrindadeeTobago", "Trinidadian???trinit??rio", "", "Tunisia???Tun??sia",
				"Tunisian???tunisiano", "Turkmenistan???Turcomenist??o", "Turkmen???turcomeno", "Turkey???Turquia",
				"Turkish???turco", "Tuvalu???Tuvalu", "Tuvaluan???tuvaluano", "Ukraine???Ucr??nia", "Ukrainian???ucraniano",
				"Uganda???Uganda", "Ugandan???ugand??s", "Uruguay???Uruguai", "Uruguayan???uruguaio",
				"UnitedArabEmirates???Emirados??rabesUnidos", "Emirati?????rabe", "UnitedKingdom???ReinoUnido",
				"British???brit??nico", "UnitedStatesofAmerica???EstadosUnidos", "American???americano",
				"Uzbekistan???Usbequist??o", "Uzbek???uzbeque", "Vanuatu???Vanuatu", "Ni-vanuatu???vanuatuano",
				"Venezuela???Venezuela", "Venezuelan???venezuelano", "Vietnam???Vietn??", "Vietnamese???vietnamita",
				"Wales???Pa??sdeGales", "Welsh???gal??s", "Yemen???I??men", "Yemeni???iemenita", "Zambia???Z??mbia",
				"Zambian???zambiano", "Zimbabwe???Zimb??bue", "Zimbabwean???zimbabueano" };

		txtNacionalidad.setModel(new DefaultComboBoxModel<String>(nacionalidad));
		txtNacionalidad.setBounds(76, 330, 255, 33);
		txtNacionalidad.setSelectedItem(huesped.getNacionalidad());
		contentPane.add(txtNacionalidad);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(78, 105, 253, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(76, 172, 255, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(76, 240, 255, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nacionalidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(76, 308, 255, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tel??fono");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(78, 380, 253, 14);
		contentPane.add(lblNewLabel_1_2);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(76, 400, 255, 33);
		txtTelefono.setText(huesped.getTelefono());
		contentPane.add(txtTelefono);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(333, 11, 95, 95);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Editar Registro de Hu??sped");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(76, 45, 244, 42);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_1_2_1 = new JLabel("N??mero de Reserva");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(78, 445, 253, 14);
		contentPane.add(lblNewLabel_1_2_1);

		txtNreserva = new JTextField();
		txtNreserva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNreserva.setEnabled(false);
		txtNreserva.setEditable(false);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBounds(76, 465, 255, 33);
		txtNreserva.setText(String.valueOf(idReserva));
		contentPane.add(txtNreserva);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int respuesta = JOptionPane.showConfirmDialog(null, "Quieres salir? Los cambios no se guardar??n.");
				if (respuesta == JOptionPane.OK_OPTION) {

					frameBusqueda.setEnabled(true);
					dispose();
				}
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtras.setBackground(new Color(65, 105, 225));
		btnAtras.setBounds(253, 515, 67, 52);
		contentPane.add(btnAtras);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (camposValidos()) {
					int resultado = editarHuesped();

					if (resultado > 0) {
						JOptionPane.showMessageDialog(contentPane, "EL huesped se edit?? con ??xito!");
						frameBusqueda.setEnabled(true);
						dispose();
					}
				}
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGuardar.setBackground(new Color(65, 105, 225));
		btnGuardar.setBounds(76, 525, 140, 33);
		contentPane.add(btnGuardar);
	}

	private int editarHuesped() {
		Date fechaNac = txtFechaN.getDate();
		java.sql.Date fechaNacSQL = new java.sql.Date(fechaNac.getTime());
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String nacionalidad = String.valueOf(txtNacionalidad.getSelectedItem());
		String telefono = txtTelefono.getText();

		Huesped huesped = new Huesped(nombre, apellido, fechaNacSQL, nacionalidad, telefono, idReserva);

		return huespedController.editar(huesped);
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
