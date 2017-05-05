import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ranking {

	public Ranking(){
		// TODO Auto-generated method stub
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		try {
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			Document doc = Jsoup.connect("https://www.tiobe.com/tiobe-index/").get();
			Elements tables = doc.getElementsByClass("table");
			Element table = tables.get(0);
			Elements tds = table.getElementsByTag("td");
			Elements trs = table.getElementsByTag("tr");
			File output=new File("output.txt");
			output.createNewFile();
			FileWriter outW=new FileWriter(output);
			BufferedWriter outBW=new BufferedWriter(outW);
			outBW.write("Rank\tProgramming Language\tRating");
			outBW.newLine();
			System.out.println("Rank\tProgramming Language\tRating");
			for (int t = 0; t <= tds.size() - 1; t=t+6)
				
			{

				String rank1 = tds.get(t).text();
				String rank2 = tds.get(t + 1).text();
				String proName = tds.get(t + 3).text();
				String ratings = tds.get(t + 4).text();
				String changes = tds.get(t + 5).text();
				Language l=new Language(rank1, proName, ratings);
				System.out.println(l.outputLanguage());
				outBW.write(l.outputLanguage());
				outBW.newLine();
			}
			outBW.close();
			outW.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}

}
