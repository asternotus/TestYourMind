package testyourmind.selestar.com.testyourmind;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;


public class MainActivity extends Activity {

    private MainMenuFragment mainMenuFragment;
    private FragmentTransaction fTrans;
    private ExitDialogFragment exitDialogFragment;

    @Override
    public void onBackPressed() {

        exitDialogFragment.show(getFragmentManager(), "exitDialog");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){


            exitDialogFragment = new ExitDialogFragment();

            fTrans = getFragmentManager().beginTransaction();
            mainMenuFragment = new MainMenuFragment();

            fTrans.add(R.id.fl_main, mainMenuFragment);
            fTrans.commit();
        } else {
            // don't do anything
        }


    }
}
