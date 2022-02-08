import java.util.Arrays;
import java.util.stream.Stream;

class MergeSortRecursive{

    public String[] sort(String[] items) {
        int length = items.length;
        if(length <= 1) return items;

        String[] left = sort(copy(items, 0, length/2));
        String[] right = sort(copy(items, length/2, length));
        return merge(left, right);
    }

    public String[] merge(String[] list1, String[] list2) {
        int lenList1 = list1.length;
        int lenList2 = list2.length;

        if(lenList1 <= 0) return list2;
        if(lenList2 <= 0) return list1;

        if(list1[0].compareTo(list2[0]) <= 0)
            return concatenate(list1[0], merge(copy(list1, 1, lenList1), list2));
        else
            return concatenate(list2[0], merge(list1, copy(list2, 1, lenList2)));
    }

    public final String[] concatenate(String list1, String[] list2) {
        return Stream.of(new String[]{list1}, list2)
                .flatMap(listArray -> Stream.of(listArray)).toArray(String[]::new);
    }

    public final String[] copy(String[] items, int start, int endExclusive) {
        return Arrays.copyOfRange(items, start, endExclusive);
    }

    public static void main(String[] args) {
        MergeSortRecursive mergesort = new MergeSortRecursive();
        String[] result = mergesort.sort(new String[]{"z", "a", "b", "t", "k", "m"});
        Stream.of(result).forEach(System.out::println);
    }
}