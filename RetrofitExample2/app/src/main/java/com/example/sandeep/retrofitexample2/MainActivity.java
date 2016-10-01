package com.example.sandeep.retrofitexample2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.sandeep.retrofitexample2.api_calls.ApiCalls;
import com.example.sandeep.retrofitexample2.model.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Context context = null;

    TextView tvOutputText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutputText = (TextView) this.findViewById(R.id.tvOutput);
        context = this;
    }

    public void callGetAllCategories( View view) {

//        //Creating a rest adapter
//        RestAdapter adapter = new RestAdapter.Builder()
//                .setEndpoint(ApplicationClass.BASE_URL)
//
//                .build();
//
//        ApiCalls api = adapter.create(ApiCalls.class);

//        api.getCats(new Callback<List<Category>>() {
//            @Override
//            public void success(List<Category> list, Response response) {
//
//                Toast.makeText(context,"Response:", Toast.LENGTH_LONG).show();
//                //Dismissing the loading progressbar
//
//                //Calling a method to show the list
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                //you can handle the errors here
//            }
//        });


//        api.getCats(new Callback<List<Category>>() {
//            @Override
//            public void success(List<Category> list, Response response) {
//
//
//                StringBuilder builder = new StringBuilder();
//
////                Toast.makeText(context,"Response:" + response.toString(), Toast.LENGTH_LONG).show();
//                //Dismissing the loading progressbar
//
//                //Calling a method to show the list
//                builder.append("Response Status:" + response.getStatus() + "\n");
//                builder.append("Response getURL:" + response.getUrl() + "\n");
//                builder.append("Response getReasons:" + response.getReason() + "\n");
//                try{
//                    builder.append("Response Body:"
//                            + new String(((TypedByteArray) response.getBody()).getBytes()) + "\n");
//                } catch ( Exception e) {
//                    e.printStackTrace();
//                }
//
//
//
//
//
//
//                for(Category cat :  list) {
//                        builder.append("Cat:" + cat.getCat_name() + "\n");
//                }
//
//
//
//                tvOutputText.setText(builder.toString());
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                //you can handle the errors here
//
//                Response response = error.getResponse();
//
//                StringBuilder builder = new StringBuilder();
//
//                builder.append("Response Status:" + response.getStatus() + "\n");
//                builder.append("Response getURL:" + response.getUrl() + "\n");
//                builder.append("Response getReasons:" + response.getReason() + "\n");
//                builder.append("Response Body:" + response.getBody() + "\n");
//
//
//                tvOutputText.setText(builder.toString());
//
//
//
//                Toast.makeText(context,"Error:" + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

//        api.getCats( new Callback<List<Category>>(
//        @Override
//        public void success(List<Book> list, Response response) {
//            //Dismissing the loading progressbar
//            loading.dismiss();
//
//            //Storing the data in our list
//            books = list;
//
//            //Calling a method to show the list
//            showList();
//        }
//
//        @Override
//        public void failure(RetrofitError error) {
//            //you can handle the errors here
//        }
//        ));

//        ApiCalls calls = ApplicationClass.getInstance().retrofit.create(ApiCalls.class);

//        List<Category> cats = calls.getCats();


    }

    public void callServiceWithParameter( View view) {

        try {
            ApiCalls gitHubService = ApiCalls.retrofit.create(ApiCalls.class);
            Call<List<Category>> call = gitHubService.getAllCats();

//            try {
//                List<Category> result = call.execute().body();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            call.enqueue(new Callback<List<Category>>() {

                @Override
                public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                    String resp = response.body().toString();
                    tvOutputText.setText("Response:"+resp);
                }

                @Override
                public void onFailure(Call<List<Category>> call, Throwable t) {
                    tvOutputText.setText("Fail:"+t.getLocalizedMessage());
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }





//        try{
//
//            RestAdapte restAdapter = new RestAdapter.Builder()
//                    .setClient(new MockClient())
//                    .setConverter(new StringConverter())
//                    .setEndpoint(ApplicationClass.BASE_URL).build();
//
//            ApiService service = restAdapter.create(ApiService.class);
//            service.getJson(new Callback<String>() {
//                @Override
//                public void success(String str, Response ignored) {
//                    // Prints the correct String representation of body.
//                    System.out.println(str);
//                tvOutputText.setText("Response:" + str);
//                }
//
//                @Override
//                public void failure(RetrofitError retrofitError) {
//                    System.out.println("Failure, retrofitError" + retrofitError);
//                    tvOutputText.setText("Failure, retrofitError" + retrofitError);
//                }
//            });
//
//
//        } catch ( Exception e) {
//            e.printStackTrace();
//        }

    }


    public void callAndGetResponse( View view) {

    }

    public interface ApiService {
//        GET("/getAllCategoryData.php")
//        Call getJson(Callback<String> callback);
    }

    public static void main(String[] args) {
//        RestAdapte restAdapter = new RestAdapter.Builder()
//                .setClient(new MockClient())
//                .setConverter(new StringConverter())
//                .setEndpoint("http://www.example.com").build();
//
//        ApiService service = restAdapter.create(ApiService.class);
//        service.getJson(new Callback<String>() {
//            @Override
//            public void success(String str, Response ignored) {
//                // Prints the correct String representation of body.
//                System.out.println(str);
//            }
//
//            @Override
//            public void failure(RetrofitError retrofitError) {
//                System.out.println("Failure, retrofitError" + retrofitError);
//            }
//        });
    }

//    static class StringConverter implements Converter {
//        @Override
//        public Object fromBody(TypedInput body, Type type) throws ConversionException {
//            String text = null;
//            try {
//                text = fromStream(body.in());
//            } catch (IOException ignored) {/*NOP*/ }
//
//            return text;
//        }
//
////        @Override
////        public Object fromBody(TypedInput typedInput, TypedInput type) throws ConversionException {
////
////        }
//
//        @Override
//        public TypedOutput toBody(Object o) {
//            return null;
//        }
//
//        public static String fromStream(InputStream in) throws IOException {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            StringBuilder out = new StringBuilder();
//            String newLine = System.getProperty("line.separator");
//            String line;
//            while ((line = reader.readLine()) != null) {
//                out.append(line);
//                out.append(newLine);
//            }
//            return out.toString();
//        }
//    }

//    public static class MockClient implements Client {
//        @Override
//        public Response execute(Request request) throws IOException {
//            URI uri = URI.create(request.getUrl());
//            String responseString = "";
//
//            if (uri.getPath().equals("/api/")) {
//                responseString = "{result:\"ok\"}";
//            } else {
//                responseString = "{result:\"error\"}";
//            }
//
//            return new Response(request.getUrl(), 200, "nothing", Collections.EMPTY_LIST,
//                    new TypedByteArray("application/json", responseString.getBytes()));
//        }
//    }
}



