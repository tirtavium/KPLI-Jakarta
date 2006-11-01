package ir.or.linux.jakarta;



import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class KPLIprojectActivity extends TabActivity {
	
	TabHost tabHost;
	Intent intent1;
	Intent intent2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
   setTab();
     /*
        tabHost.getTabWidget().setBackgroundColor(0x00000000);
        
        
        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        
        
        intent = new Intent().setClass(this, RssMain.class);
      //  spec1 = tabHost.newTabSpec("RSS").setContent(intent).setIndicator(tabIndicator);
       spec1 = tabHost.newTabSpec("RSS").setContent(intent).setIndicator("RSS",res.getDrawable(R.drawable.tab_infos) );
        tabHost.addTab(spec1);
       
        intent = new Intent().setClass(this, AgendaMain.class);
        //spec2 = tabHost.newTabSpec("Agenda").setContent(intent).setIndicator(tabIndicator);
       spec2 = tabHost.newTabSpec("Agenda").setContent(intent).setIndicator("Agenda", res.getDrawable(R.drawable.tab_infos));
        tabHost.addTab(spec2);
        
        tabHost.setCurrentTab(0);

*/
    }
    
    
    private void setTab(){
    	tabHost = getTabHost();
    	intent1 = new Intent().setClass(this, AgendaMain.class); 
    	addTab(R.string.agenda, R.drawable.tab_infos, intent1);
    	
    	intent2 = new Intent().setClass(this, RssMain.class);
    	addTab(R.string.artikel, R.drawable.tab_infos, intent2);
    	
    	
    }
    
    void addTab(int labelId, int drawableId, Intent intent1){
 
    
		
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);		
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent1);
		tabHost.addTab(spec);
    	
    	
    }
    
    public void onDestroy(){
    	super.onDestroy();
    	Toast.makeText(getApplicationContext(), "Maju Terus Open Source Indonesia", 7).show();
    	finish();
    }
}