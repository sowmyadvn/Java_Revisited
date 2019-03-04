import java.util.ArrayList;
public class Autoboxing {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for(int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		for(int i = 0; i < 10;i++) {
			System.out.print(arrayList.get(i)+" ");
		}
	}
}