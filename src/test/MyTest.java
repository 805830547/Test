package test;

public class MyTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PaiXu paiXu = new PaiXu();
//		paiXu.doPaiXu();
//		int result = JieCheng.doJieCheng(4);
		
//		int result = JieCheng.doJieChengAdd(4);
//		System.out.print("结果是:"+result);
		
		SuShu.doSuShu(100);
	}
}

class PaiXu{
	// TODO Auto-generated method stub
	int a[]={25,24,12,76,98,101,90,28};
                                                                                                                                                        
	public void doPaiXu(){

		System.out.print("排序前的数组:");
		for(int i:a){
			System.out.print(" "+i);	
		}
		for(int i=0,temp=0;i<a.length;i++){
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<a[i]){//<从小到大  >从大到小
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.print("\r排序后的数组:");
		for(int i:a){
			System.out.print(" "+i);	
		}
	}
}

class JieCheng{
	
	static int doJieCheng(int n){//n的阶乘
		int result=1;
		for(int i=1;i<=n;i++){			
			result*=i;
		}
		return result;
	}	
	
	static int doJieChengAdd(int n){//1..n的阶乘之和
		int result=0;
		for(int i=1;i<=n;i++){	
			
			result+=doJieCheng(i);
		}
		return result;
	}
}

class SuShu{	
	static void doSuShu(int n){//n以内的全部素数
		int i;
		int j;
		System.out.println(n+"以内的全部素数:");
		for(i=1;i<=n;i++){
			for(j=1;j<=i;j++){			
				if((i%j)==0&&(j!=1)){
					break;
				}
			}
			if(j==i){
				System.out.print(i+",");
			}
		}
	}	
}


















