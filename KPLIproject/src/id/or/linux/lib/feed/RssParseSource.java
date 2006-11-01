package id.or.linux.lib.feed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.net.ParseException;

import or.id.linux.jakarta.item.AgendaItem;
import or.id.linux.jakarta.item.RssItem;


public class RssParseSource {
/*
	private String url;
	private  String sourceData;

	private  List<RssItem> listRss;
*/	
	public RssParseSource() {
		// TODO Auto-generated constructor stub
/*		super();
		this.url = null;
		this.sourceData = null;
		this.listRss = new ArrayList<RssItem>(); 
*/		
	}
/*	
	public String getSource() throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(this.url);
		HttpResponse respone = client.execute(request);
		String responeBody = EntityUtils.toString(respone.getEntity());
		return responeBody;
	}
	
	
	public List<RssItem> readFromRssUrl(String url) {
		this.url = url;
		listRss.clear();
	
		try {
			sourceData = getSource();
			parseSource();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRss;
	}
	
	
	*/
	
	
	
	
	
	public void parseSource(){
		String[] parts, parts2,parts3 ,temp;
		
		parts = EveryFeed.getSourceData().split("<item>");
		if (parts.length<2) return;
		for (int i=1; i<parts.length; i++) {
			RssItem item = new RssItem();
			
			parts2 = parts[i].split("</item>");
			
			// get title
			parts3 = parts2[0].split("<title>");
			temp = parts3[1].split("</title>");
			item.setTitle(temp[0]);
			
			// get link
			parts3 = parts2[0].split("<link>");
			temp = parts3[1].split("</link>");
			item.setLink(temp[0]);
			
			// get description
			parts3 = parts2[0].split("<description>");
			temp = parts3[1].split("</description>");
			item.setDescription(temp[0]);
			
			EveryFeed.getListRss().add(item);
		
	}


}
}