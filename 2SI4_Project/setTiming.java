import java.math.BigInteger;
import java.util.Random;


public class setTiming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bi1, bi2, bi3;
		bi1 = new BigInteger("12532159872315980739201453");
		bi2 = new BigInteger("3215325311325532150");
		
		bi3 = bi1.add(bi2);
		  
		String str = "Result of addition is " +bi3;
		
		// print bi3 value
		System.out.println( bi1 + " + " + bi2 + " = " + bi3);
		System.out.println( str );
		System.out.println("***********************" );
		
		
		BigInteger bi4 = getRandomNumber(10);
		System.out.println(bi4);
		
		
	}
	
	
	public static BigInteger getRandomNumber(final int digCount){
	    return getRandomNumber(digCount, new Random());
	}

	public static BigInteger getRandomNumber(final int digCount, Random rnd){
	    final char[] charArray = new char[digCount];
	    for(int i = 0; i < digCount; i++){
	        charArray[i] = (char) ('0' + (i == 0 ? rnd.nextInt(9) + 1 : rnd.nextInt(10)));
	    }
	    return new BigInteger(new String(charArray));
	}

}
