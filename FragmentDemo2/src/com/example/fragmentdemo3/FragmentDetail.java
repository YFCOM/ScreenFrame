package com.example.fragmentdemo3;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 详情Fragment
 * 
 *
 */
public class FragmentDetail extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_detail_layout, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		//获取列表传来的参数
		Bundle bundle = getArguments();
		String date = bundle.getString("arg");
		
		List<String> list = new ArrayList<String>();
		for(int i=0, count=20; i<count; i++){
			list.add(date);
		}
		
		LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.detail_container);
		
		ListView listView = (ListView) getActivity().findViewById(R.id.fragment_detail);
		listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list));
		
		Configuration configuration = getActivity().getResources().getConfiguration();
		int ori = configuration.orientation;
	
	}

}
