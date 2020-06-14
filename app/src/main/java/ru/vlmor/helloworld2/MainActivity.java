package ru.vlmor.helloworld2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] groupsArray = new String[] { "Зима", "Весна", "Лето", "Осень" };

    private String[] winterMonthsArray = new String[] { "Декабрь", "Январь", "Февраль" };
    private String[] springMonthsArray = new String[] { "Март", "Апрель", "Май" };
    private String[] summerMonthsArray = new String[] { "Июнь", "Июль", "Август" };
    private String[] autumnMonthsArray = new String[] { "Сентябрь", "Октябрь", "Ноябрь" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> map;
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();

        for (String group : groupsArray) {
            map = new HashMap<>();
            map.put("groupName", group);
            groupDataList.add(map);
        }

        String groupFrom[] = new String[] { "groupName" };

        int groupTo[] = new int[] { android.R.id.text1 };

        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();

        for (String month : winterMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month); // название месяца
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : springMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : summerMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String month : autumnMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        String childFrom[] = new String[] { "monthName" };
        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);
    }
}
