package omninos.com.xlinx.Fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import omninos.com.xlinx.R;

public class ConfirmFlightPaymentFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private ImageView cancel;

    public ConfirmFlightPaymentFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_confirm_flight_payment_fragment, container, false);

        intIds(view);
        performActions();

        return view;
    }

    private void intIds(View view){
        cancel= view.findViewById(R.id.cancel);
    }

    private void performActions(){
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                dismiss();
                break;
        }
    }
}
