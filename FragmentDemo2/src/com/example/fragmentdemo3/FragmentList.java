package com.example.fragmentdemo3;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * �б�Fragment
 *
 */
public class FragmentList extends Fragment {
	
	private List<String> mDataSourceList = new ArrayList<String>();
	private List<FragmentTransaction> mBackStackList = new ArrayList<FragmentTransaction>();


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_list_layout, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		//������ݵ�ListView
		for(int i=0, count=20; i<count; i++){
			mDataSourceList.add("�б�����" + i);
		}
		
		//�б�ҳ���ListView
		ListView listView = (ListView) getActivity().findViewById(R.id.fragment_list);
		listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mDataSourceList));
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//ʵ��������Fragment
				Fragment detailFragment = new FragmentDetail();
				
				//���б�ҳ�洫����Ҫ�Ĳ���������ҳ��
				Bundle mBundle = new Bundle();
				mBundle.putString("arg", mDataSourceList.get(position));
				detailFragment.setArguments(mBundle);
				
				final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				
				//�ж��ֻ��ĺ�����
				Configuration configuration = getActivity().getResources().getConfiguration();
				int ori = configuration.orientation;
				
				fragmentTransaction.replace(R.id.detail_container, detailFragment);
			
				if(ori == configuration.ORIENTATION_PORTRAIT){
					fragmentTransaction.addToBackStack(null);
				}
				
				fragmentTransaction.commit();
				
				
			}
		});
		
	}
	
	/**
	 * 
	 * @param msg
	 */
	private void showTost(String msg){
		Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
	}

}
