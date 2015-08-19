package com.main;
import java.util.Random;

public class EcPrimer{
	
	public int inc1,eq1,ti1,ti2;

	public EcPrimer(){
		Random r = new Random();
		
		while (eq1 == 0){
			inc1= r.nextInt(100)+1;		
			eq1 = r.nextInt(10);
			ti1 = r.nextInt(10);
			ti2 = eq1 * inc1 + ti1;
		}
	}
	
	public String generaEcuacion(){
		String ecuacion = "";
		if (eq1 == 1){
			ecuacion = "x + " + ti1 + " = " + ti2;
		} else {
		ecuacion = eq1 + "x" + " + " + ti1 + " = " + ti2;
		}
		return ecuacion;
	}
}