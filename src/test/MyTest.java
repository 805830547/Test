package test;

public class MyTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PaiXu paiXu = new PaiXu();
//		paiXu.doPaiXu();
//		int result = JieCheng.doJieCheng(4);
		
//		int result = JieCheng.doJieChengAdd(4);
//		System.out.print("�����:"+result);
		
		SuShu.doSuShu(100);
	}
}

class PaiXu{
	// TODO Auto-generated method stub
	int a[]={25,24,12,76,98,101,90,28};
                                                                                                                                                        
	public void doPaiXu(){

		System.out.print("����ǰ������:");
		for(int i:a){
			System.out.print(" "+i);	
		}
		for(int i=0,temp=0;i<a.length;i++){
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<a[i]){//<��С����  >�Ӵ�С
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.print("\r����������:");
		for(int i:a){
			System.out.print(" "+i);	
		}
	}
}

class JieCheng{
	
	static int doJieCheng(int n){//n�Ľ׳�
		int result=1;
		for(int i=1;i<=n;i++){			
			result*=i;
		}
		return result;
	}	
	
	static int doJieChengAdd(int n){//1..n�Ľ׳�֮��
		int result=0;
		for(int i=1;i<=n;i++){	
			
			result+=doJieCheng(i);
		}
		return result;
	}
}

class SuShu{	
	static void doSuShu(int n){//n���ڵ�ȫ������
		int i;
		int j;
		System.out.println(n+"���ڵ�ȫ������:");
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


















