/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrosql;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gonchoi5
 */
public class Registrar extends javax.swing.JFrame {

    /**
     * Creates new form Registrar
     */
    public Registrar() {
        initComponents();
        setTitle("Registrar");
        conexion=new ConexionSQL();
        mdl1=(DefaultTableModel)tablaTemas.getModel();
        mdl2=(DefaultTableModel)tablaPracticas.getModel();
        mdl3=(DefaultTableModel)tablaVisitas.getModel();
        ListSelectionModel selec=tablaTemas.getSelectionModel();  
        selec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selec.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()&&mdl1.getRowCount()>0){
                    ListSelectionModel mdl=tablaTemas.getSelectionModel();
                    sel1=mdl.getLeadSelectionIndex();
                }
            }
        });
        ListSelectionModel selec2=tablaPracticas.getSelectionModel();
        selec2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selec2.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()&&mdl2.getRowCount()>0){
                    ListSelectionModel mdl=tablaPracticas.getSelectionModel();
                    sel2=mdl.getLeadSelectionIndex();
                }
            }
        });
        ListSelectionModel selec3=tablaVisitas.getSelectionModel();  
        selec3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selec3.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()&&mdl3.getRowCount()>0){
                    ListSelectionModel mdl=tablaVisitas.getSelectionModel();
                    sel3=mdl.getLeadSelectionIndex();
                }
            }
        });
        tablaTemas.setModel(mdl1);
        tablaPracticas.setModel(mdl2);
        tablaVisitas.setModel(mdl3);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        materia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        prof = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        periodo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        grupo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        carrera = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        addtema = new javax.swing.JButton();
        eliminartema = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPracticas = new javax.swing.JTable();
        addpractica = new javax.swing.JButton();
        eliminapractica = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaVisitas = new javax.swing.JTable();
        addvisita = new javax.swing.JButton();
        eliminavisita = new javax.swing.JButton();
        terminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Información de Materia");

        jLabel2.setText("Materia");

        jLabel3.setText("Catedrático");

        jLabel4.setText("Periodo");

        jLabel5.setText("Grupo");

        jLabel6.setText("Carrera");

        jLabel7.setText("Temas");

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"     ", "      ", "Inicio/Fin-Avance%", "Inicio/Fin-Avance%", "DD/MM/YY"}
            },
            new String [] {
                "#", "Tema", "Horas programadas", "Horas reales", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTemas.setColumnSelectionAllowed(true);
        tablaTemas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaTemas);
        tablaTemas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaTemas.getColumnModel().getColumnCount() > 0) {
            tablaTemas.getColumnModel().getColumn(0).setResizable(false);
            tablaTemas.getColumnModel().getColumn(1).setResizable(false);
            tablaTemas.getColumnModel().getColumn(2).setResizable(false);
            tablaTemas.getColumnModel().getColumn(3).setResizable(false);
            tablaTemas.getColumnModel().getColumn(4).setResizable(false);
        }

        addtema.setText("Añadir");
        addtema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtemaActionPerformed(evt);
            }
        });

        eliminartema.setText("Eliminar seleccionado");
        eliminartema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminartemaActionPerformed(evt);
            }
        });

        jLabel8.setText("Prácticas");

        tablaPracticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "      ", "      ", "DD/MM/YY-DD/MM/YY"}
            },
            new String [] {
                "#", "Nombre", "Unidad", "Fecha programada y realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPracticas.setColumnSelectionAllowed(true);
        tablaPracticas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaPracticas);
        tablaPracticas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaPracticas.getColumnModel().getColumnCount() > 0) {
            tablaPracticas.getColumnModel().getColumn(0).setResizable(false);
            tablaPracticas.getColumnModel().getColumn(1).setResizable(false);
            tablaPracticas.getColumnModel().getColumn(2).setResizable(false);
            tablaPracticas.getColumnModel().getColumn(3).setResizable(false);
        }

        addpractica.setText("Añadir");
        addpractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpracticaActionPerformed(evt);
            }
        });

        eliminapractica.setText("Eliminar seleccionado");
        eliminapractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminapracticaActionPerformed(evt);
            }
        });

        jLabel9.setText("Visitas");

        tablaVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "     ", "     ", "DD/MM/YY-DD/MM/YY"}
            },
            new String [] {
                "#", "Empresa", "Unidad", "Fecha programada y realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVisitas.setColumnSelectionAllowed(true);
        tablaVisitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaVisitas);
        tablaVisitas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaVisitas.getColumnModel().getColumnCount() > 0) {
            tablaVisitas.getColumnModel().getColumn(0).setResizable(false);
            tablaVisitas.getColumnModel().getColumn(1).setResizable(false);
            tablaVisitas.getColumnModel().getColumn(2).setResizable(false);
            tablaVisitas.getColumnModel().getColumn(3).setResizable(false);
        }

        addvisita.setText("Añadir");
        addvisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addvisitaActionPerformed(evt);
            }
        });

        eliminavisita.setText("Eliminar seleccionado");
        eliminavisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminavisitaActionPerformed(evt);
            }
        });

        terminar.setText("Terminar");
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(materia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(prof)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(grupo)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eliminartema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addtema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addpractica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eliminapractica)))
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addvisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eliminavisita))))
                        .addGap(0, 15, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(terminar)
                .addGap(364, 364, 364))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addtema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminartema))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addpractica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminapractica))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addvisita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminavisita)))
                .addGap(18, 18, 18)
                .addComponent(terminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addtemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtemaActionPerformed
        mdl1.addRow(new Object[]{mdl1.getRowCount(),"","","",""});
    }//GEN-LAST:event_addtemaActionPerformed

    private void eliminartemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminartemaActionPerformed
        if(sel1>0){
            mdl1.removeRow(sel1);
        }
    }//GEN-LAST:event_eliminartemaActionPerformed

    private void addpracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpracticaActionPerformed
        mdl2.addRow(new Object[]{mdl2.getRowCount(),"","",""});
    }//GEN-LAST:event_addpracticaActionPerformed

    private void eliminapracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminapracticaActionPerformed
        if(sel2>0){
            mdl2.removeRow(sel2);
        }
    }//GEN-LAST:event_eliminapracticaActionPerformed

    private void addvisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addvisitaActionPerformed
        mdl3.addRow(new Object[]{mdl3.getRowCount(),"","",""});
    }//GEN-LAST:event_addvisitaActionPerformed

    private void eliminavisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminavisitaActionPerformed
        if(sel3>0){
            mdl3.removeRow(sel3);
        }
    }//GEN-LAST:event_eliminavisitaActionPerformed

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
        if(validacampos()){
            if(validatabla(tablaTemas)&&validatabla(tablaPracticas)&&validatabla(tablaVisitas)){
                if(checkTableCells(tablaTemas)&&checkTableCells(tablaPracticas)&&checkTableCells(tablaVisitas)){
                    try{
                        PreparedStatement st=conexion.darConsultaPreparada("insert into materia values(default,?,?,?,?,?)");
                        st.setString(1,getS(materia));
                        st.setString(2,getS(periodo));
                        st.setString(3,getS(prof));
                        st.setString(4,getS(carrera));
                        st.setString(5,getS(grupo));
                        st.execute();
                        st.close();
                        ResultSet res=conexion.ConsultaSelect("select last_insert_id() as id;");
                        res.first();
                        int idmateria=res.getInt("id");
                        for(int _i=1;_i<mdl1.getRowCount();_i++){
                            ArrayList<Object>owo=new ArrayList<>();
                            for(int _j=0;_j<mdl1.getColumnCount();_j++){
                                owo.add(tablaTemas.getValueAt(_i,_j));
                            }
                            if(owo.size()!=0){
                                st=conexion.darConsultaPreparada("insert into temas values(default,?,?,?,?)");
                                st.setInt(1,idmateria);
                                st.setString(2,owo.get(1).toString());
                                st.setString(3,owo.get(2).toString());
                                st.setString(4,owo.get(3).toString());
                                st.execute();
                                st.close();
                            }
                        }
                        for(int _i=1;_i<mdl2.getRowCount();_i++){
                            ArrayList<Object>owo=new ArrayList<>();
                            for(int _j=0;_j<mdl2.getColumnCount();_j++){
                                owo.add(tablaPracticas.getValueAt(_i,_j));
                            }
                            if(owo.size()>0){
                                st=conexion.darConsultaPreparada("insert into practicas values(default,?,?,?,?)");
                                st.setInt(1,idmateria);
                                st.setString(2,owo.get(1).toString());
                                st.setString(3,owo.get(2).toString());
                                st.setString(4,owo.get(3).toString());
                                st.execute();
                                st.close();
                            }
                        }
                        for(int _i=1;_i<mdl3.getRowCount();_i++){
                            ArrayList<Object>owo=new ArrayList<>();
                            for(int _j=0;_j<mdl3.getColumnCount();_j++){
                                owo.add(tablaVisitas.getValueAt(_i,_j));
                            }
                            if(owo.size()!=0){
                                st=conexion.darConsultaPreparada("insert into visitas values(default,?,?,?,?)");
                                st.setInt(1,idmateria);
                                st.setString(2,owo.get(1).toString());
                                st.setString(3,owo.get(2).toString());
                                st.setString(4,owo.get(3).toString());
                                st.execute();
                                st.close();
                            }
                        }
                    }catch(Exception e){e.printStackTrace();}
                    PrintFrameToPDF(new File("documento"+System.currentTimeMillis()+".pdf"));
                    javax.swing.JOptionPane.showMessageDialog(null,"Éxito");
                }
                else{
                    javax.swing.JOptionPane.showMessageDialog(null,"Existen campos incorrectos en las tablas, favor de verificar");
                }
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(null,"Se requieren todos los campos de las tablas");
            }
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(null,"Se requieren todos los campos");
        }
    }//GEN-LAST:event_terminarActionPerformed
    public String getS(JTextField campo){
        return campo.getText();
    }
    public boolean validacampos(){
        return getS(carrera).length()>0&&getS(grupo).length()>0&&getS(materia).length()>0&&getS(prof).length()>0&&getS(periodo).length()>0;
    }
    public boolean checkTableCells(JTable tbl){
        DefaultTableModel mdl=(DefaultTableModel) tbl.getModel();
        if(mdl.getRowCount()>1){
            System.out.println("\t owo cells "+mdl.getColumnName(1));
            if(mdl.getColumnName(1).equals("Tema")){
                for(int _i=1;_i<mdl.getRowCount();_i++){
                    if(!(tbl.getValueAt(_i,2).toString().matches(horasTema)&&tbl.getValueAt(_i,3).toString().matches(horasTema)&&tbl.getValueAt(_i,4).toString().matches(fecha))){
                        return false;
                    }
                }
            }
            else if(mdl.getColumnName(1).equals("Nombre")||mdl.getColumnName(1).equals("Empresa")){
                for(int _i=1;_i<mdl.getRowCount();_i++){
                    if(!(tbl.getValueAt(_i,2).toString().matches("(\\d{1,2})")&&tbl.getValueAt(_i,3).toString().matches(fechaprog))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean validatabla(JTable tbl){
        DefaultTableModel mdl=(DefaultTableModel) tbl.getModel();
        if(mdl.getRowCount()>1){
            for(int _i=1;_i<mdl.getRowCount();_i++){
                for(int _j=0;_j<mdl.getColumnCount();_j++){
                    if(tbl.getValueAt(_i,_j).toString().length()==0){
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }
        return true;
    }
    public void PrintFrameToPDF(File file) {
        try {
            Document d = new Document();
            PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(file));
            d.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(PageSize.LETTER.getWidth(),PageSize.LETTER.getHeight());
            cb.addTemplate(template, 0, 0);
            Graphics2D g2d = template.createGraphics(PageSize.LETTER.getWidth(),PageSize.LETTER.getHeight());
            g2d.scale(0.4, 0.4);
            for(int i=0; i< this.getContentPane().getComponents().length; i++){
                Component c = this.getContentPane().getComponent(i);
                if(c instanceof JLabel || c instanceof JScrollPane){
                    g2d.translate(c.getBounds().x,c.getBounds().y);
                    if(c instanceof JScrollPane){c.setBounds(0,0,(int)PageSize.LETTER.getWidth()*2,(int)PageSize.LETTER.getHeight()*2);}
                    c.paintAll(g2d);
                    c.addNotify();
                }
            }
            g2d.dispose();
            d.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addpractica;
    private javax.swing.JButton addtema;
    private javax.swing.JButton addvisita;
    private javax.swing.JTextField carrera;
    private javax.swing.JButton eliminapractica;
    private javax.swing.JButton eliminartema;
    private javax.swing.JButton eliminavisita;
    private javax.swing.JTextField grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField materia;
    private javax.swing.JTextField periodo;
    private javax.swing.JTextField prof;
    private javax.swing.JTable tablaPracticas;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTable tablaVisitas;
    private javax.swing.JButton terminar;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel mdl1,mdl2,mdl3;
    private int sel1,sel2,sel3;
    private final String horasTema="(\\d{1,2}:\\d{2})\\/(\\d{1,2}:\\d{2})-(\\d{1,3})%",fecha="(\\d{2}\\/\\d{2}\\/\\d{2})",fechaprog="(\\d{2}\\/\\d{2}\\/\\d{2})-(\\d{2}\\/\\d{2}\\/\\d{2})";
    private ConexionSQL conexion;
}
