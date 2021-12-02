public class Passer{
	public static int mutate(int x){
		x+=100;
		return x;

	}

	public static String mutate(String x ){
		x+="!";
		return x;
	}

	public static String mutate(int[] x){
		x[0] = 1;
		return toString(x);
	}

	public static String toString(int[] array) {
    String arrayString = "[";
    for(int i = 0; i < array.length; i++) {
      arrayString += array[i];
      if (i != array.length - 1) {
        arrayString += ", ";
      }
    }
    return arrayString + "]";
  }

	public static void main(String[] args){
		int a = 0;
		System.out.println(mutate(a));
		System.out.println(a);
		String b = "hi";
		System.out.println(mutate(b));
    System.out.println(b);
		int[] c = {3};
		System.out.println(mutate(c));
    System.out.println(toString(c));

	}
}
