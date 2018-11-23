package udg.mxc.aplication1.goodviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;

public class FragmentTwo extends Fragment {

    @BindView( R.id.textViewFragmentTwo )
    TextView mTextViewFragmentTwo;

    public static String TAG = FragmentTwo.class.getSimpleName();
    String message;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        message = getArguments().getString( KeysConstants.FRAGMENT_ARG_FLAG );
        Util.showLog( TAG, "Message received: "+message );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind( this, view );
        mTextViewFragmentTwo.setText(message);
        return view;
    }

    public static FragmentTwo newInstance( String  someString ){
        FragmentTwo myFragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(KeysConstants.FRAGMENT_ARG_FLAG, someString);
        myFragment.setArguments(args);

        return myFragment;
    }
}