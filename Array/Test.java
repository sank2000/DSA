package Array;

public class Test {

    public static void main(String[] args) {

        Array arr = new Array();

        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);

        System.out.println(arr.indexOf(4));
        System.out.println(arr.indexOf(10));

        System.out.println(arr.removeAt(3));
        
        System.out.println(arr.getArrayString());
    }
}