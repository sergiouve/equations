package com.main;

import java.util.Random;
import java.lang.Math;

public class EcSegundo {
	int a, b, c, delta, x1aux, x2aux;
	double x1, x2, numex1, numex2, denomx1, denomx2;
	int x1nint, x2nint;
	boolean valido = false;
	boolean x1int = true;
	boolean x2int = true;	
	int raices_val[] = new int[25];
	
	public EcSegundo(int max, int min){
		Random r = new Random();
		
		a = r.nextInt(max - min + 1) +min; //random.nextInt(max - min + 1) + min
		b = r.nextInt(max - min + 1) +min;
		c = r.nextInt(max - min + 1) +min;
		
		delta = (b*b) - 4*a*c;
		
		for (int i = 0; i < raices_val.length; i++){
			raices_val[i] = i*i;
		}
		
		while (valido == false || a == 0 || b == 0 || c == 0) {
			
			for (int j = 0; j < raices_val.length; j++){
				if (delta == raices_val[j] && a != 0 && b != 0 && c != 0){
					valido = true;
				}
			}
			
			if (valido == false || a == 0 || b == 0 || c == 0){
				a = r.nextInt(max - min + 1) +min; //random.nextInt(max - min + 1) + min
				b = r.nextInt(max - min + 1) +min;
				c = r.nextInt(max - min + 1) +min;
				
				delta = (b*b) - 4*a*c;
			}
		}
		
		x1 = (-b - (Math.sqrt(delta)))/(2*a);
		x2 = (-b + (Math.sqrt(delta)))/(2*a);
		
		x1aux = (int) x1;
		x2aux = (int) x2;
		
		if (x1 % x1aux != 0){
			x1int = false;
		}
		
		if (x2 % x2aux != 0){
			x2int = false;
		}
	}
	
	public String generaEcuacion(){
		String ecuacion = "";
		if (b > 0 && c > 0){
			ecuacion = a +"x2 + " + b +"x + " + c + " = 0";
		} else if (b > 0){
			ecuacion = a +"x2 + " + b +"x " + c + " = 0";
		} else if (c > 0){
			ecuacion = a +"x2 " + b +"x + " + c + " = 0";
		} else{
		ecuacion = a +"x2" + b +"x " + c + " = 0";
		}
		return ecuacion;
	}
	
	public String escribeSol(){
		String sol="";
		if (x1int == false){
			numex1 = -b - (Math.sqrt(delta));
			denomx1 = 2*a;
			while (numex1 % 2 == 0 && denomx1 % 2 == 0){
				numex1 = numex1 / 2;
				denomx1 = denomx1 /2;
			}
			while (numex1 % 3 == 0 && denomx1 % 3 == 0){
				numex1 = numex1 / 3;
				denomx1 = denomx1 /3;
			}
			while (numex1 % 5 == 0 && denomx1 % 5 == 0){
				numex1 = numex1 / 5;
				denomx1 = denomx1 /5;
			}
			int numex1int = (int) numex1;
			int denomx1int = (int) denomx1;
			sol = sol + "\nx1: " + numex1int + "/" + denomx1int ;
		} else {
			x1nint = (int) x1;
			sol = sol + "\nx1: " + x1nint;
		}
		
		if (x2int == false){
			numex2 = -b + (Math.sqrt(delta));
			denomx2 = 2*a;
			while (numex2 % 2 == 0 && denomx2 % 2 == 0){
				numex2 = numex2 / 2;
				denomx2 = denomx2 /2;
			}
			while (numex2 % 3 == 0 && denomx2 % 3 == 0){
				numex2 = numex2 / 3;
				denomx2 = denomx2 /3;
			}
			while (numex2 % 5 == 0 && denomx2 % 5 == 0){
				numex2 = numex2 / 5;
				denomx2 = denomx2 /5;
			}
			int numex2int = (int) numex2;
			int denomx2int = (int) denomx2;
			sol = sol + "  \nx2: " + numex2int + "/" + denomx2int ;
		} else {
			x2nint = (int) x2;
			sol = sol + "  \nx2: " + x2nint;
		}		
		return sol;
	}
}
