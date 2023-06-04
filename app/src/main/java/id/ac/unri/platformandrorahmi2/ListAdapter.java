package id.ac.unri.platformandrorahmi2;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<ListData> {
//    private List<ListData> listData;
    private Context mContext;
    private int layout;
    private List<id.ac.unri.platformandrorahmi2.ListData> listData;
    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ListData> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.layout = resource;
        this.listData = objects;
    }

    static class DataHolder{
        ImageView image;
        TextView name;
        TextView amount;
        TextView time;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        DataHolder holder;
        if(v==null){
            LayoutInflater li = ((Activity)mContext).getLayoutInflater();
            v = li.inflate(layout, parent, false);

            holder = new DataHolder();
            holder.image = v.findViewById(R.id.listImage);
            holder.name = v.findViewById(R.id.listName);
            holder.amount = v.findViewById(R.id.listMoney);
            holder.time = v.findViewById(R.id.listTime);

            v.setTag(holder);
        }else {
            holder = (DataHolder) v.getTag();
        }

        ListData data = listData.get(position);
        holder.image.setImageResource(data.getImage());
        holder.name.setText(data.getName());
        holder.amount.setText(data.getAmount());
        holder.time.setText(data.getTime());
        return v;
    }
    //    public ListAdapter(Context context, ArrayList<ListData> userArrayList){
//
//        super(context,R.layout.single_list_item,userArrayList);
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        ListData data = getItem(position);
//
//        if (convertView == null){
//
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_list_item,parent,false);
//
//        }
//
//        ImageView imageView = convertView.findViewById(R.id.listImage);
//        TextView userName = convertView.findViewById(R.id.listName);
//        TextView amount = convertView.findViewById(R.id.listMoney);
//        TextView time = convertView.findViewById(R.id.listTime);
//
//        imageView.setImageResource(data.image);
//        userName.setText(data.name);
//        amount.setText(data.amount);
//        time.setText(data.time);
//
//
//        return convertView;
//    }
}
//    public ListAdapter(Context context, ArrayList<User> userArrayList){
//
//        super(context,R.layout.list_item,userArrayList);
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        User user = getItem(position);
//
//        if (convertView == null){
//
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
//
//        }
//
//        ImageView imageView = convertView.findViewById(R.id.profile_pic);
//        TextView userName = convertView.findViewById(R.id.personName);
//        TextView lastMsg = convertView.findViewById(R.id.lastMessage);
//        TextView time = convertView.findViewById(R.id.msgtime);
//
//        imageView.setImageResource(user.imageId);
//        userName.setText(user.name);
//        lastMsg.setText(user.lastMessage);
//        time.setText(user.lastMsgTime);
//
//
//        return convertView;
//    }
