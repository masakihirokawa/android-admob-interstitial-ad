package net.dolice.ad;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Dolice on 15/03/19.
 */

public class AdMobIntersBanner {
    private InterstitialAd mIntersAd;
    private static final String INTERS_AD_UNIT_ID = "Your AdMob Ad unit ID";
    private static final boolean DEBUG_MODE = true;
    private static final String[] DEBUG_DEVICE_ID = {
            "Your test device ID"
    };

    /**
     * 全面広告のプリロード
     * @param context
     */
    public void preload(Context context) {
        mIntersAd = new InterstitialAd(context);
        mIntersAd.setAdUnitId(INTERS_AD_UNIT_ID);
        mIntersAd.loadAd(getAdRequest());
    }

    /**
     * 全面広告の表示
     */
    public void show() {
        if (mIntersAd == null) {
            return;
        }

        if (mIntersAd.isLoaded()) {
            mIntersAd.show();
        }
    }

    /**
     * 広告リクエストの取得
     */
    private AdRequest getAdRequest() {
        AdRequest adRequest;
        if (DEBUG_MODE) {
            adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    //.addTestDevice(DEBUG_DEVICE_ID[0])
                    .build();
        } else {
            adRequest = new AdRequest.Builder().build();
        }

        return adRequest;
    }
}
