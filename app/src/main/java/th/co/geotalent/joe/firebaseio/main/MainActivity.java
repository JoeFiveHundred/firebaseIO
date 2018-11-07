package th.co.geotalent.joe.firebaseio.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import th.co.geotalent.joe.firebaseio.R;
import th.co.geotalent.joe.firebaseio.main.model.User;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("user");

        final EditText nameEdit = findViewById(R.id.name);
        Button submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userDatabase.push().getKey();
                User user = new User(id, nameEdit.getText().toString());
                userDatabase.child(id).setValue(user);
            }
        });

    }
}
