package com.mtech.myapplication;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQActivity extends BaseActivity {

    private ExpandableListView expandableListView;
    private CustomAdapterFQA customAdapter;

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqactivity);


        // Toolbar setup
        setupToolbar("FAQ", true);

        expandableListView = findViewById(R.id.expandableListView_Id);

        // Prepare data
        prepareListData();

        // Set adapter
        customAdapter = new CustomAdapterFQA(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        // Add listeners
        setListeners();
    }

    private void prepareListData() {
        String[] headerArray = getResources().getStringArray(R.array.fqa_title_list_header);
        String[] childArray = getResources().getStringArray(R.array.faq_description_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i = 0; i < headerArray.length; i++) {
            listDataHeader.add(headerArray[i]);

            List<String> childList = new ArrayList<>();
            childList.add(childArray[i]);

            listDataChild.put(headerArray[i], childList);
        }
    }

    private void setListeners() {
        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            String groupName = listDataHeader.get(groupPosition);

            return false;
        });

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String childContent = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

            return false;
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            private int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }
}
