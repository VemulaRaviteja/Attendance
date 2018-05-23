
public class position {
	static linkedlist l=new linkedlist();
	private static int exact;
	public position(int c) {
		exact=c;
	}
	public position() {
		
	}
	public void setExact() {
		if(l.isEmpty(l))exact+=35;
	}
	public void setDelPos(int x) {
		if(l.isEmpty(l))exact-=40;
		l.push(x);
		
	}
	public int getPos() {
		boolean b=l.isEmpty(l);
		if(b) {
			return exact;
		}
		else return l.pop();
	}

}
