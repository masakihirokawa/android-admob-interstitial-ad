package net.dolice.admobinterstitialadex;

import android.app.Activity;
import android.os.Bundle;

import net.dolice.ad.AdMobIntersBanner;

public class MainActivity extends Activity {
    private AdMobIntersBanner mIntersAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 全面広告の読み込み
        preloadInterstitialAd();
    }

    // 全面広告の読み込み
    private void preloadInterstitialAd() {
        mIntersAd = new AdMobIntersBanner();
        mIntersAd.preload(this);
    }

    // 全面広告が読み込み完了していれば表示
    private void showInterstitialAd() {
        // 全面広告表示
        if (mIntersAd != null) {
            mIntersAd.show();
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();

        // 全面広告が読み込み完了していれば表示
        showInterstitialAd();
    }
}
