package com.theonelove.mikrotiktutorial;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdListener;


public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    private boolean showPubli=true,exitApp=false;
    private InterstitialAd interstitialAd;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);




        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */




        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.nav_item_basic) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new BasicFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.nav_item_ip) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new IPFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_firewall) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FirewallFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_routing) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new RoutingFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.home) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_aboutme) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new AboutmeFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_update) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new UpdatesFragment()).commit();
                }




                return false;
            }

        });




        /**
         * Setup Drawer Toggle of the Toolbar
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();


    }

    // This is Alert Dialog When You Back Button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
            alertbox.setIcon(R.drawable.user);
            alertbox.setTitle("ออกจากโปรแกรมหรือไม่");
            alertbox.setPositiveButton("ใช่", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface arg0, int arg1) {
                    // finish used for destroyed activity
                    Toast.makeText(MainActivity.this,"ขอบคุณที่ใช้แอปนี้",Toast.LENGTH_LONG).show();
                    finish();
                }
            });

            alertbox.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    // Nothing will be happened when clicked on no button
                    // of Dialog
                    Toast.makeText(MainActivity.this,"ขอบคุณที่ยังอยู่กับเรา",Toast.LENGTH_LONG).show();
                }
            });

            alertbox.show();

            if (showPubli)
            {
                set_admob_banner();
                interstitialAdLaunch();
                //loadInterstitial();
            }



        }
        return super.onKeyDown(keyCode, event);


    }


    private void set_admob_banner()
    {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.ad_publi);

        AdView adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-3141495266234720/8113582493");

        adView.setAdSize(AdSize.SMART_BANNER);

        layout.setGravity(Gravity.CENTER);
        layout.setLayoutParams(params);
        layout.addView(adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showAdInter();
            }

            @Override
            public void onAdClosed() {
                //super.onAdClosed();
                if (exitApp)
                    finish();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                String message = String.format("onAdFailedToLoad (%s)", getErrorReason(errorCode));
                Log.e("Error: ", message);
            }


        });
    }

    private void interstitialAdLaunch()
    {
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3141495266234720/8113582493");

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showAdInter();
            }

            @Override
            public void onAdClosed() {
                //super.onAdClosed();
                if (exitApp)
                    finish();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                String message=String.format("onAdFailedToLoad (%s)",getErrorReason(errorCode));
            }


        });
    }

    private void showAdInter()
    {
        if (interstitialAd.isLoaded())
        {
            interstitialAd.show();
        }
        else
        {
            Log.d("Debug", "Interstitial as was not ready to be shown");
        }

    }

    private void loadInterstitial()
    {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        interstitialAd.loadAd(adRequest);

    }

    private String getErrorReason(int errorCode) {
        String errorReason = "";
        switch (errorCode){
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorReason = "Internal Error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorReason = "Invalid Request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorReason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                errorReason = "No Fill";
                break;
        }

        return errorReason;
    }


}
