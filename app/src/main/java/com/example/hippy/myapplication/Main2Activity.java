package com.example.hippy.myapplication;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main2Activity extends Activity{
    private LinearLayout linearLayout;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linearLayout = (LinearLayout) findViewById(R.id.linear);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab2);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                revealEditText(linearLayout);
//            }
//        });

        linearLayout.setVisibility(View.INVISIBLE);
        windowTransition();

        revealAnimation(linearLayout);
    }

    private void windowTransition() {
        getWindow().getEnterTransition().addListener(new TransitionAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {

                getWindow().getEnterTransition().removeListener(this);
            }
        });
    }

    private void revealAnimation(final LinearLayout view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                if (view.getViewTreeObserver().isAlive()) {
                    int cx = view.getWidth() / 2;
                    int cy = view.getHeight() / 2;
                    int finalRadius = Math.max(view.getWidth(), view.getHeight());
                    Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
                    floatingActionButton.setVisibility(View.INVISIBLE);
                    view.setVisibility(View.VISIBLE);
                    anim.setDuration(1500);
                    anim.start();
                }
            }
        });
    }
}
