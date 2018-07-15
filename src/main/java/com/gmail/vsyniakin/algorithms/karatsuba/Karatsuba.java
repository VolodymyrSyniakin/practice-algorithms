package com.gmail.vsyniakin.algorithms.karatsuba;

import java.math.BigInteger;

public class Karatsuba {
	
	public static BigInteger multiplication (BigInteger x, BigInteger y) {
		int lengthX = length(x); 
		int lengthY = length(y);
		int middle = middle(lengthX, lengthY);
		
		BigInteger tenExpFull = BigInteger.TEN.pow(middle*2);
		BigInteger tenExpMiddle = BigInteger.TEN.pow(middle);
		
		BigInteger a = x.divide(tenExpMiddle);
		BigInteger b = x.remainder(tenExpMiddle);
		BigInteger c = y.divide(tenExpMiddle);
		BigInteger d = y.remainder(tenExpMiddle);
		
		if (lengthX != 1 && lengthY != 1) {
			BigInteger ac = multiplication(a, c);
			BigInteger bd = multiplication(b, d);			
			BigInteger sumAdBc = multiplication(a.add(b), c.add(d)).subtract(ac).subtract(bd);
			
			return tenExpFull.multiply(ac).add(tenExpMiddle.multiply(sumAdBc)).add(bd);
		} else {
			return x.multiply(y);
		}
	}
	
	public static int length (BigInteger number) {
		return number.toString().length();
	}
	
	public static int middle (int lengthX, int lengthY) {
		if (lengthX >= lengthY) {
			if (lengthX % 2 != 0) {
				return (lengthX + 1)/2;
			} else {
				return lengthX/2;
			}
		} else {
			if (lengthY % 2 != 0) {
				return (lengthY + 1)/2;
			} else {
				return lengthY/2;
			}
		}
	}
}
