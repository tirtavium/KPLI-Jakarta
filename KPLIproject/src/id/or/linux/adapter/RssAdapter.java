package id.or.linux.adapter;



import ir.or.linux.jakarta.R;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import or.id.linux.jakarta.item.RssItem;

public class RssAdapter extends BaseAdapter{
private Context context;
private int viewHolder;
private LayoutInflater inflater;

private List<RssItem> rssList;

	public RssAdapter(Context context, int viewHolder, List<RssItem> rssList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.viewHolder = viewHolder;
		this.rssList = rssList;
		
		inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	
	}



	public int getCount() {
		// TODO Auto-generated method stub
		return rssList.size();				
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return rssList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		RssItem item = rssList.get(position);
		if (convertView == null){
			convertView = inflater.inflate(this.viewHolder, null);
		}
		TextView title = (TextView) convertView.findViewById(R.id.title);
	
		WebView description = (WebView) convertView.findViewById(R.id.description);
		description.setBackgroundColor(0x00000000);
		
		description.setFocusable(false);
		description.setClickable(false);
		description.getSettings().setTextSize(WebSettings.TextSize.SMALLER);
		String desc = item.getDescription();
		title.setText(item.getTitle());	

		desc = "<html><body><p align='justify'>"+Html.fromHtml(desc).toString()+"</p><a href='"+item.getLink()+"'>More >></a></body></html>";
		description.loadData(desc, "text/html", "utf-8");
		description.setClickable(true);
		return convertView;
		
	
	}
	
	

	
	
}
