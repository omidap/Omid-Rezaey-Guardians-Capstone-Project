package tek.sdet.framework.utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataProvider {

    public static String dataProvider(String provider) {

        Random rand = new Random();
        Faker fake = new Faker();

        String data = "";

        if (provider.equalsIgnoreCase("country")) {
            data = "United States";
        } else if (provider.equalsIgnoreCase("fullName")) {
            data = fake.name().fullName();
        } else if (provider.equalsIgnoreCase("phone")) {
            data = fake.phoneNumber().cellPhone();
        } else if (provider.equalsIgnoreCase("street")) {
            data = fake.address().streetAddress();
        } else if (provider.equalsIgnoreCase("apt")) {
            data = fake.address().secondaryAddress();
        } else if (provider.equalsIgnoreCase("city")) {
            data = fake.address().city();
        } else if (provider.equalsIgnoreCase("state")) {
            data = fake.address().state();
        } else if (provider.equalsIgnoreCase("zipCode")) {
            data = fake.address().zipCode().substring(0, 5);
        } else if (provider.equalsIgnoreCase("firstName")) {
            data = fake.name().firstName();
        } else if (provider.equalsIgnoreCase("email")) {
            data = fake.name().lastName() + "2050@gmail.com";
        } else if (provider.equalsIgnoreCase("debit")) {
            data = fake.number().digits(16);
        } else if (provider.equalsIgnoreCase("expMonth")) {
            int min = 1;
            int max = 12;
            int result = rand.nextInt(max - min) + min;
            data = String.valueOf(result);
        } else if (provider.equalsIgnoreCase("expYear")) {
            int min = 2025;
            int max = 2030;
            int result = rand.nextInt(max - min) + min;
            data = String.valueOf(result);
        } else if (provider.equalsIgnoreCase("CCV")) {
            int result = 0;
            for (int i = 0; i < 2; i++) {
                result = result * 10 + rand.nextInt(100);
            }
            data = String.valueOf(result);
        } else if (provider.equalsIgnoreCase("NameOnCard")) {
            String[] arr = {"Guardian", "Visa", "Platinum",
                    "Discovery", "Urgent", "Master", "ATM"};
            data = arr[rand.nextInt(arr.length)];
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(dataProvider("CCV"));
    }
}
