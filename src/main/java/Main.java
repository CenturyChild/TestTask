/**
 * Created by CenturyChild on 11.05.2016.
 */

import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Scanner;


public class Main {

    public static String getData() throws ParseException {
        String content = null;
        URLConnection connection;
        try {
            connection = new URL("https://www.tinkoff.ru/api/v1/currency_rates/").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return content;
    }
}