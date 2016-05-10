package com.ngu.milkway.red.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.model.bean.WeatherData;

/**
 * Created by xt on 16/5/10.
 */
public class WeatherAdapter extends BaseAdapter<WeatherData.Weather, WeatherAdapter.WeatherHolder> {

    private final static int ITEM_ONE = 0;
    private final static int ITEM_TWO = 1;
    private final static int ITEM_THREE = 2;
    private final static int ITEM_FOUR = 3;

    public WeatherAdapter(WeatherData.Weather data, Context context) {
        super(data, context);
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WeatherHolder holder = null;
        if (ITEM_ONE == viewType) {
            holder = new WeatherNowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_now, parent, false));
        } else if (ITEM_TWO == viewType) {
            holder = new WeatherHourHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_hour, parent, false));
        } else if (ITEM_THREE == viewType) {
            holder = new WeatherDailyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_daily, parent, false));
        } else if (ITEM_FOUR == viewType) {
            holder = new WeatherSuggestionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_suggestion, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        if (holder instanceof WeatherNowHolder) {
            fillNow((WeatherNowHolder) holder);
        } else if (holder instanceof WeatherHourHolder) {
            fillHour((WeatherHourHolder) holder);
        } else if (holder instanceof WeatherDailyHolder) {
            fillDaily((WeatherDailyHolder) holder);
        } else if (holder instanceof WeatherSuggestionHolder) {
            fillSuggestion((WeatherSuggestionHolder) holder);
        }
    }

    private void fillSuggestion(WeatherSuggestionHolder suggestionHolder) {
        // dress
        suggestionHolder.title1.setText(data.getSuggestion().getDrsg().getBrf());
        suggestionHolder.info1.setText(data.getSuggestion().getDrsg().getTxt());
        // sport
        suggestionHolder.title2.setText(data.getSuggestion().getSport().getBrf());
        suggestionHolder.info2.setText(data.getSuggestion().getSport().getTxt());
        // travel
        suggestionHolder.title3.setText(data.getSuggestion().getTrav().getBrf());
        suggestionHolder.info3.setText(data.getSuggestion().getTrav().getTxt());
        // wash car
        suggestionHolder.title4.setText(data.getSuggestion().getCw().getBrf());
        suggestionHolder.info4.setText(data.getSuggestion().getCw().getTxt());
    }

    private void fillDaily(WeatherDailyHolder dailyHolder) {
        for (int i = 0; i < data.getDaily_forecast().size(); i++) {
            dailyHolder.dates[i].setText("1111");
            dailyHolder.infos[i].setText("2222");
            WeatherData.Weather.DailyForecastBean.TmpBean temp = data.getDaily_forecast().get(i).getTmp();
            dailyHolder.minTemps[i].setText(temp.getMin());
            dailyHolder.maxTemps[i].setText(temp.getMax());
        }
    }

    private void fillHour(WeatherHourHolder hourHolder) {
        for (int i = 0; i < data.getHourly_forecast().size(); i++) {
            WeatherData.Weather.HourlyForecastBean hourly = data.getHourly_forecast().get(i);
            String time = hourly.getDate();
            hourHolder.times[i].setText(time.substring(time.lastIndexOf(" "), time.length()));
            hourHolder.temps[i].setText(hourly.getTmp());
            hourHolder.humiditys[i].setText(hourly.getHum());
            hourHolder.windSpeeds[i].setText(hourly.getWind().getSpd());
        }
    }

    private void fillNow(WeatherNowHolder nowHolder) {
        nowHolder.currentTmep.setText(String.format(context.getString(R.string.temp), data.getNow().getTmp()));
        nowHolder.mixTmep.setText(String.format(context.getString(R.string.max_temp), data.getDaily_forecast().get(0).getTmp().getMax()));
        nowHolder.minTmep.setText(String.format(context.getString(R.string.min_temp), data.getDaily_forecast().get(0).getTmp().getMin()));
        nowHolder.pm25.setText(String.format(context.getString(R.string.pm25), data.getAqi().getCity().getPm25()));
        nowHolder.aqi.setText(String.format(context.getString(R.string.aqi), data.getAqi().getCity().getQlty()));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data != null ? 4 : 0;
    }

    class WeatherHolder extends RecyclerView.ViewHolder {

        public WeatherHolder(View itemView) {
            super(itemView);
        }
    }

    class WeatherNowHolder extends WeatherHolder {

        private ImageView icon;
        private TextView currentTmep;
        private TextView mixTmep;
        private TextView minTmep;
        private TextView pm25;
        private TextView aqi;

        public WeatherNowHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.iv_weather_icon);
            currentTmep = (TextView) itemView.findViewById(R.id.tv_weather_now_current_temp);
            mixTmep = (TextView) itemView.findViewById(R.id.tv_weather_now_mix_temp);
            minTmep = (TextView) itemView.findViewById(R.id.tv_weather_now_min_temp);
            pm25 = (TextView) itemView.findViewById(R.id.tv_weather_now_pm25);
            aqi = (TextView) itemView.findViewById(R.id.tv_weather_now_aqi);
        }
    }

    class WeatherHourHolder extends WeatherHolder {

        private LinearLayout container;
        private TextView[] times;
        private TextView[] temps;
        private TextView[] humiditys;
        private TextView[] windSpeeds;

        public WeatherHourHolder(View itemView) {
            super(itemView);
            container = (LinearLayout) itemView.findViewById(R.id.ll_weather_hour_container);
            int size = data.getHourly_forecast().size();
            times = new TextView[size];
            temps = new TextView[size];
            humiditys = new TextView[size];
            windSpeeds = new TextView[size];
            for (int i = 0; i < size; i++) {
                View subView = View.inflate(context, R.layout.item_weather_hour_block, null);
                times[i] = (TextView) subView.findViewById(R.id.tv_weather_hour_time);
                temps[i] = (TextView) subView.findViewById(R.id.tv_weather_hour_temp);
                humiditys[i] = (TextView) subView.findViewById(R.id.tv_weather_hour_humidity);
                windSpeeds[i] = (TextView) subView.findViewById(R.id.tv_weather_hour_wind_speed);
                container.addView(subView);
            }
        }
    }

    class WeatherDailyHolder extends WeatherHolder {

        private LinearLayout container;
        private TextView[] dates;
        private TextView[] infos;
        private TextView[] minTemps;
        private TextView[] maxTemps;

        public WeatherDailyHolder(View itemView) {
            super(itemView);
            container = (LinearLayout) itemView.findViewById(R.id.ll_weather_daily_container);
            int size = data.getDaily_forecast().size();
            dates = new TextView[size];
            infos= new TextView[size];
            minTemps = new TextView[size];
            maxTemps = new TextView[size];
            for (int i = 0; i < size; i++) {
                View subView = View.inflate(context, R.layout.item_weather_daily_block, null);
                dates[i] = (TextView) subView.findViewById(R.id.tv_weather_daily_date);
                infos[i] = (TextView) subView.findViewById(R.id.tv_weather_daily_info);
                minTemps[i] = (TextView) subView.findViewById(R.id.tv_weather_daily_min_temp);
                maxTemps[i] = (TextView) subView.findViewById(R.id.tv_weather_daily_max_temp);
                container.addView(subView);
            }
        }
    }

    class WeatherSuggestionHolder extends WeatherHolder {

        private final TextView title1;
        private final TextView info1;
        private final TextView title2;
        private final TextView info2;
        private final TextView title3;
        private final TextView info3;
        private final TextView title4;
        private final TextView info4;

        public WeatherSuggestionHolder(View itemView) {
            super(itemView);
            title1 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_1_title);
            info1 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_1_info);
            title2 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_2_title);
            info2 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_2_info);
            title3 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_3_title);
            info3 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_3_info);
            title4 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_4_title);
            info4 = (TextView) itemView.findViewById(R.id.tv_weather_suggestion_4_info);
        }
    }


}
