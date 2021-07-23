package Array;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array();
        Array arr2 = new Array();

        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);

        arr2.insert(4);
        arr2.insert(5);
        arr2.insert(6);
        arr2.insert(6);

        System.out.println(arr.indexOf(4));
        System.out.println(arr.indexOf(10));

        arr.reversPrint();
        System.out.println(arr.getMax());
        
        System.out.println(arr.removeAt(3));

        arr.insertAt(7, 2);
        
        System.out.println(arr.intersect(arr2).getArrayString());
        
        System.out.println(arr.getArrayString());
    }
}