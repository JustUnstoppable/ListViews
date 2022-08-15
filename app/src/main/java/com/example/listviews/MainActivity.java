package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvlist=(ListView)findViewById(R.id.lvlist);
        ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
        MyCustomAdapter myadapter;

        //add data and view it
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(2,"tester"," develop apps"));
        listnewsData.add(new AdapterItems(3,"admin"," develop apps"));
        listnewsData.add(new AdapterItems(4,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(5,"tester"," develop apps"));
        listnewsData.add(new AdapterItems(6,"admin"," develop apps"));
        myadapter=new MyCustomAdapter(listnewsData);
        lvlist.setAdapter(myadapter);
    }
    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItems>  listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            @SuppressLint("ViewHolder") View myView = mInflater.inflate(R.layout.layout_ticket,null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView tvID=( TextView) myView.findViewById(R.id.tvID);
            tvID.setText(new StringBuilder().append("ID").append(s.ID).toString());
            TextView tvTitle=( TextView) myView.findViewById(R.id.tvTitle);
            tvTitle.setText(s.JobTitle);
            TextView tvDesc=( TextView) myView.findViewById(R.id.tvDesc);
            tvDesc.setText(s.Description);



            return myView;
        }

    }
}