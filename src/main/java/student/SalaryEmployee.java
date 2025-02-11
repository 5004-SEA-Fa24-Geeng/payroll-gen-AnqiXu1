package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee implements IEmployee {
    private final String name;
    private final String id;
    private final double payRate;
    private final double pretaxDeductions;
    private double ytdEarnings;
    private double ytdTaxesPaid;

    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }


    @Override public String getName() { return name; }
    @Override public String getID() { return id; }
    @Override public double getPayRate() { return payRate; }
    @Override public String getEmployeeType() { return "SALARY"; }
    @Override public double getYTDEarnings() { return ytdEarnings; }
    @Override public double getYTDTaxesPaid() { return ytdTaxesPaid; }
    @Override public double getPretaxDeductions() { return pretaxDeductions; }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) return null;


        BigDecimal gross = BigDecimal.valueOf(payRate)
                .divide(BigDecimal.valueOf(24), 2, RoundingMode.HALF_UP);


        BigDecimal taxable = gross.subtract(BigDecimal.valueOf(pretaxDeductions))
                .max(BigDecimal.ZERO);
        BigDecimal taxes = taxable.multiply(BigDecimal.valueOf(0.2265))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal netPay = taxable.subtract(taxes);


        this.ytdEarnings = gross.add(BigDecimal.valueOf(ytdEarnings))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        this.ytdTaxesPaid = taxes.add(BigDecimal.valueOf(ytdTaxesPaid))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        return new SimplePayStub(this,
                taxes.doubleValue(),
                netPay.doubleValue());
    }

    @Override
    public String toCSV() {
        return String.format("SALARY,%s,%s,%.2f,%.2f,%.2f,%.2f",
                name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }
}