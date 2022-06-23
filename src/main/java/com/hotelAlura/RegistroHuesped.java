package com.hotelAlura;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped();
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
	public RegistroHuesped() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/persona.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBounds(576, 150, 255, 33);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBounds(576, 217, 255, 33);
		contentPane.add(txtApellido);
		
		JDateChooser txtFechaN = new JDateChooser();
		txtFechaN.setBounds(576, 281, 255, 33);
		contentPane.add(txtFechaN);
		
		JComboBox txtNacionalidad = new JComboBox();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan â€“ AfeganistÃ£o", "Afghan â€“ afegÃ£o", "Andorra â€“ Andorra", "Andorran â€“ andorrano", "Angola â€“ Angola", "Angolan â€“ angolano", "Antigua e Barbuda â€“ AntÃ­gua e Barbuda", "Antiguan/Barbudan â€“ antiguano", "Algeria â€“ ArgÃ©lia", "Algerian â€“ argelino", "Argentina â€“ Argentina", "Argentinian â€“ argentino", "Armenia â€“ ArmÃªnia", "Armenian â€“ armÃªnio", "Australia â€“ AustrÃ¡lia", "Australian â€“ australiano", "Austria â€“ Ã�ustria", "Austrian â€“ austrÃ­aco", "Azerbaijan â€“ AzerbaijÃ£o", "Azerbaijani â€“ azeri", "The Bahamas â€“ Bahamas", "Bahamian â€“ bahamense", "Bangladesh â€“ Bangladesh", "Bangladeshi â€“ bangladÃªs", "Barbados â€“ Barbados", "Barbadian â€“ barbadiano", "Bahrain â€“ BarÃ©m", "Bahraini â€“ baremita", "Belarus â€“ BielorrÃºssia", "Belarusian â€“ bielorrusso", "Belgium â€“ BÃ©lgica", "Belgian â€“ belga", "Belize â€“ Belize", "Belizean â€“ belizenho", "Benin â€“ Benim", "Beninese â€“ beninense", "Bolivia â€“ BolÃ­via", "Bolivian â€“ boliviano", "Bosnia; Bosnia and Herzegovina â€“ BÃ³snia; BÃ³snia e Herzegovina", "Bosnian â€“ bÃ³snio", "Botswana â€“ Botsuana", "Motswana â€“ bechuano", "Brazil â€“ Brasil", "Brazilian â€“ brasileiro", "Brunei â€“ Brunei", "Bruneian â€“ bruneano", "Bulgaria â€“ BulgÃ¡ria", "Bulgarian â€“ bÃºlgaro", "BurkinaFaso â€“ BurkinaFaso", "BurkinabÃ© â€“ burquinense", "Burundi â€“ Burundi", "Burundian â€“ burundÃªs", "Bhutan â€“ ButÃ£o", "Bhutanese â€“ butanense", "Cape Verde â€“ Cabo Verde", "Cape Verdean â€“ cabo-verdiano", "Cameroon â€“ CamarÃµes", "Cameroonian â€“ camaronense", "Cambodia â€“ Camboja", "Cambodian â€“ cambojano", "", "Canada â€“ CanadÃ¡", "Canadian â€“ canadense", "", "Central African Republic â€“ RepÃºblica Centro-Africana", "Central-african â€“ centroafricano", "", "Chad â€“ Chade", "Chadian â€“ chadiano", "", "China â€“ China", "Chinese â€“ chinÃªs", "", "Chile â€“ Chile", "Chilean â€“ chileno", "", "Cook Islands â€“ Ilhas Cook", "Cook Islander â€“ cookiano", "", "Colombia â€“ ColÃ´mbia", "Colombian â€“ colombiano", "", "Comoros â€“ Comores", "Comoran â€“ comoriano", "", "Costa Rica â€“ Costa Rica", "Costa Rican â€“ costa-riquenho", "", "Croatia â€“ CroÃ¡cia", "Croatian â€“ croata", "", "Cuba â€“ Cuba", "Cuban â€“ Cubano", "", "Cyprus â€“ Chipre", "Cypriot â€“ cipriota", "", "Czech Republic â€“ RepÃºblica Tcheca", "Czech â€“ tcheco", "", "Democratic Republic of Congo â€“ RepÃºblica DemocrÃ¡tica do Congo", "Congolese â€“ congolense", "", "Denmark â€“ Dinamarca", "Danish â€“ dinamarquÃªs", "", "Djibouti â€“ Djibuti", "Djiboutian â€“ djibutiense", "", "Dominica â€“ Dominica", "Dominican â€“ dominiquense", "", "Dominican Republic â€“ RepÃºblica Dominicana", "Dominican â€“ dominicano", "", "East Timor â€“ Timor Leste", "East Timorese â€“ timorense", "", "Ecuador â€“ Equador", "Ecuadorian â€“ equatoriano", "", "Egypt â€“ Egito", "Egyptian â€“ egÃ­pcio", "", "El Salvador â€“ El Salvador", "Salvadorean â€“ salvadorenho", "", "England â€“ Inglaterra", "English â€“ inglÃªs", "", "Equatorial Guinea â€“ GuinÃ© Equatorial", "Equatoguinean â€“ guinÃ©u-equatoriano", "", "Eritrea â€“ Eritreia", "Eritrean â€“ eritreu", "", "EstÃ´nia â€“ EstÃ´nia", "Estonian â€“ estoniano", "", "Fiji â€“ Fiji", "Fijian â€“ fijiano", "", "Finland â€“ FinlÃ¢ndia", "Finnish â€“ finlandÃªs", "", "France â€“ FranÃ§a", "French â€“ francÃªs", "", "Gabon â€“ GabÃ£o", "Gabonese â€“ gabonense", "", "Gambia â€“ GÃ¢mbia", "Gambian â€“ gambiano", "", "Georgia â€“ GeÃ³rgia", "Georgian â€“ geÃ³rgico", "", "Germany â€“ Alemanha", "German â€“ alemÃ£o", "", "Grenada â€“ Granada", "Grenadian â€“ granadino", "", "Greece â€“ GrÃ©cia", "Greek â€“ grego", "", "Guatemala â€“ Guatemala", "Guatemalan â€“ guatemalteco", "", "Guinea â€“ GuinÃ©", "Guinean â€“ guineano", "", "Guineaâ€“Bissau â€“ GuinÃ©Bissau", "Bissauâ€“guinean â€“ guineense", "", "Guyana â€“ Guiana", "Guyanese â€“ guianense", "", "Haiti â€“ Haiti", "Haitian â€“ haitiano", "", "Holland â€“ Holanda", "Dutch â€“ holandÃªs", "", "Honduras â€“ Honduras", "Honduran â€“ hondurenho", "", "Hungary â€“ Hungria", "Hungarian â€“ hÃºngaro", "", "Iceland â€“ IslÃ¢ndia", "Icelander â€“ islandÃªs", "", "India â€“ Ã�ndia", "Indian â€“ indiano", "", "Indonesia â€“ IndonÃ©sia", "Indonesian â€“ indonÃ©sio", "", "Iran â€“ IrÃ£", "Iranian â€“ iraniano", "", "Ireland â€“ Irlanda", "Irish â€“ irlandÃªs", "", "Israel â€“ Israel", "Israeli â€“ israelita", "", "Italy â€“ ItÃ¡lia", "Italian â€“ italiano", "", "Ivory Coast â€“ Costa do Marfim", "Ivorianâ€“ costa-marfinense", "", "Jamaica â€“ Jamaica", "Jamaican â€“ jamaicano", "", "Japan â€“ JapÃ£o", "Japanese â€“ japonÃªs", "", "Jordan â€“ JordÃ¢nia", "Jordanian â€“ jordÃ£o", "", "Kazakhstan â€“ CazaquistÃ£o", "Kazakh â€“ cazaque", "", "Kenya â€“ QuÃªnia", "Kenyan â€“ queniano", "", "Kiribati â€“ Quiribati", "I-kiribati â€“ quiribatiano", "", "Kyrgyzstan â€“ QuirguistÃ£o", "Kyrgyzstani â€“ quirguistanÃªs", "", "Kwait â€“ Kuwait", "Kwaiti â€“ kuwaitiano", "", "Laos â€“ Laos", "Laotian â€“ laosiano", "", "Latvia â€“ LetÃ´nia", "Latvian â€“ letoniano", "", "Lebanon â€“ LÃ­bano", "Lebanese â€“ libanÃªs", "", "Lesotho â€“ Lesoto", "Basotho â€“ lesotiano", "", "Liberia â€“ LibÃ©ria", "Liberian â€“ liberiano", "", "Liechtenstein â€“ Liechtenstein", "Liechtensteiner â€“ liechtensteinense", "", "Lithuania â€“ LituÃ¢nia", "Lithuanian â€“ lituano", "", "Luxembourg â€“ Luxemburgo", "Luxembourgish â€“ luxemburguÃªs", "", "Lybia â€“ LÃ­bia", "Lybian â€“ lÃ­bio", "", "Macedonia â€“ MacedÃ´nia", "Macedonian â€“ macedÃ´nio", "", "Madagascar â€“ Madagascar", "Malagasy â€“ madagascarense", "", "Malaysia â€“ MalÃ¡sia", "Malaysian â€“ malaio", "", "Malawi â€“ Malaui", "Malawian â€“ malauiano", "", "Maldives â€“ Maldivas", "Maldivian â€“ maldivo", "", "Mali â€“ MÃ¡li", "Malian â€“ maliano", "", "Malta â€“ Malta", "Maltese â€“ maltÃªs", "", "Mauritius â€“ MaurÃ­cio", "Mauritian â€“ mauriciano", "", "Mauritia â€“ MauritÃ¢nia", "Mauritanian â€“ mauritano", "", "Marshall Island â€“ Ilhas Marshall", "Marshall Islander â€“ marshallino", "", "Micronesia/Federated States of Micronesia â€“ Estados Federados da MicronÃ©sia", "Micronesian â€“ micronÃ©sio", "", "Mexico â€“ MÃ©xico", "Mexican â€“ mexicano", "", "Morocco â€“ Marrocos", "Moroccan â€“ marroquino", "", "Moldova â€“ Moldavia", "Moldovan â€“ moldÃ¡vio", "", "Monaco â€“ MÃ´naco", "Monacan â€“ monegasco", "", "Mongolia â€“ MongÃ³lia", "Mongolian â€“ mongol", "", "Montenegro â€“ Montenegro", "Montenegrin â€“ montenegrino", "", "Mozambique â€“ MoÃ§ambique", "Mozambican â€“ moÃ§ambicano", "", "Myanmar â€“ Myanmar", "Burmese â€“ birmanÃªs", "", "Namibia â€“ NamÃ­bia", "Namibian â€“ namibiano", "", "Nauru â€“ Nauru", "Nauruan â€“ nauruano", "", "Nepal â€“ Nepal", "Nepali â€“ nepalÃªs", "", "New Zealand â€“ Nova ZelÃ¢ndia", "NewZealander â€“ neozelandÃªs", "", "Nicaragua â€“ NicarÃ¡gua", "Nicaraguan â€“ nicaraguense", "", "Niger â€“ NÃ­ger", "Nigerien â€“ nigerino", "", "Nigeria â€“ NigÃ©ria", "Nigerian â€“ nigeriano", "", "Niue â€“ Niue", "Niuean â€“ niuano", "", "North Korea â€“ CorÃ©ia do Norte", "North korean â€“ norte-coreano", "", "Norway â€“ Noruega", "Norwegian â€“ norueguÃªs", "", "Oman â€“ OmÃ£", "Omani â€“ omanense", "", "Palestine â€“ Palestina", "Palestinian â€“ palestino", "", "Pakistan â€“ PaquistÃ£o", "Pakistanese â€“ paquistanÃªs", "", "Palau â€“ Palau", "Palauan â€“ palauense", "", "Panama â€“ PanamÃ¡", "Panamanian â€“ panamenho", "", "Papua New Guinea â€“ Papua Nova GuinÃ©", "Papua New Guinean â€“ papuÃ¡sio", "", "Paraguay â€“ Paraguai", "Paraguayan â€“ paraguaio", "", "Peru â€“ Peru", "Peruvian â€“ peruano", "", "Philippines â€“ Philippines", "Philippine â€“ filipino", "", "Poland â€“ PolÃ´nia", "Polish â€“ polonÃªs", "", "Portugal â€“ Portugal", "Portuguese â€“ portuguÃªs", "", "Qatar â€“ Catar", "Qatari â€“ catarense", "", "Romania â€“ RomÃªnia", "Romanian â€“ romeno", "", "Russia â€“ RÃºssia", "Russian â€“ russo", "", "Rwanda â€“ Ruanda", "Rwandan â€“ ruandÃªs", "", "Samoa â€“ Samoa", "Samoan â€“ samoano", "", "Saint Lucia â€“ Santa LÃºcia", "Saint Lucian â€“ santa-lucense", "", "Saint Kitts and Nevis â€“ SÃ£o CristÃ³vÃ£o e Nevis", "Kittian â€“ sÃ£o-cristovense", "", "San Marino â€“ SÃ£o Marino", "San Marinan â€“ sÃ£o-marinense", "", "Sao TomÃ© and Principe â€“ SÃ£o TomÃ© e PrÃ­ncipe", "Sao Tomean â€“ sÃ£o-tomense", "", "Saint Vincent and the Grenadines â€“ SÃ£o Vicente e Granadinas", "Vicentinian â€“ sÃ£o-vicentino", "", "Scotland â€“ EscÃ³cia", "Scottish â€“ escocÃªs", "", "Senegal â€“ Senegal", "Senegalese â€“ senegalense", "", "Serbia â€“ SÃ©rvia", "Serbian â€“ sÃ©rvio", "", "Seychelles â€“ Seicheles", "Seychellois â€“ seichelense", "", "Sierra Leone â€“ Serra Leoa", "Sierra Leonean â€“ serra-leonÃªs", "", "Singapore â€“ Singapura", "Singaporean â€“ singapurense", "", "Slovakia â€“ EslovÃ¡quia", "Slovak â€“ eslovaco", "", "Solomon Islands â€“ Ilhas SalomÃ£o", "Solomon Islander â€“ salomÃ´nico", "", "Somalia â€“ SomÃ¡lia", "Somali â€“ somali", "", "South Africa â€“ Ã�frica do Sul", "South African â€“ sulâ€“africano", "", "South Korea â€“ CorÃ©ia do Sul", "Korean â€“ coreano", "", "South Sudan â€“ SudÃ£o do Sul", "South Sudanese â€“ sul-sudanense", "", "Spain â€“ Espanha", "Spanish â€“ espanhol", "", "Sri Lanka â€“ Sri Lanka", "Sri Lankan â€“ srilankÃªs", "", "Sudan â€“ SudÃ£o", "Sudanese â€“ sudanense", "", "Suriname â€“ Suriname", "Surinamese â€“ surinamÃªs", "", "Swaziland â€“ SuazilÃ¢ndia", "Swazi â€“ suazi", "", "Sweden â€“ SuÃ©cia", "Swedish â€“ sueco", "", "Switzerland â€“ SuÃ­Ã§a", "Swiss â€“ suÃ­Ã§o", "", "Syria â€“ SÃ­ria", "Syrian â€“ sÃ­rio", "", "Tajikistan â€“ TadiquistÃ£o", "Tajiki â€“ tajique", "Tanzanian â€“ tanzaniano", "Thailand â€“ TailÃ¢ndia", "Thai â€“ tailandÃªs", "Togo â€“ Togo", "Togolese â€“ togolÃªs", "Tonga â€“ Tonga", "Tongan â€“ tonganÃªs", "Trinidad and Tobago â€“ Trindade e Tobago", "Trinidadian â€“ trinitÃ¡rio", "", "Tunisia â€“ TunÃ­sia", "Tunisian â€“ tunisiano", "Turkmenistan â€“ TurcomenistÃ£o", "Turkmen â€“ turcomeno", "Turkey â€“ Turquia", "Turkish â€“ turco", "Tuvalu â€“ Tuvalu", "Tuvaluan â€“ tuvaluano", "Ukraine â€“ UcrÃ¢nia", "Ukrainian â€“ ucraniano", "Uganda â€“ Uganda", "Ugandan â€“ ugandÃªs", "Uruguay â€“ Uruguai", "Uruguayan â€“ uruguaio", "United Arab Emirates â€“ Emirados Ã�rabes Unidos", "Emirati â€“ Ã¡rabe", "United Kingdom â€“ Reino Unido", "British â€“ britÃ¢nico", "United States of America â€“ Estados Unidos", "American â€“ americano", "Uzbekistan â€“ UsbequistÃ£o", "Uzbek â€“ uzbeque", "Vanuatu â€“ Vanuatu", "Ni-vanuatu â€“ vanuatuano", "Venezuela â€“ Venezuela", "Venezuelan â€“ venezuelano", "Vietnam â€“ VietnÃ£", "Vietnamese â€“ vietnamita", "Wales â€“ PaÃ­s de Gales", "Welsh â€“ galÃªs", "Yemen â€“ IÃªmen", "Yemeni â€“ iemenita", "Zambia â€“ ZÃ¢mbia", "Zambian â€“ zambiano", "Zimbabwe â€“ ZimbÃ¡bue", "Zimbabwean â€“ zimbabueano"}));
		txtNacionalidad.setBounds(576, 350, 255, 33);
		contentPane.add(txtNacionalidad);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(578, 125, 253, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(576, 194, 255, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de Nascimiento");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(576, 256, 255, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nacionalidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(576, 325, 255, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro.png")));
		lblNewLabel.setBounds(0, 0, 502, 556);
		contentPane.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/cancelar.png")));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(764, 543, 54, 41);
		contentPane.add(btnCancelar);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exito exito = new Exito();
				exito.setVisible(true);
				dispose();
			}
		});
		btnGuardar.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/disquete.png")));
		btnGuardar.setBackground(SystemColor.menu);
		btnGuardar.setBounds(700, 543, 54, 41);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnSalir.setBackground(SystemColor.menu);
		btnSalir.setBounds(828, 543, 54, 41);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1_2 = new JLabel("TelÃ©fono");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(578, 394, 253, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(576, 419, 255, 33);
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(780, 11, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Registro de HuÃ©sped");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(576, 74, 198, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("NÃºmero de Reserva");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(578, 455, 253, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtNreserva = new JTextField();
		txtNreserva.setEnabled(false);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBounds(576, 480, 255, 33);
		contentPane.add(txtNreserva);
	}
}
