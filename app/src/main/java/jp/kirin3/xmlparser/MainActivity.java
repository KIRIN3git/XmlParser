package jp.kirin3.xmlparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<InformationReply>"
                    + "<Code>12345</Code>"
                    + "<Age/>"
                    + "<Name>EITA</Name>"
                    + "</InformationReply>";


            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(xml));
            int eventType = parser.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                if( eventType == XmlPullParser.START_TAG && parser.getName().equals("Code") ){
                    Log.w( "DEBUG_DATA", "Code:" + parser.nextText() );
//                    Log.w( "DEBUG_DATA", "CODE:" + parser.nextText() );
                }
                else if( eventType == XmlPullParser.START_TAG && parser.getName().equals("Name") ){
                    Log.w( "DEBUG_DATA", "Name:" + parser.nextText() );
                }
                else if( eventType == XmlPullParser.START_TAG && parser.getName().equals("Age") ){
                    Log.w( "DEBUG_DATA", "Age:" + parser.nextText() );
                }
                eventType = parser.next();
            }
        }catch( Exception e ){
            Log.w( "DEBUG_DATA", "e" + e.toString());
        }
    }
}
