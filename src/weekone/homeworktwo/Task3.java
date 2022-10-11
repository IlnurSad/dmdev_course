package weekone.homeworktwo;

/**
 * Задание 3
 *
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer
 * с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 *
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */

public class Task3 {
    public static void main(String[] args) {
//        //Бюджет на первые 6 месяцев
//        budgetCalculationForSeveralMonths(600, 300, 6, 2, 10, 0, 0);
//        //Бюджет 7-12 месяцы
//        budgetCalculationForSeveralMonths(1000, 300, 6, 2, 10, 0, 0);
//        //Бюджет 13-18 месяцы
//        budgetCalculationForSeveralMonths(1400, 300, 6, 2, 10, 0, 0);
//        //Бюджет 19-24 месяцы
//        budgetCalculationForSeveralMonths(1800, 300, 6, 2, 10, 0, 0);
//        //Бюджет 25-30 месяцы
//        budgetCalculationForSeveralMonths(2200, 300, 6, 2, 10, 0, 0);
//        //Бюджет 31-36 месяцы
//        budgetCalculationForSeveralMonths(2600, 300, 6, 2, 10, 0, 0);
//        //Бюджет 37-38 месяцы
//        budgetCalculationForSeveralMonths(3000, 300, 2, 2, 10, 0, 0);

        budgetCalculationForAllTime(600, 300, 38, 2, 10);
    }

    //Подсчет бюджета: startSalaryForMonth - начальная зарплата, expenses - фиксированные траты, numberOfMonths - количество месяцев,
    //profitabilityForMonth - процент прибыли в месяц на БС, percentOnInvestment - процент выделяемый на инвестиции
    public static void budgetCalculationForAllTime (int startSalaryForMonth, int expenses, int numberOfMonths, int profitabilityForMonth,
                                                          int percentOnInvestment) {
        int salary = startSalaryForMonth;
        double bankBalance = 0;
        double brokerBalance = 0;
        for (int currentNumberOfMonths = 6; currentNumberOfMonths <= numberOfMonths ; currentNumberOfMonths += 6) {
            double amountToInvest = salary * (double) percentOnInvestment/100;
            double balance = salary - expenses - amountToInvest;
            bankBalance = getBankStatement(bankBalance, balance, 6);
            brokerBalance = getInvestmentProfitCount(brokerBalance, amountToInvest, profitabilityForMonth, 6);
            salary += 400;

            if (currentNumberOfMonths + 6 > numberOfMonths) {
                int tempMonths = numberOfMonths - currentNumberOfMonths;
                bankBalance = getBankStatement(bankBalance, balance, tempMonths);
                brokerBalance = getInvestmentProfitCount(brokerBalance, amountToInvest, profitabilityForMonth, tempMonths);
            }
        }
        System.out.println("Количество средств на банковском счете за " + numberOfMonths + " months: " + bankBalance + " $");
        System.out.println("Количество средств на брокерском счете за " + numberOfMonths + " months: " + brokerBalance + " $");
    }

//    public static void budgetCalculationForSeveralMonths (int salaryForMonth, int expenses, int numberOfMonths, int profitabilityForMonth,
//                                                          int percentOnInvestment, double startBankBalance, double startBrokerBalance) {
//        double amountToInvest = salaryForMonth * (double) percentOnInvestment/100;
//        double balance = salaryForMonth - expenses - amountToInvest;
//        System.out.println("Количество средств на банковском счете за " + numberOfMonths + " months: " + getBankStatement(startBankBalance, balance, numberOfMonths) + " $");
//        System.out.println("Количество средств на брокерском счете за " + numberOfMonths + " months: " + getInvestmentProfitCount(startBrokerBalance, amountToInvest, profitabilityForMonth, numberOfMonths) + " $");
//        System.out.println();
//    }

    //Количество средств на банковском счете
    public static double getBankStatement (double startBankBalance, double balance, int numberOfMonths) {
        return startBankBalance + balance * numberOfMonths;
    }

    //Количество средств на брокерском счете
    public static double getInvestmentProfitCount (double startBrokerBalance, double amountToInvest, int profitabilityForMonth, int numberOfMonths) {
        double result = startBrokerBalance;
        for (int currentNumberOfMoth = numberOfMonths; currentNumberOfMoth != 0 ; currentNumberOfMoth--) {
            result = (result + amountToInvest) * ((double) profitabilityForMonth/100 + 1);
        }
        return result;
    }
}
