package com.abhi.quizwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Toolbar toolbar = findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("","UPSC"));
        list.add(new CategoryModel("","UPPSC"));
        list.add(new CategoryModel("","SSC CGL"));
        list.add(new CategoryModel("","SSC CHSL"));
        list.add(new CategoryModel("","UPSSSC"));
        list.add(new CategoryModel("","NDA"));
        list.add(new CategoryModel("","CDS"));
        list.add(new CategoryModel("","BNAK PO"));
        list.add(new CategoryModel("","BANK SO"));
        list.add(new CategoryModel("","IIT"));
        list.add(new CategoryModel("","NEET"));
        list.add(new CategoryModel("","GATE"));
        list.add(new CategoryModel("","PSU"));
        list.add(new CategoryModel("","CODING"));
        list.add(new CategoryModel("","CAT"));
        list.add(new CategoryModel("","GRE"));
        list.add(new CategoryModel("","GMAT"));
        list.add(new CategoryModel("","AFCAT"));
        list.add(new CategoryModel("","UPSEEE"));
        list.add(new CategoryModel("","AMCAT"));
        list.add(new CategoryModel("","UPCATET"));

        CategoryAdapter adapter = new CategoryAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}