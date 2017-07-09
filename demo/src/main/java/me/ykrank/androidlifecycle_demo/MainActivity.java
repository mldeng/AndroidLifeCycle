package me.ykrank.androidlifecycle_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.ykrank.androidlifecycle.manager.LifeCycleManagerSupportFragment;

public class MainActivity extends AppCompatActivity {
    static final String FRAGMENT_TAG = "me.ykrank.androidlifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        l("onCreate");
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        MainFragment mainFragment = new MainFragment();
        fm.beginTransaction().add(R.id.layout_fragment, mainFragment).commitNow();

        FragmentManager lifeCycleFm = mainFragment.getChildFragmentManager();
        LifeCycleManagerSupportFragment fragment = (LifeCycleManagerSupportFragment) lifeCycleFm.findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new LifeCycleManagerSupportFragment();
            lifeCycleFm.beginTransaction().add(fragment, FRAGMENT_TAG).commitAllowingStateLoss();
        }

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        l("onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        l("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        l("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        l("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        l("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        l("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        l("onDestroy");
    }

    private void l(String msg) {
        Log.d("MainActivity", msg);
    }
}
