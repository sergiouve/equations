package com.main;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Ecuaciones extends JFrame implements ActionListener, ChangeListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField JTecuacion, JTsolucion, JTtuSolucion;
	private JLabel JLecuacion, JLsolucion, JLtitulo, JLtuSolucion, JLaviso;
	private JButton JBecuacion, JBsolucion, JBcomprueba, JBsalir;
	private JRadioButton JRtipo1, JRtipo2;
	private ButtonGroup bg;
	int clicked = 0;
	int selected = 0;
	boolean resuelta = false;

	public Ecuaciones(){
		setLayout(null);
		setTitle("Ecuaciones - Alpha version");
		
		bg = new ButtonGroup();
		
		JRtipo1 = new JRadioButton("Primero");
		JRtipo1.setBounds(200,50,100,20);
		JRtipo1.addChangeListener(this);
		add(JRtipo1);
		
		JRtipo2 = new JRadioButton("Segundo");
		JRtipo2.setBounds(300,50,100,20);
		JRtipo2.addChangeListener(this);
		add(JRtipo2);
		
		bg.add(JRtipo1);
		bg.add(JRtipo2);
		
		JLtitulo = new JLabel("Grado de la ecuacion: ");
		JLtitulo.setBounds(30,10,300,100);
		add(JLtitulo);

		JLecuacion = new JLabel("Ecuacion");
		JLecuacion.setBounds(30,45,100,100);
		add(JLecuacion);
		
		JLsolucion = new JLabel("Solucion");
		JLsolucion.setBounds(460,45,100,100);
		add(JLsolucion);

		JTecuacion = new JTextField();
		JTecuacion.setBounds(30,120,400,150);
		JTecuacion.setEditable(false);
		add(JTecuacion);
		
		JTsolucion = new JTextField();
		JTsolucion.setBounds(460,120,200,150);
		JTsolucion.setEditable(false);
		JTsolucion.setVisible(false);
		add(JTsolucion);

		JBecuacion = new JButton("Generar");
		JBecuacion.setBounds(30,290,120,40);
		JBecuacion.addActionListener(this);
		JBecuacion.setEnabled(false);
		add(JBecuacion);
		
		JLaviso = new JLabel("Selecciona el tipo de ecuación");
		JLaviso.setBounds(160,290,300,40);
		add(JLaviso);
		
		JLtuSolucion = new JLabel("Tu solucion:");
		JLtuSolucion.setBounds(30,370,100,40);
		add(JLtuSolucion);
		
		JTtuSolucion = new JTextField();
		JTtuSolucion.setBounds(30,400,70,35);
		add(JTtuSolucion);
		
		JBcomprueba = new JButton("Comprueba");
		JBcomprueba.setBounds(30,470,120,40);
		JBcomprueba.addActionListener(this);
		add(JBcomprueba);
		
		JBsalir = new JButton("Salir");
		JBsalir.setBounds(650,470,120,40);
		JBsalir.addActionListener(this);
		add(JBsalir);
		
		JBsolucion = new JButton("Solucion");
		JBsolucion.setBounds(165,470,120,40);
		JBsolucion.addActionListener(this);
		JBsolucion.setEnabled(false);
		add(JBsolucion);		
	}
	
	public void comprueba1(int propuesta, int real){
		if (propuesta == real){
			resuelta = true;
		} else
			resuelta = false;
	}
	
	public void comprueba2(int propuesta1, int propuesta2, int real1, int real2){
		if (propuesta1 == real1 || propuesta1 == real2){
			if (propuesta2 == real1 || propuesta2 == real2){			
				resuelta = true;
			}
		}
	}
	
	public void stateChanged(ChangeEvent e) {
        if (JRtipo1.isSelected() == true || JRtipo2.isSelected() == true) {
            JLaviso.setVisible(false);
            JBecuacion.setEnabled(true);
        }
        
        if (JRtipo1.isSelected() == false && JRtipo2.isSelected() == false) {
            JLaviso.setVisible(true);
            JBecuacion.setEnabled(false);
        }
        
        if (JRtipo2.isSelected() == true){
        	JTtuSolucion.setVisible(false);
        	JLtuSolucion.setVisible(false);
        	JBcomprueba.setVisible(false);
        	JBsolucion.setBounds(30,470,120,40);
        } else {
        	JTtuSolucion.setVisible(true);
        	JLtuSolucion.setVisible(true);
        	JBcomprueba.setVisible(true);
        	JBsolucion.setBounds(165,470,120,40);
        }
            	
   }
	
	public void actionPerformed(ActionEvent e){
		//No creo que sea la mejor forma de comprobar el click
		if (e.getSource() == JBecuacion) {
			clicked++;
			if (JRtipo1.isSelected() == true){
				EcPrimer ecu1 = new EcPrimer();
				JTecuacion.setText(ecu1.generaEcuacion());
				String sol = Integer.toString(ecu1.inc1);
				JTsolucion.setText(sol);
			} else {
				EcSegundo ecu2 = new EcSegundo(10,-10);
				JTecuacion.setText(ecu2.generaEcuacion());
				String sol = ecu2.escribeSol();
				JTsolucion.setText(sol);
			}
			JBsolucion.setEnabled(true);
			
			if (clicked > 0) {
				JTsolucion.setVisible(false);
			}
		}
		
		if (e.getSource() == JBsolucion){
			JTsolucion.setVisible(true);
		}
		
		if (e.getSource() == JBcomprueba && JRtipo1.isSelected() == true){
			String propuesta = JTtuSolucion.getText();
			String real = JTsolucion.getText();
			int n1 = Integer.parseInt(propuesta);
			int n2 = Integer.parseInt(real);
			comprueba1(n1, n2);
			
			if (resuelta == true){
				 JOptionPane.showMessageDialog(null, "¡Solución correcta!");
			} else
				JOptionPane.showMessageDialog(null, "Solución incorrecta");
		}
		
		/*if (e.getSource() == JBcomprueba && JRtipo2.isSelected() == true){
			String dos_prop = JTtuSolucion.getText();
			String dos_real = JTsolucion.getText();
			
			String[] props = dos_prop.split(",");
			int solp1 = Integer.parseInt(props[0]);
			int solp2 = Integer.parseInt(props[1]);
			
			String[] reals = dos_real.split("");
			
			comprueba2(solp1,solp2)
			
			if (resuelta == true){
				 JOptionPane.showMessageDialog(null, "¡Solución correcta!");
			} else
				JOptionPane.showMessageDialog(null, "Solución incorrecta");
		}*/
		
		if (e.getSource() == JBsalir){
			int salir = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "¿Salir?", JOptionPane.YES_NO_OPTION);
			if (salir == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	public static void main(String[] ar){
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		    }
		    catch (ClassNotFoundException e) {
		    }
		    catch (InstantiationException e) {
		    }
		    catch (IllegalAccessException e) {
	    }
			
		Ecuaciones window = new Ecuaciones();
		window.setBounds(500,90,800,550);
		window.setVisible(true);
		window.setResizable(false);
	}
	
	
}