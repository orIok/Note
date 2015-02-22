package com.code.shity.note;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    public static final String NOTE_EXTRA = "NOTE_EXTRA";
    private ActionBar mActionBar;
    ListView mListView;
    NoteAdapter mNoteAdapter;
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notes = new ArrayList<Note>();
        /*test*/
        notes.add(new Note()
                .setName("Test1")
                .setNote("BLABLABLBLABLAasdsadadadasdasdasadsaaaaaaaaaaaaaaaaaaaaaaaBLAA")
                .setTag("testtag")
                .setColorActionBar(R.color.RedActionBar)
                .setColorStatusBar(R.color.RedStatusbar));

        notes.add(new Note()
                .setName("Test2")
                .setNote("BLABLABLBLABLAasdsadadadasdasdasadsaaaaaaaaaaaaaaaaaaaaaaaBLAA")
                .setTag("testtag")
                .setColorActionBar(R.color.BrownActionBar)
                .setColorStatusBar(R.color.BrownStatusbar));

        notes.add(new Note()
                .setName("Test3")
                .setNote("BLABLABLBLABLAasdsadadadasdasdasadsaaaaaaaaaaaaaaaaaaaaaaaBLAA")
                .setTag("testtag")
                .setColorActionBar(R.color.CyanActionBar)
                .setColorStatusBar(R.color.CyanStatusbar));

        notes.add(new Note()
                .setName("Test4")
                .setNote("BLABLAasdsadadadasdasdasadsaaaaaaaaaaaaaaaaaaaaaaaBLA")
                .setTag("testtag")
                .setColorActionBar(R.color.DeepOrangeActionBar)
                .setColorStatusBar(R.color.DeepOrangeStatusbar));
        /*/test*/

        mNoteAdapter = new NoteAdapter(this, notes);
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mNoteAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra(NOTE_EXTRA, notes.get(position));
                startActivity(intent);
            }
        });

        ActionBar bar = getActionBar();

        // Встановлення кольору статус і екшенбара
        bar.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowHomeEnabled(true); //іконка на головні
//        bar.setDisplayHomeAsUpEnabled(true); // стрєлочка назад


        bar.setBackgroundDrawable(getResources().getDrawable(R.color.BrownActionBar)); //ActionBar
        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.BrownStatusbar)); //StatusBar //DarckBrown






//        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//        final String[] itemElements = getResources().getStringArray(R.array.action_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActionBar.getThemedContext(),
//                android.R.layout.simple_spinner_item, android.R.id.text1, itemElements);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        mActionBar.setListNavigationCallbacks(adapter, new ActionBar.OnNavigationListener() {
//            @Override
//            public boolean onNavigationItemSelected(int position, long id) {
//                /*mSpinnerSelected = position;
//                SharedPreferences.Editor editor = mSharedPreferences.edit();
//                editor.putInt(Constants.EXTRA_SPINNER_POSITION, position);
//                editor.apply();
//                switch (position) {
//                    case 2:
//                        mSwipeLayout.setVisibility(View.VISIBLE);
//                        mProgressBar.setVisibility(View.GONE);
//                        updateFavourite();
//                        break;
//                    default:
//                        mSwipeLayout.setVisibility(View.GONE);
//                        mProgressBar.setVisibility(View.VISIBLE);
//                        startDownloadData(getSelectedLink(mSpinnerSelected));
//                }*/
//                return true;
//            };
//        });

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        menu.findItem(R.id.action_search).getActionView();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:

                Intent i = new Intent(MainActivity.this, NoteActivity.class);
                Note note = new Note();
                i.putExtra(NOTE_EXTRA, note);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
