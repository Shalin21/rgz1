import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Created by admin on 10.11.17.
 */

public class Main {

    public static class Cities {
        public String name;
        public Integer population, area, year, school;
        public String dir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+File.separator+"rgzText.txt";
        public Cities(String name, Integer population, Integer area, Integer
                year, Integer school) {
            this.name = name;
            this.population = population;
            this.area = area;
            this.year = year;
            this.school = school;
        }

        public void ShowInfo() {
            System.out.println(name + "," + population + "," + area + "," +
                    year + "," + school);
        }
        public String getInfo(){
            return name + "," + population + "," + area + "," +
                    year + "," + school;
        }

        public Cities(Cities other) {
            this.name = new String(other.name);
            this.population = other.population;
            this.area = other.area;
            this.year = other.year;
            this.school = other.school;
        }

        public Cities copy() {
            return new Cities(this);
        }
    }

    public static void main(String[] args) {
        List<Cities> citiesList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String inname;
        Integer inpopulation, inarea, inyear, inschool;
        System.out.println("Do you want to add position?(yes/no)");
        String str = in.nextLine();
        if (str.equals("yes")) {
            System.out.println("Input:");
            inname = in.nextLine();
            inpopulation = Integer.valueOf(in.nextLine());
            inarea = Integer.valueOf(in.nextLine());
            inyear = Integer.valueOf(in.nextLine());
            inschool = Integer.valueOf(in.nextLine());
            Cities C = new Cities(inname, inpopulation, inarea, inyear,
                    inschool);
            C.ShowInfo();
            citiesList.add(C);
        }
        Cities Odessa = new Cities("Odessa", 1010783, 236, 1794, 135);
        Cities Kiev = new Cities("Kiev", 2928177, 847, 482, 350);
        Cities Kharkov = new Cities("Kharkov", 1447881, 847, 1654, 150);
        Cities Dop = Odessa.copy();
        Dop.ShowInfo();
        Odessa.ShowInfo();
        Kiev.ShowInfo();
        Kharkov.ShowInfo();
        citiesList.add(Odessa);
        citiesList.add(Kiev);
        citiesList.add(Kharkov);
        citiesList.add(Dop);
        StringBuilder fullInfo = new StringBuilder();
        for (Cities c:citiesList
             ) {
            fullInfo.append(c.getInfo());
            fullInfo.append("\n");
        }

        write("D:\\lab4.txt", fullInfo.toString() );
        //System.out.println(Odessa.dir);

    }
    public static void write(String fileName, String text) {
        //Определяем файл

        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
