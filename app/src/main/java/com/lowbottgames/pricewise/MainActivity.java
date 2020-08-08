package com.lowbottgames.pricewise;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.lowbottgames.pricewise.adapter.ItemRecyclerAdapter;
import com.lowbottgames.pricewise.manager.PItemManager;
import com.lowbottgames.pricewise.model.PItem;
import com.lowbottgames.pricewise.util.DialogHelper;
import com.lowbottgames.pricewise.util.Utility;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrice, editTextUnit;
    private RecyclerView recyclerView;
    private ItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDone();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        adapter = new ItemRecyclerAdapter(PItemManager.getInstance().getItemList());
        recyclerView.setAdapter(adapter);

        editTextPrice = (EditText) findViewById(R.id.editText_price);
        editTextUnit = (EditText) findViewById(R.id.editText_unit);

        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_clear_all:
                        PItemManager.getInstance().clear();
                        if (adapter != null) adapter.notifyDataSetChanged();
                        clearEditText();
                        if (editTextPrice != null) editTextPrice.requestFocus();
                        return true;

                    case R.id.action_rate:
                        Utility.rateApp(MainActivity.this);
                        return true;
                }
                return false;
            }
        });
    }

    private void clickedDone() {
        String price = editTextPrice.getText().toString();
        String unit = editTextUnit.getText().toString();

        if (!isValidDouble(price)){
            DialogHelper.showErrorDialog(MainActivity.this, getString(R.string.error_price)).show();
            return;
        }

        if (!isValidDouble(unit)){
            DialogHelper.showErrorDialog(MainActivity.this, getString(R.string.error_unit)).show();
            return;
        }

        PItem item = new PItem(Double.parseDouble(price), Double.parseDouble(unit));
        PItemManager.getInstance().add(item);
        if (adapter != null) adapter.notifyDataSetChanged();

        clearEditText();
        recyclerView.requestFocus();
        Utility.hideKeyboard(this);
    }

    private void clearEditText() {
        if (editTextPrice != null) {
            editTextPrice.setText("");
        }

        if (editTextPrice != null){
            editTextUnit.setText("");
        }
    }

    private boolean isValidDouble(String value){
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
