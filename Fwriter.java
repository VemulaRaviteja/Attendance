import java.io.*;
public class Fwriter {
	String dname,fname;
	public void setData(String dname,String fname,int[] arr) throws IOException{
		File f=new File(dname,fname);
		PrintWriter pw=new PrintWriter(f);
		pw.println(arr[0]);
		pw.println(arr[1]);
		pw.close();
	}
    public void delFile(String fname) {
    	File f=new File("Subjects",fname);
    	f.delete();
    }
}
