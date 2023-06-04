package id.ac.unri.platformandrorahmi2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {
    private static final String TAG = "CustomListViewActivity";
    private ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_second);

        listView = findViewById(R.id.listview);
        ArrayList<ListData> listData = new ArrayList<>();

        ListData data1, data2, data3, data4, data5, data6;
        data1 = new ListData("Coffee", "Rp 18.000", "07/04/2023", R.drawable.coffee);
        data2 = new ListData("Groceries", "Rp 45.000", "07/04/2023", R.drawable.carrot);
        data3 = new ListData("Breakfast", "Rp 7.000", "08/04/2023", R.drawable.bread);
        data4 = new ListData("Cat Food", "Rp 20.000", "09/04/2023", R.drawable.kitty);
        data5 = new ListData("Stationery", "Rp 2.000", "10/04/2023", R.drawable.pen);
        data6 = new ListData("Fuel", "Rp 28.000", "10/04/2023", R.drawable.wallet);

        listData.add(data1);
        listData.add(data2);
        listData.add(data3);
        listData.add(data4);
        listData.add(data5);
        listData.add(data6);

        listView.setAdapter(new ListAdapter(this, R.layout.single_list_item, listData));
    }
}
