package udg.mxc.aplication1.viewpager;

import udg.mxc.aplication1.R;

public enum Model {

    RED(R.string.red, R.layout.view_red ),
    BLUE( R.string.blue, R.layout.view_blue ),
    GREEN( R.string.green, R.layout.view_green );

    private int mTitleResId;
    private int mLayoutResId;

    Model( int titleResId, int layoutResId ){
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getmTitleResId() {
        return mTitleResId;
    }

    public void setmTitleResId(int mTitleResId) {
        this.mTitleResId = mTitleResId;
    }

    public int getmLayoutResId() {
        return mLayoutResId;
    }

    public void setmLayoutResId(int mLayoutResId) {
        this.mLayoutResId = mLayoutResId;
    }
}
