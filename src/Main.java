public class Main {
    public static void main(String[] args) {
Automobile LadaGranta = new Automobile("Lada", "Granta", 1.7, "желтый", 2015, "Россия");
Automobile AudiA8 = new Automobile("Audi", "A8 50 L TDI quattro", 3, "черный", 2020, "Германия");
Automobile BMWZ8 = new Automobile("BMW", "Z8", 3, "желтый", 2021, "Германия");
Automobile KiaSportage = new Automobile("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея");
Automobile HyundaiAvante = new Automobile("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная корея");
 Automobile car = new Automobile();
 Automobile car2 = new Automobile();
 car2.setBrand("Тесла"); car2.setYear(2018); car2.setCountry("США");
        System.out.println(LadaGranta+""+AudiA8+""+BMWZ8+""+KiaSportage+""+HyundaiAvante);
        System.out.println(car);
        System.out.println(car2);
    }
}

