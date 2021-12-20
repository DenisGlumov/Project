import  okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.IOException;

public class HomeWork6 {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String FORECAST_PERIOD1 = "1day";

    private static final String SAINT_PETERSBURG_KEY = "295212";
    private static final String API_KEY = "l5zpfLZKQWVkses8GUVJytF8v5ArgzCG";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(SAINT_PETERSBURG_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("details", "true")
                .addQueryParameter("metric", "true")
                .build();

        HttpUrl url2 = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD1)
                .addPathSegment(SAINT_PETERSBURG_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("details", "true")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());
        System.out.println(url2.toString());

        // При необходимости указать заголовки
        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        Request requesthttp2 = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url2)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        String jsonResponse2 = client.newCall(requesthttp2).execute().body().string();
        System.out.println("Прогноз на 5 дней");
        System.out.println(jsonResponse);
        System.out.println("Прогноз на 1 день");
        System.out.println(jsonResponse2);
    }
}
