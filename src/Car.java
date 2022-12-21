import java.awt.*;
import java.time.LocalDate;
import java.util.Locale;

public class Car {
    private String transmission;
    private final String bodyType = "5-дверный универсал";
    private int regNumder;
    private final int placesCount = 7;
    private static boolean isWinterRubber;
    private final String model = "Патриот";
    private final String mark = "УАЗ";
    private final int year = 2005;
    private final String country = "Россия";

    private Key key;

    public static boolean isIsWinterRubber() {
        return isWinterRubber;
    }

    public static void setIsWinterRubber(boolean isWinterRubber) {
        Car.isWinterRubber = isWinterRubber;
    }

    public Key getKey() {
       Key nullProve = new Key (false, false);
       if (key == null) {return nullProve;} else {
        return key;}
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getTransmission() {
        if (this == null||this.transmission == null) {return "Автоматическая";}
        else {
        return transmission;}
    }

    public String getBodyType() {
        if (this == null) {return "5-дверный универсал";}
        return bodyType;
    }

    public int getRegNumder() {
        if (this == null) {return 0;}
        return regNumder;
    }

    public int getPlacesCount() {
        if (this == null) {return 7;}
        return placesCount;
    }

    public boolean isWinterRubber() {
        if (this == null) {return false;}
        return isWinterRubber;
    }

    public String getModel() {
        if (this == null) {return "Патриот";}
        return model;
    }

    public String getMark() {
        if (this == null) {return "УАЗ";}
        return mark ;
    }

    public int getYear() {
        if (this == null) {return 2005;}
        return year;
    }

    public String getCountry() {
        if (this == null) {return "Россия";}
        return country;
    }

    public void setTransmission(String transmission) {
if (transmission.trim()!="Автоматическая"||transmission.trim()!="Механическая"||transmission.trim()!="Вариативная"||transmission.trim()!="Роботизированная")
{this.transmission = "Автоматическая";} else {
        this.transmission = transmission;}
    }

    public void setRegNumder(int regNumder) {
        if (regNumder<0) {this.regNumder=Math.abs(regNumder);} else {
        this.regNumder = regNumder;}
    }

    public static void setWinterRubber(boolean winterRubber) {
        isWinterRubber = winterRubber;
    }
    public static void rubberChange (){
        int month = LocalDate.now().getMonthValue();
        if (((month > 1)&&(month<5))||month>10) {setWinterRubber(true);}
        else setWinterRubber(false);
    }

    private class Key {
        private boolean distanceLaunch;
        private boolean keylessEntry;

        public Key(boolean distanceLaunch, boolean keylessEntry) {
            this.distanceLaunch = distanceLaunch;
            this.keylessEntry = keylessEntry;
        }

        public boolean isDistanceLaunch() {
            if (key == null) {
                return false;
            } else {
                return distanceLaunch;
            }
        }

        public void setDistanceLaunch(boolean distanceLaunch) {
            this.distanceLaunch = distanceLaunch;

        }

        public boolean isKeylessEntry() {
            if (key == null) {
                return false;
            } else {
                return keylessEntry;
            }
        }

        public void setKeylessEntry(boolean keylessEntry) {
            this.keylessEntry = keylessEntry;
        }

        @Override
        public String toString() {
            return distanceLaunchToString()+", "+keylessEntryToString();
        }

        private String keylessEntryToString() {
            if (distanceLaunch == false) {
                return "доступ отсутствует";
            } else {
                return "доступ разрешен";
            }
        }
        private String distanceLaunchToString () {if (distanceLaunch==false) {
           return "Двигатель выключен";} else {
            return "Двигатель запущен";
        }
        }
    }
    Key tt = new Key (true, true);
    Key tf = new Key (true, false);
    Key ft = new Key (false, true);
    Key ff = new Key (false, false);


    @Override
    public String toString() {
        return "Car{" +
                "transmission='" + getTransmission() + '\'' +
                ", bodyType='" + getBodyType() + '\'' +
                ", regNumder=" + getRegNumder() +
                ", placesCount=" + getRegNumder() +
                ", model='" + getModel() + '\'' +
                ", mark='" + getMark() + '\'' +
                ", year=" + getYear() +
                ", country='" + getCountry() + '\'' +
                "Key = " + getKey() + '}';
    }
}
