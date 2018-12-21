package site.ahwan0m.dorraxis;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.support.v4.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {
public WebView webme;
public Button btn,btn1,btn2;
public WebSettings sett;
public SwipeRefreshLayout swipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipe = (SwipeRefreshLayout)findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        });

        WebAction();

    }
    public void WebAction(){

        swipe.setRefreshing(true);
        webme.setWebViewClient(new WebViewClient() {

                                   public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                                       webme.loadUrl("file:///android_assets/error.html");

                                   }
            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

        btn = (Button)findViewById(R.id.btnlogin);
        btn1 = (Button)findViewById(R.id.btnpw);
        btn2= (Button)findViewById(R.id.btndor);
        webme = (WebView) findViewById(R.id.webdor);
        sett = webme.getSettings();
        sett.getJavaScriptEnabled();
        webme.loadUrl("https://ahwan0m.site/");
        String rawHTML = "<HTML>"+ "<body><h1>HTML content</h1></body>"+ "</HTML>";
        webme.setWebViewClient(new WebViewClient());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webme.loadUrl("https://staging.axisnet.id:81/newaxisnetbeta/home");

            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webme.loadUrl("https://staging.axisnet.id:81/newaxisnetbeta/home");

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webme.loadUrl("https://staging.axisnet.id:81/newaxisnetbeta/tarif_dasar?chage_tarif/5110080");

            }

        });

    }
    @Override
    public void onBackPressed() {

        if (webme.canGoBack()) {
            webme.goBack();
        } else {
            finish();
        }
    }
    }