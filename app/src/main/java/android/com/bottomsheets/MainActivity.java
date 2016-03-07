package android.com.bottomsheets;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button expandBottomSheetButton = (Button) findViewById(R.id.expandBottomSheetButton);
        Button collapseBottomSheetButton = (Button) findViewById(R.id.collapseBottomSheetButton);
        Button bottomSheetDialogTestButton = (Button) findViewById(R.id.bottomSheetDialogTestButton);
        Button showBottomSheetDialogButton = (Button) findViewById(R.id.showBottomSheetDialogButton);
        final TextView text1 = (TextView) findViewById(R.id.text1);

        /**
         *  通过为CoordinatorLayout的子视图添加BottomSheetBehavior（比如添加app:layout_behavior=”android.support.design.widget.BottomSheetBehavior”），你便能够获得可以在下面五种状态间自由变换的触摸选项。
         *  STATE_COLLAPSED：默认状态，只显示布局沿着底边的一部分。高度可以通过使用app:behavior_peekHeight来进行控制；
         *  STATE_DRAGGING：用户直接将bottom sheet上拉或者下拉的一种中间状态；
         *  STATE_SETTLING：视图发布与最终就位之间简短的时间；
         *  STATE_EXPANDED：bottom sheet的充分扩展状态。包括整个bottom sheet被完全显示（如果其高度小于CoordinatorLayout容器）或整个CoordinatorLayout被充满；
         *  STATE_HIDDEN：默认禁用（可使用app:behavior_hideable来启用），启用该状态后就会允许用户通过滑动来完全隐藏bottom sheet。
         */
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet));

        expandBottomSheetButton.setOnClickListener(this);
        collapseBottomSheetButton.setOnClickListener(this);
        bottomSheetDialogTestButton.setOnClickListener(this);
        showBottomSheetDialogButton.setOnClickListener(this);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    text1.setText("Collapse Me!");
                } else {
                    text1.setText("Expand Me!");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.expandBottomSheetButton:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.collapseBottomSheetButton:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.bottomSheetDialogTestButton:
                CustomBottomSheetDialog bottomSheetDialog = new CustomBottomSheetDialog(this);
                bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this,"bottomSheetDialog OnShowListener",Toast.LENGTH_SHORT).show();
                    }
                });
                bottomSheetDialog.show();
                break;
            case R.id.showBottomSheetDialogButton:
                new CustomBottomSheetDialogFragment().show(getSupportFragmentManager(), "sample");
        }
    }
}
