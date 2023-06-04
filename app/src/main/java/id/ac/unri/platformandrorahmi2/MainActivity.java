package id.ac.unri.platformandrorahmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

public class MainActivity extends AppIntro {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.createInstance("Welcome!",
                "This is an super money manager app",
                R.drawable.dollars, R.color.pink1, R.color.orange1, R.color.white, R.font.baksosapi, R.font.baksosapi));

        addSlide(AppIntroFragment.createInstance(
                "Cute interfaced ^-^",
                "There's a lot cute things in this app",
                R.drawable.pen, R.color.pink2, R.color.orange1, R.color.white, R.font.baksosapi, R.font.baksosapi
        ));

        addSlide(AppIntroFragment.createInstance(
                "Simple, yet Customizable",
                "Offers a lot of customization.. while keeping it simple for those that like simple, specially to manage their money",
                R.drawable.wallet, R.color.pink4, R.color.orange1, R.color.white, R.font.baksosapi, R.font.baksosapi
        ));

        setTransformer(AppIntroPageTransformerType.Fade.INSTANCE);
        showStatusBar(true);
        setScrollDurationFactor(2);
        setSystemBackButtonLocked(true);
        setImmersiveMode();
        setButtonsEnabled(true);

        isColorTransitionsEnabled();

    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(MainActivity.this, SplashhActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(MainActivity.this, SplashhActivity.class);
        startActivity(intent);
        finish();
    }

}
