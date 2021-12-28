package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        Map<String, Info> map = new HashMap<>();
        for (Info info : list) {
            map.putIfAbsent(info.getCity(), new Info(info.getCity(), 0));
            map.computeIfPresent(info.getCity(),
                 (k, v) -> {
                              v.setRainfall(v.getRainfall() + info.getRainfall());
                              return v;
                            });
        }
        return new ArrayList<>(map.values());
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        public void setRainfall(int rainfall) {
            this.rainfall = rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                            && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }

        @Override
        public String toString() {
            return "Info{"
                    + "city='" + city + '\''
                    + ", rainfall=" + rainfall
                    + '}';
        }
    }
}
