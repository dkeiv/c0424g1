import phone.AuthenticPhone;
import phone.HandGoodPhone;
import phone.Phone;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    private final List<Phone> phones;

    public PhoneManager() {
        this.phones = new ArrayList<Phone>();
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    public int getMaxId() {
        if(this.phones.isEmpty()) {
            return 1;
        }
        Phone phone = this.phones.get(phones.size() - 1);
        return phone.getId() + 1;
    }

    public void removePhone(Phone phone) {
        this.phones.remove(phone);
    }

    public Phone getPhone(int id) {
        Phone returnedPhone = null;
        for(Phone phone : asCollection()) {
            if(phone.getId() == id) {
                returnedPhone = phone;
            }
        }

        return returnedPhone;
    }

    public void isValidQuantity(int quantity) throws Exception {
        if (quantity < 0) {
            throw new Exception("Invalid quantity");
        }
    }

    public void isValidType(String type) throws Exception {
        if (!type.equals("authentic") && !type.equals("hand good")) {
            throw new Exception("Invalid type");
        }
    }

    public void isValidPrice(double price) throws Exception {
        if (price < 0) {
            throw new Exception("Invalid price");
        }
    }

    public void isValidInsuranceDay(int insuranceDay) throws Exception {
        int minInsuranceDay = 0;
        int maxInsuranceDay = 730;
        if (insuranceDay < minInsuranceDay || insuranceDay > maxInsuranceDay) {
            throw new Exception("Invalid insurance day");
        }
    }

    public void isValidScope(String scope) throws Exception {
        String local = "Toan Quoc";
        String global = "Quoc Te";
        if (!scope.equals(global) && !scope.equals(local)) {
            throw new Exception("Invalid scope");
        }
    }

    public void isValidCountry(String country) throws Exception {
        String banned = "Viet Nam";
        if (country.equals(banned)) {
            throw new Exception("Invalid country");
        }
    }

    public void isValidStatus(String status) throws Exception {
        String[] validStatus = {"Da sua chua", "Chua sua chua"};
        if (!status.equals(validStatus[0]) && !status.equals(validStatus[1])) {
            throw new Exception("Invalid status");
        }
    }

    public List<Phone> searchByName(String name) {
        List<Phone> result = new ArrayList<>();
        for(Phone phone : asCollection()) {
            if(phone.getName().contains(name)) {
                result.add(phone);
            }
        }
        return result;
    }

    public List<Phone> asCollection() {
        return this.phones;
    }

    public void saveAuthentic() {
        try {
            String fileName = "src\\data\\authentic.csv";
            FileWriter myWriter = new FileWriter(fileName);
            for (Phone phone : this.asCollection()) {
                if (phone instanceof AuthenticPhone) {
                    myWriter.write(phone.toCSVLine() + "\n");
                }
            }
            myWriter.close();

        } catch (Exception e) {
            System.out.println("Exception in saving to file: " + e.getMessage());
//            e.printStackTrace();
        }
    }

    public void saveHandGood() {
        try {
            String fileName = "src\\data\\handgood.csv";
            FileWriter myWriter = new FileWriter(fileName);
            for (Phone phone : this.asCollection()) {
                if (phone instanceof HandGoodPhone) {
                    myWriter.write(phone.toCSVLine() + "\n");
                }
            }
            myWriter.close();

        } catch (Exception e) {
            System.out.println("Exception in saving to file: " + e.getMessage());
//            e.printStackTrace();
        }
    }

    public void loadAuthentic() {
        try {
            String fileName = "src\\data\\authentic.csv";
            ArrayList<String[]> buffer = new ArrayList<>();
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                buffer.add(line);
            }

            reader.close();

            for (String[] line : buffer) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                double price = Double.parseDouble(line[2]);
                int quantity = Integer.parseInt(line[3]);
                String manufacturer = line[4];
                int insuranceDay = Integer.parseInt(line[5]);
                String scope = line[6];

                Phone phone = new AuthenticPhone(id, name, price, quantity, manufacturer, insuranceDay, scope);
                this.addPhone(phone);
            }

        } catch (Exception e) {
            System.out.println("Exception in loading from file: " + e.getMessage());
        }
    }

    public void loadHandleGood() {
        try {
            String fileName = "data\\handgood.csv";
            ArrayList<String[]> buffer = new ArrayList<>();
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                buffer.add(line);
            }

            reader.close();

            for (String[] line : buffer) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                double price = Double.parseDouble(line[2]);
                int quantity = Integer.parseInt(line[3]);
                String manufacturer = line[4];
                String country = line[5];
                String status = line[6];

                Phone phone = new HandGoodPhone(id, name, price, quantity, manufacturer, country, status);
                this.addPhone(phone);
            }

        } catch (Exception e) {
            System.out.println("Exception in loading from file: " + e.getMessage());
        }
    }
}
