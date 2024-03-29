/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappclient.client.forms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fon.ai.maventransportappclient.controller.CommunicationController;
import fon.ai.maventransportappcommon.domain.CostItem;
import fon.ai.maventransportappcommon.domain.CostList;
import fon.ai.maventransportappcommon.domain.CostType;
import fon.ai.maventransportappcommon.domain.Drive;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import fon.ai.maventransportappclient.models.ModelDriveSearch;
import fon.ai.maventransportappcommon.domain.Driver;
import fon.ai.maventransportappcommon.domain.Trailer;
import fon.ai.maventransportappcommon.domain.Truck;
import fon.ai.maventransportappcommon.domain.VehicleType;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import fon.ai.maventransportappclient.client.forms.FDriveMode;

/**
 *
 * @author Bratislav
 */
public class FDrivesSearch extends javax.swing.JFrame {
	boolean voznjaIzmenjena = false;
	FMainForm fmf;

	/**
	 * Creates new form FDrivesSearch
	 */
	public FDrivesSearch(FMainForm fmf) {
		initComponents();
		this.setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				fmf.setEnabled(true);
				dispose();
			}
		});
		setLocationRelativeTo(null);
		srediTabelu();
		this.fmf = fmf;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextName = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButtonSearch = new javax.swing.JButton();
		jButtonDeclineFilter = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();
		jButtonUpdate = new javax.swing.JButton();
		jButtonCancel = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jButtonJSON = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jTextJSON = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Searching drives");

		jLabel1.setText("Name:");

		jTable1.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(jTable1);

		jButtonSearch.setText("Search");
		jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSearchActionPerformed(evt);
			}
		});

		jButtonDeclineFilter.setText("Decline Filter");
		jButtonDeclineFilter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonDeclineFilterActionPerformed(evt);
			}
		});

		jButtonDelete.setText("Delete drive");
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonDeleteActionPerformed(evt);
			}
		});

		jButtonUpdate.setText("Update drive");
		jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonUpdateActionPerformed(evt);
			}
		});

		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelActionPerformed(evt);
			}
		});

		jLabel2.setText("Pretraga radi po broju CMR-a, broju vozaca i broju kamiona");

		jButtonJSON.setText("Izvezi u JSON");
		jButtonJSON.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonJSONActionPerformed(evt);
			}
		});

		jButton1.setText("Uvezi iz JSON");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane1)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
								.addComponent(jLabel1).addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 272,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jButtonDeclineFilter)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jButtonJSON)))))
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
						layout.createSequentialGroup().addGap(64, 64, 64).addComponent(jButtonUpdate).addGap(27, 27, 27)
								.addComponent(jButtonDelete).addGap(31, 31, 31).addComponent(jButtonCancel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jTextJSON, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton1).addGap(22, 22, 22)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addComponent(jLabel2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jButtonSearch).addComponent(jButtonDeclineFilter).addComponent(jButtonJSON))
				.addGap(24, 24, 24)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButtonDelete).addComponent(jButtonUpdate).addComponent(jButtonCancel)
						.addComponent(jButton1).addComponent(jTextJSON, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(36, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
		String filter = jTextName.getText();
		if (!filter.isEmpty()) {
			srediTabelu();
			ModelDriveSearch mds = (ModelDriveSearch) jTable1.getModel();
			mds.search(filter);
		} else
			srediTabelu();
	}// GEN-LAST:event_jButtonSearchActionPerformed

	private void jButtonDeclineFilterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDeclineFilterActionPerformed
		jTextName.setText("");
		srediTabelu();
	}// GEN-LAST:event_jButtonDeclineFilterActionPerformed

	private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDeleteActionPerformed
		int row = jTable1.getSelectedRow();
		if (row != -1) {
			ModelDriveSearch mds = (ModelDriveSearch) jTable1.getModel();
			Drive d = mds.getSelectedRow(row);
			try {
//				ArrayList<CostItem> troskovi = CommunicationController.getInstance().vratiTroskove();
//				for (CostItem c : troskovi) {
//					if (c.getCostList().getId() == d.getId())
//						CommunicationController.getInstance().deleteCostItem(c);
//				}
//				CommunicationController.getInstance().deleteCostList(d.getCostList());
				
				//Punjenje liste troskova
				List<CostItem> troskovi = CommunicationController.getInstance().vratiTroskove();
				for(CostItem c : troskovi) {
					if(d.getCostList().getCosts() == null)
						d.getCostList().setCosts(new ArrayList<>());
					if(c.getCostList().getId() == d.getCostList().getId())
						d.getCostList().getCosts().add(c);
				}
				
				CommunicationController.getInstance().deleteDrive(d);
				JOptionPane.showMessageDialog(this, "Voznja je uspesno obrisana!");
				srediTabelu();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(this, "Morate odabrati voznju!");
		}
	}// GEN-LAST:event_jButtonDeleteActionPerformed

	private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUpdateActionPerformed
		int selectedRow = jTable1.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(this, "Morate da odaberete voznju!");
			return;
		}
		ModelDriveSearch mds = (ModelDriveSearch) jTable1.getModel();
		Drive d = mds.getDrives().get(selectedRow);

		System.out.println(d.getId() + "\n-------------------------------------\n");
		Drive potpunaVoznja;

		try {
			potpunaVoznja = CommunicationController.getInstance().vratiVoznjuPoIDu(d);
			System.out.println(potpunaVoznja.getId() + "\n-------------------------------------\n");

			List<CostItem> troskovi = CommunicationController.getInstance().vratiTroskove();
			System.out.println(troskovi.size());
			ArrayList<CostItem> konkretniTroskovi = new ArrayList<>();
			for (CostItem c : troskovi) {
				System.out.println(c.getCostList().getId() + " ID voznja" + potpunaVoznja.getId());
				if (c.getCostList().getId() == potpunaVoznja.getId()) {
					konkretniTroskovi.add(c);
				}
			}
			CostList cl = new CostList();
			cl.setCosts(konkretniTroskovi);
			cl.setDrive(potpunaVoznja);
			potpunaVoznja.setCostList(cl);
			System.out.println(potpunaVoznja.getCostList().getCosts().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, ex.getMessage());
			return;
		}

		voznjaIzmenjena = false;
		JFrame frmIzmenaVoznje = new FDrive(this, true, FDriveMode.EDIT, potpunaVoznja, null);
		this.setEnabled(false);

		frmIzmenaVoznje.setVisible(true);
		frmIzmenaVoznje.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (voznjaIzmenjena) {
					dispose();
					fmf.omoguciIzmenu();
				}
			}
		});
	}// GEN-LAST:event_jButtonUpdateActionPerformed

	private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCancelActionPerformed
		fmf.omoguciIzmenu();
		this.dispose();
	}// GEN-LAST:event_jButtonCancelActionPerformed

	private void jButtonJSONActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonJSONActionPerformed
		/*
		 * try{ Drive drive = CommunicationController.getInstance().importFromJSON();
		 * JOptionPane.showMessageDialog(this, "Sistem je uspesno uvezao racun.");
		 * CommunicationController.getInstance().prikaziDetalje(drive);
		 * //pretraziRacune(); }catch(Exception ex){
		 * 
		 * }
		 */
		// istestirajJSONUpis();

		int row = jTable1.getSelectedRow();
		if (row != -1) {
			ModelDriveSearch mds = (ModelDriveSearch) jTable1.getModel();
			Drive d = mds.getSelectedRow(row);
			try {
				CommunicationController.getInstance().izveziUJson(d);
				JOptionPane.showMessageDialog(this,
						"Voznja je uspesno izvezena u JSON fajl. Proverite folder projekta!");
				srediTabelu();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(this, "Morate odabrati voznju za serijalizaciju u JSON!");
		}
	}// GEN-LAST:event_jButtonJSONActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		Drive voznja = null;
		try {
			String putanja = jTextJSON.getText();
			voznja = CommunicationController.getInstance().deserijalizacijaJSON(putanja);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Bacen IO EXC");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}

		if (voznja != null) {
			JOptionPane.showMessageDialog(this, "Uspesno unesen JSON objekat. Pogledajte u tabeli!");
			ModelDriveSearch mds = (ModelDriveSearch) jTable1.getModel();
			mds.add(voznja);
			mds.fireTableDataChanged();
		} else {
			JOptionPane.showMessageDialog(this, "Neuspesno unesen JSON objekat!");
		}
		// CommunicationController.getInstance().insertDrive(voznja);

	}// GEN-LAST:event_jButton1ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonDeclineFilter;
	private javax.swing.JButton jButtonDelete;
	private javax.swing.JButton jButtonJSON;
	private javax.swing.JButton jButtonSearch;
	private javax.swing.JButton jButtonUpdate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextJSON;
	private javax.swing.JTextField jTextName;
	// End of variables declaration//GEN-END:variables

	public void srediTabelu() {
		try {
			List<Drive> drives = CommunicationController.getInstance().vratiVoznje();
			ModelDriveSearch mds = new ModelDriveSearch((ArrayList<Drive>) drives);
			jTable1.setModel(mds);
			mds.fireTableDataChanged();
		} catch (Exception ex) {
			Logger.getLogger(FDrivesSearch.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}