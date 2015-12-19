package net.halilkaya.beykentandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<UserModel> {

    private Context context;
    private int resource;
    private ArrayList<UserModel> items;

    public UserAdapter(Context context, int resource, ArrayList<UserModel> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);

        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.layout);
        ImageView photo = (ImageView) view.findViewById(R.id.photo);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView email = (TextView) view.findViewById(R.id.email);

        photo.setImageDrawable(context.getResources().getDrawable(items.get(position).getPhoto()));

        if (items.get(position).isSubscribed()) {
            layout.setBackgroundColor(Color.parseColor("#dfffdf"));
        } else {
            layout.setBackgroundColor(Color.parseColor("#ffdfdf"));
        }

        name.setText(items.get(position).getFirstName() + " " + items.get(position).getLastName());
        email.setText(items.get(position).getEmail());

        return view;
    }
}
