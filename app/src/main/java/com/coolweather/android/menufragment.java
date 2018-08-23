package com.coolweather.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class menufragment extends Fragment {
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private List<String> dataList = new ArrayList<>();
    private Button back_button;
    public DrawerLayout drawerLayout;
    Intent introdution_intent;
    Intent C_manager_intent;
    private String Array[]={"城市定位","分享","城市管理","设置","关于作者"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menufragment,container,false);
        listView=(ListView) view.findViewById(R.id.menu_list_view);
        back_button=(Button)view.findViewById(R.id.back_button1);

        adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        introdution_intent=new Intent(getActivity(),devoloper_introdution.class);
        C_manager_intent=new Intent(getActivity(),city_manager.class);

        return view;
    }

  //  @Override
  //  public void onCreate(@Nullable Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    drawerLayout = (DrawerLayout) drawerLayout.findViewById(R.id.drawer_layout);
   // }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for(int i=0;i<Array.length;++i)
        {
            dataList.add(Array[i]);
        }
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {

                switch (position)
                {
                    case 0:
                        Toast.makeText(getActivity(),Array[position],Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(),Array[position],Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        startActivity(C_manager_intent);
                        //Toast.makeText(getActivity(),Array[position],Toast.LENGTH_LONG).show();
                        break;
                    case  3:
                        Toast.makeText(getActivity(),Array[position],Toast.LENGTH_LONG).show();
                        break;
                    case  4:
                        startActivity(introdution_intent);
                       // Toast.makeText(getActivity(),Array[position],Toast.LENGTH_LONG).show();
                        break;
                }


            }
        });

    }

}
