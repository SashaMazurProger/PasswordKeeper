package com.example.sasham.passwordkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sasham.passwordkeeper.model.DaoSession;
import com.example.sasham.passwordkeeper.model.Password;
import com.example.sasham.passwordkeeper.model.PasswordDao;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreatePasswordActivity extends AppCompatActivity {

    @BindView(R.id.create_pass_title)
    protected EditText tvTitle;

    @BindView(R.id.create_pass_email)
    protected EditText tvEmail;

    @BindView(R.id.create_pass_key)
    protected EditText tvKey;


    private PasswordDao mPasswordDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ButterKnife.bind(this);
        initPasswordDao();
    }


    private void initPasswordDao() {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mPasswordDao = daoSession.getPasswordDao();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_pass_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.btn_save_password) {
            savePassword();
            return true;
        }
        return false;
    }
    private void savePassword(){

        String title=tvTitle.getText().toString().trim();
        String email=tvEmail.getText().toString().trim();
        String key=tvKey.getText().toString().trim();

        if(title.isEmpty()||key.isEmpty()){
            Toast.makeText(this,R.string.empty_pass_field,Toast.LENGTH_SHORT)
                    .show();
        }
        else
        {
            Password password=new Password();

            password.setTitle(title);
            password.setEmail(email);
            password.setKey(key);
            password.setDate(new Date());

            mPasswordDao.insert(password);
        }
    }
}
