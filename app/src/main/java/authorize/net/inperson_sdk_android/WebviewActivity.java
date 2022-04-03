package authorize.net.inperson_sdk_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;

import java.text.DecimalFormat;

import authorize.net.inperson_sdk_android.model.Invoice;

public class WebviewActivity extends AppCompatActivity {

    private Invoice invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView webview = findViewById(R.id.webview);
        //Ativa o javascript
        webview.getSettings().setJavaScriptEnabled(true);
        //melhora a performaçe salvando dados nmo disco
        webview.getSettings().setDomStorageEnabled(true);
        //Criando objeto webview
        webview.setWebViewClient(new WebViewClient());
        //Url a ser chamada
        String baseURL = "https://www.1844junkrat.com/app_sandbox/pages/request/invoice.php?total=1000.00&request_id=22360&jobs_price=1000.00&job_description=&labor=500.00&labor_description=&coupon=";
        //String baseURL = "https://www.1844junkrat.com/app";
        //Carregando a url
        webview.loadUrl(baseURL);
        //Habillitando a comunicação do php com o projeto via javascript
        webview.addJavascriptInterface(this, "PushSdkWebView");
    }

    //FUnção a ser chamada apos o click no INSERT CARD do website em php
    @JavascriptInterface
    public void getForm(int req_id, double totpay) {

        DecimalFormat currency = new DecimalFormat("$###,###.##");
        int request_id = req_id;
        double totalpay = totpay;


        Intent LoginPage = new Intent(getApplicationContext(), LoginActivity.class);
        Bundle parametros = new Bundle();
        parametros.putLong("chave_request_id", request_id);
        parametros.putDouble("chave_totalpay", totpay);
        LoginPage.putExtras(parametros);
        startActivity(LoginPage);
        finish();
    }

}

