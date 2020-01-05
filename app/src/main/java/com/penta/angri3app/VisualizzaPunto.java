package com.penta.angri3app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class VisualizzaPunto extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private PuntoStradaDatabase helper;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_punto);
        helper = new PuntoStradaDatabase(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(this,12);
        recyclerView.setLayoutManager(layoutManager);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> theList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM PUNTOSTRADA", null);
        while(cursor.moveToNext()){
            theList.add(cursor.getString(1));
            theList.add(cursor.getString(2));
            theList.add(cursor.getString(3));
            theList.add(cursor.getString(4));
            theList.add(cursor.getString(5));
            theList.add(cursor.getString(6));
            theList.add(cursor.getString(7));
            theList.add(cursor.getString(8));
            theList.add(cursor.getString(9));
            theList.add(cursor.getString(10));
            theList.add(cursor.getString(11));
            theList.add(cursor.getString(12));
            //theList.add("\n");
        }
        adapter = new MyRecyclerViewAdapter(this, theList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
