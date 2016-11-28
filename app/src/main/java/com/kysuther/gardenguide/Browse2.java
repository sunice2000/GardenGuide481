package com.kysuther.gardenguide;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Browse2 extends AppCompatActivity {

    private LinearLayout llContainer;
    private EditText etSearch;
    private ListView lvPlantss;

    private ArrayList<Plants> mPlantsArrayList = new ArrayList<Plants>();
    private MyAdapter adapter1;
    ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        initialize();



        // Add Text Change Listener to EditText
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter1.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void initialize() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        lvPlantss = (ListView)findViewById(R.id.lvPlantss);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        mPlantsArrayList.add(new Plants("Abelia", R.drawable.abelia));
        mPlantsArrayList.add(new Plants("Abeliophyllum", R.drawable.abeliophyllum));
        mPlantsArrayList.add(new Plants("Abelmoschus", R.drawable.abelmoschus));
        mPlantsArrayList.add(new Plants("Abies", R.drawable.abies));
        mPlantsArrayList.add(new Plants("Abroma", R.drawable.abroma));
        mPlantsArrayList.add(new Plants("Abromeitiella", R.drawable.abromeitiella));
        mPlantsArrayList.add(new Plants("Abronia", R.drawable.abronia));
        mPlantsArrayList.add(new Plants("Abrus", R.drawable.abrus));
        mPlantsArrayList.add(new Plants("Abutilon", R.drawable.abutilon));
        mPlantsArrayList.add(new Plants("Acacia", R.drawable.acacia));
        mPlantsArrayList.add(new Plants("Ramonda", R.drawable.ramonda));
        mPlantsArrayList.add(new Plants("Ranunculus", R.drawable.ranunculus));
        mPlantsArrayList.add(new Plants("Ranzania", R.drawable.ranzania));
        mPlantsArrayList.add(new Plants("Raoulia", R.drawable.raoulia));
        mPlantsArrayList.add(new Plants("Raphia", R.drawable.raphia));
        mPlantsArrayList.add(new Plants("Ratibida", R.drawable.ratibida));
        mPlantsArrayList.add(new Plants("Ravenala", R.drawable.ravenala));
        mPlantsArrayList.add(new Plants("Rebutia", R.drawable.rebutia));
        mPlantsArrayList.add(new Plants("Rehderodendron", R.drawable.rehderodendron));
        mPlantsArrayList.add(new Plants("Rehmannia", R.drawable.rehmannia));
        mPlantsArrayList.add(new Plants("Robinia", R.drawable.robinia));
        mPlantsArrayList.add(new Plants("Rochea", R.drawable.rochea));
        mPlantsArrayList.add(new Plants("Rodgersia", R.drawable.rodgersia));
        mPlantsArrayList.add(new Plants("Rodriguezia", R.drawable.rodriguezia));
        mPlantsArrayList.add(new Plants("Rohdea", R.drawable.rohdea));
        mPlantsArrayList.add(new Plants("Romanzoffia", R.drawable.romanzoffia));
        mPlantsArrayList.add(new Plants("Romneya", R.drawable.romneya));
        mPlantsArrayList.add(new Plants("Romulea", R.drawable.romulea));
        mPlantsArrayList.add(new Plants("Rondeletia", R.drawable.rondeletia));
        mPlantsArrayList.add(new Plants("Roscoea", R.drawable.roscoea));
        mPlantsArrayList.add(new Plants("Rose", R.drawable.rose));
        mPlantsArrayList.add(new Plants("Rosemary", R.drawable.rosemary));
        mPlantsArrayList.add(new Plants("Rossioglossum", R.drawable.rossioglossum));


        adapter1 = new MyAdapter(Browse2.this, mPlantsArrayList);
        lvPlantss.setAdapter(adapter1);
    }


    // Adapter Class
    public class MyAdapter extends BaseAdapter implements Filterable {

        private ArrayList<Plants> mOriginalValues; // Original Values
        private ArrayList<Plants> mDisplayedValues;    // Values to be displayed
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<Plants> mPlantsArrayList) {
            this.mOriginalValues = mPlantsArrayList;
            this.mDisplayedValues = mPlantsArrayList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mDisplayedValues.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            LinearLayout llContainer;
            TextView plantName,plantImage;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder2 holder = null;

            if (convertView == null) {

                holder = new ViewHolder2();
                convertView = inflater.inflate(R.layout.row, null);
                holder.container = (LinearLayout)convertView.findViewById(R.id.llContainer);
                holder.text = (TextView) convertView.findViewById(R.id.plantName);
                holder.icon = (ImageView) convertView.findViewById(R.id.plantImage);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder2) convertView.getTag();
            }
            holder.text.setText(mDisplayedValues.get(position).name);
            holder.icon.setImageResource(mDisplayedValues.get(position).plant);

            holder.container.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Toast.makeText(Browse2.this, mDisplayedValues.get(position).name, Toast.LENGTH_SHORT).show();
                    if((mDisplayedValues.get(position).name) == "Rose") {
                        Intent intent = new Intent(Browse2.this, Rose2.class);
                        startActivity(intent);
                    }
                }
            });

            return convertView;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint,Filter.FilterResults results) {

                    mDisplayedValues = (ArrayList<Plants>) results.values; // has the filtered values
                    notifyDataSetChanged();  // notifies the data with new filtered values
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                    ArrayList<Plants> FilteredArrList = new ArrayList<Plants>();

                    if (mOriginalValues == null) {
                        mOriginalValues = new ArrayList<Plants>(mDisplayedValues); // saves the original data in mOriginalValues
                    }

                    /********
                     *
                     *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                     *  else does the Filtering and returns FilteredArrList(Filtered)
                     *
                     ********/
                    if (constraint == null || constraint.length() == 0) {

                        // set the Original result to return
                        results.count = mOriginalValues.size();
                        results.values = mOriginalValues;
                    } else {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < mOriginalValues.size(); i++) {
                            String data = mOriginalValues.get(i).name;
                            if (data.toLowerCase().startsWith(constraint.toString())) {
                                FilteredArrList.add(new Plants(mOriginalValues.get(i).name,mOriginalValues.get(i).plant));
                            }
                        }
                        // set the Filtered result to return
                        results.count = FilteredArrList.size();
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
            return filter;
        }
    }
}

class ViewHolder4 {
    TextView text;
    TextView timestamp;
    ImageView icon;
    LinearLayout container;
    int position;
}

class MyViewHolder3
{
    ImageView imageView;
    TextView textView;

    MyViewHolder3(View v)
    {
        textView=(TextView)v.findViewById(R.id.textView);
        imageView=(ImageView)v.findViewById(R.id.imageView);
    }
}
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}

*/