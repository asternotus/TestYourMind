package testyourmind.selestar.com.testyourmind;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ASTER-NOTUS on 18.09.2015.
 */
public class ExitDialogFragment extends DialogFragment {

    private Button btn_yes, btn_no;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.exit_dialog_layout, null);

        getDialog().setTitle(getString(R.string.exit_text));

        btn_yes = (Button) v.findViewById(R.id.btn_yes);
        btn_no = (Button) v.findViewById(R.id.btn_no);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return v;
    }
}
