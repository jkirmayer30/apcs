public class ListTester {
    public static void main(String[] args){
        LList testList = new LList();
        for (int i = 0;i<10;i++){
            testList.add((10-i)+"");
        }
        System.out.println(testList);
        testList.remove(4);
        System.out.println(testList);
        testList.add("hi",5);
        System.out.println(testList);
    }
}