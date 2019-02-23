package UserIF;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Start {
	final static int userSum=6040;
	final static int itemSum=3952;
	public static void main(String[] args){
		double start=System.currentTimeMillis();
		int N=10;//���û��Ƽ�����Ʒ����
		int K=160;//��ĳһ�û���Ȥ��ӽ���K���û�
		double coverage,popularity;
		double[]rp=new double[2];
		SplitDataToTestAndTrain S=new SplitDataToTestAndTrain();
		Similarity W=new Similarity();
		CalculateRecommend CR=new CalculateRecommend();
		EvaluationIndices EI=new EvaluationIndices();
		List<String> data=new ArrayList<String>();
		data=GetDataOfMovieLens.getData();//����ԭʼ���ݼ�
		S.splitData(data,8,3,10);//�ֽ�Ϊ���Լ���ѵ����
		W.UserSimilarity(S.train);//�����û����ƶȣ����ұ��浽simMatrix���ƶȾ�����
		CR.userSimSort(Similarity.simMatrix,K);
		CR.recommend(S.train,Similarity.simMatrix,K);//�����û�i������K���û��Ƽ���������Ʒi����Ȥ��
		CR.getRecommend(N);//��ȡ��ÿ���û����Ƽ��б�
		rp=EI.recallAndPrecision(S.train,S.test, N);
		coverage=EI.coverage(S.train,N);
		popularity=EI.popularity(S.train, N);
		DecimalFormat df1 = new DecimalFormat("0.00%");
		DecimalFormat df2 = new DecimalFormat("0.000001");
		System.out.println("KΪ"+K+"ʱ");
		System.out.print("׼ȷ��"+df1.format(rp[0]));
		System.out.print("�ٻ���"+df1.format(rp[1]));
		System.out.print("������"+df1.format(coverage));
		System.out.print("���ж�"+df2.format(popularity));
		double end=System.currentTimeMillis();
		System.out.println("�������е�ʱ��Ϊ��"+(end-start)/1000+"��");
	}
}
