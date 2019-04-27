package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Option extends Activity {
    public final static String OPTION_UPDATE = "UPDATE";
    public final static String OPTION_DELETE = "DELETE";
    public final static String OPTION_NONE = "NONE";
    static String OPTION_SELECTED = null;

    static Boolean selected_option = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        selected_option = false;
        OPTION_SELECTED = null;

        TextView update = findViewById(R.id.option_update);
        TextView delete = findViewById(R.id.option_delete);
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                OPTION_SELECTED = OPTION_UPDATE;
                selected_option = true;
                Option.this.finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OPTION_SELECTED = OPTION_DELETE;
                selected_option = true;
                Option.this.finish();
            }
        });
    }

    public static String getOptionSelected(){
        if (selected_option) {
            selected_option = false;
            return OPTION_SELECTED;
        }
        return null;
    }

}
