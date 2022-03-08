package org.unosquare.shopping;
import java.io.*;

public class Main {

    public static void main(String[] args)
            throws IOException {
        ShoppingList myList = new ShoppingList();
        ShoppingCart myCart = new ShoppingCart();
        myCart.setShoppingList(myList);
        String commandQuit = "";
        do {
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String name = reader.readLine();

            // Printing the read line

            String product = "";
            String command = "";
            String value = "";
            int blankSpaceCounter = 0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == ' ' && blankSpaceCounter == 0) {
                    blankSpaceCounter++;
                }
                if (blankSpaceCounter == 0 && name.charAt(i) != ' ') {
                    command = command + name.charAt(i);
                }


                if (name.charAt(i) == ' ' && blankSpaceCounter == 1 && product != "") {
                    blankSpaceCounter++;
                }
                if (name.charAt(i) != ' ' && blankSpaceCounter == 1) {
                    product = product + name.charAt(i);
                }

                if (name.charAt(i) != ' ' && blankSpaceCounter == 2) {
                    value = value + name.charAt(i);
                }


            }
            System.out.println("COMMANDO ->" + command + "---");
            System.out.println("PRDUCTO ->" + product + "---");
            System.out.println("VALOR ->" + value + "---");
            double newVal = 1;
            commandQuit=command;
            switch (command) {
                case "add":
                   // System.out.println(command + " " + product + " " + newVal);
                    myList.addProduct(product, Integer.parseInt(value));
                    break;
                case "buy":
                  //  System.out.println(command + " " + product + " " + newVal);
                    myCart.addProductsToSet(product, Double.parseDouble(value));
                    break;
                case "remove":
               //     System.out.println(command + " " + product);
                    myList.deleteProduct(product);
                    break;
                case "return":
               //     System.out.println(command + " " + product);
                    myCart.removeProductFromSet(product);
                case "total":
                //    System.out.println(command + " " + product + " " + newVal);
                    myCart.showProductsInSet();
                    myCart.showPricingData();
                    break;
                default:
            }
        }while (commandQuit!="quit");
}
}

