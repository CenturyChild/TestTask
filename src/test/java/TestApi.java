import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.text.ParseException;


import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * Created by CenturyChild on 11.05.2016.
 */
public class TestApi {

    String toCurrency, fromCurrency;

    String rub = "{\"code\":643,\"name\":\"RUB\"}";
    String eur = "{\"code\":978,\"name\":\"EUR\"}";
    String usd = "{\"code\":840,\"name\":\"USD\"}";
    String gbp = "{\"code\":826,\"name\":\"GBP\"}";

    @Test
    public void testCodeNameMapping() throws FileNotFoundException, ParseException {
        JSONObject jsonObject = new JSONObject(Main.getData());
        JSONObject payload = jsonObject.getJSONObject("payload");
        JSONArray jsonArray = payload.getJSONArray("rates");
                                                                            //Parsing JSON
        for (int i = 0; i < jsonArray.length(); i++) {

            toCurrency = jsonArray.getJSONObject(i).getJSONObject("toCurrency").toString();
            fromCurrency = jsonArray.getJSONObject(i).getJSONObject("fromCurrency").toString();


                                                                            //Checking toCurrency object
            if (toCurrency.contains("\"code\":643")) {
                assertEquals(rub, toCurrency);
            } else if (toCurrency.contains("\"code\":826")) {
                assertEquals(gbp, toCurrency);
            } else if (toCurrency.contains("\"code\":978")) {
                assertEquals(eur, toCurrency);
            } else if (toCurrency.contains("\"code\":840")) {
                assertEquals(usd, toCurrency);
            } else {
                fail("Unexpected currency detected" + " " + toCurrency);
            }
                                                                            //Checking fromCurrency object
            if (fromCurrency.contains("\"code\":643")) {
                assertEquals(rub, fromCurrency);
            } else if (fromCurrency.contains("\"code\":826")) {
                assertEquals(gbp, fromCurrency);
            } else if (fromCurrency.contains("\"code\":978")) {
                assertEquals(eur, fromCurrency);
            } else if (fromCurrency.contains("\"code\":840")) {
                assertEquals(usd, fromCurrency);
            } else {
                fail("Unexpected currency detected" + " " + fromCurrency);
            }
        }
    }
}
