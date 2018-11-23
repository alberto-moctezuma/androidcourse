package udg.mxc.aplication1.goodviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.Util;

public class FragmentThree extends Fragment {

    public static String TAG = FragmentThree.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    public static FragmentThree newInstance(  ){
        FragmentThree myFragment = new FragmentThree();
        return myFragment;
    }

    @OnClick( R.id.buttonFragmentThree ) public void click( View view ){
        Util.showToast(getActivity(), "Ha presionado el botón");
    }
}
