package src;

import java.util.*;
import java.io.*;

public class Merchandise implements Comparable<Merchandise>{
    private String itemCode;
    private int quantity;
    private double unitPrice;

    List<Merchandise> arr = new ArrayList<>();

    public Merchandise(String itemCode, int quantity, double unitPrice) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getunitprice()
    {
        return this.unitPrice;
    }

    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length == 3) {
                    String itemCode = tokens[0];
                    int quantity = Integer.parseInt(tokens[1]);
                    double unitPrice = Double.parseDouble(tokens[2]);

                    arr.add(new Merchandise(itemCode, quantity, unitPrice));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            System.out.println("Done execution");
        }
    }

    public void displayItems() {
        for (Merchandise item : arr) {
            System.out.println("Item Code: " + item.itemCode +
                    ", Quantity: " + item.quantity +
                    ", Unit Price: " + item.unitPrice);
        }
    }

    @Override
    public int compareTo(Merchandise m) {
        return this.itemCode.compareTo(m.itemCode);
    }
}
