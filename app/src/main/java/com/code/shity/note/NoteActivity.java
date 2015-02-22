package com.code.shity.note;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class NoteActivity extends Activity {
    Note mNote;
    int[] mColors;

    private void setBarColor(int colorS, int colorA) {
        getWindow().setStatusBarColor(getResources().getColor(colorS));

        getActionBar().setBackgroundDrawable(getResources().getDrawable(colorA));
        findViewById(R.id.content_add_note)
                .setBackgroundColor(getResources().getColor(colorA));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(getResources().getDrawable(R.color.BrownActionBar));
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.BrownStatusbar));

        mNote = (Note) getIntent().getSerializableExtra(MainActivity.NOTE_EXTRA);
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        editTextName.setText(mNote.getName());

        EditText editTextNote = (EditText) findViewById(R.id.editTextNote);
        editTextNote.setText(mNote.getNote());

        EditText editTextTag = (EditText) findViewById(R.id.editTextTag);
        editTextTag.setText(mNote.getTag());

        setBarColor(mNote.getColorStatusBar(), mNote.getColorActionBar());


        mColors = new int[3];
        mColors[0] = R.color.BlueActionBar;
        mColors[1] = R.color.AmberActionBar;
        mColors[2] = R.color.BrownActionBar;

        ListView listView =
                (ListView) findViewById(R.id.list_colors);
        listView.setAdapter(new ColorAdapter(this,
                mColors));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                findViewById(R.id.list_colors).setVisibility(View.GONE);
                setBarColor(mColors[position], mColors[position]);
            };
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.color: //Кнопка вибору кольору
                ColorPickFragment dialog = new ColorPickFragment();
                dialog.show(getFragmentManager(), "Colors");
                //findViewById(R.id.horizontalScrollView).setVisibility(View.GONE);
                findViewById(R.id.list_colors).setVisibility(View.VISIBLE);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu item) {
        getMenuInflater().inflate(R.menu.add_note_menu, item);
        return true;
    }
}
