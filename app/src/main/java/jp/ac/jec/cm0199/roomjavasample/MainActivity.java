package jp.ac.jec.cm0199.roomjavasample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Executors;

import jp.ac.jec.cm0199.roomjavasample.data.AppDatabase;
import jp.ac.jec.cm0199.roomjavasample.data.DataModule;
import jp.ac.jec.cm0199.roomjavasample.data.User;
import jp.ac.jec.cm0199.roomjavasample.data.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtResult = findViewById(R.id.txtResult);

        final AppDatabase db = DataModule.getInstance(this).getDb();
        final UserDao userDao = db.userDao();

        userDao.getAll().observe(this, (List<User> users) -> {
            final StringBuilder sb = new StringBuilder();
            for (User u : users) {
                sb.append(u.toString()).append("\n");
            }
            txtResult.setText(sb.toString());
        });

        findViewById(R.id.buttonAdd).setOnClickListener(v -> {
            final User user = new User();
            user.firstName = "Taro";
            user.lastName = "Denshi";

            final User user2 = new User();
            user2.firstName = "Hanako";
            user2.lastName = "Denshi";

            Executors.newSingleThreadExecutor().execute(() -> userDao.insertAll(user, user2));
        });
        findViewById(R.id.buttonAdd2).setOnClickListener(v -> {
            final User user = new User();
            user.firstName = "Taro";
            user.lastName = "Denshi";
            // 別スレッドで処理する必要がある.
            Executors.newSingleThreadExecutor().execute(() -> userDao.insertAll(user));
        });

        findViewById(R.id.buttonLoadAllByIds).setOnClickListener(v -> Executors.newSingleThreadExecutor().execute(() -> {
            final List<User> users = userDao.loadAllByIds(new int[]{1, 2, 3});
            final StringBuilder sb = new StringBuilder();
            for (User u : users) {
                sb.append(u.toString()).append("\n");
            }
            getMainExecutor().execute(() -> txtResult.setText(sb.toString()));
        }));

        findViewById(R.id.buttonFindByName).setOnClickListener(v -> Executors.newSingleThreadExecutor().execute(() -> {
            final User user = userDao.findByName("Taro", "Denshi");
            if(user != null) {
                userDao.delete(user);
            }
        }));
    }
}