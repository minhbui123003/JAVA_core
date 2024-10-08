
package SalaryForm;

import EmployeeForm.EmployeeDTO;
import EmployeeForm.EmployeeDAO;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Database.DBEngine;


/**
 *
 * @author buiquangminh,doanhuutuan,nguyenminhtai
 */
public class Salary extends javax.swing.JFrame {
    ArrayList<SalaryDTO> list_sl = new ArrayList<>();
    ArrayList<SalaryDTO> list_DB = new ArrayList<>();
    ArrayList<EmployeeDTO> list_emp = new ArrayList<>();
    String NameFile = "src\\Database\\Salary.txt";
    String file_emp = "src\\Database\\Employee.txt";
    int select = -1;
    SalaryDTO nv = new SalaryDTO();

    
    
    /**^
     * Creates new form Salary
     */
    static DBEngine db = new DBEngine();
    
    
    public Salary() throws Exception{
        initComponents();
        Add();
        getData();
        AddcbbPositon();
        loadTable();
    }
    
    public void Add() throws Exception{
        try {
            list_DB = (ArrayList<SalaryDTO>) db.ReadFile("src\\Database\\Salary.txt");
//            list_sl = new ArrayList<SalaryDTO>(list_DB);
         
//            for(SalaryDTO sl: list_sl){
//                System.out.println(sl.getEmployeeID());
//            }
//            for(SalaryDTO emp:list_sl){
//                System.out.println(emp.getEmployeeID());
//                String ID = emp.getEmployeeID();
//                String Name = emp.getEmployeeName();
//                String Dob = emp.getDateOfBirth();
//                String Gender = emp.getGender();             
//                String Position = emp.getPosition();
//                String Dpm = emp.getDepartment();
//                String Add = emp.getAdd();
//                String phone = emp.getPhoneNumber();
//                String Email = emp.getEmail();
////                nv = new SalaryDTO(2, 2000000, 0, 0, 500000, ID, Name, Dob, Gender, Dpm, Position, Add, phone, Email);
////                nv.setCoefficientsSalary();
//                nv = new SalaryDTO();
//                list_sl.add(nv);
//        }
            list_emp = (ArrayList<EmployeeDTO>) db.ReadFile("src\\Database\\Employee.txt");
            for(EmployeeDTO emp: list_emp){
                String ID = emp.getEmployeeID();
                String Name = emp.getEmployeeName();
                String Dob = emp.getDateOfBirth();
                String Gender = emp.getGender();             
                String Position = emp.getPosition();
                String Dpm = emp.getDepartment();
                String Add = emp.getAdd();
                String phone = emp.getPhoneNumber();
                String Email = emp.getEmail();
                nv = new SalaryDTO(2, 2000000, 0, 0, 500000, ID, Name, Dob, Gender, Dpm, Position, Add, phone, Email);
//                nv.setCoefficientsSalary();
                list_sl.add(nv);
              
            }
              SaveData();
              loadTable();
        } catch (Exception ex) {
            Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void AddcbbPositon(){
        try {
            list_emp = (ArrayList<EmployeeDTO>) db.ReadFile("src\\Database\\Employee.txt");
            String[] d = new String[list_emp.size()];
            int i=0;
            for(EmployeeDTO emp: list_emp){
                d[i]= emp.getPosition();
                i++;
            }
            cbbPoisition.setModel(new javax.swing.DefaultComboBoxModel(d));
        } catch (Exception ex) {
            Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadTable(){
        tblSalary.setModel(new SalaryDAO(list_sl));
    }
    public void SaveData(){
        try {
            db.SaveFile(NameFile, list_sl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void getData(){
        try {
           list_DB = (ArrayList<SalaryDTO>) db.ReadFile(NameFile);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCoefficient = new javax.swing.JTextField();
        txtBaseSalary = new javax.swing.JTextField();
        txtBonus = new javax.swing.JTextField();
        txtPenalty = new javax.swing.JTextField();
        txtAllowances = new javax.swing.JTextField();
        tbnEdit = new javax.swing.JButton();
        tbnSort = new javax.swing.JButton();
        tbnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalary = new javax.swing.JTable();
        cbbPoisition = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setText("Coefficients salary");

        jLabel3.setText("Base salary");

        jLabel4.setText("Bonus");

        jLabel5.setText("Penalty");

        jLabel6.setText("Allowances");

        txtCoefficient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoefficientActionPerformed(evt);
            }
        });

        tbnEdit.setText("Edit");
        tbnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnEditActionPerformed(evt);
            }
        });

        tbnSort.setText("Sort by total salary");
        tbnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSortActionPerformed(evt);
            }
        });

        tbnExit.setText("Exit");
        tbnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitActionPerformed(evt);
            }
        });

        tblSalary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Poisition", "Department", "Coefficients salary", "Base salary", "Bonus", "Penalty", "Allowances", "Total salary"
            }
        ));
        tblSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSalaryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSalary);

        cbbPoisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPoisitionActionPerformed(evt);
            }
        });

        jLabel7.setText("HUMAN RESOURCES SCHEDULE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(tbnEdit)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCoefficient, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBaseSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAllowances, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(cbbPoisition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbnSort)
                                .addGap(85, 85, 85)
                                .addComponent(tbnExit)
                                .addGap(122, 122, 122))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(452, 452, 452)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCoefficient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAllowances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtBaseSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnEdit)
                    .addComponent(tbnSort)
                    .addComponent(tbnExit)
                    .addComponent(cbbPoisition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCoefficientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoefficientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoefficientActionPerformed

    private void tbnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnEditActionPerformed
        // TODO add your handling code here:
        select = tblSalary.getSelectedRow();
        String[] a = new String[list_emp.size()];
        String[] b = new String[list_emp.size()];
        String[] c = new String[list_emp.size()];
        String[] f = new String[list_emp.size()];
       
        if(select!=-1){
            nv = list_sl.get(select);
            nv.setCoefficientsSalary(Double.parseDouble((String)txtCoefficient.getText()));
            nv.setBaseSalary(Double.parseDouble((String)txtBaseSalary.getText()));
            nv.setBonus(Double.parseDouble((String)txtBonus.getText()));
            nv.setPenalty(Double.parseDouble((String)txtPenalty.getText()));
            nv.setAllowances(Double.parseDouble((String)txtAllowances.getText()));

//            System.out.println(nv.toString());

            select = -1;
            loadTable();
            SaveData();
            
        }else{
            JOptionPane.showConfirmDialog(this,"No line selected!","Notification", HEIGHT);
        }
        txtCoefficient.setText("");
        txtBaseSalary.setText("");
        txtBonus.setText("");
        txtPenalty.setText("");
        txtAllowances.setText("");
    }//GEN-LAST:event_tbnEditActionPerformed

    private void tbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tbnExitActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            getData();
            list_sl.clear();
            list_sl.addAll(list_DB);
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void tbnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSortActionPerformed
        // TODO add your handling code here:
           Comparator<SalaryDTO> c = new Comparator<SalaryDTO>() {
            @Override
            public int compare(SalaryDTO t, SalaryDTO t1) {
                if(((t.getCoefficientsSalary()* t.getBaseSalary()+t.getBonus()+t.getAllowances()-t.getPenalty()))>(t1.getCoefficientsSalary()* t1.getBaseSalary()+t1.getBonus()+t1.getAllowances()-t1.getPenalty())){
                    return -1 ;
                }else if(((t.getCoefficientsSalary()* t.getBaseSalary()+t.getBonus()+t.getAllowances()-t.getPenalty()))>(t1.getCoefficientsSalary()* t1.getBaseSalary()+t1.getBonus()+t1.getAllowances()-t1.getPenalty())){
                    return 1;
                }else {
                    return 0;
                }
            }
        };
        Collections.sort(list_sl,c);
        loadTable();
    }//GEN-LAST:event_tbnSortActionPerformed

    private void tblSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalaryMouseClicked
        // TODO add your handling code here:
          select = tblSalary.getSelectedRow();
        if(select!= -1 ){
             nv= list_sl.get(select);
            txtCoefficient.setText(nv.getCoefficientsSalary()+"");
            txtBaseSalary.setText(nv.getBaseSalary()+"");
            txtBonus.setText(nv.getBonus()+"");
            txtPenalty.setText(nv.getPenalty()+"");
            txtAllowances.setText(nv.getAllowances()+"");
        }
    }//GEN-LAST:event_tblSalaryMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        SaveData();
    }//GEN-LAST:event_formWindowClosing

    private void cbbPoisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPoisitionActionPerformed
        // TODO add your handling code here:
         String Position = (String)cbbPoisition.getSelectedItem();
        if(cbbPoisition.getSelectedItem() != null){
            ArrayList<SalaryDTO> listNew = new ArrayList<>();
            for(SalaryDTO emp: list_sl){
                if(emp.getPosition().equals(Position)){
                    listNew.add(emp);
                }
            }
            
            tblSalary.setModel(new SalaryDAO(listNew));
            txtCoefficient.setText("");
            txtBaseSalary.setText("");
            txtBonus.setText("");
            txtPenalty.setText("");
            txtAllowances.setText("");
        }else{
            JOptionPane.showConfirmDialog(this, "Please enter the department", "notification", WIDTH);
        }                
    }//GEN-LAST:event_cbbPoisitionActionPerformed

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
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Salary().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbPoisition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalary;
    private javax.swing.JButton tbnEdit;
    private javax.swing.JButton tbnExit;
    private javax.swing.JButton tbnSort;
    private javax.swing.JTextField txtAllowances;
    private javax.swing.JTextField txtBaseSalary;
    private javax.swing.JTextField txtBonus;
    private javax.swing.JTextField txtCoefficient;
    private javax.swing.JTextField txtPenalty;
    // End of variables declaration//GEN-END:variables
}
