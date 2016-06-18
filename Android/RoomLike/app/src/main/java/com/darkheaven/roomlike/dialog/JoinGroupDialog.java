package com.darkheaven.roomlike.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.adapter.GroupSearchAdapter;
import com.darkheaven.roomlike.object.Group;
import com.darkheaven.roomlike.sync.GetGroupList;
import com.darkheaven.roomlike.sync.GetGroupsUsers;

/**
 * Created by tinyiota on 5/31/16.
 */
public class JoinGroupDialog extends BaseDialog implements AdapterView.OnItemClickListener {
    EditText groupSearchText;
    public ListView groupSearchList;
    public GroupSearchAdapter adapter;

    public JoinGroupDialog(Context context) {
        super(context);
    }

    @Override
    public void init() {
        setContentView(R.layout.dialog_join_group);
        groupSearchText = (EditText)findViewById(R.id.group_search_text);
        groupSearchList = (ListView)findViewById(R.id.group_search_list);
        final JoinGroupDialog dialog = this;
        groupSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {
                String[] params = new String[1];
                params[0] = "http://10.0.2.2:8080/get_group_list/" + s.toString();
                GetGroupList task = new GetGroupList(context);
                task.setDialog(dialog);
                task.execute(params);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Group group = (Group)parent.getItemAtPosition(position);
        MainActivity.os.setGroup(group);
        // get users
        new GetGroupsUsers().execute("http://10.0.2.2:8080/groups_users/" + group.getGroupID());
        // get objects

        dismiss();
        MainActivity.changeScreen(MainActivity.CHORE_SCREEN);
    }
}
