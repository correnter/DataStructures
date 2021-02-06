package my.agrithm;

public class HanoiTower {
	public static void main(String[] args) {
		HanoiTower ht=new HanoiTower();
		ht.tower(5, 'a', 'b', 'c');
	}
	public void tower(int num,char a, char b,char c) {
		if(num==1) {
			System.out.println("Œ¢"+num+"Ä " +a+ "->"+c);
		}else {
			tower(num-1,a,c,b);
			System.out.println("½«"+num+"´Ó"+a+"->"+c);
			tower(num-1,b,a,c);
		}
	}
}
