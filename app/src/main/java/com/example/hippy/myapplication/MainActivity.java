package com.example.hippy.myapplication;

import android.animation.Animator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linear);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(this);

        linearLayout.setVisibility(View.INVISIBLE);

    }

    private void revealAnimation(LinearLayout view) {
        int cx = view.getRight() - 120;
        int cy = view.getBottom() - 120;
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        view.setVisibility(View.VISIBLE);
//        isEditTextVisible = true;
        anim.setDuration(1500);
        anim.start();
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fab){
//            revealEditText(linearLayout);
//            applyRippleColor(getResources().getColor(R.color.light_green), getResources().getColor(R.color.dark_green));

            Intent transitionIntent = new Intent(MainActivity.this, Main2Activity.class);
//            Pair<View, String> float_btn = Pair.create((View) floatingActionButton, "float_btn");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,floatingActionButton,"float_btn");
            startActivity(transitionIntent, options.toBundle());
        }
    }
}
