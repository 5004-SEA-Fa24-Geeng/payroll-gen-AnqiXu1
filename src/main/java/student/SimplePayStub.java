package student;

public class SimplePayStub implements IPayStub {
    private final IEmployee employee;
    private final double taxesPaid;
    private final double netPay;


    public SimplePayStub(IEmployee employee, double taxesPaid, double netPay) {
        this.employee = employee;
        this.taxesPaid = taxesPaid;
        this.netPay = netPay;
    }

    @Override public double getPay() { return netPay; }
    @Override public double getTaxesPaid() { return taxesPaid; }

    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                employee.getName(),
                netPay,
                taxesPaid,
                employee.getYTDEarnings(),
                employee.getYTDTaxesPaid());
    }
}