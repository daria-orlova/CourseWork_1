import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static Employee[] employees = new Employee[10];

//    -- Первый способ создания имен сотрудников --
//    private final static Random random = new Random();
//    private final static String[] maleFirstNames = {"Арчи", "Джери", "Стенли", "Мэтью", "Оливер"};
//    private final static String[] maleMiddleNames = {"Оскар", "Атлас", "Майлс", "Джеймс", "Генри"};
//    private final static String[] maleLastNames = {"Купер", "Стюарт", "Картер", "Хардман", "Спектр"};
//    private final static String[] femaleFirstNames = {"Кейт", "Шарлота", "Маргарет", "Меган", "Элизабет"};
//    private final static String[] femaleMiddleNames = {"Джейн", "Клер", "Френчес", "Мари", "Тесс"};
//    private final static String[] femaleLastNames = {"Грей", "Бруклин", "Кидман", "Грин", "Паркер"};
//
//    private static Employee generateEmployee() {
//        boolean male = random.nextBoolean();
//        String firstName = male ?
//                maleFirstNames[random.nextInt(maleFirstNames.length)] :
//                femaleFirstNames[random.nextInt(femaleFirstNames.length)];
//        String middleName = male ?
//                maleMiddleNames[random.nextInt(maleMiddleNames.length)] :
//                femaleMiddleNames[random.nextInt(femaleMiddleNames.length)];
//        String lastName = male ?
//                maleLastNames[random.nextInt(maleLastNames.length)] :
//                femaleLastNames[random.nextInt(femaleLastNames.length)];
//        int department = random.nextInt(1, 6);
//        int salary = random.nextInt(200_000, 500_000);
//        return new Employee(firstName + " " + middleName + " " + lastName, department, salary);
//    }

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//    -- Относится к первому методу создания имен сотрудников --
//        for (int i = 0; i < employees.length; i++) {
//            employees [i] = generateEmployee();
//        }

//    -- Второй способ создания имен сотрудников --
//        employees[0] = new Employee ("Медведев Максим Иванович", 1, 200_000);
//        employees[1] = new Employee ("Лисицын Андрей Алексеевич", 2, 210_000);
//        employees[2] = new Employee ("Волков Алексей Антонович", 3, 220_000);
//        employees[3] = new Employee ("Зайцев Юрий Сергеевич", 4, 230_000);
//        employees[4] = new Employee ("Быков Евгений Петрович", 5, 240_000);
//        employees[5] = new Employee ("Ястребова Екатерина Евгеньевна", 1, 250_000);
//        employees[6] = new Employee ("Соколова Дарья Андреевна", 2, 260_000);
//        employees[7] = new Employee ("Орлова Анастасия Александровна", 3, 270_000);
//        employees[8] = new Employee ("Дроздова Ангелина Максимовна", 4, 280_000);
//        employees[9] = new Employee ("Скворцова Елизавета Егоровна", 5, 290_000);

//    -- Третий способ создания имен сотрудников --
      Scanner scanner = new Scanner(System.in);
      scanner.useDelimiter("\n");
        for (int i = 0; i < employees.length; i++) {
           System.out.print("Введите ФИО " + (i + 1) + "-го сотрудника: ");
           String fullName = scanner.next();
           System.out.print("Введите номер отдела " + (i + 1) + "-го сотрудника: ");
           int department = scanner.nextInt();
           System.out.print("Введите ЗП " + (i + 1) + "-го сотрудника: ");
           int salary = scanner.nextInt();
           System.out.println();
           employees [i] = new Employee(fullName, department, salary);
        }

        print();
        System.out.println();
        System.out.println("Сумма всех ЗП сотрудников: " + numberFormat.format(calculateSumOfSalaries()));
        System.out.println("Средняя ЗП в компании: " + numberFormat.format(calculateAverageSalary()));
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinSalary());
        System.out.println();
        printFullNames();
    }

    private static void print() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void printFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static double calculateAverageSalary() {
        if (employees.length == 0) {
            return 0;
        }
        return (double) calculateSumOfSalaries() / employees.length;
    }
}