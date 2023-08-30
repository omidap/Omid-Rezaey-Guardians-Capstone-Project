package tek.sdet.framework.utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataProvider {

    static Random rand = new Random();

    static Faker fake = new Faker();

    public static String getCountry() {
        return "United States";
    }

    public static String getFullName() {
        return fake.name().fullName();
    }

    public static String getPhone() {
        return fake.phoneNumber().cellPhone();
    }

    public static String getStreet() {
        return fake.address().streetAddress();
    }

    public static String getApt() {
        return fake.address().secondaryAddress();
    }

    public static String getCity() {
        return fake.address().city();
    }

    public static String getState() {
        return fake.address().state();
    }

    public static String getZipCode() {
        return fake.address().zipCode().substring(0, 5);
    }

    public static String getFirstName() {
        return fake.name().firstName();
    }

    public static String getEmail() {
        return fake.name().lastName() + "33355@gmail.com";
    }

    public static String getDebit() {
        return fake.number().digits(16);
    }


    // to generate random numbers within specific range of values.
    public static int getYear() {
        int min = 2023;
        int max = 2030;
        return rand.nextInt(max - min) + min;
    }

    public static int getMonth() {
        int min = 1;
        int max = 12;
        return rand.nextInt(max - min) + min;
    }

    public static int getCCV() {
        return (int) (Math.random() * 1000);
    }

    public static void main(String[] args) {
        System.out.println(getCCV());
    }

}
