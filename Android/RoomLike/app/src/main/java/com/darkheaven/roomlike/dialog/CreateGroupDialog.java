package com.darkheaven.roomlike.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.sync.CreateGroup;
import com.darkheaven.roomlike.utils.SP;

/**
 * Created by tinyiota on 5/31/16.
 */
public class CreateGroupDialog extends BaseDialog {
    EditText groupNameField;
    Button create;
    Button cancel;

    public CreateGroupDialog(Context context) {
        super(context);
    }

    @Override
    public void init() {
        setContentView(R.layout.dialog_create_group);
        groupNameField = (EditText)findViewById(R.id.group_name);
        create = (Button)findViewById(R.id.create_button);
        cancel = (Button)findViewById(R.id.cancel_button);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(cancel)){
            dismiss();
        }else if(v.equals(create)){
            new CreateGroup().execute("http://10.0.2.2:8080/insert_group/"
                    + SP.getInt(SP.USER_ID_KEY) + "/"
                    + (groupNameField.getText().toString()).replaceAll(" ", "|"));
        }
    }
}
