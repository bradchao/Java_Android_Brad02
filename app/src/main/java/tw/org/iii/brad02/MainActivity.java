package tw.org.iii.brad02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private WebView webview;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView)findViewById(R.id.username);
        webview = (WebView)findViewById(R.id.webview);
        initWebView();
    }

    private void initWebView(){
        WebViewClient client = new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String name = "Brad";
                webview.loadUrl("javascript:showName('" + name + "')");

            }
        };
        webview.setWebViewClient(client);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        webview.loadUrl("file:///android_asset/brad.html");

    }
    public void prev(View v){
        webview.goBack();
    }
    public void next(View v){
        webview.goForward();
    }
    public void reload(View v){
        webview.reload();
    }
    public void lottery(View v){
        String name = "Brad";
        webview.loadUrl("javascript:showName('" + name + "')");
    }

    public class BradJS {
        @JavascriptInterface
        public void getName(String info){
            Log.d("brad", "getName()");
        }
    }

}
