package UserIF;
/*
 * ���ļ��л�ȡuserid��itemid��
 * �����뵽һ����ά������
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GetDataOfMovieLens {//ת���ַ����͵�userID��itemIDΪint�ͣ�
	public static int[] IDsget(String str){
		String[] strLine=str.split(",");
		int[] intLine=new int[2];
		intLine[0]=Integer.parseInt(strLine[0]);
		intLine[1]=Integer.parseInt(strLine[1]);
		return intLine;
	}
	public static  List<String> getData(){		

		List<String> data=new ArrayList<String>();
        try {//��ȡ�ļ��е����ݴ���data
        	FileReader reader = new FileReader("c:\\ratings.txt");
        	BufferedReader br = new BufferedReader(reader);      
        	String str = null;
        	while((str = br.readLine()) != null) {
        		data.add(str);	        			
        	}      	
        	br.close();
        	reader.close();
        }catch(FileNotFoundException e) {
              e.printStackTrace();
        }catch(IOException e) {
              e.printStackTrace();
        }
       /* for(String line:data){
        	System.out.println(line);
        }*/
       return data;
  }
}
