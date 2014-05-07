package com.example.kanjistudy;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

public class ExpandableChapterSelect extends ExpandableListActivity {
	
	private ArrayList<String> chapters = new ArrayList<String>();
	private ArrayList<Object> vocabOrKanji = new ArrayList<Object>();
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		ExpandableListView expandableList = getExpandableListView();
		expandableList.setDividerHeight(3);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);
		
		setChapters();
		setChapterOptions();
		
		MyExpandableAdapter adapter = new MyExpandableAdapter(chapters, vocabOrKanji);
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener(this);
	}
	
	public void setChapters()
	{
		for(int i = 1; i <= 12; i++)
			chapters.add("Chapter " + i);
	}
	
	public void setChapterOptions()
	{
		ArrayList<String> options = new ArrayList<String>();
		options.add("Kanji");
		options.add("Vocabulary");
		
		for(int i = 1; i <=12; i++)
		{
			vocabOrKanji.add(options);
		}
	}
	

}
