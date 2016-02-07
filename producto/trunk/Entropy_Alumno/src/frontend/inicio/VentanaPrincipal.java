package frontend.inicio;

import backend.auxiliares.Mensajes;
import frontend.auxiliares.GestorImagenes;
import frontend.auxiliares.LookAndFeelEntropy;
import frontend.auxiliares.PanelDeslizante;
import frontend.auxiliares.PanelConMenu;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * Clase que representa la Ventana Principal de la aplicación en el módulo del
 * profesor.
 *
 * @author Denise
 */
public class VentanaPrincipal extends javax.swing.JFrame implements IVentanaPrincipal {
    
    private static VentanaPrincipal INSTANCIA;
    private boolean blnSeEstaRealizandoPresentacion;

    /**
     * Constructor por defecto.
     */
    private VentanaPrincipal() {
        this.blnSeEstaRealizandoPresentacion = false;
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.pnlSlides.setPanelMostrado(pnlInicio);
        this.setIconImage(this.getIconImage());
        this.getRootPane().registerKeyboardAction(new EscapeAction(this), 
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new VentanaPrincipal();
        }
    }

    public static VentanaPrincipal getInstancia() {
        createInstance();
        return INSTANCIA;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConMenu = new PanelConMenu(new MenuPrincipal(this));
        pnlBackground = new frontend.auxiliares.PanelConFondo();
        pnlMargen = new javax.swing.JPanel();
        lblSeparador = new javax.swing.JLabel();
        pnlSlides = new frontend.auxiliares.PanelDeslizante();
        mnbMenuBar = new javax.swing.JMenuBar();
        mncAyuda = new javax.swing.JMenu();
        mniAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Administración de Entornos Educativos");
        setMinimumSize(new java.awt.Dimension(500, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlBackground.setImagen(GestorImagenes.crearImage("/frontend/imagenes/main_background.jpg"));
        pnlBackground.setLayout(new javax.swing.BoxLayout(pnlBackground, javax.swing.BoxLayout.LINE_AXIS));

        pnlMargen.setBackground(new java.awt.Color(255, 255, 255));
        pnlMargen.setOpaque(false);
        pnlMargen.setLayout(new java.awt.GridLayout(1, 0));

        lblSeparador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeparador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/imagenes/separator.png"))); // NOI18N
        lblSeparador.setMaximumSize(new java.awt.Dimension(30, 50));
        lblSeparador.setMinimumSize(new java.awt.Dimension(30, 50));
        lblSeparador.setPreferredSize(new java.awt.Dimension(30, 50));
        pnlMargen.add(lblSeparador);

        pnlBackground.add(pnlMargen);

        pnlInicio  = new PanelInicio();
        pnlSlides.setOpaque(false);
        pnlInicio.setOpaque(false);

        javax.swing.GroupLayout pnlSlidesLayout = new javax.swing.GroupLayout(pnlSlides);
        pnlSlides.setLayout(pnlSlidesLayout);
        pnlSlidesLayout.setHorizontalGroup(
            pnlSlidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
        pnlSlidesLayout.setVerticalGroup(
            pnlSlidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        pnlSlides.setName("Central");
        pnlSlides.setLayout(new java.awt.CardLayout());
        pnlInicio.setName("Inicial");
        pnlSlides.add(pnlInicio, "card1");

        pnlBackground.add(pnlSlides);

        javax.swing.GroupLayout pnlConMenuLayout = new javax.swing.GroupLayout(pnlConMenu);
        pnlConMenu.setLayout(pnlConMenuLayout);
        pnlConMenuLayout.setHorizontalGroup(
            pnlConMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlConMenuLayout.setVerticalGroup(
            pnlConMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlConMenu.setLayer(pnlBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mnbMenuBar.setFont(LookAndFeelEntropy.FUENTE_REGULAR);

        mncAyuda.setText("Ayuda");
        mncAyuda.setFont(LookAndFeelEntropy.FUENTE_REGULAR);

        mniAcercaDe.setFont(LookAndFeelEntropy.FUENTE_REGULAR);
        mniAcercaDe.setText("Acerca de...");
        mniAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAcercaDeActionPerformed(evt);
            }
        });
        mncAyuda.add(mniAcercaDe);

        mnbMenuBar.add(mncAyuda);

        setJMenuBar(mnbMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConMenu, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAcercaDeActionPerformed
        Mensajes.mostrarAcercaDe();
    }//GEN-LAST:event_mniAcercaDeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (blnSeEstaRealizandoPresentacion) {
            Mensajes.mostrarAdvertencia("Usted está conectado a una presentación, desconectese para salir");
            return;
        }

        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSeparador;
    private javax.swing.JMenuBar mnbMenuBar;
    private javax.swing.JMenu mncAyuda;
    private javax.swing.JMenuItem mniAcercaDe;
    private frontend.auxiliares.PanelConFondo pnlBackground;
    private javax.swing.JLayeredPane pnlConMenu;
    private javax.swing.JPanel pnlMargen;
    private frontend.auxiliares.PanelDeslizante pnlSlides;
    private PanelInicio pnlInicio;
    // End of variables declaration//GEN-END:variables

    @Override
    public PanelDeslizante getPanelDeslizante() {
        return pnlSlides;
    }

    public PanelInicio getPnlInicio() {
        return pnlInicio;
    }

    @Override
    public Image getIconImage() {
        return GestorImagenes.crearImage("/frontend/imagenes/ic_system.png");
    }

    /**
     * Oculta el menú lateral.
     */
    @Override
    public void ocultarMenu() {
        try {
            ((PanelConMenu) pnlConMenu).ocultar();
        } catch (Exception e) {
            System.err.println("Error al castear el panel con menú: " + e.getMessage());
        }
    }
    
    @Override
    public void volverAInicio(){
        VentanaPrincipal.getInstancia().getPanelDeslizante().setPanelMostrado(VentanaPrincipal.getInstancia().getPnlInicio());
        VentanaPrincipal.getInstancia().setTitle("Sistema de Administración de Entornos Educativos");
    }
    
    @Override
    public void setTitulo (String strTitulo) {
        VentanaPrincipal.getInstancia().setTitle(strTitulo);
    }
    
    public void setBlnSeEstaRealizandoPresentacion(boolean blnSeEstaRealizandoPresentacion) {
        this.blnSeEstaRealizandoPresentacion = blnSeEstaRealizandoPresentacion;
    }

    /**
     * Clase que escucha por el tecleo de la tecla Esc.
     */
    private class EscapeAction implements ActionListener {

        VentanaPrincipal frmPrincipal;

        public EscapeAction(VentanaPrincipal frame) {
            this.frmPrincipal = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pnlSlides.esPanelMostrado(pnlInicio)) {
                return;
            }
            pnlSlides.setPanelMostrado(pnlInicio, false);
        }
    }
    
    public boolean isMaximized() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        double windowHeight = getSize().height;
        double windowWidth = getSize().width;
        return getExtendedState() == JFrame.MAXIMIZED_BOTH
                || getExtendedState() == JFrame.MAXIMIZED_VERT
                || windowWidth > screenWidth / 2 - 60
                || screenHeight - windowHeight < 50;
    }
}
