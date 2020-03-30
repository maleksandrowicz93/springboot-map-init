package com.github.maleksandrowicz93.springbootmapinit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19Parser {

    private static final String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public List<Point> getCovidData() throws IOException {
        List<Point> points = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String values = restTemplate.getForObject(url, String.class);

        StringReader stringReader = new StringReader(values);
        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parse) {
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            String text = strings.get("3/29/20");
            points.add(new Point(lat, lon, text));
        }

        return points;
    }

}
