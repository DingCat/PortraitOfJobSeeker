package UserIF;

public class EvaluationIndices {
	final static int userSum=6040;
	final static int itemSum=3952;
	
	public double[] recallAndPrecision(int[][]train,int[][] test,int N){
		int Tu=0;//�û�u�ڲ��Լ���ϲ������Ʒ����
		int Ru=0;//���û�u�Ƽ�����Ʒ���û�u�ڲ��Լ���ϲ������Ʒ��ͬ�ĸ���
		double[] rp=new double[2];
		int[] count=new int[userSum+1];
		for(int u=1;u<=userSum;++u){
			count[u]=0;
			for(int i=1;i<=itemSum;i++){
				if(test[u][i]!=0){
					++Tu;
					for(int k=1;k<=N;++k){
						if(CalculateRecommend.recomMatrix[u][k]==i){
						++count[u];
						}
					}
				}
			}
			Ru+=count[u];
		}
		rp[0]=Ru/(N*userSum*1.0);//׼ȷ��
		rp[1]=Ru/(Tu*1.0);//�ٻ���
		return rp;
	}
	public double coverage(int[][]train,int N){
		double coverage=0;//������
		int sum=0;
		int ID;
		int[] count=new int[itemSum+1];
		for(int u=1;u<=userSum;++u){
					for(int i=1;i<=N;++i){
						ID=CalculateRecommend.recomMatrix[u][i];
						if(count[ID]==0){
							count[ID]=1;
							++sum;
						}
					}
		}
		coverage=sum/(1.0*itemSum);
		return coverage;
	}
	public double popularity(int[][]train,int N){
		double popularity=0;//��ӱ��
		int ID;
		int count=0,sum=0;
		for(int u=1;u<=userSum;++u){
			for(int i=1;i<=N;++i){
				ID=CalculateRecommend.recomMatrix[u][i];
				for(int k=1;k<userSum;++k){
					if(train[k][ID]==1){
						++count;//������û�u�Ƽ���N����Ʒ�������ж�
					}
				}
				sum+=Math.log(1.0*(1+count));//������û�u�Ƽ���N����Ʒ��ƽ�����ж�
				count=0;//��ʼ�����������������û��Ƽ���N����Ʒ�������ж�
			}
		}
		popularity=sum/(userSum*N*1.0);
		return popularity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
