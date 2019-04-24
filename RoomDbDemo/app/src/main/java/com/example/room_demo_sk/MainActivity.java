package com.example.room_demo_sk;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Add Note");
                alertDialog.setMessage("Enter Note Here");

                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                note = input.getText().toString();
                                DemoAppDB demoAppDB=DemoAppDB.getDatabase(getApplicationContext());
                                DemoDAO demoDAO = demoAppDB.demoDAO();
                                final String id = UUID.randomUUID().toString();
                                DemoEntity demoEntity = new DemoEntity(id,note);
                                insert(demoDAO,demoEntity);
                            }
                        });
                alertDialog.show();
            }

        });


    }

    public void insert(DemoDAO demoDAO, DemoEntity demoEntity) {
        new InsertAsyncTask(demoDAO).execute(demoEntity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private class InsertAsyncTask extends AsyncTask<DemoEntity,Void,Void>{

        DemoDAO demoDAO;
        public InsertAsyncTask(DemoDAO demoDAO) {
        this.demoDAO=demoDAO;
        }


        @Override
        protected Void doInBackground(DemoEntity... demoEntities) {
            demoDAO.insert(demoEntities[0]);
            return null;
        }
    }
}
