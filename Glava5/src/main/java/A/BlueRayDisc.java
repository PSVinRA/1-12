package A;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class BlueRayDisc {
    private String discName;
    private List<Catalog> catalogs;

    public BlueRayDisc(String discName) {
        this.discName = discName;
        this.catalogs = new ArrayList<>();
    }

    public void addCatalog(String catalogName) {
        catalogs.add(new Catalog(catalogName));
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void displayContents() {
        System.out.println("Диск: " + discName);
        for (Catalog catalog : catalogs) {
            catalog.display(0);
        }
    }

    public class Catalog {
        private String name;
        private List<Catalog> subCatalogs;
        private List<String> records;

        public Catalog(String name) {
            this.name = name;
            this.subCatalogs = new ArrayList<>();
            this.records = new ArrayList<>();
        }

        public void addSubCatalog(String subCatalogName) {
            subCatalogs.add(new Catalog(subCatalogName));
        }

        public void addRecord(String record) {
            records.add(record);
        }

        public List<Catalog> getSubCatalogs() {
            return subCatalogs;
        }

        public List<String> getRecords() {
            return records;
        }

        public void display(int indent) {
            String indentSpaces = " ".repeat(indent * 4);
            System.out.println(indentSpaces + "Каталог: " + name);

            if (!records.isEmpty()) {
                System.out.println(indentSpaces + "  Записи:");
                for (String record : records) {
                    System.out.println(indentSpaces + "    - " + record);
                }
            }

            if (!subCatalogs.isEmpty()) {
                System.out.println(indentSpaces + "  Подкаталоги:");
                for (Catalog subCatalog : subCatalogs) {
                    subCatalog.display(indent + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BlueRayDisc disc = new BlueRayDisc("Мой BlueRay Диск");

        disc.addCatalog("Фильмы");
        Catalog movies = disc.getCatalogs().get(0);

        movies.addRecord("Фильм 1");
        movies.addRecord("Фильм 2");

        movies.addSubCatalog("Сериалы");
        Catalog series = movies.getSubCatalogs().get(0);

        series.addRecord("Сериал 1");
        series.addRecord("Сериал 2");

        disc.addCatalog("Музыка");
        Catalog music = disc.getCatalogs().get(1);
        music.addRecord("Песня 1");
        music.addRecord("Песня 2");

        disc.displayContents();
    }
}

