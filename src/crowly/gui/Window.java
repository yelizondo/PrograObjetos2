package crowly.gui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import crowly.library.IConstants;
import crowly.program.VideoProcessor;
import crowly.graphics.*;

public class Window extends JFrame implements IConstants
{
	VideoProcessor proc;
	AbstractCreator cre; 
	IGraphic scatterChart;
	IGraphic barChart;
	IGraphic lineChart; 
	
    public Window() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Principal = new javax.swing.JPanel();
        AnadirVideosPane = new javax.swing.JButton();
        ScatterChart = new javax.swing.JButton();
        LineChart = new javax.swing.JButton();
        BarChart = new javax.swing.JButton();
        CargarVideosPane = new javax.swing.JButton();
        GraficarVideos = new javax.swing.JButton();
        AnadirVideos = new javax.swing.JPanel();
        IrInicioDesdeProcesar = new javax.swing.JButton();
        URLPorProcesar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Anadir = new javax.swing.JButton();
        ProcesarVideos = new javax.swing.JButton();
        CargarVideos = new javax.swing.JPanel();
        IrInicioDesdeCargar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SeleccionarVideo = new javax.swing.JButton();
        FileEscogido = new javax.swing.JTextField();
        Cargar = new javax.swing.JButton();
        proc = new VideoProcessor();
        fileChooser = new javax.swing.JFileChooser();
        cre = new CreatorForName();
    	scatterChart = cre.createForName(AbstractCreator.SCATTER);
    	barChart = cre.createForName(AbstractCreator.BAR);
    	lineChart = cre.createForName(AbstractCreator.LINE);
    	graficados = false;
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        AnadirVideosPane.setText("Anadir Videos");
        AnadirVideosPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirVideosPaneActionPerformed(evt);
            }
        });

        ScatterChart.setText("Scatter Chart");
        ScatterChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					ScatterChartActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        LineChart.setText("Line Chart");
        LineChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					LineChartActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        BarChart.setText("Bar Chart");
        BarChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarChartActionPerformed(evt);
            }
        });

        CargarVideosPane.setText("Cargar Videos");
        CargarVideosPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarVideosPaneActionPerformed(evt);
            }
        });

        GraficarVideos.setText("Graficar videos");
        GraficarVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficarVideosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AnadirVideosPane)
                        .addGap(18, 18, 18)
                        .addComponent(CargarVideosPane))
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(ScatterChart)
                        .addGap(101, 101, 101)
                        .addComponent(LineChart)
                        .addGap(121, 121, 121)
                        .addComponent(BarChart)))
                .addContainerGap(178, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GraficarVideos)
                .addGap(302, 302, 302))
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnadirVideosPane)
                    .addComponent(CargarVideosPane))
                .addGap(130, 130, 130)
                .addComponent(GraficarVideos)
                .addGap(51, 51, 51)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScatterChart)
                    .addComponent(LineChart)
                    .addComponent(BarChart))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jPanel1.add(Principal, "card2");

        IrInicioDesdeProcesar.setText("Ir al Inicio");
        IrInicioDesdeProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrInicioDesdeProcesarActionPerformed(evt);
            }
        });

        URLPorProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URLPorProcesarActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite el URL del video por procesar:");

        Anadir.setText("Añadir");
        Anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirActionPerformed(evt);
            }
        });

        ProcesarVideos.setText("Procesar videos");
        ProcesarVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesarVideosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AnadirVideosLayout = new javax.swing.GroupLayout(AnadirVideos);
        AnadirVideos.setLayout(AnadirVideosLayout);
        AnadirVideosLayout.setHorizontalGroup(
            AnadirVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnadirVideosLayout.createSequentialGroup()
                .addGroup(AnadirVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnadirVideosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(IrInicioDesdeProcesar))
                    .addGroup(AnadirVideosLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(URLPorProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AnadirVideosLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel1))
                    .addGroup(AnadirVideosLayout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(ProcesarVideos))
                    .addGroup(AnadirVideosLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(Anadir)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        AnadirVideosLayout.setVerticalGroup(
            AnadirVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnadirVideosLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(IrInicioDesdeProcesar)
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(URLPorProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Anadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(ProcesarVideos)
                .addGap(93, 93, 93))
        );

        jPanel1.add(AnadirVideos, "card3");

        IrInicioDesdeCargar.setText("Ir al Inicio");
        IrInicioDesdeCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrInicioDesdeCargarActionPerformed(evt);
            }
        });

        jLabel4.setText("Seleccione los videos para graficar");

        SeleccionarVideo.setText("Seleccionar video");
        SeleccionarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarVideoActionPerformed(evt);
            }
        });

        Cargar.setText("Cargar");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CargarVideosLayout = new javax.swing.GroupLayout(CargarVideos);
        CargarVideos.setLayout(CargarVideosLayout);
        CargarVideosLayout.setHorizontalGroup(
            CargarVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CargarVideosLayout.createSequentialGroup()
                .addGap(0, 139, Short.MAX_VALUE)
                .addGroup(CargarVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CargarVideosLayout.createSequentialGroup()
                        .addComponent(FileEscogido, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(SeleccionarVideo)
                        .addGap(179, 179, 179))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CargarVideosLayout.createSequentialGroup()
                        .addComponent(Cargar)
                        .addGap(380, 380, 380))))
            .addGroup(CargarVideosLayout.createSequentialGroup()
                .addGroup(CargarVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CargarVideosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(IrInicioDesdeCargar))
                    .addGroup(CargarVideosLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CargarVideosLayout.setVerticalGroup(
            CargarVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargarVideosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IrInicioDesdeCargar)
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CargarVideosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeleccionarVideo)
                    .addComponent(FileEscogido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(Cargar)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jPanel1.add(CargarVideos, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void AnadirVideosPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirVideosPaneActionPerformed
        // TODO add your handling code here:
        Principal.setVisible(false);
        AnadirVideos.setVisible(true);
    }//GEN-LAST:event_AnadirVideosPaneActionPerformed

    private void CargarVideosPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarVideosPaneActionPerformed
        // TODO add your handling code here:
        Principal.setVisible(false);
        CargarVideos.setVisible(true);
    }//GEN-LAST:event_CargarVideosPaneActionPerformed

    private void IrInicioDesdeProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrInicioDesdeProcesarActionPerformed
        // TODO add your handling code here:
        Principal.setVisible(true);
        AnadirVideos.setVisible(false);
    }//GEN-LAST:event_IrInicioDesdeProcesarActionPerformed

    private void IrInicioDesdeCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrInicioDesdeCargarActionPerformed
        // TODO add your handling code here:
        Principal.setVisible(true);
        CargarVideos.setVisible(false);
    }//GEN-LAST:event_IrInicioDesdeCargarActionPerformed

    private void ScatterChartActionPerformed(java.awt.event.ActionEvent evt) throws Exception 
    {
    	if (graficados)
    	{
    		scatterChart.getCuerpos(proc.getCuerpos());
    		scatterChart.Graficar();
    	}
    }

    private void LineChartActionPerformed(java.awt.event.ActionEvent evt) throws Exception 
    {
    	if (graficados)
    	{
    		lineChart.getCuerpos(proc.getCuerpos());
    		lineChart.Graficar();
    	}
    }

    private void BarChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarChartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarChartActionPerformed

    private void URLPorProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URLPorProcesarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_URLPorProcesarActionPerformed

    private void AnadirActionPerformed(java.awt.event.ActionEvent evt) 
    {    
    	LISTA_VIDEOS_GUI.add(this.URLPorProcesar.getText());
    	URLPorProcesar.setText("");   	
    }

    private void ProcesarVideosActionPerformed(java.awt.event.ActionEvent evt) 
    {
        proc.analizarVideos();
    }

    private void SeleccionarVideoActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION	)
        {
        	String path = fileChooser.getSelectedFile().getAbsolutePath();
        	FileEscogido.setText(path);           	
        }
    }

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	LISTA_VIDEOS_JSON.add(FileEscogido.getText());
    	FileEscogido.setText("");
    	
    }

    private void GraficarVideosActionPerformed(java.awt.event.ActionEvent evt) 
    {
        proc.procesarVideos();
        graficados = true;
    }


    public static void main(String args[]) 
    {
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    private javax.swing.JButton Anadir;
    private javax.swing.JPanel AnadirVideos;
    private javax.swing.JButton AnadirVideosPane;
    private javax.swing.JButton BarChart;
    private javax.swing.JButton Cargar;
    private javax.swing.JPanel CargarVideos;
    private javax.swing.JButton CargarVideosPane;
    private javax.swing.JTextField FileEscogido;
    private javax.swing.JButton GraficarVideos;
    private javax.swing.JButton IrInicioDesdeCargar;
    private javax.swing.JButton IrInicioDesdeProcesar;
    private javax.swing.JButton LineChart;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton ProcesarVideos;
    private javax.swing.JButton ScatterChart;
    private javax.swing.JButton SeleccionarVideo;
    private javax.swing.JTextField URLPorProcesar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFileChooser fileChooser;
    private boolean graficados;
}
