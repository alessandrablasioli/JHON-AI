package it.unibo.sistemidigitali.exam.jhon_ai;



import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.bson.Document;
import org.bson.types.ObjectId;

import io.realm.RealmResults;
import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.auth.GoogleAuthType;
import io.realm.mongodb.mongo.iterable.MongoCursor;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Movie;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Speaker;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Utterance;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.mongo.MongoCollection;
import it.unibo.sistemidigitali.exam.jhon_ai.mongodb.MongoDb;


public class UtteranceActivity extends AppCompatActivity {
    public static final int RecordAudioRequestCode = 1;
    private TextView editText;
    private ImageButton btnSpeak;
    private Button btnFilm;

    private Handler handler;
    private RecyclerView recyclerView;

    RecyclerViewInterface recyclerViewInterface;
    private String result;
    private int count=0;
    private SpeechRecognizer speechRecognizer;

    App app;
    MongoCollection<Document> mongoCollection;

    List<Utterance> utterances;

    private UtteranceAdapter adapter;


    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            checkPermissions();
        }

        //Conncetion to MongoDb with Google
        Realm.init(getApplicationContext());


        app = new App(new AppConfiguration.Builder("jhon-ai-ezdrn").build());

        signInWithGoogle();


        editText = findViewById(R.id.text);

        btnSpeak = findViewById(R.id.button);
        btnFilm = findViewById(R.id.buttonfilm);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerViewInterface=new RecyclerViewInterface() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(UtteranceActivity.this, RecomendationAcivity.class);

                intent.putExtra("MOVIE",utterances.get(position).getMovie().getName());
                intent.putExtra("TEXT",utterances.get(position).getText());
                intent.putExtra("LINK",utterances.get(position).getMovie().getLink());
                intent.putExtra("SPEAKER",utterances.get(position).getSpeaker().getName());

                startActivity(intent);
            }
        };


        btnFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (  editText.getText() != null) {

                    showUtterance(editText.getText().toString());

                }else {
                    Toast.makeText(getApplicationContext(),"Please write something",Toast.LENGTH_LONG).show();
                }

                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            }
        });


        // Initialize the speech Recognizer  (check the request permission)
       speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.US);//lingua di default
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());

        //methods for Recognition
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
            }

            @Override
            public void onBeginningOfSpeech() {

                editText.setText("");
                editText.setHint("Listening...");
            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {
            }

            @Override
            public void onError(int error) {

                String message;
                switch (error) {
                    case SpeechRecognizer.ERROR_AUDIO:
                        message = "Audio recording error";
                        break;
                    case SpeechRecognizer.ERROR_CLIENT:
                        message = "Client side error";
                        break;
                    case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                        message = "Insufficient permissions";
                        break;
                    case SpeechRecognizer.ERROR_NETWORK:
                        message = "Network error";
                        break;
                    case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                        message = "Network timeout";
                        break;
                    case SpeechRecognizer.ERROR_NO_MATCH:
                        message = "No match";
                        break;
                    case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                        message = "RecognitionService busy";
                        break;
                    case SpeechRecognizer.ERROR_SERVER:
                        message = "error from server";
                        break;
                    case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                        message = "No speech input";
                        break;
                    default:
                        message = "Didn't understand, please try again.";
                        break;
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResults(Bundle results) {

                ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                Log.d("MIC INFORMATION", data.get(0));
                editText.setText(data.get(0));
                showUtterance(data.get(0));


            }


            @Override
            public void onPartialResults(Bundle partialResults) {
               ArrayList<String> data = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
               Log.d("MIC INFORMATION", data.get(0));
            }

            @Override
            public void onSegmentResults(@NonNull Bundle segmentResults) {
                RecognitionListener.super.onSegmentResults(segmentResults);
            }

            @Override
            public void onEndOfSegmentedSession() {
                RecognitionListener.super.onEndOfSegmentedSession();
            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

        btnSpeak.setOnClickListener(v -> {
            if (count == 0) {
                btnSpeak.setImageDrawable(getDrawable(R.drawable.ic_film_on));
                speechRecognizer.startListening(speechRecognizerIntent);
                Log.d("MIC STATE", "Start");

                count = 1;
            } else {

                btnSpeak.setImageDrawable(getDrawable(R.drawable.ic_film_off));
                speechRecognizer.stopListening();
                Log.d("MIC STATE", "STop");

                count = 0;

            }

        });



    }

    //permissions

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void checkPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO},
                RecordAudioRequestCode);
        ActivityCompat.checkSelfPermission(this, Manifest.permission_group.MICROPHONE);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speechRecognizer.destroy();

    }


    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    protected void onResume() {
        super.onResume();
      //  adapter.notifyDataSetChanged();

    }

// GOOGLE AUTHENTICATION FOR MONGO_DB CONNCETION
    private void signInWithGoogle() {
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("981882379838-7sg0iv529u7frf4povjd667a0amvpdh0.apps.googleusercontent.com")
                .build();
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, gso);
        Intent signInIntent = googleSignInClient.getSignInIntent();
        ActivityResultLauncher<Intent> resultLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                Task<GoogleSignInAccount> task =
                                        GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                                handleSignInResult(task);
                            }
                        });
        resultLauncher.launch(signInIntent);
    }
    private void handleSignInResult(com.google.android.gms.tasks.Task<GoogleSignInAccount> completedTask) {
        try {
            if (completedTask.isSuccessful()) {
                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
                String token = account.getIdToken();
                Credentials googleCredentials =
                        Credentials.google(token, GoogleAuthType.ID_TOKEN);
                app.loginAsync(googleCredentials, it -> {
                    if (it.isSuccess()) {
                        Log.v("AUTH",
                                "Successfully logged in to MongoDB Realm using Google OAuth.");

                        Toast.makeText(getApplicationContext(),"Login Succesful", Toast.LENGTH_LONG).show();

                    } else {
                        Log.e("AUTH",
                                "Failed to log in to MongoDB Realm: ", it.getError());
                    }
                });
            } else {
                Log.e("AUTH", "Google Auth failed: "
                        + completedTask.getException().toString());
            }
        } catch (ApiException e) {
            Log.w("AUTH", "Failed to log in with Google OAuth: " + e.getMessage());
        }
    }

    //SHOW THE RESULTS
    public void showUtterance(String text){

        utterances = new ArrayList<>();

        if(!text.isBlank()) {

        mongoCollection = MongoDb.mongoConnection(app);
        Document queryFilter = new Document().append("text", Pattern.compile(text + "(?i)"));
        RealmResultTask<MongoCursor<Document>> findTask = mongoCollection.find(queryFilter).iterator();

            //get the async task
            findTask.getAsync(task -> {
                if (task.isSuccess()) {

                    MongoCursor<Document> cursor = task.get();

                    try {
                        while (cursor.hasNext()) {
                            Document utterance = cursor.next();
                            System.out.println(utterance.toString());

                            Document speaker = (Document) utterance.get("speaker");
                            Document movie = (Document) utterance.get("movie");

                            Utterance utt = new Utterance(new ObjectId(utterance.get("_id").toString()), (String) utterance.get("id"), (String) utterance.get("text"), (String) utterance.get("conversation_id"),
                                    new Speaker((String) speaker.get("id"), (String) speaker.get("name")), new Movie((String) movie.get("id"), (String) movie.get("name"), (String) movie.get("link")));

                            utterances.add(utt);
                            System.out.println(utt.toString());


                        }

                        //set the adapter

                        adapter = new UtteranceAdapter(recyclerViewInterface, this, utterances);

                        recyclerView.setAdapter(adapter);

                        recyclerView.setLayoutManager(new LinearLayoutManager(this));

                        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

                        // check if the quote is valid
                        if (utterances.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Ops we cannot find your quote", Toast.LENGTH_LONG).show();
                        }

                    } finally {
                        cursor.close();
                    }
                }
            });

        }else{
            Toast.makeText(getApplicationContext(), "Please write something", Toast.LENGTH_LONG).show();

        }
    } //end showUtterances


}
//end




