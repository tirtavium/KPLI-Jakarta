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

public class EveryFeed {
	private String url;
	private static String sourceData;
	private static SimpleDateFormat dateFormat;
	private static List<AgendaItem> listAgenda ;
	private static List<RssItem> listRss;
	
	
	
	public static List<RssItem> getListRss() {
		return listRss;
	}


	public static void setListRss(List<RssItem> listRss) {
		EveryFeed.listRss = listRss;
	}


	public static SimpleDateFormat getDateFormat() {
		return dateFormat;
	}


	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}


	public static String getSourceData() {
		return sourceData;
	}


	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}


	public static List<AgendaItem> getListAgenda() {
		return listAgenda;
	}


	public void setListAgenda(List<AgendaItem> listAgenda) {
		this.listAgenda = listAgenda;
	}


	public EveryFeed() {
		// TODO Auto-generated constructor stub
	super();
		this.url = null;
		this.sourceData = null;
		this.listAgenda = new ArrayList<AgendaItem>();
		this.dateFormat = new SimpleDateFormat("dd MMM yyyy");
		this.listRss = new ArrayList<RssItem>();
	
	}
	
	
	public String getSource() throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(this.url);
		HttpResponse respone = client.execute(request);
		String responeBody = EntityUtils.toString(respone.getEntity());
		return responeBody;
	}
	
	public List<AgendaItem> readFromUrl(String url){
		this.url = url;
		listAgenda.clear();
		AgendaParseSource parseS = new AgendaParseSource();
		
		try {
			sourceData = getSource();
			
				parseS.parseSource();	
			
			
			
			
		}catch (ParseException E){
			E.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listAgenda;
	}
	
	public List<RssItem> readFromRssUrl(String url) {
		this.url = url;
		listRss.clear();
		RssParseSource parseR = new RssParseSource();
		try {
			sourceData = getSource();
			parseR.parseSource();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRss;
	}
	
	

}
