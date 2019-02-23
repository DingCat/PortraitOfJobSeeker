package UserIF;
/*
 * ʵ��UserIF�㷨
 * 
 * */
public class CalculateRecommend {
	final static int userSum=6040;
	final static int itemSum=3952;
	static double[][]matrixOut;
	static double[][]ItemPref;
	static int[][] recomMatrix;
	//ѡ�����û�u��Ȥ��ӽ���K���û�
	public  boolean userSimSort(double[][]simMatrix,int K){
		double[][]matrixIn =new double[userSum+1][userSum+1];
		matrixIn=simMatrix;
		matrixOut =new double[userSum+1][K+1];
		int arrayIndex;//��¼Ҫ���û�u��Ȥ��ӽ����û�ID
		double max;
		for(int u=1;u<=userSum;++u){
			for(int j=K-1;j>=0;--j){
				arrayIndex=0;
				max=matrixIn[u][1];
				for(int v=1;v<=userSum;++v){
					if(max<matrixIn[u][v]){
						max=matrixIn[u][v];
						if(v==userSum)break;
						arrayIndex=v;
					}
					
				}
				matrixOut[u][K-j]=max+arrayIndex;
				matrixIn[u][arrayIndex]=0;
				//��ʱ���û�u�����Ƶ��û�v�Ѿ���ѡ���ˣ���ô
				//�����������ƶ�Ϊ0����ֹ�����û�u����һ���û��Ƚ�
			}
		}
		return true;
	}
	public  boolean recommend(int[][]train,double[][]simMatrix,int K){
		//���û�u����Ʒi����Ȥ��ItemPref[u][i]
		ItemPref =new double[userSum+1][itemSum+1];
		int ID;
		double Wuv=0;		
		for(int u=1;u<=userSum;++u){
			for(int i=1;i<=itemSum;++i){
				if(train[u][i]==0){//���û�u�Ƽ�û�й���Ϊ����Ʒi
					for(int v=1;v<=K;++v){
						ID=(int)matrixOut[u][v];
						if(ID==6041){System.out.println("Խ��"+matrixOut[u][v]);System.exit(0);}
						if(train[ID][i]==1){//�û�uû�й���Ϊ��Ʒi�������û�v����Ϊ
							Wuv=matrixOut[u][v]-(double)ID;
							ItemPref[u][i]+=Wuv;
							//System.out.println(ItemPref[u][i]);
							//�������ԣ�ÿ�������0.124���һ���0.247���Ҳ���
							//֮���Գ��ֺü����ظ��Ľ������Ϊ�û�v�кü�����Ʒ���û�uû�е�
						}
					}
				}else{
					ItemPref[u][i]=0;
				}
			}
		}
		return true;
	}	

	public boolean getRecommend(int N){//��ȡ����û�u���Ƽ��б�
		int ID;//��Ʒid��
		double recomDegree;//ĳ����Ʒ���û�u���Ƽ���
		recomMatrix=new int[userSum+1][N+1];
		for(int u=1;u<=userSum;++u){
			for(int k=1;k<=N;++k){
				recomDegree=ItemPref[u][0];
				ID=0;
				for(int i=1;i<=itemSum;++i){//ѡ������ÿ��ѡ�������Ƽ��ȵ���Ʒi
					if(recomDegree<ItemPref[u][i]){
						recomDegree=ItemPref[u][i];
						ID=i;
					}
				}
				ItemPref[u][ID]=0;//�Ѿ��ȽϹ�����Ʒi��0����ֹ���ֵ�ѭ�����Ǹ���Ʒ
				recomMatrix[u][k]=ID;//����k���Ƽ�����Ʒ���뵽�Ƽ�������
			}
		}
		return true;
	}
	
	/*
	 * ���Դ���
 	public static void main(String[] args){
			SplitDataToTestAndTrain S=new SplitDataToTestAndTrain();
			Similarity W=new Similarity();
			List<String> data=new ArrayList<String>();
			data=GetDataOfMovieLens.getData();//����ԭʼ���ݼ�
			S.splitData(data,8,3,10);//�ֽ�Ϊ���Լ���ѵ����
			W.UserSimilarity(S.train);//�����û����ƶȣ����ұ��浽simMatrix���ƶȾ�����
			userSimSort(Similarity.simMatrix,3);
			recommend(S.train,Similarity.simMatrix,3);//�����û�i�������û�v�Ƽ���������Ʒi����Ȥ��
			
		}
		
		*/
}


