public class ListTester {
    public static void main(String[] args){
        LList testList = new LList();

        for (int i = 0;i<10;i++){
          Integer testInt = new Integer(i);
          testList.add(testInt);
        }
        System.out.println(testList);
        testList.remove(4);
        System.out.println(testList);
    }
}
