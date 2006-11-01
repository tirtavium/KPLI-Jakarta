package id.or.linux.adapter;

import ir.or.linux.jakarta.R;

import java.util.List;

import or.id.linux.jakarta.item.AgendaItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AgendaAdapter extends BaseAdapter {
	
	
	private Context context;
	private int viewHolder;
	private LayoutInflater inflater;
	private List<AgendaItem> agendaList;
	
	public AgendaAdapter(Context context, int viewHolder, List<AgendaItem> agendaList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.viewHolder = viewHolder;
		this.agendaList = agendaList;
		inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		
		
	}
	
	

	public int getCount() {
		// TODO Auto-generated method stub
		return agendaList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return agendaList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		AgendaItem  item = agendaList.get(position);
		if(convertView == null ){
			convertView = inflater.inflate(this.viewHolder , null);
		}
		TextView judul = (TextView) convertView.findViewById(R.id.judul);
		TextView topik = (TextView) convertView.findViewById(R.id.topik);
		TextView pukul = (TextView) convertView.findViewById(R.id.pukul);
		TextView tanggal = (TextView) convertView.findViewById(R.id.tanggal);
		TextView tempat = (TextView) convertView.findViewById(R.id.tempat);
		TextView pubdate = (TextView) convertView.findViewById(R.id.publishdate);
		
		judul.setText(item.getJudul());
		topik.setText(item.getTopik());
		pukul.setText(item.getPukul());
		tanggal.setText(item.getTanggal());
		tempat.setText(item.getTempat());
		pubdate.setText(item.getPublishDateString());
		
		return convertView;
	}
	
	public void clear(){
		agendaList.clear();
		this.notifyDataSetChanged();
	}
	

}
