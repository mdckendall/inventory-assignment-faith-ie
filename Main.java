import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

class Main {
    public static void main(String[] args) {
        String name;
        String serialNumber;
        int value;
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        int cont;
        Scanner scanner = new Scanner(System.in);
        do {
            out.println("Press 1 to add an item.\nPress 2 to delete an item.\nPress 3 to update an item.\nPress 4 to show all items.\nPress 5 to quit the program.");
            cont = scanner.nextInt();
            scanner.nextLine();
            switch (cont) {
                case 1:
                    out.println("Enter the name:");
                    name = scanner.nextLine();
                    out.println("Enter the serial number:");
                    serialNumber = scanner.nextLine();
                    out.println("Enter the value in dollars (whole number):");
                    value = scanner.nextInt();
                    scanner.nextLine();
                    Inventory inv = new Inventory(name, serialNumber, value);
                    inventoryArrayList.add(inv);
                    break;
                case 2:
                    out.println("Enter the serial number of the item to delete:");
                    serialNumber = scanner.nextLine();
                    ArrayList<Inventory> a = new ArrayList<>();
                    for (Inventory i : inventoryArrayList) {
                        if (i._serialNumber.equalsIgnoreCase(serialNumber)) {
                            a.add(i);
                        }
                        if (!i._serialNumber.equalsIgnoreCase(serialNumber)) {
                            out.println("Could not find serial number in the database.");
                        }
                    }
                    try {
                        inventoryArrayList.removeAll(a);
                        out.println("Done. Removed " + a.size() + " items.");
                    } catch (NullPointerException e) {
                        out.println(e.getMessage());
                    }
                    break;

                case 4:
                    for (Inventory i : inventoryArrayList) {
                        out.println(i._name + "," + i._serialNumber + "," + i._value);
                    }
            }
        } while (cont != 5);
    }

    static class Inventory {
        String _name;
        String _serialNumber;
        int _value;

        public Inventory(String Name, String SerialNumber, int Value) {
            this._name = Name;
            this._serialNumber = SerialNumber;
            this._value = Value;
        }
    }
}