package com.codekul.animations;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimate).setOnClickListener(this::animate);
    }

    private void animate(View view) {
        /*Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        findViewById(R.id.imageView).startAnimation(animation);*/

        threeDFlip();
    }

    private void threeDFlip(){
        final Flip3dAnimation rotation = new Flip3dAnimation(findViewById(R.id.imageView));
        rotation.applyPropertiesInRotation();
        findViewById(R.id.imageView).startAnimation(rotation);
    }

    public class Flip3dAnimation extends Animation {
        private final float mFromDegrees;
        private final float mToDegrees;
        private final float mCenterX;
        private final float mCenterY;
        private Camera mCamera;

        public Flip3dAnimation(View view) {
            mFromDegrees = 0;
            mToDegrees = 750;
            mCenterX = view.getWidth()/2;
            mCenterY = view.getHeight()/2;
        }

        @Override
        public void initialize(int width, int height, int parentWidth,
                               int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            mCamera = new Camera();
        }

        public void applyPropertiesInRotation()
        {
            this.setDuration(2000);
            this.setFillAfter(true);
            this.setInterpolator(new AccelerateInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            final float fromDegrees = mFromDegrees;
            float degrees = fromDegrees
                    + ((mToDegrees - fromDegrees) * interpolatedTime);

            final float centerX = mCenterX;
            final float centerY = mCenterY;
            final Camera camera = mCamera;

            final Matrix matrix = t.getMatrix();

            camera.save();

            Log.e("Degree",""+degrees) ;
            Log.e("centerX",""+centerX) ;
            Log.e("centerY",""+centerY) ;

            camera.rotateY(degrees);

            camera.getMatrix(matrix);
            camera.restore();

            matrix.preTranslate(-centerX, -centerY);
            matrix.postTranslate(centerX, centerY);
        }
    }
}
