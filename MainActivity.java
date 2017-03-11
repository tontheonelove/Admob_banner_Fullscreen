package com.theonelove.tutorial;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    private InterstitialAd interstitial;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
        
        
        /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });


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


                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });
                    
                    
                    /// ADMOB  BANNER FOOTER///
                     mAdView = (AdView) findViewById(R.id.adView);
                     AdRequest adRequestbn = new AdRequest.Builder()
                              .build();
                     mAdView.loadAd(adRequestbn);



                }

                if (menuItem.getItemId() == R.id.nav_item_ip) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new IPFragment()).commit();

                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });


                }

                if (menuItem.getItemId() == R.id.nav_item_firewall) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FirewallFragment()).commit();


                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });


                }

                if (menuItem.getItemId() == R.id.nav_item_routing) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new RoutingFragment()).commit();


                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });
                }

                if (menuItem.getItemId() == R.id.home) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();


                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });

                }

                if (menuItem.getItemId() == R.id.nav_item_aboutme) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new AboutmeFragment()).commit();

                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });

                }

                if (menuItem.getItemId() == R.id.nav_item_update) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new UpdatesFragment()).commit();

                    /// This is Admob Show
                    interstitial = new InterstitialAd(getApplicationContext());
                    interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitial.loadAd(adRequest);
                    interstitial.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (interstitial.isLoaded()) {
                                interstitial.show();
                            }
                        }
                    });
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


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
            alertbox.setIcon(R.drawable.attention);
            alertbox.setTitle("ออกจากโปรแกรมหรือไม่");
            alertbox.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    // finish used for destroyed activity
                    finish();
                }
            });

            alertbox.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    // Nothing will be happened when clicked on no button
                    // of Dialog
                }
            });

            alertbox.show();
        }
        return super.onKeyDown(keyCode, event);
    }



}
