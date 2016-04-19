package com.example.interface_activity;

import java.util.ArrayList;
import java.util.List;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView Listview;
	private List<String> groupkey = new ArrayList<String>();
	private List<String> list = null;
	private List<String> titlelist = new ArrayList<String>();
	private List<String> iplist = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TitleActionBar();//自定义actionbar
		
		Listview = (ListView)findViewById(R.id.Listviewid);
		initData();
		MyAdapter adapter = new MyAdapter();
		Listview.setAdapter(adapter);
		Listview.setOnItemClickListener(new ItemClickListener());
	}
	class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, HomeActivity.class);
				startActivity(intent);
		}
	}
	
	public void TitleActionBar()
	{
		ActionBar Actionbar = getActionBar();
		Actionbar.setDisplayShowHomeEnabled(false);
		ActionBar.LayoutParams lp =new ActionBar.LayoutParams(
		          ActionBar.LayoutParams.MATCH_PARENT,
		          ActionBar.LayoutParams.MATCH_PARENT,
		          Gravity.CENTER);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View titleView = inflater.inflate(R.layout.title, null);
		Actionbar.setCustomView(titleView, lp);
		Actionbar.setDisplayShowHomeEnabled(false);
		Actionbar.setDisplayShowTitleEnabled(false);
		Actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		Actionbar.setDisplayShowCustomEnabled(true);
	}
	public void initData()
	{
		list = new ArrayList<String>();
		groupkey.add(" ");
		titlelist.add("本地文档");
		list.add(" ");
		list.addAll(titlelist);
		iplist.add("192.168.191.1");
		iplist.add("10.11.5.38");
		iplist.add("192.168.0.1");
		iplist.add("10.11.38.1");
		iplist.add("192.168.191.16");
		iplist.add("192.168.191.191");
		iplist.add("192.168.191.1");
		iplist.add("10.11.5.38");
		iplist.add("192.168.0.1");
		iplist.add("10.11.38.1");
		iplist.add("192.168.191.16");
		iplist.add("192.168.191.191");
		list.add(" ");
		list.addAll(iplist);
	}
	
	private class MyAdapter extends BaseAdapter{  
		  
        @Override  
        public int getCount() {  
            // TODO Auto-generated method stub  
            return list.size();  
        }  
  
        @Override  
        public Object getItem(int position) {  
            // TODO Auto-generated method stub  
            return list.get(position);  
        }  
  
        @Override  
        public long getItemId(int position) {  
            // TODO Auto-generated method stub  
            return position;  
        }  
        @Override  
        public boolean isEnabled(int position) {  
            // TODO Auto-generated method stub  
             if(groupkey.contains(getItem(position))){  
                 return false;  
             }  
             return super.isEnabled(position);  
        }  
        @Override  
        public View getView(int position, View convertView, ViewGroup parent) {  
            // TODO Auto-generated method stub  
            View view=convertView;  
            if(groupkey.contains(getItem(position))){  
                view=LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item_tag, null);  
            }else{  
                view=LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, null);  
            }  
            TextView text=(TextView) view.findViewById(R.id.group_list_item_text);  
            text.setText((CharSequence) getItem(position));  
            return view;  
        }  
          
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId())
		{
			case R.id.action_settings : 
				break;
		    default :
		    	break; 
		}
		return super.onOptionsItemSelected(item);
	}
}
