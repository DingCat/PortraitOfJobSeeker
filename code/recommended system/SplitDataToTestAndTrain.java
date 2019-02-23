/*
 * �����ݼ���Ϊѵ�����Ͳ��Լ�
 */
package UserIF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

	public class SplitDataToTestAndTrain{
		
		 int[][] test=new int[6040+1][3952+1];
		 int[][] train=new int[6040+1][3952+1];
		 static int count[]=new int[6041];
		public  boolean  splitData(List<String> data,int M,int k,int seed){		
			int[] intLine=new int[2];
			
			Random random=new Random();
			random.setSeed(seed);
			for(String line:data){
				intLine=UserIF.GetDataOfMovieLens.IDsget(line);
				
				if(random.nextInt(M)%M!=k){
					train[intLine[0]][intLine[1]]=1;
					count[intLine[0]]=1;
				}else{
					test[intLine[0]][intLine[1]]=1;
				}			
			}
			data.clear();
			return true;
			
		}
/*		
	public static void main(String[] args){
			double start=System.currentTimeMillis();
			List<String> data=new ArrayList<String>();
			int len=0,all=0;
			SplitDataToTestAndTrain S=new SplitDataToTestAndTrain();
			data=GetDataOfMovieLens.getData();//����ԭʼ���ݼ�
			len=data.size();
			S.splitData(data,8,3,10);//�ֽ�Ϊ���Լ���ѵ����
			for(int i=1;i<=6040;i++){
				if(count[i]!=0){
					all++;
				}
			}
			System.out.println(len);
			System.out.println(all);//˵��ѵ��������6040���û�
			double end=System.currentTimeMillis();
			System.out.println("�������е�ʱ��Ϊ��"+(end-start)/1000+"��");
		
	}
	*/
}
