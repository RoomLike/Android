package com.darkheaven.roomlike.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 6/1/16.
 */
public class ObjectEditDialog extends BaseDialog {
    public ObjectEditDialog(Context context) {
        super(context);
    }

    @Override
    public void init(){
        setContentView(R.layout.dialog_object_edit);

        final Button editButton = (Button)findViewById(R.id.edit_object);
        final Button deleteButton = (Button)findViewById(R.id.delete_object);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : send objectID and screen to edit
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : delete object from ObjectStore
            }
        });
    }
}
