package com.gmail.vsyniakin.algorithms.karatsuba;

import java.math.BigInteger;

public class KaratsubaDemo {

	public static void main(String[] args) {
		
		BigInteger x = new BigInteger("1685287499328328297814655639278583667919355849391453456921116729");
		BigInteger y = new BigInteger("7114192848577754587969744626558571536728983167954552999895348492");
		
		System.out.println(Karatsuba.multiplication(x, y));
	}

}
