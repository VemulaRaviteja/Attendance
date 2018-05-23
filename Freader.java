import java.io.*;
public class Freader {
	public String[] dread(String dname) {
		File f=new File(dname);
		String[] s=f.list();
		return s;
	}
	public int[] fread(String fname) throws IOException{
		File f=new File("Subjects",fname);
		BufferedReader br=new BufferedReader(new FileReader(f));
		int[] arr=new int[2];
		arr[0]=Integer.parseInt(br.readLine());
		arr[1]=Integer.parseInt(br.readLine());
		br.close();
		return arr;
		
	}

}
