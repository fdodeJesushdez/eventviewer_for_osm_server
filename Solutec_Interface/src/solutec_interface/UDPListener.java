/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solutec_interface;

/**
 *
 * @author Fernando
 */
import java.io.*;
import java.net.*;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JDialog;

import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Color;


public class UDPListener {

  public UDPListener(){
  intSwitch = 0;
  numericPort = 0;
  stringPort = "null";
  numericArray = new char[5];

  BUFFERSIZE = 4096;
  data = null;
  splitter = "\"";
  splited = null;
  firstPart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xml_al><msg command=\"commit\" sq=\"";
  secondPart = "\"/></xml_al>";
  sq = null;
  ack = null;
  serialNumber = null;
  sourceofTime = null;
  timeStamp = null;
  event = null;
  console = null;
  contactID = "  ";

  accountNumber = new char[4];
  contactIdCode = new char[4];
  partitionNumber = new char[2];
  partitionNumber[0] = '0';
  partitionNumber[1] = '0';
  zoneNumber = new char[3];
  zoneNumber[0] = '0';
  zoneNumber[1] = '0';
  zoneNumber[2] = '0';
  

  

        aboutDialog = new JDialog();
        aboutDialogPanel = new JPanel();
        aboutDialogIconLabel = new JLabel();
        aboutDialogCenterTitle = new JLabel();
        aboutDialogDescriptionLabel = new JLabel();
        aboutDialogVersionLabel = new JLabel();
        aboutDialogCopyLabel = new JLabel();
        aboutDialogWebPageLabel = new JLabel();
        aboutDialogVersionValueLabel = new JLabel();
        aboutDialogCopyValueLabel = new JLabel();
        aboutDialogWebPageValueLabel = new JLabel();
        jPanel1 = new JPanel();
        descriptionLabel = new JLabel();
        
        logoLabel = new JLabel();

        scrollPane = new JScrollPane();
        model = new StringTableModel(100, new String [] {"Fecha y Hora", "No de Cuenta", "Unidad", "Evento", "Partición", "Zona/Usuario"});
        eventsTable = new JTable(model);
        /*
        {

            @Override
	    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
			{
				Component c = super.prepareRenderer(renderer, row, column);
				if (!c.getBackground().equals(getSelectionBackground()))
				{
					String type = (String)getModel().getValueAt(row, 3);
					c.setBackground( type.equals("E120") ? Color.RED : Color.WHITE );
				}
				return c;
			}};*/
                        
        toolBar = new JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        choosePortMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        aboutDialog.setTitle("Acerca de: Visualizador de Eventos 1.0");
        aboutDialog.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        aboutDialog.setMinimumSize(new java.awt.Dimension(450, 170));

        aboutDialogIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_only.png"))); // NOI18N

        //aboutDialogCenterTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aboutDialogCenterTitle.setText("Visualizador de Eventos");

        aboutDialogDescriptionLabel.setText("Dispositivos soportados: LX/EX/AG");

        //aboutDialogVersionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        aboutDialogVersionLabel.setText("Versión:");

        //aboutDialogCopyLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        aboutDialogCopyLabel.setText("Copyrigth by:");

        //aboutDialogWebPageLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        aboutDialogWebPageLabel.setText("Página Web:");

        aboutDialogVersionValueLabel.setText("1.0");

        aboutDialogCopyValueLabel.setText("Solutec Soluciones Tecnológicas Ltda");

        aboutDialogWebPageValueLabel.setText("www.solutecltda.com");

        javax.swing.GroupLayout aboutDialogPanelLayout = new javax.swing.GroupLayout(aboutDialogPanel);
        aboutDialogPanel.setLayout(aboutDialogPanelLayout);
        aboutDialogPanelLayout.setHorizontalGroup(
            aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogPanelLayout.createSequentialGroup()
                .addComponent(aboutDialogIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(aboutDialogDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                        .addComponent(aboutDialogCenterTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                    .addGroup(aboutDialogPanelLayout.createSequentialGroup()
                        .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aboutDialogVersionLabel)
                            .addComponent(aboutDialogCopyLabel)
                            .addComponent(aboutDialogWebPageLabel))
                        .addGap(21, 21, 21)
                        .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aboutDialogWebPageValueLabel)
                            .addComponent(aboutDialogCopyValueLabel)
                            .addComponent(aboutDialogVersionValueLabel))
                        .addGap(229, 229, 229))))
        );
        aboutDialogPanelLayout.setVerticalGroup(
            aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutDialogIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(aboutDialogPanelLayout.createSequentialGroup()
                .addComponent(aboutDialogCenterTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutDialogDescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutDialogVersionLabel)
                    .addComponent(aboutDialogVersionValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutDialogCopyLabel)
                    .addComponent(aboutDialogCopyValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aboutDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aboutDialogWebPageValueLabel)
                    .addComponent(aboutDialogWebPageLabel))
                .addContainerGap(83, Short.MAX_VALUE))
        );

       javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutDialogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
  frame = new JFrame();
  frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  frame.setTitle("Visualizador de Eventos Solutec Ltda");

  descriptionLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
  descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
  descriptionLabel.setText("Visualizador de Eventos LX/EX/AG");

  logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
  logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo cajas.png"))); // NOI18N



  
 
  //eventsTable.setModel(model);
  eventsTable.getTableHeader().setReorderingAllowed(false);

  scrollPane.setViewportView(eventsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                        .addGap(206, 206, 206)
                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logoLabel)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        toolBar.setRollover(true);

        fileMenu.setText("Archivo");

        choosePortMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        choosePortMenuItem.setText("Abrir puerto UDP");
        choosePortMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePortMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(choosePortMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        aboutMenu.setText("Acerca de");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setText("Acerca de Visualizador de Eventos");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenuItem);

        jMenuBar1.add(aboutMenu);

        frame.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        frame.pack();

 
  frame.setVisible(true);
  }

      public boolean isInteger( String input )
    {
       try
       {
          Integer.parseInt( input );
          return true;
       }
       catch(NumberFormatException nfe )
       {
        return false;
      }
   }

  private void choosePortMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        stringPort = JOptionPane.showInputDialog(frame,"Ingrese el No de puerto UDP","Para iniciar debe seleccionar un puerto",JOptionPane.INFORMATION_MESSAGE);

        if(isInteger(stringPort)){
            intSwitch = 1;
            choosePortMenuItem.setEnabled(false);
            try
            {
                numericPort=Integer.parseInt(stringPort);
            }
                catch(NumberFormatException nfe )
            {

            }
        }
        else{
            JOptionPane.showMessageDialog(frame,
                                    "Debe ingresar un valor númerico!",
                                    "Entrada no valida",
                                    JOptionPane.WARNING_MESSAGE);

        }

    }
   private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
          aboutDialog.setLocationRelativeTo(frame);
          aboutDialog.setVisible(true);
    }
   private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
       System.exit(0);
    }

  public void rearrangeData (StringTableModel tableModel){
      Object aux = null;
      for(int i = 99; i>0; i--){
        for(int j=0; j<6;j++){
            aux = tableModel.getValueAt(i-1, j);
            tableModel.setValueAt(aux, i, j);
        }
      }
  }

  public static void main(String[] args) {
    UDPListener interfaceObj = new UDPListener();

  
  while(true){
    try { // Poll every ~10 ms
            Thread.sleep(10);
         }
         catch (InterruptedException e) {}
    
    switch(interfaceObj.intSwitch){  
        
        case 0:
            break;
        case 1:
    DatagramSocket sock;
    byte confirmData [] = new byte[4096];
    //confirmData [0] = 6;
    InetAddress osmClient = null;
    int port = 7100;
    DatagramPacket packet = new DatagramPacket(new byte[interfaceObj.BUFFERSIZE],interfaceObj.BUFFERSIZE);
    DatagramPacket confirm = null;

    try {
      sock = new DatagramSocket(interfaceObj.numericPort);
     //System.out.println("SocketCreado");
    } catch (SocketException e) {
      System.out.println(e);
      return;
    }
    // echo back everything
    while (true) {
      try {
        sock.receive(packet);
        interfaceObj.data = new String(packet.getData(),0,packet.getLength());

        /*
        osmClient = packet.getAddress();
        port = packet.getPort();
        confirm = new DatagramPacket(confirmData,confirmData.length,osmClient,port);
        sock.send(confirm);
       */

        interfaceObj.splited = interfaceObj.data.split(interfaceObj.splitter);
       interfaceObj.sq = interfaceObj.splited[5];
        interfaceObj.ack = interfaceObj.firstPart + interfaceObj.sq + interfaceObj.secondPart;



        confirmData = interfaceObj.ack.getBytes();
        osmClient = packet.getAddress();
        port = packet.getPort();
        confirm = new DatagramPacket(confirmData,confirmData.length,osmClient,port);
        sock.send(confirm);

        //System.out.println(data);

        interfaceObj.accountNumber[0]='?';
        interfaceObj.accountNumber[1]='?';
        interfaceObj.accountNumber[2]='?';
        interfaceObj.accountNumber[3]='?';

        interfaceObj.partitionNumber[0] = '0';
        interfaceObj.partitionNumber[1] = '0';
        interfaceObj.zoneNumber[0] = '0';
        interfaceObj.zoneNumber[1] = '0';
        interfaceObj.zoneNumber[2] = '0';
        interfaceObj.serialNumber = interfaceObj.splited[17];
        interfaceObj.sourceofTime = interfaceObj.splited[18];
        interfaceObj.timeStamp = interfaceObj.splited[19];


        if(interfaceObj.sourceofTime.equals(" dts=")){
        interfaceObj.event = interfaceObj.splited[25];
        }
        else{
        interfaceObj.event = interfaceObj.splited[23];
        }


        if(interfaceObj.event.equalsIgnoreCase("DATA DTMF"))
        {
            interfaceObj.contactID = interfaceObj.splited[27];

            interfaceObj.accountNumber[0] = interfaceObj.contactID.charAt(7);
            interfaceObj.accountNumber[1] = interfaceObj.contactID.charAt(9);
            interfaceObj.accountNumber[2] = interfaceObj.contactID.charAt(11);
            interfaceObj.accountNumber[3] = interfaceObj.contactID.charAt(13);

            interfaceObj.contactIdCode[0]= interfaceObj.contactID.charAt(19);
            if(interfaceObj.contactIdCode[0]=='1'){
            interfaceObj.contactIdCode[0] = 'E';
            }
            else{
            interfaceObj.contactIdCode[0] = 'R';
            }
            interfaceObj.contactIdCode[1] = interfaceObj.contactID.charAt(21);
            interfaceObj.contactIdCode[2] = interfaceObj.contactID.charAt(23);
            interfaceObj.contactIdCode[3] = interfaceObj.contactID.charAt(25);

            interfaceObj.partitionNumber[0] = interfaceObj.contactID.charAt(27);
            interfaceObj.partitionNumber[1] = interfaceObj.contactID.charAt(29);

            interfaceObj.zoneNumber[0] = interfaceObj.contactID.charAt(31);
            interfaceObj.zoneNumber[1] = interfaceObj.contactID.charAt(33);
            interfaceObj.zoneNumber[2] = interfaceObj.contactID.charAt(35);

            interfaceObj.event = new String(interfaceObj.contactIdCode);
        }


        interfaceObj.rearrangeData(interfaceObj.model);

        interfaceObj.eventsTable.repaint();

        interfaceObj.model.setValueAt(interfaceObj.timeStamp, 0, 0);
        interfaceObj.model.setValueAt(new String(interfaceObj.accountNumber), 0, 1);
        interfaceObj.model.setValueAt(interfaceObj.serialNumber, 0, 2);
        interfaceObj.model.setValueAt(interfaceObj.event, 0, 3);
        interfaceObj.model.setValueAt(new String(interfaceObj.partitionNumber), 0, 4);
        interfaceObj.model.setValueAt(new String(interfaceObj.zoneNumber), 0, 5);

        //System.out.println(interfaceObj.stringPort);
        

        //System.out.println(data);

        //System.out.println(ack);


        }
      catch (IOException ioe) {
        System.out.println(ioe);
      }
     }

     }
    }
  }
  final int BUFFERSIZE;
  String data;
  final String  splitter;
  String [] splited;
  final String firstPart;
  final String secondPart;

  String sq;
  String ack;
  String serialNumber;
  String sourceofTime;
  String timeStamp;
  String event;
  String console;
  String contactID;

  char [] accountNumber;
  char [] contactIdCode;
  char [] zoneNumber;
  char [] partitionNumber;

  JFrame frame;
  
  StringTableModel model;
  JTable table;
  JScrollPane myScrollPane;

    JDialog aboutDialog;
    JMenu aboutMenu;
    JLabel aboutDialogCopyLabel;
    JLabel aboutDialogCopyValueLabel;
    JLabel aboutDialogDescriptionLabel;
    JLabel aboutDialogIconLabel;
    JPanel aboutDialogPanel;
    JLabel aboutDialogVersionLabel;
    JLabel aboutDialogVersionValueLabel;
    JLabel aboutDialogWebPageLabel;
    JLabel aboutDialogWebPageValueLabel;
    JLabel aboutDialogCenterTitle;

    JMenuItem aboutMenuItem;
    
    JLabel descriptionLabel;
    JTable eventsTable;
    JMenuItem exitMenuItem;
    JMenuItem choosePortMenuItem;
    JMenu fileMenu;
    JMenuBar jMenuBar1;
    JPanel jPanel1;
    JLabel logoLabel;
    JScrollPane scrollPane;
    JToolBar toolBar;
    String stringPort;
    char [] numericArray;
    int intSwitch;
    int numericPort;


}
