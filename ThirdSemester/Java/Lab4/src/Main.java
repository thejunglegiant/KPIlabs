import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Init
        List<MyString> mList = new LinkedList<>();
        mList.add(new MyString("my "));
        mList.add(new MyString("name "));
        mList.add(new MyString("abracadbra "));
        mList.add(new MyString("!"));
        mList.add(new MyString("name "));
        mList.add(new MyString("Oleksii"));
        mList.add(new MyString("Hello, "));
        mList.add(new MyString("!"));
        mList.add(new MyString("is "));
        mList.add(new MyString("abracadbra "));
        mList.add(new MyString("blabla "));
        mList.add(new MyString("hahah "));
        mList.add(new MyString("afsdgfuahergiu "));

        // Print
        printList(mList);
        System.out.println("\n====================\n");

        // Sort
        mList.sort(new HashComparator());

        // Print
        printList(mList);
        System.out.println("\n====================\n");

        // Remove duplicates
        for (int i = 0; i < mList.size() - 1; i++) {
            if (mList.get(i).equals(mList.get(i + 1))) {
                mList.remove(i);
            }
        }

        // Print
        printList(mList);
    }

    private static void printList(List<MyString> list) {
        Iterator<MyString> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static class HashComparator implements Comparator<MyString> {

        @Override
        public int compare(MyString myString, MyString t1) {
            return Integer.compare(myString.getCode(), t1.getCode());
        }
    }
}
