package net.halilkaya.beykentandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    private ListView userList;
    private ArrayList<UserModel> data = new ArrayList<>();
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userList = (ListView) findViewById(R.id.user_list);

        UserModel ali = new UserModel(1, R.drawable.user, "Ali", "Veli", "ali@veli.net", true);
        UserModel ahmet = new UserModel(2, R.drawable.no_photo, "Ahmet", "Mehmet", "ahmet@mehmet.net", false);

        data.add(ali);
        data.add(ahmet);

        adapter = new UserAdapter(this, R.layout.list_item, data);
        userList.setAdapter(adapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(UserListActivity.this, UserDetail.class);
                detailIntent.putExtra("id", data.get(position).getId());
                detailIntent.putExtra("photo", data.get(position).getPhoto());
                detailIntent.putExtra("firstName", data.get(position).getFirstName());
                detailIntent.putExtra("lastName", data.get(position).getLastName());
                detailIntent.putExtra("email", data.get(position).getEmail());
                detailIntent.putExtra("isSubscribed", data.get(position).isSubscribed());
                startActivity(detailIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
