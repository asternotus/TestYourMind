package testyourmind.selestar.com.testyourmind;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by ASTER-NOTUS on 11.09.2015.
 */
public class ResultFragment extends Fragment {

    private TextView tv_title, tv_descr;
    private Button btn_tryagain;

    private FragmentTransaction fTrans;
    private TestFragment testFragment;

    private Resources res;

    private String [] titles;
    private String [] descriptions;

    private int position;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.result_layout, null);

        res = getResources();

        fTrans = getFragmentManager().beginTransaction();
        testFragment = new TestFragment();

        titles = res.getStringArray(R.array.titles);
        descriptions = res.getStringArray(R.array.descriptions);

        tv_title = (TextView) v.findViewById(R.id.tv_title);
        tv_descr = (TextView) v.findViewById(R.id.tv_descr);

        btn_tryagain = (Button) v.findViewById(R.id.btn_tryagain);

        Random rd = new Random();
        position = rd.nextInt(titles.length);

        tv_title.setText(titles[position]);
        tv_descr.setText(descriptions[position]);

        btn_tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTrans.replace(R.id.fl_main, testFragment);
                fTrans.commit();
            }
        });

        return v;
    }
}
