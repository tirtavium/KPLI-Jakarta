package ir.or.linux.jakarta;

import id.or.linux.adapter.AgendaAdapter;


import id.or.linux.lib.feed.EveryFeed;

import java.util.ArrayList;
import java.util.List;



import or.id.linux.jakarta.item.AgendaItem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

public class AgendaMain extends Activity {
	final AgendaMain this_class = this;
	private ListView result;
	private List<AgendaItem> resultList = new ArrayList<AgendaItem>();
	private AgendaAdapter adapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agendalist);
		result = (ListView) findViewById(R.id.listagenda);

	}

	public void onStart() {
		super.onStart();
		new GetSourceTask().execute();
	}

	public class GetSourceTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog dialog;

		protected void onPreExecute() {
			dialog = ProgressDialog.show(this_class, "", "harap tunggu", true,
					true);
			dialog.setOnCancelListener(new OnCancelListener() {

				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub

					GetSourceTask.this.cancel(true);

				}
			});
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			EveryFeed feed = new EveryFeed();
			resultList = feed
					.readFromUrl("http://linuxjak.web.id/main/semua-agenda.html");

			return null;
		}

		protected void onPostExecute(Void unused) {
			adapter = new AgendaAdapter(this_class,R.layout.agendaitem ,resultList);
			result.setAdapter(adapter);
			dialog.dismiss();
		}

	}
	

}
