package id.ac.unri.platformandrorahmi2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        ListView listView = view.findViewById(R.id.listview);
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

        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.single_list_item, listData);
        listView.setAdapter(adapter);

        return view;
    }
}