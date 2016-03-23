package cl.zecovery.android.sidcoalert.animation;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cl.zecovery.android.sidcoalert.R;

/**
 * Created by fran on 13-03-16.
 */
public class UIAnimation {

    private FloatingActionButton fab;
    private Animation rotateForward;
    private Context context;

    public UIAnimation() {
    }

    public void animateFAB(Context context, FloatingActionButton fab) {

        rotateForward = AnimationUtils.loadAnimation(context, R.anim.rotate_forward);

        fab.startAnimation(rotateForward);
    }

}
