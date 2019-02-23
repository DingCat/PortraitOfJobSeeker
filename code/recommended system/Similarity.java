package UserIF;

import java.util.ArrayList;
import java.util.List;

public class Similarity {
	/*
	 * ����Ľ����û��������ƶ�
	 * �ҵ���ͬ�û��������Ʒ����Ϊ
	 * Ȼ������ǵ���Ϊ���ҳ�һ������Ʒ
	 * �������������ƶȹ�ʽ����
	 * */
	final static int userSum=6040;
	final static int itemSum=3952;
	static double[][] simMatrix=new double[userSum+1][userSum+1];
	public boolean UserSimilarity(int[][]train){
		for(int i=1;i<=userSum;++i){
			for(int j=i+1;j<=userSum;++j){
				int Icomment=0;
				int Jcomment=0;
				int Bothcomment=0;
				double similarity=0;
				for(int k=1;k<=itemSum;++k){
					if(train[i][k]==1&&train[j][k]==1){
						Bothcomment+=1;
					}
					if(train[i][k]>0){
						Icomment+=1;
					}
					if(train[j][k]>0){
						Jcomment+=1;
					}
				}
				if(Bothcomment!=0&&Icomment!=0&&Jcomment!=0){
					similarity=Bothcomment/(Math.sqrt(1.0*Icomment*Jcomment)*Math.log(1+userSum));
					simMatrix[i][j]=similarity;//���Ϊ0.01����	
					//System.out.println(similarity);
					simMatrix[j][i]=similarity;
				}
				if(Bothcomment==0||Icomment==0||Jcomment==0){
					simMatrix[i][j]=0;
					
				}
			}
			simMatrix[i][i]=0;
		}
		return true;
		
	}
	/*
	public static void main(String[] args){
		SplitDataToTestAndTrain S=new SplitDataToTestAndTrain();
		Similarity W=new Similarity();
		List<String> data=new ArrayList<String>();
		data=GetDataOfMovieLens.getData();
		S.splitData(data,8,3,10);
		W.UserSimilarity(S.train);
	}
	*/
		
}
	
	
	
	
	

