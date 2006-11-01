package ir.or.linux.jakarta;

import id.or.linux.adapter.RssAdapter;

import id.or.linux.lib.feed.EveryFeed;

import java.util.List;


import or.id.linux.jakarta.item.RssItem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class RssMain extends Activity{
	final RssMain this_class =this;
	private ListView result;
	private List<RssItem> listResult;
	private RssAdapter adapter;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rsslist);
        result = (ListView) findViewById(R.id.listrss);
        result.setOnItemClickListener(new OnItemClickListener() {
        		public void onItemClick(AdapterView<?> arg0, View arg1, int posisition, long id){
        			Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(listResult.get(posisition).getLink()));
        			startActivity(browser);
        		}
		} );
    }
	
	public void onStart(){
		super.onStart();
		new GetRSSTask().execute();
	}
	
	public class GetRSSTask extends AsyncTask<Void, Void, Void >{

			ProgressDialog dialog;
			protected void onPreExecute(){
					dialog = ProgressDialog.show(this_class,"", "Harap Tunggu", true, true);
					dialog.setOnCancelListener(new OnCancelListener() {
						
						public void onCancel(DialogInterface dialog) {
							// TODO Auto-generated method stub
							GetRSSTask.this.cancel(true);
						}
					});
			}
			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				EveryFeed feed = new EveryFeed();
				listResult = feed.readFromRssUrl("http://linuxjak.web.id/main/rss.xml");
				return null;
				
				
			}
			protected void onPostExecute(Void unused){
				adapter = new RssAdapter(this_class,R.layout.rssitem, listResult);
				result.setAdapter(adapter);
				
				dialog.dismiss();
			
		}
		
		
		
	}
	

}
