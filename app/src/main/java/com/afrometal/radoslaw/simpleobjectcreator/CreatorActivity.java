package com.afrometal.radoslaw.simpleobjectcreator;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreatorActivity extends AppCompatActivity {

    private RadioGroup radioTypeGroup;
    private RadioButton radioTypeButton;
    private RadioGroup radioSizeGroup;
    private RadioButton radioSizeButton;
    private RadioGroup radioColorGroup;
    private RadioButton radioColorButton;
    private StringBuilder objectDescriptionBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        radioTypeGroup = (RadioGroup)findViewById(R.id.rg_question1);
        radioSizeGroup = (RadioGroup)findViewById(R.id.rg_question2);
        radioColorGroup = (RadioGroup)findViewById(R.id.rg_question3);
    }

    public void create(View view) {
        radioTypeButton = (RadioButton)findViewById(radioTypeGroup.getCheckedRadioButtonId());
        radioSizeButton = (RadioButton)findViewById(radioSizeGroup.getCheckedRadioButtonId());
        radioColorButton = (RadioButton)findViewById(radioColorGroup.getCheckedRadioButtonId());

        if(radioTypeButton == null || radioSizeButton == null || radioColorButton == null) {
            Toast.makeText(this, "Answer all questions", Toast.LENGTH_SHORT).show();
            return;
        }

        List<RadioButton> descriptionSortedButtons = new ArrayList(3);
        descriptionSortedButtons.add(radioSizeButton);
        descriptionSortedButtons.add(radioColorButton);
        descriptionSortedButtons.add(radioTypeButton);

        objectDescriptionBuilder = new StringBuilder("You've created");
        for(RadioButton button : descriptionSortedButtons) {
            objectDescriptionBuilder.append(" ");
            objectDescriptionBuilder.append(button.getText());
        }
        objectDescriptionBuilder.append("!");

        TextView objectDescriptionTextView = (TextView)findViewById(R.id.tv_object_description);
        objectDescriptionTextView.setText(objectDescriptionBuilder.toString());
    }
}
