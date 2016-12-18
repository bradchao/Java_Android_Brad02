package tw.org.iii.brad02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
