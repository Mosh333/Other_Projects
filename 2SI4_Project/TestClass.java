import java.math.BigInteger;
import java.util.Random;


public class TestClass {

	 public static void main(String[] args) {
        
	        String s1= "-53253";
	        String s2= "1253113";
	        String s3=null;
	        
	        int n1= 10;
	        int n2= -1;
	       
	       // Test 1 for constructor 1 (positive case)
	       System.out.println("Test 1 : constructor 1 (positive case)");
	       HugeInteger Obj1= new HugeInteger(s2);
	       System.out.println(Obj1.toString());
	       
	       // Test 2 for constructor 1 (negative case)
	       System.out.println("Test 2 : constructor 1 (negative case)");
	       HugeInteger Obj2= new HugeInteger(s1);
	       System.out.println(Obj2.toString());
	       
	        
	       // Test 3 for contructor 2 ( normal case)
	       System.out.println("Test 3 : constructor 2 (normal case)");
	       HugeInteger Obj4= new HugeInteger(n1);
	       System.out.println(Obj4.toString());

	       
	       // Test 4 for add (2 positive numbers)
	       System.out.println("Test 4 : add (positive numbers)");
	       HugeInteger Obj6= new HugeInteger("46289");
	       HugeInteger Obj7= new HugeInteger("183789");
	       HugeInteger Obj8= Obj6.add(Obj7);
	       System.out.println(Obj8.toString());
	       
	       // Test 5 for add (2 negative numbers)
	       System.out.println("Test 5 : add (negative numbers)");
	       HugeInteger Obj9= new HugeInteger("-56289");
	       HugeInteger Obj10= new HugeInteger("-152789");
	       HugeInteger Obj11= Obj9.add(Obj10);
	       System.out.println(Obj11.toString());
	       
	        // Test 6 for add (positive and negative numbers)
	       System.out.println("Test 6 : add (positive and negative numbers)");
	       HugeInteger Obj12= new HugeInteger("-97");
	       HugeInteger Obj13= new HugeInteger("100");
	       HugeInteger Obj14= Obj12.add(Obj13);
	       System.out.println(Obj14.toString());
	       
	        // Test 7 for subtract (2 positive numbers)
	       System.out.println("Test 7 : subtract (positive numbers)");
	       HugeInteger Obj15= new HugeInteger("12256789");
	       HugeInteger Obj16= new HugeInteger("1523789");
	       HugeInteger Obj17= Obj15.subtract(Obj16);
	       System.out.println(Obj17.toString());
	       
	        // Test 8 for subtract (2 negative numbers)
	       System.out.println("Test 8 : subtract (negative numbers)");
	       HugeInteger Obj18= new HugeInteger("-99");
	       HugeInteger Obj19= new HugeInteger("-100");
	       HugeInteger Obj20= Obj18.subtract(Obj19);
	       System.out.println(Obj20.toString());
	       
	        // Test 9 for subtract ( positive and negative numbers)
	       System.out.println("Test 9 : subtract (positive and negative numbers)");
	       HugeInteger Obj21= new HugeInteger("-12256789");
	       HugeInteger Obj22= new HugeInteger("1523789");
	       HugeInteger Obj23= Obj21.subtract(Obj22);
	       System.out.println(Obj23.toString());
	       
	       
	        // Test 10 for multiply ( positive numbers)
	       System.out.println("Test 10 : multiply (positive numbers)");
	       HugeInteger Obj24= new HugeInteger("1225");
	       HugeInteger Obj25= new HugeInteger("25");
	       HugeInteger Obj26= Obj24.multiply(Obj25);
	       System.out.println(Obj26.toString());
	       
	       // Test 11 for multiply ( negative numbers)
	       System.out.println("Test 11 : multiply (negative numbers)");
	       HugeInteger Obj27= new HugeInteger("-122567");
	       HugeInteger Obj28= new HugeInteger("-567");
	       HugeInteger Obj29= Obj27.multiply(Obj28);
	       System.out.println(Obj29.toString());
	       
	       // Test 12 for multiply ( positive and negative numbers)
	       System.out.println("Test 12 : multiply (positve and negative numbers)");
	       HugeInteger Obj30= new HugeInteger("122567");
	       HugeInteger Obj31= new HugeInteger("-567");
	       HugeInteger Obj32= Obj30.multiply(Obj31);
	       System.out.println(Obj32.toString());
	       
	       
	       // Test 13 for compareTo ( positive  numbers)
	       System.out.println("Test 13 : compareTo (positive numbers)");
	       HugeInteger Obj33= new HugeInteger("122567");
	       HugeInteger Obj34= new HugeInteger("2465799");
	       int obj= Obj33.compareTo(Obj34);
	       System.out.println(obj);
	       System.out.print("output should be -1\n");
	       
	       // Test 14 for compareTo ( negative numbers)
	       System.out.println("Test 14 : compareTo (negative numbers)");
	       HugeInteger Obj35= new HugeInteger("-122567");
	       HugeInteger Obj36= new HugeInteger("-2465799");
	       int obj1= Obj35.compareTo(Obj36);
	       System.out.println(obj1);
	       System.out.print("output should be 1\n");
	       
	       // Test 15 for compareTo ( positive negative  numbers)
	       System.out.println("Test 15 : compareTo ( positive and negative numbers)");
	       HugeInteger Obj37= new HugeInteger("-122567");
	       HugeInteger Obj38= new HugeInteger("2465799");
	       int obj2= Obj37.compareTo(Obj38);
	       System.out.println(obj2);
	       System.out.print("output should be -1\n");
	       
	        // Test 16 for compareTo ( same  numbers)
	       System.out.println("Test 16 : compareTo ( same numbers)");
	       HugeInteger Obj39= new HugeInteger("122567");
	       HugeInteger Obj40= new HugeInteger("122567");
	       int obj3= Obj39.compareTo(Obj40);
	       System.out.println(obj3);
	       System.out.print("output should be 0\n\n");
	       
	       
	    // run time for add with own HugeInteger Class
	       System.out.println("Run time for add with my HugeInteger Class: ");
	       HugeInteger A,B,C;
	       long startTime, endTime;
	       double runTime=0.0;
	       int n4= 10000;
	       int MAXNUMINTS= 100;
	       int MAXRUN= 500;
	       for (int numInts=0; numInts < MAXNUMINTS; numInts++)
	       {
	            A = new HugeInteger(n4); //creates a random integer of n digits
	            B = new HugeInteger(n4); //creates a random integer of n digits
	            startTime = System.currentTimeMillis();
	            for(int numRun=0; numRun < MAXRUN; numRun++)
	            { C = A.add(B); }
	            endTime = System.currentTimeMillis();
	            runTime +=(double) (endTime - startTime)/((double) MAXRUN);
	        }
	        runTime = runTime/((double)MAXNUMINTS);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTime*MAXRUN);
	        System.out.println("The run time (ms) for add is:");
	        System.out.println(runTime);
	        System.out.println("*******************************************");
	       
	        //run time for add with BigInteger Class
	        System.out.println("Run time for add with BigInteger Class: ");
	       BigInteger big1, big2, big3;
	       long startTimeBig, endTimeBig;
	       double runTimeBig=0.0;
	       int n4Big= 10000;
	       int MAXNUMINTSBig= 100;
	       int MAXRUNBig= 500;
	       for (int numIntsBig=0; numIntsBig < MAXNUMINTSBig; numIntsBig++)
	       {
	            big1 = getRandomNumber(n4Big); //creates a random integer of n digits
	            big2 = getRandomNumber(n4Big); //creates a random integer of n digits
	            startTimeBig = System.currentTimeMillis();
	            for(int numRunBig=0; numRunBig < MAXRUNBig; numRunBig++)
	            { big3 = big1.add(big2); }
	            endTimeBig = System.currentTimeMillis();
	            runTimeBig +=(double) (endTimeBig - startTimeBig)/((double) MAXRUN);
	        }
	        runTimeBig = runTimeBig/((double)MAXNUMINTSBig);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTimeBig*MAXRUNBig);
	        System.out.println("The run time (ms) for add is:");
	        System.out.println(runTimeBig);
	        System.out.println("*******************************************");
	        
	         //run time for subtract
	        System.out.println("Run time for subtract with my HugeInteger Class: ");
	       HugeInteger D,E,F;
	       long startTime1, endTime1;
	       double runTime1=0.0;
	       int n5= 10000;
	       int MAXNUMINTS1= 100;
	       int MAXRUN1= 700;
	       for (int numInts1=0; numInts1 < MAXNUMINTS1; numInts1++)
	       {
	            D = new HugeInteger(n5); //creates a random integer of n digits
	            E = new HugeInteger(n5); //creates a random integer of n digits
	            startTime1 = System.currentTimeMillis();
	            for(int numRun1=0; numRun1 < MAXRUN1; numRun1++)
	            { F = D.subtract(E); }
	            endTime1 = System.currentTimeMillis();
	            runTime1 +=(double) (endTime1 - startTime1)/((double) MAXRUN1);
	        }
	        runTime1 = runTime1/((double)MAXNUMINTS1);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTime1*MAXRUN1);
	        System.out.println("The run time (ms) for subtract is:");
	        System.out.println(runTime1);
	        System.out.println("*******************************************");
	      
	      //run time for subtract with BigInteger Class
	        System.out.println("Run time for subtract with BigInteger Class: ");
	       BigInteger big4, big5, big6;
	       long startTimeBig1, endTimeBig1;
	       double runTimeBig1=0.0;
	       int n5Big= 10000;
	       int MAXNUMINTSBig1= 100;
	       int MAXRUNBig1= 500;
	       for (int numIntsBig1=0; numIntsBig1 < MAXNUMINTSBig1; numIntsBig1++)
	       {
	            big4 = getRandomNumber(n5Big); //creates a random integer of n digits
	            big5 = getRandomNumber(n5Big); //creates a random integer of n digits
	            startTimeBig1 = System.currentTimeMillis();
	            for(int numRunBig=0; numRunBig < MAXRUNBig; numRunBig++)
	            { big6 = big4.subtract(big5); }
	            endTimeBig1 = System.currentTimeMillis();
	            runTimeBig1 +=(double) (endTimeBig1 - startTimeBig1)/((double) MAXRUNBig1);
	        }
	        runTimeBig1 = runTimeBig1/((double)MAXNUMINTSBig1);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTimeBig1*MAXRUNBig1);
	        System.out.println("The run time (ms) for subtract is:");
	        System.out.println(runTimeBig1);
	        System.out.println("*******************************************");
	        
	       // run time for multiply with my HugeInteger Class
	        System.out.println("Run time for multiply with my HugeInteger Class: ");
	       HugeInteger G,H,I;
	       long startTime2, endTime2;
	       double runTime2=0.0;
	       int n6= 10;
	       int MAXNUMINTS2= 100;
	       int MAXRUN2= 1;
	       for (int numInts2=0; numInts2 < MAXNUMINTS2; numInts2++)
	       {
	            G = new HugeInteger(n6); //creates a random integer of n digits
	            H = new HugeInteger(n6); //creates a random integer of n digits
	            startTime2 = System.currentTimeMillis();
	            for(int numRun2=0; numRun2 < MAXRUN2; numRun2++)
	            { I = G.multiply(H); }
	            endTime2 = System.currentTimeMillis();
	            runTime2 +=(double) (endTime2 - startTime2)/((double) MAXRUN2);
	        }
	        runTime2 = runTime2/((double)MAXNUMINTS2);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTime2*MAXRUN2);
	        System.out.println("The run time (ms) for multiply is:");
	        System.out.println(runTime2);
	        System.out.println("*******************************************");
	        
	      //run time for multiply with BigInteger Class
	        System.out.println("Run time for multiply with BigInteger Class: ");
	       BigInteger big7, big8, big9;
	       long startTimeBig2, endTimeBig2;
	       double runTimeBig2=0.0;
	       int n6Big= 10000;
	       int MAXNUMINTSBig2= 100;
	       int MAXRUNBig2= 500;
	       for (int numIntsBig2=0; numIntsBig2 < MAXNUMINTSBig2; numIntsBig2++)
	       {
	            big7 = getRandomNumber(n6Big); //creates a random integer of n digits
	            big8 = getRandomNumber(n6Big); //creates a random integer of n digits
	            startTimeBig2 = System.currentTimeMillis();
	            for(int numRunBig2=0; numRunBig2 < MAXRUNBig2; numRunBig2++)
	            { big9 = big7.multiply(big8); }
	            endTimeBig2 = System.currentTimeMillis();
	            runTimeBig2 +=(double) (endTimeBig2 - startTimeBig2)/((double) MAXRUNBig2);
	        }
	        runTimeBig2 = runTimeBig2/((double)MAXNUMINTSBig2);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTimeBig2*MAXRUNBig2);
	        System.out.println("The run time (ms) for multiply is:");
	        System.out.println(runTimeBig2);
	        System.out.println("*******************************************");

	        // run time for compareTo for my HugeInteger class
	       System.out.println("Run time for compareTo with my HugeInteger Class: ");
	       HugeInteger J,K;
	       int L;
	       long startTime3, endTime3;
	       double runTime3=0.0;
	       int n7=10000;
	       int MAXNUMINTS3= 100;
	       int MAXRUN3= 50000000;
	       for (int numInts3=0; numInts3 < MAXNUMINTS3; numInts3++)
	       {
	            J = new HugeInteger(n7); //creates a random integer of n digits
	            K = new HugeInteger(n7); //creates a random integer of n digits
	            startTime3 = System.currentTimeMillis();
	            for(int numRun3=0; numRun3 < MAXRUN3; numRun3++)
	            { L = J.compareTo(K); }
	            endTime3 = System.currentTimeMillis();
	            runTime3 +=(double) (endTime3 - startTime3)/((double) MAXRUN3);
	        }
	        runTime3 = runTime3/((double)MAXNUMINTS3);
	        System.out.println("The endTime-startTime is:");
	        System.out.println(runTime3*MAXRUN3);
	        System.out.println("The run time for compareTo is:");
	        System.out.println(runTime3);
	        System.out.println("*******************************************");
	        
	     // run time for compareTo for BigInteger class
	        System.out.println("Run time for compareTo with BigInteger Class: ");
		       BigInteger big10, big11;
		       int compareResult;
		       long startTimeBig3, endTimeBig3;
		       double runTimeBig3=0.0;
		       int n7Big= 10000;
		       int MAXNUMINTSBig3= 100;
		       int MAXRUNBig3= 500;
		       for (int numIntsBig3=0; numIntsBig3 < MAXNUMINTSBig3; numIntsBig3++)
		       {
		            big10 = getRandomNumber(n7Big); //creates a random integer of n digits
		            big11 = getRandomNumber(n7Big); //creates a random integer of n digits
		            startTimeBig3 = System.currentTimeMillis();
		            for(int numRunBig3=0; numRunBig3 < MAXRUNBig3; numRunBig3++)
		            { compareResult = big10.compareTo(big11); }
		            endTimeBig3 = System.currentTimeMillis();
		            runTimeBig3 +=(double) (endTimeBig3 - startTimeBig3)/((double) MAXRUNBig3);
		        }
		        runTimeBig3 = runTimeBig3/((double)MAXNUMINTSBig3);
		        System.out.println("The endTime-startTime is:");
		        System.out.println(runTimeBig3*MAXRUNBig3);
		        System.out.println("The run time (ms) for compareTo is:");
		        System.out.println(runTimeBig3);
		        System.out.println("*******************************************");
	    
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
