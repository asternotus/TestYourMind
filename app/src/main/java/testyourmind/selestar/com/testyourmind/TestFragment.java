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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by ASTER-NOTUS on 11.09.2015.
 */
public class TestFragment extends Fragment {

    private ArrayList<String> variants;

    private Resources res;

    private ResultFragment resultFragment;

    private FragmentTransaction fTrans;

    private TextView tv_progress;

    private ProgressBar pb_progress;

    private RadioButton rb_first, rb_second, rb_third, rb_fourth;

    private Button btn_next;

    private int question_progress;

    private int step = 10;

    private int limit = 90;

    private static int SUM_OF_QUESTIONS = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.test_layout, null);

        res = getResources();

        resultFragment = new ResultFragment();

        fTrans = getFragmentManager().beginTransaction();

        question_progress = 0;

        variants = new ArrayList<String>(Arrays.asList(res.getStringArray(R.array.variants)));

        tv_progress = (TextView) v.findViewById(R.id.tv_progress);

        pb_progress = (ProgressBar) v.findViewById(R.id.pb_progress);

        rb_first = (RadioButton) v.findViewById(R.id.rb_first);
        rb_second = (RadioButton) v.findViewById(R.id.rb_second);
        rb_third = (RadioButton) v.findViewById(R.id.rb_third);
        rb_fourth = (RadioButton) v.findViewById(R.id.rb_fourth);

        btn_next = (Button) v.findViewById(R.id.btn_next);

        tv_progress.setText(question_progress+" "+getString(R.string.from)+" "+SUM_OF_QUESTIONS);

        Random rd = new Random();

        setRBText(rd);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question_progress == limit)
                {
                    fTrans.replace(R.id.fl_main, resultFragment);
                    fTrans.commit();
                }

                if(rb_first.isChecked() || rb_second.isChecked() || rb_third.isChecked() || rb_fourth.isChecked()) {
                    Random rd = new Random();
                    setRBText(rd);
                    question_progress += step;
                    tv_progress.setText(question_progress/step+" "+getString(R.string.from)+" "+SUM_OF_QUESTIONS);
                    pb_progress.setProgress(question_progress);
                }
                else
                {
                    Toast toast = Toast.makeText(getActivity(),
                            getString(R.string.check_please), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return v;
    }

    private void setRBText(Random rd) {
        rb_first.setText(variants.get(rd.nextInt(variants.size())));
        variants.remove(rb_first.getText().toString());

        rb_second.setText(variants.get(rd.nextInt(variants.size())));
        variants.remove(rb_second.getText().toString());

        rb_third.setText(variants.get(rd.nextInt(variants.size())));
        variants.remove(rb_third.getText().toString());

        rb_fourth.setText(variants.get(rd.nextInt(variants.size())));
        variants.remove(rb_fourth.getText().toString());
    }
}
