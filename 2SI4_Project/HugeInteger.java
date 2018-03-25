import java.math.BigInteger;
import java.util.Random;

public class HugeInteger {
    
    private int op;			//variable to keep track whether hugeInteger object has gone thru previous arithmetic operation
    private int size;
    private int[] myArray;
    private int sign;
    
    
    public HugeInteger(String val)
    {
    	op=0;
    	Character[] charArray = strToChar(val);
		sign = 0;
		
		//compute num of myArray in theNum
		this.size = String.valueOf(val).length();
		if(val.charAt(0)== '-'){
				sign = 1;
				this.size--;
		}
	
		//convert array of char to array of int
		if(sign==0){
			this.myArray = new int[this.size];
		}else{
			this.myArray = new int[this.size];
			//this.myArray[0] = -1; //we represent the negative sign with the value -1
		}
		if(sign==0){
			for(int i=0; i<this.size; i++){
				int temp;
				temp = (int) charArray[i];
				temp = temp - 48; //convert from ASCII value to decimal value
				myArray[i] = temp;
			}
		}else{
			for(int i=1;i<this.size+1;i++){
				//and do the same thing here again
				int temp;
				temp = (int) charArray[i]; //why no i-1?, prolly the for loop 1 to size+1
				temp = temp - 48;
				myArray[i-1] = temp; //needed to shift down the array
			}
		}
    }    
    
	public static Character[] strToChar(String str) {

		   if ( str == null ) {
		     return null;
		   }

		   int len = str.length();
		   Character[] array = new Character[len];
		   for (int i = 0; i < len ; i++) {
		      array[i] = new Character(str.charAt(i));
		   }

		   return array;
	}
    
    public HugeInteger( int n)
    {
		//we will use random number generator in the math library
		//math.random
		/*if(n<1){
			throw new IllegalArgumentException("n must be equal or greater than 1"); //throw an exception object
		}else{*/
			this.size = n;
			this.myArray = new int[n+1];
			Random randomGenerator = new Random();
			
			if(randomGenerator.nextInt(2)==1){ //generate either 0 or 1, if 1 set +1, if 0 set -1
				this.sign = 1;
			}else{
				this.sign = 0;
			}
			this.myArray[0] = randomGenerator.nextInt(9)+1; //generate a number from 0 to 8, then shift up by 1
			for(int i=1; i<n; i++){
				this.myArray[i] = randomGenerator.nextInt(10); //generate a number from 0 to 9
			}
		//}
    }
    

    
public HugeInteger add( HugeInteger h)
{
    int carry=0; // intializing variables
    int sizeDif1=0;
    int sizeDif2=0;
    int origDig=0; // variable for the original array
    int hDig=0; // variable for the h array
    int fDig=0; // the final sum
    int tempsize= size;
    
    if(size> h.size) // if this object is larger in digits
    {
        tempsize=size; // the size is going to be the larger size
        sizeDif1= size-h.size; // keeping track of the difference
    }
    else if( size < h.size) // if h object is larger in digits
    {
        tempsize=h.size;
        sizeDif2= h.size-size;
    }
    
    if(sign == h.sign) // if the signs are the same
    {
        HugeInteger output= new HugeInteger(tempsize); // the new object with the larger size
        output.sign=0; // default, set to positive
        
        for(int i= tempsize;i>0;i--) // starting from the end
        {
            int thisIndex= i-1-sizeDif2; // index of the first array
            int hIndex= i-1-sizeDif1; // index of the second array
            
            if(thisIndex>=0) // as long as the index is in range, the digit of the first array
            {
                origDig=myArray[thisIndex];
            }
            else // otherwise its 0
            {
                origDig= 0;
            }
            
            if(hIndex>=0) // as long as the index is in range, the digit of the second array
            {
                hDig=h.myArray[hIndex];
            }
            else // otherwise  its 0
            {
                hDig=0;
            }
            
            fDig= origDig+hDig+carry; // the sum
            if(fDig>9) // if the sum is greater than 9
            {
                fDig=fDig%10; // the digit is modulus 10
                carry= 1; // carry is set to 1
                output.myArray[i-1]= fDig;// store at the end of the array
            }
            else
            {
                carry=0; // carry is set to 0
                output.myArray[i-1]= fDig;// store at the end of the array
            }
        }
        
        if(carry==1) // if the final carry is 1, allocate extra digit of space
        {
            HugeInteger foutput= new HugeInteger(tempsize+1); // new object is created with size+1
            foutput.myArray[0]= carry; // first index is the carry
            
            for(int i= 1;i<(tempsize+1);i++)// everything else is copied over
            {
                foutput.myArray[i]=output.myArray[i-1];
            }
            
            if (sign ==1) // is sign is negative 
            {
                foutput.sign=1; // final sign is negative 
                return removeLeadingZero(foutput); // deleting leading zeros
            }
            else
            {
                foutput.sign=0; // final sign is positive
                return removeLeadingZero(foutput); // deleting leading zeros
            }
        }
        else // if no carry at end
        {
            HugeInteger foutput= output;// foutput is output
            if (sign ==1)// same sign checking
            {
                foutput.sign=1;
                return removeLeadingZero(foutput);
            }
            else
            {
                foutput.sign=0;
                return removeLeadingZero(foutput);
            }
        }
    }
    else //signs are not the same call subtract
    {
        op=1;
        HugeInteger foutput= subtract(h);
        return removeLeadingZero(foutput);
    }
}

public HugeInteger removeLeadingZero(HugeInteger h) //when we add two numbers there will be leading zero in the smaller digit
{//we need to remove it
    int count=0;
    for(int i=0;i<h.size;i++)
    {
        if(h.myArray[i]==0){
            count++;
        }
        else{
            break;
        }
    }
    if(count == h.size){
        HugeInteger output= new HugeInteger(1);
        output.sign= h.sign;
        output.op=h.op;
        output.myArray[0]=0;
    }
    
    HugeInteger output= new HugeInteger(h.size-count);
    for(int i=0;i<(h.size-count);i++)
    {
        output.myArray[i]= h.myArray[i+count];
    }
    output.sign=h.sign;
    output.op=h.op;
    return output;
}


public HugeInteger subtract(HugeInteger h)
{
    int borrow=0;
    int sizeDif1=0;
    int sizeDif2=0;
    int origDig=0;
    int hDig=0;
    int fDig=0;
    int tempsize= size;
    
    if(size> h.size)
    {
        tempsize=size;
        sizeDif1= size-h.size;
    }
    else if( size < h.size)
    {
        tempsize=h.size;
        sizeDif2= h.size-size;
    }
    
    if (op == 1){
        HugeInteger output= new HugeInteger(tempsize);
        output.sign=0;
        
        for(int i=tempsize;i>0;i--)
        {
            int thisIndex= i-1-sizeDif2;
            int hIndex= i-1-sizeDif1;
            
            if((sign==0) && (h.sign==1))
            {
                h.sign=0;
                if((compareTo(h)==0) || (compareTo(h)==1)){
                    if(thisIndex>=0){
                        origDig=myArray[thisIndex];
                    }
                    else{
                        origDig= 0;
                    }
                    if(hIndex>=0){
                        hDig=h.myArray[hIndex];
                    }
                    else{
                        hDig=0;
                    }
                    output.sign=0;
                }
                if(compareTo(h)==-1){
                    if(hIndex>=0){
                        origDig=h.myArray[hIndex];
                    }
                    else{
                        origDig= 0;
                    }
            
                    if(thisIndex>=0){
                        hDig=myArray[thisIndex];
                    }
                    else{
                        hDig=0;
                    }
                    output.sign=1;
                }
                h.sign=1;
            }
            if((sign==1)&&(h.sign==0)){
                sign=0;
                if((compareTo(h)==-1) || (compareTo(h)==0)){
                    if(hIndex>=0){
                        origDig=h.myArray[hIndex];
                    }
                    else{
                        origDig= 0;
                    }
            
                    if(thisIndex>=0){
                        hDig=myArray[thisIndex];
                    }
                    else{
                        hDig=0;
                    }
                    output.sign= 0;
                }
                if(compareTo(h)== 1){
                    if(thisIndex>=0){
                        origDig=myArray[thisIndex];
                    }
                    else{
                        origDig= 0;
                    }
            
                    if(hIndex>=0){
                        hDig=h.myArray[hIndex];
                    }
                    else{
                        hDig=0;
                    }
                    output.sign=1;
                }
                sign=1;
            }
            fDig= origDig-hDig-borrow; //since we are subtracting, borrow will decrease digit by one
            if(fDig<0){
                fDig=fDig+10;
                borrow=1;
                output.myArray[i-1]= fDig;
            }
            else
            {
                borrow=0;
                output.myArray[i-1]= fDig;
            }
        }
        return output;
    }
    else //deal with the signs, basically when we want to add or subtract, we use both add and subtract
    {
        if((sign==0) && (h.sign==0)){ 
            h.sign=1; //we are effectively subtracting when we set h to opposite sign of this
            HugeInteger output= add(h); //call add since opposite of subtract is add
            h.sign=0;
            return output;
        }
        if((sign==1) && (h.sign==1)){
            h.sign=0;
            HugeInteger output= add(h);
            h.sign=1;
            return output;
        }
        if((sign==1) && (h.sign==0)){
            h.sign=1;
            HugeInteger output= add(h);
            h.sign=0;
            return output;
        }
        else{
            h.sign=0;
            HugeInteger output= add(h);
            h.sign=1;
            return output;
        }
    }
}


public HugeInteger multiply(HugeInteger h)
{
      
      int carry=0;
      int origDig=0;
      int hDig=0;
      int fDig=0;
      int tempsize1=size;
      int tempsize2=h.size;
      int x= tempsize1;
      int y= tempsize1;
      String product="";
      
      HugeInteger output= new HugeInteger("0");
      
      if((tempsize1> tempsize2) || ( tempsize1 == tempsize2))
      {
          x= tempsize1;
          y= tempsize2;
      }
      if(tempsize1 < tempsize2)
      {
          x= tempsize2;
          y= tempsize1;
      }
      
      for(int i=y; i>0; i--)
      {
            product="";
            if((tempsize1> tempsize2) || (tempsize1== tempsize2)) 
            {
                origDig= h.myArray[i-1];
            }
           if(tempsize1 < tempsize2)
           {
               origDig=myArray[i-1];
           }
           for (int j= (y-i);j>0;j-- )
           {
               product= product+ 0;
           }
           for (int k=x;k>0;k--)
           {
                if((tempsize1> tempsize2) || (tempsize1== tempsize2))
                {
                    hDig= myArray[k-1];
                }
                if(tempsize1 < tempsize2)
                {
                    hDig=h.myArray[k-1];
                }
                fDig=((origDig*hDig)+carry)%10;	//take the carry over to next digit
                carry= ((origDig*hDig)+carry)/10; //do int division
                product= product+fDig;
                
                if((k-1)==0) //special case when
                {
                    product= product+carry;
                    carry=0;
                    product= new StringBuilder(product).reverse().toString();
                    HugeInteger foutput= new HugeInteger(product);
                    output= output.add(foutput);
                }
           }
      }
      if(sign != h.sign){
          output.sign= 1;
      }
      return output;
}

public int compareTo(HugeInteger h)
{
    
    if( sign > h.sign)
    {
        return -1;
    }
    else if(sign < h.sign)
    {
        return 1;
    }
    else
    {
        if(size > h.size)
        {
            if(sign == 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        if( size < h.size)
        {
            if(sign ==1)
            {
                return 1;
            }
            else if( sign== 0)
            {
                return -1;
            }
            
        }
        else
        {
            for(int i=0;i<size;i++)
            {
                if(myArray[i]>h.myArray[i])
                {
                    if(sign ==0 )
                    {
                        return 1;
                    }
                    else 
                    {
                        return -1;
                    }
                }
                if(myArray[i]<h.myArray[i])
                {
                    if(sign == 0)
                    {
                        return -1;
                    }
                    else
                    {
                        return 1;
                    }
                }
                else
                {
                    continue;
                }
            }
        }
        return 0;
    }
}

public String toString(){
        String output = ""; //initialize output string 
        if(sign == 1){ // if the output is negative add a (-) sign at the beginning 
            output = output + "-"; 
        }
        output = output + myArray[0];
	    
        for (int i = 1; i < size; i++) { 
            output = output + myArray[i]; //After the sign is added if there is one just loop through the array and add the numbers to the output string  
        } 
        
        return output; 
    } 
}
