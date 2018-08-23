package com.coolweather.android;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.coolweather.android.db.my_city;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class city_manager extends Activity{
    private Button back_button;
   private Button plus_button;
   public DrawerLayout drawerLayout;
   private ListView listView;
   private List<my_city> my_cityList;
    private List<String> datalist = new ArrayList<>();
    private ArrayAdapter<String> adapter;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        back_button=(Button)findViewById(R.id.Cmanager_back_button);
        plus_button=(Button)findViewById(R.id.plus_button);
        listView=(ListView)findViewById(R.id.mycity_listview);
        my_cityList= DataSupport.findAll(my_city.class);
        for(my_city Mcity:my_cityList)
        {
            datalist.add(Mcity.getMy_citynamee());
        }
        adapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1, datalist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {


            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id)
            {



                return true;
            }
        });




     //   drawerLayout=(DrawerLayout) findViewById(R.id.mycitydrawer_layout);
        back_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               // drawerLayout.openDrawer(GravityCompat.START);
                replaceFragment(new ChoosemycityFragment());
            }

            private void replaceFragment(Fragment fragment)
            {
                android.app.FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.mycity_layout,fragment);
                transaction.commit();

            }
        });
    }
/*@RequiresApi(api = Build.VERSION_CODES.M)
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState)
  {
      View view = inflater.inflate(R.layout.activity_city_manager, container, false);
      back_button=(Button)findViewById(R.id.Cmanager_back_button);
      plus_button=(Button)findViewById(R.id.plus_button);
      listView=(ListView)findViewById(R.id.mycity_listview);
      my_cityList= DataSupport.findAll(my_city.class);
      for(my_city Mcity:my_cityList)
      {
          datalist.add(Mcity.getMy_citynamee());
      }
      adapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1, datalist);
      listView.setAdapter(adapter);
      back_button.setOnClickListener(new View.OnClickListener()
      {
          @Override
          public void onClick(View view)
          {
              finish();
          }
      });
      plus_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view)
          {
              // drawerLayout.openDrawer(GravityCompat.START);
              replaceFragment(new ChoosemycityFragment());
          }

          private void replaceFragment(Fragment fragment)
          {
              android.app.FragmentManager fragmentManager=getFragmentManager();
              FragmentTransaction transaction=fragmentManager.beginTransaction();
              transaction.replace(R.id.mycity_layout,fragment);
              transaction.commit();

          }
      });
      return view;

  }*/



}
