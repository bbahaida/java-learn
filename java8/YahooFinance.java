import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
//START:CLASS
public class YahooFinance {
	private static final String API_KEY = "87T37WI5P73KOUTU";
  public static double getPriceOrig(final String ticker) {
    try {
      final URL url = 
		//new URL( "http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
        //new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + ticker + "&f=nsl1op&e=.csv");
        new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+ticker+"&apikey="+API_KEY+"&datatype=csv");
		
		//System.out.println("Accesing: " + url);
      Thread.sleep(1000);
      final BufferedReader reader = 
        new BufferedReader(new InputStreamReader(url.openStream()));
      final String data = reader.lines().skip(1).limit(1).findFirst().get();
      final String[] dataItems = data.split(",");
      return Double.parseDouble(dataItems[dataItems.length - 1]);      
      //return 12.22;
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  
//    try {
//      Thread.sleep(1000);
//    } catch(Exception ex) {}
//    return Math.random() * 1000;
  }
  
  public static double getPriceMock(final String ticker) {
		return prices.get(ticker);
	}

	public static double getPrice(final String ticker, boolean useMock) {
//		try {
//			Thread.sleep(1000);
//		} catch (Exception ex) {
//		}
		return useMock ? getPriceMock(ticker) : getPriceOrig(ticker);
}
  
  @SuppressWarnings("serial")
	static Map<String, Double> prices = new HashMap<String, Double>() {
		{
			put("AMD", 3.28);
			put("HPQ", 35.92);
			put("IBM", 189.36);
			put("TXN", 46.94);
			put("VMW", 92.98);
			put("XRX", 13.09);
			put("AAPL", 100.8);
			put("ADBE", 67.99);
			put("AMZN", 322.7);
			put("CRAY", 25.92);
			put("CSCO", 24.66);
			put("SNE", 17.79);
			put("GOOG", 572.5);
			put("INTC", 34.27);
			put("INTU", 83.8);
			put("MSFT", 46.78);
			put("ORCL", 39.02);
			put("TIBX", 23.44);
			put("VRSN", 56.13);
			put("YHOO", 41.08);
		}
};
  
}
//END:CLASS
