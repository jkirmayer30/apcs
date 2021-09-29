public class Arrays {

    public static double[] powArray(double[] a,int n){
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.pow(a[i], n);
        }
        return a;
    }

    public static int[] histogram(int[] scores,int n){ 
        int[] counts = new int[n];
        for (int score : scores) {
            counts[score]++;
        }
        return counts;
    }
    
    public static int idxOfMax(int[] a){
        int maxVal = a[0];
        int maxIdx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]>maxVal){
                maxVal = a[i];
                maxIdx = i;
            }
        }
      return maxIdx;
    }

    public static Boolean[] sieve(int n){
        Boolean[] a = new Boolean[n];
        for (int i = 0; i < a.length; i++) {
            if (i>1){
            a[i]=true;
            } else {
                a[i]=false; 
            }
            for (int j = 2; j < i; j++){
                if (i>1&i%j==0){
                    a[i]=false;
                }
            }
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = new int[3];
        a[0]=1;
        a[1]=3;
        a[2]=2;
        System.out.println(sieve(7));
        System.out.println(idxOfMax(a));
    }

}