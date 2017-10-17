package br.com.hammersoft.net.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public final class HttpURLConnector {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final int BUFFER_SIZE = 4096;

	public static void main(String[] args) throws Exception {
		System.out.println("Testing 1 - Send Http GET request");
		HttpURLConnector.sendGet("http://www.google.com/search?q=mkyong");

		System.out.println("\nTesting 2 - Send Http POST request");
		HttpURLConnector.sendPost("https://selfsolve.apple.com/wcResults.do");

	}

	// HTTP GET request
	public static String sendGet(String url) throws IOException {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		return response.toString();
	}
	
	public String parseUrlForFileName(String url){
		String[] parts = url.split("/");
		String filename = parts[parts.length - 2] + "." + parts[parts.length - 1];
		return filename;
	}

	// HTTP POST request
	public static String sendPost(String url) throws IOException {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
	
	private boolean cancel = false;
	
	public void cancelDownload(){
		this.cancel = true;
	}
	
	public void downloadFile(String fileURL, String saveAs, IDownloadProgressListener listener)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
            listener.started(contentLength);
 
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + saveAs);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveAs);
 
            int bytesRead = -1;
            float bytesTotalRead = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1 && !cancel) {
            	bytesTotalRead += bytesRead;
            	float percentage = (bytesTotalRead/contentLength)*100;
                outputStream.write(buffer, 0, bytesRead);
                listener.updated(Math.round(percentage));
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
}