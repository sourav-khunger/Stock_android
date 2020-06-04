package com.doozycod.stock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.doozycod.stock.Model.StockResponseModel;
import com.google.gson.Gson;

import java.lang.reflect.Method;

import static com.doozycod.stock.Utils.APIconstants.STOCK_URL;

public class StockAvailableActivity extends AppCompatActivity {
    String barcode;
    String url;
    TextView itemCodeTxt, descriptionTxt, categoryTxt, stoneyStock, stoneyArea, stoneyRetPrice, stoneyContPrice,
            londonStock, londonArea, londonRetPrice, londonContPrice,
            nuggetStock, nuggetArea, nuggetRetPrice, nuggetContPrice,
            caledoniaStock, caledoniaArea, caledoniaRetPrice, caledoniaContPrice,
            _101westStock, _101westArea, _101westRetPrice, _101westContPrice,
            _75westStock, _75westArea, _75westRetPrice, _75westContPrice,
            bramaleaStock, bramaleaArea, bramaleaRetPrice, bramaleaContPrice;
    CustomProgressBar customProgressBar;
    LinearLayout stockLayout;

    private void initUI() {
        stockLayout = findViewById(R.id.stockLayout);
        bramaleaContPrice = findViewById(R.id.bramaleaContPrice);
        bramaleaRetPrice = findViewById(R.id.bramaleaRetPrice);
        bramaleaArea = findViewById(R.id.bramaleaArea);
        bramaleaStock = findViewById(R.id.bramaleaStock);
        _75westContPrice = findViewById(R.id._75westContPrice);
        _75westRetPrice = findViewById(R.id._75westRetPrice);
        _75westArea = findViewById(R.id._75westArea);
        _75westStock = findViewById(R.id._75westStock);
        _101westContPrice = findViewById(R.id._101westContPrice);
        _101westRetPrice = findViewById(R.id._101westRetPrice);
        _101westArea = findViewById(R.id._101westArea);
        _101westStock = findViewById(R.id._101westStock);
        caledoniaContPrice = findViewById(R.id.caledoniaContPrice);
        caledoniaRetPrice = findViewById(R.id.caledoniaRetPrice);
        caledoniaArea = findViewById(R.id.caledoniaArea);
        caledoniaStock = findViewById(R.id.caledoniaStock);
        caledoniaContPrice = findViewById(R.id.caledoniaContPrice);
        caledoniaRetPrice = findViewById(R.id.caledoniaRetPrice);
        caledoniaArea = findViewById(R.id.caledoniaArea);
        caledoniaStock = findViewById(R.id.caledoniaStock);
        nuggetContPrice = findViewById(R.id.nuggetContPrice);
        nuggetRetPrice = findViewById(R.id.nuggetRetPrice);
        nuggetArea = findViewById(R.id.nuggetArea);
        nuggetStock = findViewById(R.id.nuggetStock);
        londonContPrice = findViewById(R.id.londonContPrice);
        londonRetPrice = findViewById(R.id.londonRetPrice);
        londonArea = findViewById(R.id.londonArea);
        londonStock = findViewById(R.id.londonStock);
        stoneyContPrice = findViewById(R.id.stoneyContPrice);
        stoneyRetPrice = findViewById(R.id.stoneyRetPrice);
        stoneyArea = findViewById(R.id.stoneyArea);
        stoneyStock = findViewById(R.id.stoneyStock);
        itemCodeTxt = findViewById(R.id.itemCodeTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        categoryTxt = findViewById(R.id.categoryTxt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_available);
        getSupportActionBar().hide();
        customProgressBar = new CustomProgressBar(this);
        initUI();

        barcode = getIntent().getStringExtra("barcode");
        customProgressBar.showProgress();
        getStockApi(barcode);
    }


    private void getStockApi(String barcode) {
        url = STOCK_URL + "itemCode=" + barcode;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(VolleyLog.TAG, "onResponse: " + response);
                if (response.contains("error")) {
                    stockLayout.setVisibility(View.GONE);
                    itemCodeTxt.setText("-");
                    descriptionTxt.setText("-");
                    categoryTxt.setText("-");
                    Toast.makeText(StockAvailableActivity.this, "invalid item code", Toast.LENGTH_SHORT).show();
                    showErrorDialog();
                } else {
                    stockLayout.setVisibility(View.VISIBLE);
                    try {
                        Gson gson = new Gson();

                        StockResponseModel gsonObj = gson.fromJson(response, StockResponseModel.class);
                        Log.e("TAG", "onResponse: GSON" + gsonObj.getItem().getItemCode());
                        itemCodeTxt.setText(gsonObj.getItem().getItemCode());
                        descriptionTxt.setText(gsonObj.getItem().getDescription());
                        categoryTxt.setText(gsonObj.getItem().getCategory());
                        stoneyStock.setText(gsonObj.getItem().getStoney().getStock());
                        stoneyArea.setText(gsonObj.getItem().getStoney().getArea());
                        stoneyRetPrice.setText(gsonObj.getItem().getStoney().getRetPrice());
                        stoneyContPrice.setText(gsonObj.getItem().getStoney().getContPrice());
                        londonStock.setText(gsonObj.getItem().getLondon().getStock());
                        londonArea.setText(gsonObj.getItem().getLondon().getArea());
                        londonRetPrice.setText(gsonObj.getItem().getLondon().getRetPrice());
                        londonContPrice.setText(gsonObj.getItem().getLondon().getContPrice());
                        nuggetStock.setText(gsonObj.getItem().getNugget().getStock());
                        nuggetArea.setText(gsonObj.getItem().getNugget().getArea());
                        nuggetRetPrice.setText(gsonObj.getItem().getNugget().getRetPrice());
                        nuggetContPrice.setText(gsonObj.getItem().getNugget().getContPrice());
                        caledoniaStock.setText(gsonObj.getItem().getCaledonia().getStock());
                        caledoniaArea.setText(gsonObj.getItem().getCaledonia().getArea());
                        caledoniaRetPrice.setText(gsonObj.getItem().getCaledonia().getRetPrice());
                        caledoniaContPrice.setText(gsonObj.getItem().getCaledonia().getContPrice());
                        _101westStock.setText(gsonObj.getItem().get101west().getStock());
                        _101westArea.setText(gsonObj.getItem().get101west().getArea());
                        _101westRetPrice.setText(gsonObj.getItem().get101west().getRetPrice());
                        _101westContPrice.setText(gsonObj.getItem().get101west().getContPrice());
                        _75westStock.setText(gsonObj.getItem().get75west().getStock());
                        _75westArea.setText(gsonObj.getItem().get75west().getArea());
                        _75westRetPrice.setText(gsonObj.getItem().get75west().getRetPrice());
                        _75westContPrice.setText(gsonObj.getItem().get75west().getContPrice());
                        bramaleaStock.setText(gsonObj.getItem().getBramalea().getStock());
                        bramaleaArea.setText(gsonObj.getItem().getBramalea().getArea());
                        bramaleaRetPrice.setText(gsonObj.getItem().getBramalea().getRetPrice());
                        bramaleaContPrice.setText(gsonObj.getItem().getBramalea().getContPrice());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                customProgressBar.hideProgress();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(VolleyLog.TAG, "onErrorResponse: " + error);
                customProgressBar.hideProgress();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showErrorDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.error_dialog);
        Button dismissBtn = dialog.findViewById(R.id.okBtn);
        dialog.setCancelable(false);
        dialog.show();
        dismissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
//                finish();
            }
        });

    }
}
