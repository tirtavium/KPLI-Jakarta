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

public class AgendaParseSource {
/*
	private String url;
	private  String sourceData;
	private  SimpleDateFormat dateFormat;
	private  List<AgendaItem> listAgenda ;
*/
	
	
	
	public AgendaParseSource() {
/*
		// TODO Auto-generated constructor stub
		super();
		this.url = null;
		this.sourceData = null;
		this.listAgenda = new ArrayList<AgendaItem>();
		this.dateFormat = new SimpleDateFormat("dd MMM yyyy");
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
	
	public List<AgendaItem> readFromUrl(String url){
		this.url = url;
		listAgenda.clear();
		
		
		try {
			sourceData = getSource();
			
		parseSource();
			
			
			
		}catch (ParseException E){
			E.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listAgenda;
	}

	*/
	
	 public void parseSource(){
		String[] parts, parts2, parts3, temp;
		
		parts = EveryFeed.getSourceData().split("<table>") ;
		if (parts.length <2 ) return;
		
		for (int i = 1; i < parts.length; i++ ){
			AgendaItem item = new AgendaItem();
			parts2 = parts[i].split("</table>");
			
			
			parts3 = parts2[0].split("<tr><td colspan=2><span class=tanggal>");
			temp = parts3[1].split("</span></td></tr>");
			
			item.setPublishDateString(temp[0]);
			try{
				item.setPublishDate(EveryFeed.getDateFormat().parse(temp[0]));
				
			}catch(java.text.ParseException e){
				e.printStackTrace();
			}


		// ambil judul
			parts3 = parts2[0].split("<tr><td colspan=2><span class=judul>");
			temp = parts3[1].split("</span></td></tr>");
			item.setJudul(temp[0]);
		
		// ambil topik
			
			parts3 = parts2[0].split("<tr><td valign=top><b>Topik</b>  </td><td> :");
			temp = parts3[1].split("</td></tr>");
			String benar = temp[0].replace("<p>", " ").replace("<br />", " ").replace("</p>", " ").replace("&nbsp;", " ");
			
			item.setTopik(benar);

			// ambil tanggal
			parts3 = parts2[0].split("<tr><td><b>Tanggal</b> </td><td> :");
			temp = parts3[1].split("</td></tr>");
			item.setTanggal("Tanggal  :"+temp[0]);
		 
			

			// ambil pukul
			parts3 = parts2[0].split("<tr><td><b>Pukul</b> </td><td> :");
			temp = parts3[1].split("</td></tr>");
			item.setPukul("Pukul      :"+temp[0]);

			// ambil tempat
			parts3 = parts2[0].split("<tr><td><b>Tempat</b> </td><td> :");
			
			temp = parts3[1].split("</td></tr>");
			item.setTempat("Tempat  :"+temp[0]);
				
			
			EveryFeed.getListAgenda().add(item);
			
			
			
		}
		
	}

}
