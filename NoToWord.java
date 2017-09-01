import java.util.Scanner;
public class NoToWord {
    public static void main(String args[]){
        String[] singles = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] tens = {"","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] tenPlus = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        Scanner in = new Scanner(System.in);
        String numString = in.nextLine();
        int num = Integer.parseInt(numString);
        int tempNum = num,i=0;
        String resultString="";
		if(numString.length()<=9){
        while(tempNum>0){
            i++;
            int rem = tempNum%10;
			if(((tempNum%100)>10) && ((tempNum%100)<20) && i==1){
				resultString = tenPlus[(tempNum%100)-10]+resultString;
				i++;
				tempNum = tempNum/10;
			}else{
				if(i==1){
                resultString = singles[rem]+" "+resultString;
				}
				if(i==2){
                resultString = tens[rem]+" "+resultString;
				}
			}
            if(i==3){
				if(rem!=0){
					resultString = singles[rem]+" Hundred "+resultString;
				}
            }
            if(i==4){
				if((numString.length())>4){
					if(((tempNum%100)>10) && ((tempNum%100)<20)){
						resultString = tenPlus[(tempNum%100)-10]+" Thousand "+resultString;
					}else{
						int th=tempNum%100;
						resultString = tens[th/10]+" "+singles[th%10]+" Thousand "+resultString;
					}
					i++;
					tempNum = tempNum/10;
				}else{
					if(rem!=0){
						resultString = singles[rem]+" Thousand "+resultString;
					}
				}
            }
			if(i==6){
				if(numString.length()>6){
					if(((tempNum%100)>10) && ((tempNum%100)<20)){
						resultString = tenPlus[(tempNum%100)-10]+" Lakh "+resultString;
					}else{					
						int lh = tempNum%100;
						resultString = tens[lh/10]+" "+singles[lh%10]+" Lakh "+resultString;
					}
					i++;
					tempNum = tempNum/10;
				}else{
					if(rem!=0){
						resultString = singles[rem]+" Lakh "+resultString;
					}
				}
			}
			if(i==8){
				if((numString.length())>8){
					if(((tempNum%100)>10) && ((tempNum%100)<20)){
						resultString = tenPlus[(tempNum%100)-10]+" Crore "+resultString;
					}else{
						int th=tempNum%100;
						resultString = tens[th/10]+" "+singles[th%10]+" Crore "+resultString;
					}
					i++;
					tempNum = tempNum/10;
				}else{					
					resultString = singles[rem]+" Crore "+resultString;
				}
			}
		    tempNum = tempNum/10;
        }
		}else{
			System.out.println("limit exceeded");
		}
        System.out.println(resultString);
    }
    
}