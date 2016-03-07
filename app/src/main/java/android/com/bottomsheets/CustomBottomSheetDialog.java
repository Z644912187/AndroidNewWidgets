package android.com.bottomsheets;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by charles_zhu on 2016/3/7.
 */
public class CustomBottomSheetDialog extends BottomSheetDialog implements View.OnClickListener {
    private Context mContext;

    public CustomBottomSheetDialog(Context context) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog_main,null);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        tv1.setOnClickListener(this);

        setContentView(view);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv1) {
            Toast.makeText(mContext,"AccountActionsDialog click tv1",Toast.LENGTH_SHORT).show();
        }
    }
}
