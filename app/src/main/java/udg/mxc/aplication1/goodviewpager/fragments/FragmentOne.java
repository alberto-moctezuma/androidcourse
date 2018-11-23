package udg.mxc.aplication1.goodviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;

public class FragmentOne extends Fragment {

    public static String TAG = FragmentOne.class.getSimpleName();

    @BindView( R.id.imageViewFragmentOne )
    ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        ButterKnife.bind(this, view );

        Glide.with( getActivity() )
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Skull_Icon_%28Noun_Project%29.svg/2000px-Skull_Icon_%28Noun_Project%29.svg.png")
                .centerCrop()
                .crossFade(2500)
                .into( mImageView );

        return view;
    }

    public static FragmentOne newInstance(  ){
        FragmentOne myFragment = new FragmentOne();
        return myFragment;
    }
}