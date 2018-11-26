package udg.mxc.aplication1.database.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.database.model.DogShop;

public class DogShopAdapter extends RecyclerView.Adapter<DogShopAdapter.ViewHolderAdapter> {

    List<DogShop> dogShops;
    Context context;
    DogShopClick dogShopClick;
    DogShopLongClick dogShopLongClick;

    public DogShopAdapter(List<DogShop> dogShops, Context context, DogShopClick dogShopClick, DogShopLongClick dogShopLongClick) {
        this.dogShops = dogShops;
        this.context = context;
        this.dogShopClick = dogShopClick;
        this.dogShopLongClick = dogShopLongClick;
    }


    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_dog_shop, viewGroup, false);
        return new ViewHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter viewHolderAdapter, int position) {
        DogShop dogShop = dogShops.get(position);
        viewHolderAdapter.setTextsAndImage( dogShop );
        viewHolderAdapter.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogShopClick.onDogShopClickListener( dogShop );
            }
        });

        viewHolderAdapter.rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dogShopLongClick.onDogShopLongClickListener( dogShop );
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dogShops.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {

        @BindView( R.id.imageViewDogShop ) ImageView mImgShop;
        @BindView( R.id.textViewDogShopName ) TextView mTvDogShopName;
        @BindView( R.id.textViewAddress ) TextView mTvDogShopAddress;

        View rootView;

        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView = itemView;
        }

        public void setTextsAndImage( DogShop dogShop ){
            Glide.with( context )
                    .load( dogShop.image )
                    .centerCrop()
                    .crossFade(1500)
                    .into(mImgShop);

            mTvDogShopName.setText("Nombre: "+dogShop.name);
            mTvDogShopName.setText("Dirección: "+dogShop.address);

        }
    }
}
