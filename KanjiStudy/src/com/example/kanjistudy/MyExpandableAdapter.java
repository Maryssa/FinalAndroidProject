package com.example.kanjistudy;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableAdapter extends BaseExpandableListAdapter {
	private Activity activity;
	private ArrayList<Object> chapterOptions;
	private LayoutInflater inflater;
	private ArrayList<String> chapters, options;
	
	public MyExpandableAdapter(ArrayList<String> parents, ArrayList<Object> children)
	{
		this.chapters = parents;
		this.chapterOptions = children;
	}
	
	public void setInflater(LayoutInflater inflater, Activity activity)
	{
		this.inflater=inflater;
		this.activity=activity;
	}
	
	@Override
	public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
	{
		options = (ArrayList<String>)chapterOptions.get(groupPosition);
		TextView textView = null;
		if(convertView == null)
		{
			convertView = inflater.inflate(R.layout.study_option,null);
			
		}
		
		textView = (TextView)convertView.findViewById(R.id.study_options);
		textView.setText(options.get(childPosition));
		
		convertView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				Toast.makeText(activity, options.get(childPosition), Toast.LENGTH_SHORT).show();
			}
		});
		return convertView;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
	{
		if(convertView == null)
		{
			convertView = inflater.inflate(R.layout.chapter_select, null);
		}
		
		((CheckedTextView) convertView).setText(chapters.get(groupPosition));
		((CheckedTextView) convertView).setChecked(isExpanded);
		
		return convertView;
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition)
	{
		return 0;
	}
	
	@Override
	public int getChildrenCount(int groupPosition)
	{
		return ((ArrayList<String>)chapterOptions.get(groupPosition)).size();
	}
	
	@Override
	public Object getGroup(int groupPosition)
	{
		return null;
	}
	
	@Override
	public int getGroupCount()
	{
		return chapters.size();
	}
	
	@Override
	public void onGroupCollapsed(int groupPosition)
	{
		super.onGroupCollapsed(groupPosition);
	}
	
	@Override
	public long getGroupId(int groupPosition)
	{
		return 0;
	}
	
	@Override
	public boolean hasStableIds()
	{
		return false;
	}
	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{
		return false;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}
}
