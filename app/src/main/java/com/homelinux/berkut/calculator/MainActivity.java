package com.homelinux.berkut.calculator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import static android.view.View.*;

//import android.content.Context;
//import android.support.v7.app.ActionBarActivity;
//import javax.script.*;
//import org.mozilla.javascript.;

public class MainActivity extends Activity {

    List<String> memory;
    EditText textViewIn;
    EditText textViewOut;
//      MyTextEdit textViewIn;
//      MyTextEdit textViewOut;
//    @Override
//    public View findViewById(int id) {
//        return super.findViewById(id);
//    }


    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
        memory = new LinkedList<>();

//        textViewIn =  findViewById(R.id.editText);
//        ((EditText) findViewById(R.id.editText)).setInputType(InputType.TYPE_NULL);
//        ((EditText) findViewById(R.id.editText2)).setInputType(InputType.TYPE_NULL);
        textViewIn = (EditText) findViewById(R.id.editText);

        textViewOut = (EditText) findViewById(R.id.editText2);
        textViewOut.setKeyListener(null);
        textViewIn.setInputType(InputType.TYPE_NULL);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            textViewIn.setRawInputType(InputType.TYPE_CLASS_TEXT);
            textViewIn.setTextIsSelectable(true);
        }
//        textViewIn.setInputType(InputType.TYPE_NULL);
//        textViewOut.setInputType(InputType.TYPE_NULL);

        final OnClickListener lbtn24 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.calculate();
                textViewIn.setText(String.valueOf(textViewOut.getText()));
                textViewIn.setSelection(textViewIn.getText().length());
            }
        };

        OnClickListener lbtn_mplus = new OnClickListener() {
            @Override
            public void onClick(View v) {
                memory.add(textViewIn.getText().toString());
            }
        };
        OnClickListener lbtn_mminus = new OnClickListener() {
            @Override
            public void onClick(View v) {
                memory.clear();
            }
        };
        OnClickListener lbtn_mlist = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // call intent
                Intent intent = new Intent(getApplicationContext(), MemoryListActivity.class);
                intent.putExtra("list", (Serializable)memory);
                startActivity(intent);
            }
        };


        OnClickListener lbtn_br1 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("(");
            }
        };
        OnClickListener lbtn_br2 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol(")");
            }
        };
        OnClickListener lbtn1 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("1");
            }
        };

        OnClickListener lbtn2 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("2");
            }
        };
        OnClickListener lbtn3 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("3");
            }
        };
        OnClickListener lbtn4 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("4");
            }
        };
        OnClickListener lbtn5 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("5");
            }
        };
        OnClickListener lbtn6 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("6");
            }
        };
        OnClickListener lbtn7 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("7");
            }
        };
        OnClickListener lbtn8 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("8");
            }
        };
        OnClickListener lbtn9 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("9");
            }
        };
        OnClickListener lbtn0 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("0");
            }
        };
        OnClickListener lbtnumn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("*");
            }
        };
        OnClickListener lbtnminus = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("-");
            }
        };
        OnClickListener lbtn23 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("+");
            }
        };
        OnClickListener lbtnd = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol("/");
            }
        };
        OnClickListener lbtndel = new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(textViewIn.getText());
                int pos = textViewIn.getSelectionStart();
                if(pos>0){
                    textViewIn.setText(textViewIn.getText().delete(pos-1,pos));
                    textViewIn.setSelection(pos-1);
                }
//                if (!text.equals("")) {
//                    String substring = text.substring(0, text.length() - 1);
//                    textViewIn.setText(substring);
//                }
                calculate();
            }
        };

        Button btn_mmplus = (Button) findViewById(R.id.button9);
        btn_mmplus.setOnClickListener(lbtn_mplus);

        Button btn_mminus = (Button) findViewById(R.id.button14);
        btn_mminus.setOnClickListener(lbtn_mminus);

        Button btn_mlist = (Button) findViewById(R.id.button19);
        btn_mlist.setOnClickListener(lbtn_mlist);

        Button btn_br1 = (Button) findViewById(R.id.button1);
        btn_br1.setOnClickListener(lbtn_br1);
        Button btn_br2 = (Button) findViewById(R.id.button2);
        btn_br2.setOnClickListener(lbtn_br2);
        Button btn24 = (Button) findViewById(R.id.button24);
        btn24.setOnClickListener(lbtn24);
        Button btn0 = (Button) findViewById(R.id.button20);
        btn0.setOnClickListener(lbtn0);
        Button btn23 = (Button) findViewById(R.id.button23);
        btn23.setOnClickListener(lbtn23);
        Button btn1 = (Button) findViewById(R.id.button15);
        btn1.setOnClickListener(lbtn1);
        Button btn2 = (Button) findViewById(R.id.button16);
        btn2.setOnClickListener(lbtn2);
        Button btn3 = (Button) findViewById(R.id.button17);
        btn3.setOnClickListener(lbtn3);
        Button btn4 = (Button) findViewById(R.id.button10);
        btn4.setOnClickListener(lbtn4);
        Button btn5 = (Button) findViewById(R.id.button11);
        btn5.setOnClickListener(lbtn5);
        Button btn6 = (Button) findViewById(R.id.button12);
        btn6.setOnClickListener(lbtn6);
        Button btn7 = (Button) findViewById(R.id.button5);
        btn7.setOnClickListener(lbtn7);
        Button btn8 = (Button) findViewById(R.id.button6);
        btn8.setOnClickListener(lbtn8);
        Button btn9 = (Button) findViewById(R.id.button7);
        btn9.setOnClickListener(lbtn9);
        Button btnd = (Button) findViewById(R.id.button8);
        btnd.setOnClickListener(lbtnd);
        Button btndel = (Button) findViewById(R.id.button4);
        btndel.setOnClickListener(lbtndel);
        Button btnumn = (Button) findViewById(R.id.buttonumn);
        btnumn.setOnClickListener(lbtnumn);
        Button btnminus = (Button) findViewById(R.id.buttonminus);
        btnminus.setOnClickListener(lbtnminus);
        Button btnpoint = (Button) findViewById(R.id.buttonPoint);
        OnClickListener lbtnPoint = new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSymbol(".");

//                textViewIn.append(".");
            }
        };
        btnpoint.setOnClickListener(lbtnPoint);
    }

    private void insertSymbol(String s) {
        int pos = textViewIn.getSelectionStart();
        textViewIn.setText(textViewIn.getText().insert(pos,s));
        textViewIn.setSelection(pos+1);
        calculate();
    }

    private void calculate() {
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//        javax.script.ScriptEngine
        String s = String.valueOf(textViewIn.getText());
        MathEvaluator me = new MathEvaluator(s);
//        double res = ;
        textViewOut.setText(me.getValue());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
