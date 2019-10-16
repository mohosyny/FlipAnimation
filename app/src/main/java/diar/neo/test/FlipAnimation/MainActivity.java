package diar.neo.test.FlipAnimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
public class MainActivity extends Activity {

    private Animator flipLeftIn, flipLeftOut, flipRightIn, flipRightOut;
    private boolean mIsBackVisible = false;
    private TextView cartFront, cartBack;
    private FrameLayout cardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        cardContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareCardAnim();
            }
        });
    }


    private void setupViews() {
        cardContainer = findViewById(R.id.cardContainer);
        cartFront = findViewById(R.id.cartFront);
        cartBack = findViewById(R.id.cartBack);
        flipLeftIn = AnimatorInflater.loadAnimator(this, R.animator.card_flip_left_in);
        flipLeftOut = AnimatorInflater.loadAnimator(this, R.animator.card_flip_left_out);
        flipRightIn = AnimatorInflater.loadAnimator(this, R.animator.card_flip_right_in);
        flipRightOut = AnimatorInflater.loadAnimator(this, R.animator.card_flip_right_out);
    }

    private void prepareCardAnim() {
        if (!mIsBackVisible) {
            flipLeftOut.setTarget(cartFront);
            flipLeftIn.setTarget(cartBack);
            flipLeftOut.start();
            flipLeftIn.start();
            mIsBackVisible = true;
        } else {
            flipRightIn.setTarget(cartFront);
            flipRightOut.setTarget(cartBack);
            flipRightIn.start();
            flipRightOut.start();
            mIsBackVisible = false;
        }
    }

}
