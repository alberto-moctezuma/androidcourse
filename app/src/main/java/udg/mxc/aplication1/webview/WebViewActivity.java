package udg.mxc.aplication1.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;

public class WebViewActivity extends AppCompatActivity {

    @BindView( R.id.webView ) WebView mWebView;
    @BindView( R.id.progressBarWB ) ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        mWebView.setWebChromeClient( new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setProgress( newProgress );
                if( newProgress == 100 ){
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });

        mWebView.loadUrl("https://stackoverflow.com/questions/34685905/how-to-link-pycharm-with-pyspark");
    }
}
