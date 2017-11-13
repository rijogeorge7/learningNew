package com.rijo.learningapp.Activities;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rijo.learningapp.R;

/**
 * Created by rijogeorge on 11/8/17.
 */

public class AsyncTaskLoaderActivity extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctaskloader);
        Button addTextButton=(Button)findViewById(R.id.addTextButton);
        Button clearBtton=(Button)findViewById(R.id.clearButton);
        final TextView output=(TextView)findViewById(R.id.outputTV);
        final LoaderManager.LoaderCallbacks<String> loaderCalbbacks= new LoaderManager.LoaderCallbacks<String>() {
            @Override
            public Loader<String> onCreateLoader(int i, Bundle bundle) {
                output.append("creating loader\n");
                return new MyTaskLoader(AsyncTaskLoaderActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<String> loader, String data) {
                output.append("loader finished and data is "+data+"\n");
            }

            @Override
            public void onLoaderReset(Loader<String> loader) {

            }
        };
        clearBtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("");
            }
        });
        addTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLoaderManager().initLoader(1,null,loaderCalbbacks).forceLoad();
                //use getLoaderManager().initLoader to load each time
            }
        });
    }


    private static class MyTaskLoader extends AsyncTaskLoader<String> {

        public MyTaskLoader(Context context) {
            super(context);
        }

        @Override
        public String loadInBackground() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "loader finished loading in background";
        }
    }
}
