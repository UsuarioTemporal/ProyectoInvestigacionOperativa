package App;

import Animation.AWTUtilities;
import Animation.FadeEffect;
import matriz.GeneradorMatrizTrans;
import MetodosTransporte.Cacillero;
import MetodosTransporte.NorOeste;
import MetodosTransporte.PersonalizarTable;
import MetodosTransporte.Vogel;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import rojerusan.RSAnimation;
import javax.swing.*;
public class App extends JFrame {
    private PersonalizarTable tablaPersonalizable = new PersonalizarTable();
    private DialogError error;
    private boolean comenzando = true;
    private boolean comenzandoMenu = true;
    private int ejex;
    private int ejey;
    private int ejexDialog;
    private int ejeyDialog;
    public static int destinos = 0 ;
    public static int fuentes = 0;
    public static DefaultTableModel tablaModeloRestr = null;
    private DefaultTableModel tablaModeloSol = null;
    public static Cacillero[][] celda;
    
    public static int filaAdicional = 0;
    public static int columnaAdicional = 0;
    public boolean filaFicticia = false, columnaFicticia = false;
    private double demanda = 0;
    private double oferta = 0;
    public static String existeRedundancia;
    private GeneradorMatrizTrans matriztrans = new GeneradorMatrizTrans();
    private NorOeste metodoNorOeste;
    private Vogel metodoVogel;
    

    public App() {
        initComponents();
        tableSolucion.setDefaultRenderer(Object.class, tablaPersonalizable);
        // inicializando las varibles
        tableSolucion.setRowHeight(50);
        jTablaIngreso.setRowHeight(30);
        jTableResultados.setRowHeight(22);
        destinos = Integer.parseInt("" + spinnerDestino.getValue());
        fuentes = Integer.parseInt("" + spinnerFuente.getValue());
        new GeneradorMatrizTrans().generadorMatrizTrans(destinos, fuentes, jTablaIngreso, 0);
        frameDialog.setBounds(getX() + (getWidth() / 2) - (frameDialog.getWidth() / 2), (getHeight() / 2) - (frameDialog.getHeight() / 2), frameDialog.getWidth(), frameDialog.getHeight());
        
        JTableHeader tableHead;
        tableHead = jTablaIngreso.getTableHeader();
        tableHead.setForeground(Color.RED);
        jTableResultados.setEnabled(false);
        AWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrame(this, 50, 0.1f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameDialog = new javax.swing.JFrame();
        panelDatosIngresables = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        cbxMetodos = new rojerusan.RSComboMetro();
        jLabel6 = new javax.swing.JLabel();
        spinnerDestino = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spinnerFuente = new javax.swing.JSpinner();
        btnGuardarCambios = new rojerusan.RSMaterialButtonRectangle();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTabla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaIngreso = new rojerusan.RSTableMetro();
        btnMenu1 = new javax.swing.JButton();
        btnProcesar = new rojerusan.RSMaterialButtonRectangle();
        btnEquilibrar = new rojerusan.RSMaterialButtonRectangle();
        frameEqulibrio = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel5 = new javax.swing.JLabel();
        equiliDestino = new javax.swing.JCheckBox();
        equilibrioFuente = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jScrollContenedorSolucion = new javax.swing.JScrollPane();
        tableSolucion = new javax.swing.JTable();
        panelResultado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfResultado = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResultados = new rojerusan.RSTableMetro();
        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new rojerusan.RSMaterialButtonCircle();
        jLabel8 = new javax.swing.JLabel();
        btnIniciarDatos = new rojerusan.RSMaterialButtonRectangle();
        btnSolucion = new rojerusan.RSMaterialButtonRectangle();
        btnMenu = new javax.swing.JButton();

        frameDialog.setTitle("Coeficientes");
        frameDialog.setBackground(new java.awt.Color(255, 255, 255));
        frameDialog.setMinimumSize(new java.awt.Dimension(540, 530));
        frameDialog.setUndecorated(true);
        frameDialog.setResizable(false);
        frameDialog.setSize(new java.awt.Dimension(540, 530));
        frameDialog.setState(100000);
        frameDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatosIngresables.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosIngresables.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));
        panelDatosIngresables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelOpciones.setBackground(new java.awt.Color(255, 255, 255));
        panelOpciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 3));
        panelOpciones.setForeground(new java.awt.Color(0, 102, 153));

        cbxMetodos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Esquina Noroeste", "Vogel" }));
        cbxMetodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Destino");

        spinnerDestino.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        spinnerDestino.setModel(new javax.swing.SpinnerNumberModel(2, 2, 350, 1));
        spinnerDestino.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerDestinoStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Fuente");

        spinnerFuente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        spinnerFuente.setModel(new javax.swing.SpinnerNumberModel(2, 1, 400, 1));

        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(spinnerFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spinnerDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxMetodos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(cbxMetodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panelDatosIngresables.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 170, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 102, 153));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel10MouseDragged(evt);
            }
        });
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 46)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INGRESO DE DATOS ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosIngresables.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 540, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTabla.setBackground(new java.awt.Color(255, 255, 255));
        lblTabla.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTabla.setForeground(new java.awt.Color(153, 0, 0));
        lblTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTabla.setText("Tabla Desactivada");
        jPanel3.add(lblTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 279, 34));

        jTablaIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Fuente 1", null, null, null},
                {"Fuente 2", null, null, null},
                {"Demanda", null, null, null}
            },
            new String [] {
                "", "Destino 1", "Destino 2", "Oferta"
            }
        ));
        jTablaIngreso.setAltoHead(16);
        jTablaIngreso.setEnabled(false);
        jTablaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTablaIngresoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaIngreso);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 462, 283));

        btnMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-menu.png"))); // NOI18N
        btnMenu1.setBorder(null);
        btnMenu1.setContentAreaFilled(false);
        btnMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 52));

        panelDatosIngresables.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 520, 370));

        btnProcesar.setText("PROCESAR");
        btnProcesar.setEnabled(false);
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        panelDatosIngresables.add(btnProcesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 168, 45));

        btnEquilibrar.setText("Equilibrar");
        btnEquilibrar.setEnabled(false);
        btnEquilibrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquilibrarActionPerformed(evt);
            }
        });
        panelDatosIngresables.add(btnEquilibrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 170, 45));

        frameDialog.getContentPane().add(panelDatosIngresables, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 530));

        frameEqulibrio.setMaximumSize(new java.awt.Dimension(194, 298));
        frameEqulibrio.setMinimumSize(new java.awt.Dimension(194, 298));
        frameEqulibrio.setUndecorated(true);
        frameEqulibrio.setSize(new java.awt.Dimension(194, 298));
        frameEqulibrio.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                frameEqulibrioWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/informacion.png"))); // NOI18N

        rSMaterialButtonRectangle1.setText("OK");
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Equilibrar");

        equiliDestino.setBackground(new java.awt.Color(255, 255, 255));
        equiliDestino.setForeground(new java.awt.Color(0, 102, 153));
        equiliDestino.setText("Destino");
        equiliDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equiliDestinoActionPerformed(evt);
            }
        });

        equilibrioFuente.setBackground(new java.awt.Color(255, 255, 255));
        equilibrioFuente.setForeground(new java.awt.Color(0, 102, 153));
        equilibrioFuente.setText("Fuente");
        equilibrioFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equilibrioFuenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(equiliDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(equilibrioFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equiliDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equilibrioFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout frameEqulibrioLayout = new javax.swing.GroupLayout(frameEqulibrio.getContentPane());
        frameEqulibrio.getContentPane().setLayout(frameEqulibrioLayout);
        frameEqulibrioLayout.setHorizontalGroup(
            frameEqulibrioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frameEqulibrioLayout.setVerticalGroup(
            frameEqulibrioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frameEqulibrio.getAccessibleContext().setAccessibleParent(frameDialog);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transporte ");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(442, 687));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(442, 632));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));
        jPanel6.setMaximumSize(new java.awt.Dimension(442, 632));
        jPanel6.setPreferredSize(new java.awt.Dimension(442, 632));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollContenedorSolucion.setBackground(new java.awt.Color(255, 255, 255));
        jScrollContenedorSolucion.setForeground(new java.awt.Color(0, 0, 0));
        jScrollContenedorSolucion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollContenedorSolucion.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollContenedorSolucion.setWheelScrollingEnabled(false);

        tableSolucion.setBackground(new java.awt.Color(255, 255, 255));
        tableSolucion.setForeground(new java.awt.Color(0, 0, 0));
        tableSolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableSolucion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableSolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableSolucion.setRowHeight(10);
        jScrollContenedorSolucion.setViewportView(tableSolucion);

        jPanel6.add(jScrollContenedorSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-430, 160, 428, 400));

        panelResultado.setBackground(new java.awt.Color(255, 255, 255));
        panelResultado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        panelResultado.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("ÓPTIMO =");
        panelResultado.add(jLabel2);
        jLabel2.setBounds(20, 50, 100, 30);

        jtfResultado.setBackground(new java.awt.Color(255, 255, 255));
        jtfResultado.setForeground(new java.awt.Color(0, 0, 0));
        jtfResultado.setOpaque(true);
        panelResultado.add(jtfResultado);
        jtfResultado.setBounds(120, 50, 80, 30);

        lblTipo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(0, 102, 153));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelResultado.add(lblTipo);
        lblTipo.setBounds(40, 10, 280, 40);

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTableResultados.setBackground(new java.awt.Color(255, 255, 255));
        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fuente", "Destino", "Materiales", "Precio", "Total"
            }
        ));
        jTableResultados.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jTableResultados.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(jTableResultados);

        panelResultado.add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 390, 300);

        jPanel6.add(panelResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 406, 400));

        panelTitulo.setBackground(new java.awt.Color(0, 102, 153));
        panelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        panelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        panelTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelTituloMouseDragged(evt);
            }
        });
        panelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelTituloMousePressed(evt);
            }
        });
        panelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MÉTODOS DE");
        panelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 250, 60));

        btnSalir.setBackground(new java.awt.Color(153, 0, 0));
        btnSalir.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnSalir.setLabel("x"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelTitulo.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 40, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TRANSPORTE");
        panelTitulo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 50));

        jPanel6.add(panelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 440, 100));

        btnIniciarDatos.setText("Iniciar Datos");
        btnIniciarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarDatosActionPerformed(evt);
            }
        });
        jPanel6.add(btnIniciarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 50));

        btnSolucion.setText("SOLUCIÓN");
        btnSolucion.setEnabled(false);
        btnSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolucionActionPerformed(evt);
            }
        });
        jPanel6.add(btnSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 180, 50));

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/derecha.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel6.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, -1, 52));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(442, 645));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void equilibrioFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equilibrioFuenteActionPerformed

        if (equiliDestino.isSelected()) {
            quitarColumna();
        }
        calcularDemandaOfretTotal(tableSolucion, 0, 0);

        equiliDestino.setSelected(false);
        if (!equilibrioFuente.isSelected()) {
            quitarFila();
        } else {
            insertarFila();
        }


    }//GEN-LAST:event_equilibrioFuenteActionPerformed

    private void equiliDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equiliDestinoActionPerformed

        if (equilibrioFuente.isSelected()) {
            quitarFila();
        }
        calcularDemandaOfretTotal(jTablaIngreso, 0, 0);
        equilibrioFuente.setSelected(false);
        if (!equiliDestino.isSelected()) {
            quitarColumna();
        } else {
            insertarColumna();
        }
    }//GEN-LAST:event_equiliDestinoActionPerformed

    private void btnIniciarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarDatosActionPerformed
        // TODO add your handling code here:
        RSAnimation.setBajar(-155, this.getY(), 1, 1, frameDialog);

        frameDialog.setVisible(true);
        frameDialog.setLocationRelativeTo(this);
        btnIniciarDatos.setEnabled(false);

    }//GEN-LAST:event_btnIniciarDatosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolucionActionPerformed
        // TODO add your handling code here:
        btnIniciarDatos.setEnabled(true);
        boolean terminarProceso = false;
        while (!terminarProceso) {
            if (cbxMetodos.getSelectedIndex() == 0) {
                if (metodoNorOeste.metodNorOeste(tableSolucion, tablaModeloSol)) {
                    retornar();
                    btnSolucion.setEnabled(false);
                    terminarProceso = true;
                }
            }
            if (cbxMetodos.getSelectedIndex() == 1) {
                metodoVogel.calcularmenoresColumnas(tableSolucion);
                metodoVogel.calcularSumaMenoresFilas(tableSolucion);
                metodoVogel.buscarMayorFilaColumna(tableSolucion);
                if (metodoVogel.getFilaMayor() >= 0 && metodoVogel.getColumnaMayor() >= 0) {
                    metodoVogel.buscarCostoMenor();
                    metodoVogel.agregar(tableSolucion);
                } else {
                    terminarProceso = true;
                    retornar();
                    btnSolucion.setEnabled(false);
                }
            }

        }
        jtfResultado.setText("" + retornaSolucion());
    }//GEN-LAST:event_btnSolucionActionPerformed

    private void panelTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTituloMousePressed
        // TODO add your handling code here:
        ejex = evt.getX();
        ejey = evt.getY();
    }//GEN-LAST:event_panelTituloMousePressed

    private void panelTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTituloMouseDragged
        // TODO add your handling code here:
        setLocation(getLocation().x + evt.getX() - ejex, getLocation().y + evt.getY() - ejey);
    }//GEN-LAST:event_panelTituloMouseDragged

    private void cbxMetodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodosActionPerformed
        // TODO add your handling code here:
        existeRedundancia = null;
        if (cbxMetodos.getSelectedIndex() == 0) {
            filaAdicional = 0;
            columnaAdicional = 0;

        } else {
            filaAdicional = 1;
            columnaAdicional = 1;
        }

        btnSolucion.setEnabled(false);
    }//GEN-LAST:event_cbxMetodosActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        // TODO add your handling code here:

        boolean resp = sistemaGeneradorEquilibrio();
        lblTipo.setText(cbxMetodos.getSelectedItem() + "");
        if (validarNumero(jTablaIngreso) && resp) {
            destinos = Integer.parseInt("" + spinnerDestino.getValue());
            fuentes = Integer.parseInt("" + spinnerFuente.getValue());
            matriztrans.crearMatrizSolucion(jTablaIngreso, tableSolucion, filaAdicional, columnaAdicional);

            if (cbxMetodos.getSelectedIndex() == 0) {
                metodoNorOeste = new NorOeste();
                metodoNorOeste.equilibrioDemandaOfertaTotal(tableSolucion, 0, 0);
            } else if (cbxMetodos.getSelectedIndex() == 1) {
                metodoVogel = new Vogel();
                metodoVogel.calcularmenoresColumnas(tableSolucion);
                metodoVogel.calcularSumaMenoresFilas(tableSolucion);
                metodoVogel.buscarMayorFilaColumna(tableSolucion);

            }
            try {
                RSAnimation.setSubir(getY(), -500, 1, 1, frameDialog);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnSolucion.setEnabled(true);
            frameDialog.setVisible(false);
            /*Limpiando datos*/
            jTablaIngreso.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {"Fuente 1", null, null, null},
                        {"Fuente 2", null, null, null},
                        {"Demanda", null, null, null}
                    },
                    new String[]{
                        "", "Destino 1", "Destino 2", "Oferta"
                    }
            ));
            jTablaIngreso.setAltoHead(16);
            jTablaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    jTablaIngresoKeyTyped(evt);
                }
            });
            /**
             * ****************
             */
            btnProcesar.setEnabled(false);
            jTablaIngreso.setEnabled(false);
            lblTabla.setBackground(new java.awt.Color(255, 255, 255));
            lblTabla.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            lblTabla.setForeground(new java.awt.Color(153, 0, 0));
            lblTabla.setText("Tabla Desactivada");
            btnGuardarCambios.setEnabled(true);
            btnEquilibrar.setEnabled(false);
            equilibrioFuente.setSelected(false);
            equiliDestino.setSelected(false);
            cbxMetodos.setEnabled(true);
            spinnerFuente.setEnabled(true);
            spinnerDestino.setEnabled(true);
        }


    }//GEN-LAST:event_btnProcesarActionPerformed

    private void jPanel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseDragged
        // TODO add your handling code here:
        frameDialog.setLocation(frameDialog.getLocation().x + evt.getX() - ejexDialog, frameDialog.getLocation().y + evt.getY() - ejeyDialog);
    }//GEN-LAST:event_jPanel10MouseDragged

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        // TODO add your handling code here:
        ejexDialog = evt.getX();
        ejeyDialog = evt.getY();
    }//GEN-LAST:event_jPanel10MousePressed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:

        lblTabla.setText("Tabla activada");
        lblTabla.setForeground(Color.GREEN);
        lblTabla.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnProcesar.setEnabled(true);
        jTablaIngreso.setEnabled(true);
        destinos = Integer.parseInt("" + spinnerDestino.getValue());
        fuentes = Integer.parseInt("" + spinnerFuente.getValue());
        new GeneradorMatrizTrans().generadorMatrizTrans(destinos, fuentes, jTablaIngreso, 0);

        equilibrioFuente.setSelected(false);
        equiliDestino.setSelected(false);
        columnaFicticia = false;
        filaFicticia = false;
        btnEquilibrar.setEnabled(true);
        btnGuardarCambios.setEnabled(false);
        cbxMetodos.setEnabled(false);
        spinnerFuente.setEnabled(false);
        spinnerDestino.setEnabled(false);
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void jTablaIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablaIngresoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '-' && c != 'E' && c != '.') {
            evt.consume();
        }

    }//GEN-LAST:event_jTablaIngresoKeyTyped

    private void spinnerDestinoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerDestinoStateChanged
        // Destino

    }//GEN-LAST:event_spinnerDestinoStateChanged

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        try {
            // TODO add your handling code here:

            RSAnimation.setSubir(getY(), -500, 1, 2, frameEqulibrio);
            Thread.sleep(950);
        } catch (InterruptedException ex) {
            Logger.getLogger(DialogError.class.getName()).log(Level.SEVERE, null, ex);

        }
        frameEqulibrio.setVisible(false);
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void btnEquilibrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquilibrarActionPerformed
        RSAnimation.setBajar(-155, getY(), 1, 2, frameEqulibrio);
        AWTUtilities.setOpaque(frameEqulibrio, false);
        frameEqulibrio.setLocationRelativeTo(this);
        frameEqulibrio.setVisible(true);
    }//GEN-LAST:event_btnEquilibrarActionPerformed

    private void frameEqulibrioWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_frameEqulibrioWindowOpened
        
    }//GEN-LAST:event_frameEqulibrioWindowOpened

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        if(comenzando){
            btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/derecha.png"))); // NOI18N
            Animacion.Animacion.mover_derecha(-430, 5, 2, 2, jScrollContenedorSolucion);
            btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/izquierd.png"))); // NOI18N
            comenzando=false;
        }else{
            btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/izquierd.png"))); // NOI18N
            Animacion.Animacion.mover_izquierda(5, -430, 2, 2, jScrollContenedorSolucion);
            btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/derecha.png"))); // NOI18N
            comenzando=true;
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu1ActionPerformed
        if(comenzandoMenu){
            Animacion.Animacion.mover_derecha(-300, 2, 2, 2, panelOpciones);
            comenzandoMenu=false;
        }else{
            Animacion.Animacion.mover_izquierda(2, -300, 2, 2, panelOpciones);
            comenzandoMenu=true;
        }
    }//GEN-LAST:event_btnMenu1ActionPerformed
    
    

    private void quitarFila() {
        filaFicticia = false;
        tablaModeloRestr.removeRow(tablaModeloRestr.getRowCount() - 2);
    }

    private void insertarColumna() {
        columnaFicticia = true;
        tablaModeloRestr.addColumn("Oferta");
        setNombreColumna("Ficticio", jTablaIngreso);
        enviarCelda(jTablaIngreso);
        tablaModeloRestr.setValueAt((oferta - demanda), tablaModeloRestr.getRowCount() - 1, tablaModeloRestr.getColumnCount() - 2);
    }

    private void quitarColumna() {
        columnaFicticia = false;
        String tem[][] = obtenerDatosDe(jTablaIngreso, 1);
        new GeneradorMatrizTrans().generadorMatrizTrans(destinos, fuentes, jTablaIngreso, 0);
        for (int i = 0; i < tem.length; i++) {
            for (int j = 1; j < tem[i].length; j++) {
                tablaModeloRestr.setValueAt(tem[i][j], i, j);
            }
        }
    }

    private void insertarFila() {
        filaFicticia = true;
        String temp;
        tablaModeloRestr.addRow(new String[]{"Demanda"});
        int p = tablaModeloRestr.getRowCount();
        for (int i = 0; i < tablaModeloRestr.getColumnCount(); i++) {
            temp = "" + tablaModeloRestr.getValueAt(p - 2, i);
            if (String.valueOf(tablaModeloRestr.getValueAt(p - 2, i)).equalsIgnoreCase("null")) {
                temp = "";
            }
            tablaModeloRestr.setValueAt(temp, p - 1, i);
            if (i == 0) {
                tablaModeloRestr.setValueAt("Ficticio", p - 2, i);
            } else {
                tablaModeloRestr.setValueAt("0", p - 2, i);
            }
        }

        tablaModeloRestr.setValueAt((demanda - oferta), tablaModeloRestr.getRowCount() - 2, tablaModeloRestr.getColumnCount() - 1);
    }

    public void setNombreColumna(String nom, JTable t) {
        JTableHeader tableHead = t.getTableHeader();
        TableColumnModel tableConteinerModel = tableHead.getColumnModel();
        TableColumn tableConteniner = tableConteinerModel.getColumn(t.getColumnCount() - 2);
        tableConteniner.setHeaderValue("Ficticio");
        tableHead.repaint();
    }

    public void enviarCelda(JTable t) {
        for (int f = 0; f < t.getRowCount() - 1; f++) {
            t.setValueAt(t.getValueAt(f, t.getColumnCount() - 2), f, t.getColumnCount() - 1);
            t.setValueAt(0, f, t.getColumnCount() - 2);
        }
    }

    public String[][] obtenerDatosDe(JTable table, int celd) {
        String[][] temporal = new String[table.getRowCount()][table.getColumnCount() - celd];
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount() - 2; j++) {
                if (String.valueOf(table.getValueAt(i, j)).equalsIgnoreCase("null")) {
                    temporal[i][j] = "";
                } else {
                    temporal[i][j] = "" + table.getValueAt(i, j);
                }
            }
        }
        int p = table.getColumnCount();
        for (int i = 0; i < table.getRowCount() - 1; i++) {
            if (String.valueOf(table.getValueAt(i, p - 1)).equalsIgnoreCase("null")) {
                temporal[i][p - celd - 1] = "";
            } else {
                temporal[i][p - celd - 1] = "" + table.getValueAt(i, p - 1);
            }
        }
        return temporal;
    }

    public void calcularDemandaOfretTotal(JTable tableSolucion, int filaExtra, int ColumnaExtra) {
        demanda = 0;
        oferta = 0;
        for (int i = 1; i < jTablaIngreso.getColumnCount() - 1 - ColumnaExtra; i++) {
            try {
                demanda = demanda + Double.parseDouble("" + jTablaIngreso.getValueAt(jTablaIngreso.getRowCount() - 1, i));
            } catch (Exception r) {
            }
        }
        for (int i = 0; i < jTablaIngreso.getRowCount() - 1 - filaExtra; i++) {
            try {
                oferta = oferta + Double.parseDouble("" + jTablaIngreso.getValueAt(i, jTablaIngreso.getColumnCount() - 1));
            } catch (Exception e) {
            }
        }
    }

    private boolean validarNumero(JTable table) {

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 1; j < table.getColumnCount(); j++) {
                try {
                    if (i == table.getRowCount() - 1 && j == table.getColumnCount() - 1) {
                        return true;
                    }
                    if (i == table.getRowCount() - 1 || j == table.getColumnCount() - 1) {
                        Double.parseDouble("" + table.getValueAt(i, j));

                    } else if (!"-".equals("" + table.getValueAt(i, j))) {
                        Double.parseDouble("" + table.getValueAt(i, j));
                    }

                } catch (NumberFormatException nfe) {
                    error = new DialogError(frameDialog, true, "El tipo de dato ", "ingresado es invalido" );
                    return false;
                }
            }
        }
        return true;

    }

    public void retornar() {
        String[] cabeza = {"Fuente", "Destino", "Material", "Precio", "Total"};
        DefaultTableModel mode = new DefaultTableModel(cabeza, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String row[] = new String[5];
        for (int i = 0; i < celda.length; i++) {
            for (int j = 0; j < celda[0].length; j++) {
                if (celda[i][j].getSubCoeficiente() > 0D) {
                    row[0] = "" + (i + 1);
                    row[1] = "" + (j + 1);
                    row[2] = "" + celda[i][j].getSubCoeficiente();
                    row[3] = "" + celda[i][j].getPrecio();
                    row[4] = "" + celda[i][j].getSubCoeficiente() * Double.parseDouble(celda[i][j].getPrecio());
                    mode.addRow(row);
                }
            }
        }
        jTableResultados.setModel(mode);
    }

    private double retornaSolucion() {
        double total = 0;
        for (int i = 0; i < celda.length; i++) {
            for (int j = 0; j < celda[i].length; j++) {
                if (!celda[i][j].getPrecio().equalsIgnoreCase("-")) {
                    total = total + Double.parseDouble(celda[i][j].getPrecio()) * celda[i][j].getSubCoeficiente();
                }
            }
        }

        return total;
    }
    public boolean sistemaGeneradorEquilibrio() {
        if (columnaFicticia) {
            calcularDemandaOfretTotal(jTablaIngreso, 0, 1);

        } else if (filaFicticia) {
            calcularDemandaOfretTotal(jTablaIngreso, 1, 0);
        } else {
            calcularDemandaOfretTotal(jTablaIngreso, 0, 0);
        }

        if (oferta == demanda) {
            if (filaFicticia) {
                error = new DialogError(frameDialog, true, "Fuente Artificial ", "innecesaria");
                return false;
            } else if (columnaFicticia) {
                error = new DialogError(frameDialog, true, "Destino Artificial ", "innecesaria");
                return false;
            }
        } else if (oferta != demanda) {
            if (oferta > demanda && filaFicticia) {
                error = new DialogError(frameDialog, true, "Sistema Mal ", "equilibrado");
                return false;
            } else if (oferta < demanda && columnaFicticia) {
                error = new DialogError(frameDialog, true, "Sistema Mal ", "equilibrado");
                return false;
            }

        }
        if (!columnaFicticia && !filaFicticia) {
            if (oferta < demanda) {
                error = new DialogError(frameDialog, true, "La Oferta No ", "Satisface la demanda");
                return false;
            } else if (oferta > demanda) {
                error = new DialogError(frameDialog, true, "La Demanda No ", "Satisface la Oferta");
                return false;
            }
        }
        return true;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btnEquilibrar;
    private rojerusan.RSMaterialButtonRectangle btnGuardarCambios;
    private rojerusan.RSMaterialButtonRectangle btnIniciarDatos;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMenu1;
    private rojerusan.RSMaterialButtonRectangle btnProcesar;
    private rojerusan.RSMaterialButtonCircle btnSalir;
    private rojerusan.RSMaterialButtonRectangle btnSolucion;
    private rojerusan.RSComboMetro cbxMetodos;
    private javax.swing.JCheckBox equiliDestino;
    private javax.swing.JCheckBox equilibrioFuente;
    private javax.swing.JFrame frameDialog;
    private javax.swing.JFrame frameEqulibrio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollContenedorSolucion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro jTablaIngreso;
    private rojerusan.RSTableMetro jTableResultados;
    private javax.swing.JLabel jtfResultado;
    private javax.swing.JLabel lblTabla;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel panelDatosIngresables;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelResultado;
    private javax.swing.JPanel panelTitulo;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JSpinner spinnerDestino;
    private javax.swing.JSpinner spinnerFuente;
    private javax.swing.JTable tableSolucion;
    // End of variables declaration//GEN-END:variables
}
