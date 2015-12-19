package net.halilkaya.beykentandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {

    private Intent me;
    private UserModel user;

    private ImageView photo;
    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        me = getIntent();
        user = new UserModel();

        user.setId(me.getIntExtra("id", 0));
        user.setPhoto(me.getIntExtra("photo", 0));
        user.setFirstName(me.getStringExtra("firstName"));
        user.setLastName(me.getStringExtra("lastName"));
        user.setEmail(me.getStringExtra("email"));
        user.setIsSubscribed(me.getBooleanExtra("isSubscribed", false));

        photo = (ImageView) findViewById(R.id.photo);
        details = (TextView) findViewById(R.id.details);

        String subscription = "No";
        if (user.isSubscribed())
            subscription = "Yes";

        photo.setImageDrawable(getResources().getDrawable(user.getPhoto()));
        details.setText("ID: " + String.valueOf(user.getId()) + "\n" +
                        "Name: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                        "Email: " + user.getEmail() + "\n" +
                        "Is subscribed?: " + subscription);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
