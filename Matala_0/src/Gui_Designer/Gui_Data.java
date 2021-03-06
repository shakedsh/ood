package Gui_Designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ReadAndWriteFiles.ExportKML;
import ReadAndWriteFiles.ReadCombCsv;
import ReadAndWriteFiles.WriteCombCsv;
import ReadAndWriteFiles.ReadWigleWifiFiles;
import Sample_Object.SampleOfWifi;
import Sample_Object.macSamlpe;

import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;

import Algoritems.CallToAlgo1;
import Algoritems.CallToAlgo2;
import Algoritems.Constant;
import DataBase.SetDataBase;
import Filters.FilterByLocation;
import Filters.FilterByPhoneId;
import Filters.FilterByTime;
import Filters.FilterObject;

import javax.swing.event.CaretEvent;
import javax.swing.JTextPane;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.sql.rowset.Joinable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Canvas;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
public class Gui_Data {

	public String getInputFoldePath() {
		return InputfoldePath;
	}
	//-----------------call the other classes---------------
	ReadWigleWifiFiles newCsv;// read the wigle files and write comb CSV
	
	
	
	
	
	//-----------------parameters-------------------------------
	String combName = "\\DataNetWorks.csv";
	static String combFilterdName = "\\FilterdDataNetWorks.csv";

	String completeCombPath="";

	public JFrame frame;
	private ImageIcon image1;
	private JTextField folderPathInput_textField;
	public static String InputfoldePath="";
	public static String OutputfoldePath="";
	public static String OutputfoldePathForKML="";
	public static String combPath="";
	public static JTextField folderPathOutput_textField;
	private JTextField combPath_textField;
	
	
	//read folder with wigle csv files
	public static ArrayList<SampleOfWifi> processedCsvFile= new ArrayList<>();;//will use us also for the undo filter
	//------read comb----
	public static ArrayList <SampleOfWifi> combData= new ArrayList<>();
	//--------write kml file--------
	public static String kmlName= "\\KmlFile.kml";
	public static boolean deletedHeader=false;
	//--------data info--------------
	public static JLabel AnsNumberOfRecords;
	public static JLabel AnsNumOfNetworks;
	static FilterByPhoneId filterID;
	static FilterByTime filterTIME;
	static FilterByLocation filterLocation;
	public static String Operand="";
	public static CallToAlgo1 algo1;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_3;
	public static CallToAlgo2 algo2;
	public static macSamlpe mac1;
	public static macSamlpe mac2;
	public static macSamlpe mac3;
	public static SampleOfWifi smp;
	//-----Filters-------------------------------
	public static String filter_Properties= " ";
	public static FilterObject filterp;
	private JLabel lblFilter;
	public static JLabel label_Filter;
	private JButton btnSql;
	private JButton btnFilter;
	private JButton btnAlgorithms;
	private JDesktopPane desktopPane_1;
	private JLayeredPane layeredPane;
	private JLayeredPane layeredPane_1;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Data window = new Gui_Data();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui_Data() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tal\\git\\oop\\Matala_0\\bin\\back.png"));
		//image1=new ImageIcon(getClass().getResource("/black_background1.png"));
		
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		//frame.imageUpdate(image1, 0, 0, 0, 0, 0);
		frame.setBounds(100, 100, 1225, 1072);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//if((OutputfoldePath!="")&&(combPath==""))
		System.out.println("kffffffffffffffffffffffffffffffffffff");
		
		textField = new JTextField();
		textField.setText("insrert mac1");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("insrert signal1");
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("insrert signal2");
		textField_3.setColumns(10);
		
		lblFilter = new JLabel("Filter:");
		lblFilter.setForeground(new Color(0, 255, 255));
		lblFilter.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		desktopPane_1 = new JDesktopPane();
		
		layeredPane_1 = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(995)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(212)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(262)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 936, Short.MAX_VALUE)
					.addComponent(lblFilter, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(133))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(233, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1079, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFilter, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(778))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		layeredPane_1.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(45, 564, 963, -543);
		desktopPane_1.add(layeredPane);
		layeredPane.setLayout(null);
		
		btnAlgorithms = new JButton("Algorithms");
		btnAlgorithms.setBounds(216, 520, 146, 35);
		desktopPane_1.add(btnAlgorithms);
		btnAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Algo_Window algw= new Algo_Window();
				algw.createAlgoWindow();
			}
		});
		btnAlgorithms.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		
		label_Filter = new JLabel("___________________________________________________________________________________________________");
		label_Filter.setBounds(310, 489, 446, 18);
		desktopPane_1.add(label_Filter);
		label_Filter.setForeground(new Color(0, 255, 255));
		label_Filter.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		
		btnSql = new JButton("SQL");
		btnSql.setBounds(524, 566, 61, 29);
		desktopPane_1.add(btnSql);
		
		JLabel lblNumberOfDiff = new JLabel("number of different \r\nwifi networks");
		lblNumberOfDiff.setBounds(55, 453, 246, 33);
		desktopPane_1.add(lblNumberOfDiff);
		lblNumberOfDiff.setForeground(new Color(0, 255, 255));
		lblNumberOfDiff.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		
		JLabel lblNumberOfRecords = new JLabel("Number of records");
		lblNumberOfRecords.setBounds(45, 417, 155, 18);
		desktopPane_1.add(lblNumberOfRecords);
		lblNumberOfRecords.setForeground(new Color(0, 255, 255));
		lblNumberOfRecords.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		
		AnsNumOfNetworks = new JLabel("0");
		AnsNumOfNetworks.setBounds(329, 455, 155, 18);
		desktopPane_1.add(AnsNumOfNetworks);
		AnsNumOfNetworks.setForeground(new Color(0, 255, 255));
		AnsNumOfNetworks.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		
		AnsNumberOfRecords = new JLabel("0");
		AnsNumberOfRecords.setBounds(207, 417, 155, 18);
		desktopPane_1.add(AnsNumberOfRecords);
		AnsNumberOfRecords.setForeground(new Color(0, 255, 255));
		AnsNumberOfRecords.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		//----------------------------Undo Filter-------------------------
		JButton btnUndoFilter = new JButton("Undo Filter ");
		btnUndoFilter.setBounds(485, 428, 149, 29);
		desktopPane_1.add(btnUndoFilter);
		btnUndoFilter.setForeground(new Color(0, 255, 255));
		btnUndoFilter.setBackground(new Color(0, 0, 0));
		
		btnFilter = new JButton("Filter");
		btnFilter.setBounds(663, 423, 75, 35);
		desktopPane_1.add(btnFilter);
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filter_Window fltw= new Filter_Window();
				fltw.createFilterWindow();
			}
		});
		btnFilter.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		
		JLabel lblInsertPackagePath = new JLabel("Insert Input package path");
		lblInsertPackagePath.setBounds(26, 37, 185, 19);
		desktopPane_1.add(lblInsertPackagePath);
		lblInsertPackagePath.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblInsertPackagePath.setForeground(new Color(0, 255, 255));
		//----------------------------------------------folder output path text field------------------------------------
		JLabel lblInsertOutputPackage = new JLabel("Insert output package path");
		lblInsertOutputPackage.setBounds(26, 78, 185, 18);
		desktopPane_1.add(lblInsertOutputPackage);
		lblInsertOutputPackage.setForeground(new Color(0, 255, 255));
		lblInsertOutputPackage.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		//----------------------------------------------folder path input text field------------------------------------
		folderPathInput_textField = new JTextField();
		folderPathInput_textField.setBounds(223, 37, 673, 26);
		desktopPane_1.add(folderPathInput_textField);
		folderPathInput_textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				InputfoldePath=folderPathInput_textField.getText();
				System.out.println("meeeeeeeeeeeeeee11111111111111111111");

			}
		});
		
		//----------------------------------------------ok button for read folder with wigle csv files---------------------
		folderPathInput_textField.setColumns(10);
		
		folderPathOutput_textField = new JTextField();
		folderPathOutput_textField.setBounds(223, 78, 673, 26);
		desktopPane_1.add(folderPathOutput_textField);
		folderPathOutput_textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				OutputfoldePath=folderPathOutput_textField.getText();
				OutputfoldePathForKML=folderPathOutput_textField.getText();
			}
		});
		folderPathOutput_textField.setColumns(10);
		JButton btnReadFiles = new JButton("read files");
		btnReadFiles.setBounds(943, 58, 151, 29);
		desktopPane_1.add(btnReadFiles);
		btnReadFiles.setBackground(new Color(0, 0, 0));
		btnReadFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((InputfoldePath!="")&&(OutputfoldePath!=""))
				{
					System.out.println(InputfoldePath);

					try {
						
						frame.getContentPane().setBackground(new Color(0, 0, 0));
						// newCsv = new csvToNewCsv(InputfoldePath);
						//JOptionPane.showMessageDialog(null, "Your message goes here!","Message", JOptionPane.ERROR_MESSAGE);
						File folderOfCsvFiles = new File(InputfoldePath);
						if (folderOfCsvFiles.canRead()) {
							 processedCsvFile = ReadWigleWifiFiles.readCsvFile(folderOfCsvFiles);
							 OutputfoldePath= OutputfoldePath+combName;
						combPath_textField.setText(OutputfoldePath);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		
		btnReadFiles.setForeground(new Color(0, 255, 255));
		
		//----------------------------export comb csv--------------------------------------------------------------
		JButton btnbtnOkInputPath = new JButton("create comb");
		btnbtnOkInputPath.setBounds(911, 96, 183, 29);
		desktopPane_1.add(btnbtnOkInputPath);
		btnbtnOkInputPath.setBackground(new Color(0, 0, 0));
		btnbtnOkInputPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deletedHeader=false;
					WriteCombCsv.writeCsvFile(processedCsvFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnbtnOkInputPath.setForeground(new Color(0, 255, 255));
		
		//----------------------------------------------comb csv input path text field------------------------------------

		JLabel lblInsertCombCsv = new JLabel("Insert comb csv path");
		lblInsertCombCsv.setBounds(15, 196, 185, 18);
		desktopPane_1.add(lblInsertCombCsv);
		lblInsertCombCsv.setForeground(new Color(0, 255, 255));
		lblInsertCombCsv.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		combPath_textField = new JTextField();
		combPath_textField.setBounds(218, 192, 519, 26);
		desktopPane_1.add(combPath_textField);
		
				
				combPath_textField.addCaretListener(new CaretListener() {
					
					//------------------------------------------------------------------------------------
					public void caretUpdate(CaretEvent e) {
						combPath=combPath_textField.getText();
						
					}
				});
				combPath_textField.setColumns(10);
				
				
				//----------------------------------------------ok button for read comb---------------------
				JButton btnOkcsvCOMB = new JButton("read comb");
				btnOkcsvCOMB.setBounds(810, 191, 350, 29);
				desktopPane_1.add(btnOkcsvCOMB);
				btnOkcsvCOMB.setBackground(new Color(0, 0, 0));
				btnOkcsvCOMB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (combPath!="")
						{
							combData=ReadCombCsv.readCsvCombwithHeaders(combPath);
							Constant.setCsvCombPath(combPath);
							///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							AnsNumberOfRecords.setText(""+combData.size());
							AnsNumOfNetworks.setText(""+SetDataBase.numOfDifferentMacSamples(combData));
						}

						
					}
				});
				btnOkcsvCOMB.setForeground(new Color(0, 255, 255));
				
				//---------------------------------delete database button --------------------------------------------
				JButton btnDeleteDatabase = new JButton("delete database");
				btnDeleteDatabase.setBounds(32, 247, 141, 29);
				desktopPane_1.add(btnDeleteDatabase);
				btnDeleteDatabase.setForeground(new Color(0, 255, 255));
				btnDeleteDatabase.setBackground(new Color(0, 0, 0));
				
				//-----------------update csvfiles ----------------------------------
				JButton btnUpdateDatabase = new JButton("update database");
				btnUpdateDatabase.setBounds(224, 247, 125, 29);
				desktopPane_1.add(btnUpdateDatabase);
				btnUpdateDatabase.setForeground(new Color(0, 255, 255));
				btnUpdateDatabase.setBackground(new Color(0, 0, 0));
				
				JButton buttonExportKML = new JButton("export KML");
				buttonExportKML.setBounds(378, 247, 183, 29);
				desktopPane_1.add(buttonExportKML);
				buttonExportKML.setBackground(new Color(0, 0, 0));
				buttonExportKML.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//if(!combData.isEmpty())
							ExportKML.writeKMLFile(combData);
					}
				});
				buttonExportKML.setForeground(new Color(0, 255, 255));
				btnUpdateDatabase.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
							deletedHeader=false;
							WriteCombCsv.writeCsvFile(combData);
							AnsNumberOfRecords.setText(""+combData.size());
							AnsNumOfNetworks.setText(""+SetDataBase.numOfDifferentMacSamples(combData));
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnDeleteDatabase.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deletedHeader=true;
						combData=SetDataBase.deleteCombData(combData);
						AnsNumberOfRecords.setText(""+combData.size());
						AnsNumOfNetworks.setText(""+SetDataBase.numOfDifferentMacSamples(combData));

					}
				});
		btnUndoFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				combData= processedCsvFile;
				Gui_Data.AnsNumberOfRecords.setText(""+Gui_Data.combData.size());
				Gui_Data.AnsNumOfNetworks.setText(""+SetDataBase.numOfDifferentMacSamples(Gui_Data.combData));
			}
		});
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				SQL_window sqWind= new SQL_window();
				sqWind.createSQL_Window();
			}
		});
		frame.getContentPane().setLayout(groupLayout);
	}
	
	
	
//	public static ArrayList <SampleOfWifi> filterID ( ArrayList <SampleOfWifi> combData)
//	{
//		ArrayList <SampleOfWifi> filtered=combData;
//		if (Gui_Data.Operand.equals("OR"))
//		{
//			ArrayList <SampleOfWifi> specificFiltered1=combData;
//			ArrayList <SampleOfWifi> specificFiltered2=combData;
//			ArrayList <SampleOfWifi> specificFiltered3=combData;// he will contain the and operator
//			ArrayList <SampleOfWifi> join=new ArrayList<>();
//
//			if ((Gui_Data.CheckBoxByPhoneID.isSelected())&&(Gui_Data.CheckBoxByTime.isSelected()))
//			{
//				if (!textFieldPhoneID.getText().isEmpty()){
//					filterID=new FilterByPhoneId(textFieldPhoneID.getText());
//					specificFiltered1=SetDataBase.filter(combData,filterID);
//				}
//				if ((!txtInsertStartTime.getText().isEmpty())&&(!txtInsertEndTime.getText().isEmpty())){
//					filterTIME=new FilterByTime(txtInsertStartTime.getText(),txtInsertEndTime.getText());
//					specificFiltered2=SetDataBase.filter(filtered,filterTIME);
//					specificFiltered3=SetDataBase.filter(specificFiltered1,filterTIME);
//
//				}
//				filter_Properties="(PhoneId("+textFieldPhoneID.getText()+")||(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+")))";
//				label_Filter.setText(filter_Properties);
//				//щерд
//				filterp=new FilterObject("","","",textFieldPhoneID.getText(),txtInsertStartTime.getText(),txtInsertEndTime.getText());
//				System.out.println(filter_Properties);
//			}
//			
//			if ((Filter_Window.CheckBoxByPhoneID.isSelected())&&(Gui_Data.CheckboxByLocation.isSelected()))
//			{
//				if (!textFieldPhoneID.getText().isEmpty()){
//					filterID=new FilterByPhoneId(textFieldPhoneID.getText());
//					specificFiltered1=SetDataBase.filter(combData,filterID);
//				}
//				if ((!txtInsertLat.getText().isEmpty())&&(!txtInsertLon.getText().isEmpty())&&(!txtInsertRadios.getText().isEmpty())){
//					double lat = Double.parseDouble(txtInsertLat.getText());
//					double lon = Double.parseDouble(txtInsertLon.getText());
//					double radios = Double.parseDouble(txtInsertRadios.getText());
//					if ((!txtInsertLat.getText().isEmpty())&&(!txtInsertLon.getText().isEmpty())&&(!txtInsertRadios.getText().isEmpty())){
//						filterLocation=new FilterByLocation(lat,lon,0,radios);
//						specificFiltered2=SetDataBase.filter(filtered,filterLocation);
//						specificFiltered3=SetDataBase.filter(specificFiltered1,filterLocation);
//
//					}
//				}
//				filter_Properties="(PhoneId("+textFieldPhoneID.getText()+")||(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+"))))";
//				label_Filter.setText(filter_Properties);
//				//щерд
//				filterp=new FilterObject(txtInsertRadios.getText(),txtInsertLat.getText(),txtInsertLon.getText(),textFieldPhoneID.getText(),"","");
//				System.out.println(filter_Properties);
//			}
//			
//			if ((Gui_Data.CheckBoxByTime.isSelected())&&(Gui_Data.CheckboxByLocation.isSelected()))
//			{
//				if ((!txtInsertStartTime.getText().isEmpty())&&(!txtInsertEndTime.getText().isEmpty())){
//					filterTIME=new FilterByTime(txtInsertStartTime.getText(),txtInsertEndTime.getText());
//					specificFiltered1=SetDataBase.filter(filtered,filterTIME);
//				}
//				if ((!txtInsertLat.getText().isEmpty())&&(!txtInsertLon.getText().isEmpty())&&(!txtInsertRadios.getText().isEmpty())){
//					double lat = Double.parseDouble(txtInsertLat.getText());
//					double lon = Double.parseDouble(txtInsertLon.getText());
//					double radios = Double.parseDouble(txtInsertRadios.getText());
//					if ((!txtInsertLat.getText().isEmpty())&&(!txtInsertLon.getText().isEmpty())&&(!txtInsertRadios.getText().isEmpty())){
//						filterLocation=new FilterByLocation(lat,lon,0,radios);
//						specificFiltered2=SetDataBase.filter(filtered,filterLocation);
//						specificFiltered3=SetDataBase.filter(specificFiltered1,filterLocation);
//
//					}
//				}
//				filter_Properties="(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+")||(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+"))))";
//				label_Filter.setText(filter_Properties);
//				//щерд
//				filterp=new FilterObject(txtInsertRadios.getText(),txtInsertRadios.getText(),txtInsertLon.getText(),"",txtInsertStartTime.getText(),txtInsertEndTime.getText());
//				System.out.println(filter_Properties);
//			}
//			
//			//we will add the specificFiltered2 to specificFiltered1
//			for (int i = 0; i < specificFiltered2.size(); i++) {
//				join.add(specificFiltered2.get(i));
//			}
//			for (int i = 0; i < specificFiltered1.size(); i++) {
//				join.add(specificFiltered1.get(i));
//			}
//			
//			for (int i = 0; i < specificFiltered3.size(); i++) {
//				for (int j = 0; j < join.size(); j++) {
//					if(specificFiltered3.get(i).equals(join.get(j)))
//					{
//						join.remove(j);
//						j--;
//						}
//					
//					
//				}
//			}
//			if(Gui_Data.Operand.equals("AND")){
//				if ((Gui_Data.CheckBoxByPhoneID.isSelected())&&(Gui_Data.CheckBoxByTime.isSelected())){
//					filter_Properties="(PhoneId("+textFieldPhoneID.getText()+")&&(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+")))";
//					filterp=new FilterObject("","","",textFieldPhoneID.getText(),txtInsertStartTime.getText(),txtInsertEndTime.getText());
//					System.out.println("time+id ");
//				}
//				else if((Gui_Data.CheckBoxByPhoneID.isSelected())&&(Gui_Data.CheckboxByLocation.isSelected())){
//					filter_Properties="(PhoneId("+textFieldPhoneID.getText()+")&&(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+"))))";
//					filterp=new FilterObject(txtInsertRadios.getText(),txtInsertLat.getText(),txtInsertLon.getText(),textFieldPhoneID.getText(),"","");
//					System.out.println("hhhhhhhhhhhhhhhhhhhh");
//				}
//				else if((Gui_Data.CheckBoxByTime.isSelected())&&(Gui_Data.CheckboxByLocation.isSelected())){
//					filter_Properties="(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+")&&(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+"))))";
//					filterp=new FilterObject(txtInsertRadios.getText(),txtInsertLat.getText(),txtInsertLon.getText(),"",txtInsertStartTime.getText(),txtInsertEndTime.getText());
//				}
//			}
//			filtered=join;
//			
//			
//
//		}///////////////////////////////////////////////////////////////////////////////
//		else
//		{
//			System.out.println("is correct"+ filtered.get(3).getPhoneId());
//			//_________________filter by phone ID___________
//			if (Gui_Data.CheckBoxByPhoneID.isSelected()){
//				if (!textFieldPhoneID.getText().isEmpty()){
//					filterID=new FilterByPhoneId(textFieldPhoneID.getText());
//					filtered=SetDataBase.filter(combData,filterID);
//				}
//				filter_Properties="(PhoneId("+textFieldPhoneID.getText()+"))";
//				filterp=new FilterObject("", "", "", textFieldPhoneID.getText(), "", "");
//				label_Filter.setText(filter_Properties);
//				System.out.println(filter_Properties);
//			}
//			//_________________filter by time___________
//					if (Gui_Data.CheckBoxByTime.isSelected()){
//						if ((!txtInsertStartTime.getText().isEmpty())&&(!txtInsertEndTime.getText().isEmpty())){
//							filterTIME=new FilterByTime(txtInsertStartTime.getText(),txtInsertEndTime.getText());
//							filtered=SetDataBase.filter(filtered,filterTIME);
//						}
//						filter_Properties="(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+"))";
//						filterp=new FilterObject("", "", "", "", txtInsertStartTime.getText(),(String)txtInsertEndTime.getText());
//						label_Filter.setText(filter_Properties);
//						System.out.println(filter_Properties);
//					}
//			
//			//_________________filter by location___________
//					
//			if (Gui_Data.CheckboxByLocation.isSelected()){
//				if ((!txtInsertLat.getText().isEmpty())&&(!txtInsertLon.getText().isEmpty())&&(!txtInsertRadios.getText().isEmpty())){
//					double lat = Double.parseDouble(txtInsertLat.getText());
//					double lon = Double.parseDouble(txtInsertLon.getText());
//					double radios = Double.parseDouble(txtInsertRadios.getText());
//					filterLocation=new FilterByLocation(lat,lon,0,radios);
//					filtered=SetDataBase.filter(filtered,filterLocation);
//				}
//				filter_Properties="(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+")))";
//				filterp=new FilterObject(txtInsertRadios.getText(),txtInsertLat.getText(), txtInsertLon.getText(), "", "","");
//				label_Filter.setText(filter_Properties);
//				System.out.println(filter_Properties);
//			}
//		}
//		
//		if(Gui_Data.Operand.equals("NOT")){
//			if(Gui_Data.CheckBoxByPhoneID.isSelected()){
//				filter_Properties="!"+textFieldPhoneID.getText();
//				filterp=new FilterObject("", "", "", "!"+textFieldPhoneID.getText(), "", "");
//			}
//			else if(Gui_Data.CheckBoxByTime.isSelected()){
//				filter_Properties="!(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+"))";
//			    filterp=new FilterObject("", "", "", "", txtInsertStartTime.getText(),"!"+txtInsertEndTime.getText());
//			}
//			else if(Gui_Data.CheckboxByLocation.isSelected()){
//				filter_Properties="!(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+")))";
//				filterp=new FilterObject("!("+txtInsertRadios.getText(),txtInsertLat.getText(), txtInsertLon.getText()+")", "", "","");
//			}
//			else if ((Gui_Data.CheckBoxByPhoneID.isSelected())&&(Gui_Data.CheckBoxByTime.isSelected())){ 
//				filter_Properties="!(PhoneId("+textFieldPhoneID.getText()+")&&!(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+")))";
//				filterp=new FilterObject("","","","!"+textFieldPhoneID.getText(),"!("+txtInsertStartTime.getText(),txtInsertEndTime.getText()+")");
//				System.out.println("time+id ");
//			}
//			else if((Gui_Data.CheckBoxByPhoneID.isSelected())&&(Gui_Data.CheckboxByLocation.isSelected())){
//				filter_Properties="(!PhoneId("+textFieldPhoneID.getText()+")&&(!Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+"))))";
//				filterp=new FilterObject("!"+txtInsertRadios.getText(),txtInsertLat.getText(),"!"+txtInsertLon.getText(),"!"+textFieldPhoneID.getText(),"","");
//			}
//			else if((Gui_Data.CheckBoxByTime.isSelected())&&(Gui_Data.CheckboxByLocation.isSelected())){
//				filter_Properties="!(Time("+txtInsertStartTime.getText()+"<data<"+txtInsertEndTime.getText()+")&&!(Location("+txtInsertRadios.getText()+"<"+"Distance ("+txtInsertLat.getText()+","+txtInsertLon.getText()+"))))";
//				filterp=new FilterObject("!("+txtInsertRadios.getText(),txtInsertLat.getText(),txtInsertLon.getText()+")","","!("+txtInsertStartTime.getText(),txtInsertEndTime.getText()+")");
//			}
//		}
//		
//	filtered=SetDataBase.filterNOT(combData, filtered);
//	return filtered;
//	}
}