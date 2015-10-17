package testyourmind.selestar.com.testyourmind;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ASTER-NOTUS on 13.09.2015.
 */
public class MainMenuFragment extends Fragment {

    private Button btn_start;
    private TestFragment testFragment;
    private FragmentTransaction fTrans;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_menu, null);

        Log.i("FRAG", "ohlala");

        btn_start = (Button) v.findViewById(R.id.btn_start);
        fTrans = getFragmentManager().beginTransaction();
        testFragment = new TestFragment();

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTrans.replace(R.id.fl_main, testFragment);
                fTrans.commit();
            }
        });

        return v;
    }
}
