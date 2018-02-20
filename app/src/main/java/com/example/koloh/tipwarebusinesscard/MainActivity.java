package com.example.koloh.tipwarebusinesscard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        //Spinner is declared and initialised
        Spinner timeSpinner = (Spinner) findViewById ( R.id.opening_time_spinner );

        // ArrayAdapter is created and default spinner is used from the android studio inbuilt library of spinner items
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String> ( MainActivity.this,
                android.R.layout.simple_spinner_item, getResources ().getStringArray ( R.array.time_array ) );

        // The simple_spinner_dropdown_item type of layout is used to display the dropdown items
        timeAdapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        // Adapter is applied to the spinner
        timeSpinner.setAdapter ( timeAdapter );

        //To activate the contact  telephone number button
        Button callButton = (Button) findViewById ( R.id.call_button );
        callButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent ( Intent.ACTION_DIAL, Uri.parse ( "tel:023619878790" ) );
                startActivity ( callIntent );
            }
        } );

        //To activate the email button
        Button emailButton = (Button) findViewById ( R.id.email_button );
        emailButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String subject = "";
                String body = "";
                Intent emailIntent = new Intent ( Intent.ACTION_SENDTO, Uri.fromParts ( "mailto", "info@tipware.de", null ) );
                emailIntent.putExtra ( Intent.EXTRA_SUBJECT, subject );
                emailIntent.putExtra ( Intent.EXTRA_TEXT, body );
                startActivity ( Intent.createChooser ( emailIntent, "info@tipware.de :" ) );
            }
        } );

        //To activate the website address button
        Button websiteButton = (Button) findViewById ( R.id.website_button );
        websiteButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent websiteIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://www.tipware.de/" ) );
                startActivity ( websiteIntent );
            }
        } );


    }
}


// Helpful Resources
//1. website Icon made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
//2. https://stackoverflow.com/questions/21720640/sending-email-from-android-app-when-click-on-button