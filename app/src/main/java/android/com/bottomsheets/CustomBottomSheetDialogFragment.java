package android.com.bottomsheets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog_main, container, false);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        tv1.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv1) {
            Toast.makeText(getActivity(), "BottomSheetDialogFragment click tv1", Toast.LENGTH_SHORT).show();
        }
    }
}
