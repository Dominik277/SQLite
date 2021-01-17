package hr.dominik.sqlite;

import android.app.ActionBar;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CountryListActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[]{
            DatabaseHelper._ID,
            DatabaseHelper.SUBJECT,
            DatabaseHelper.DESC};
    final int[] to = new int[]{R.id.id,R.id.title,R.id.desc};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this,
                R.layout.activity_view_record,cursor,from,to,0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

    }
}
