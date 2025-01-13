package src;

import java.util.Collections;
import java.util.Comparator;

public class MerchandiseInventoryTest {
    public static void main(String[] args) {
        Merchandise m = new Merchandise("0", 0, 0.0);
        m.readFromFile("C:\\Users\\rashid.tahasildar\\Desktop\\day5\\src\\input_data.txt");
        m.displayItems();

        System.out.println();
        Collections.sort(m.arr);
        m.displayItems();

        System.out.println();
        Collections.sort(m.arr, new Comparator<Merchandise>() {
            @Override
            public int compare(Merchandise m1, Merchandise m2) {
                return Double.compare(m2.getunitprice(), m1.getunitprice());
            }
        });
        m.displayItems();
    }
}
