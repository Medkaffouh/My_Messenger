package com.hfad.mymessanger;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class CreateMessageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    //Call onSendMessage() when the button is clicked
    public void onSendMessage(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        //Intent intent = new Intent(this, ReceiveMessageActivity.class);

        //intent.putExtra("message",messageText);

        //we're using a constant for the name of the extra information so that we know CreateMessageActivity
        //and ReceiveMessageActivity are using the same String, will add the constant in the ReceiveMessageActivity
        //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE,messageText);

        //Send Action
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,messageText);
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}