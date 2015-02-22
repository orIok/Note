package com.code.shity.note;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;


public class MainActivity extends Activity {

    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar bar = getActionBar();



        // Встановлення кольору статус і екшенбара
        bar.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowHomeEnabled(true); //іконка на головні
//        bar.setDisplayHomeAsUpEnabled(true); // стрєлочка назад


        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#887b68"))); //Brown
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.StatusGrey)); //DarckBrown






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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);

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
